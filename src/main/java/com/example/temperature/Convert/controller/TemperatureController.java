package com.example.temperature.Convert.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class TemperatureController {
	@GetMapping("/")
	public String home() {
		return "index";
	}
	@PostMapping("convert")
	public String convert(@RequestParam("value") double value , @RequestParam("scale") String scale , Model model){
		double result;
		String resultLabel;
		if("c2f".equals(scale)) {
			result = value * 9/5 + 32;
			resultLabel = String.format("%.2f °C = %.2f °F", value, result);
		}
		else if("f2c".equals(scale)){
            result = (value - 32) * 5/9;
            resultLabel = String.format("%.2f °F = %.2f °C", value, result);
        }
		else if("k2c".equals(scale)){
			 result = value - 273.15;
	         resultLabel = String.format("%.2f °K = %.2f °C", value, result);
		}

		else if("c2k".equals(scale)){
			 result = value +273.15;
	         resultLabel = String.format("%.2f °C = %.2f °K", value, result);
		}
		else if("k2f".equals(scale)){
			 result = (value - 273.15) * 5/9 + 32;
	         resultLabel = String.format("%.2f °K = %.2f °F", value, result);
		}

		else if("f2k".equals(scale)){
			 result = (value - 32) * 5/9 + 273.15;
	         resultLabel = String.format("%.2f °F = %.2f °K", value, result);
		}
		else {
			return "";
		}
		
		model.addAttribute("result", resultLabel);
		return "index";
		
		
	}
	

}
