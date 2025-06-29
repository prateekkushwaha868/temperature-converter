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
		else {
            result = (value - 32) * 5/9;
            resultLabel = String.format("%.2f °F = %.2f °C", value, result);
        }
		
		model.addAttribute("result", resultLabel);
		return "index";
		
		
	}
	

}
