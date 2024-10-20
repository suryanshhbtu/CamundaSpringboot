package com.example.Camunda.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.Constant.Constant;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class CamundaController {

	@GetMapping("/")
	public String getHome() {
		return "Jai Shree Ram";
	}
	@GetMapping("/stock")
	public HashMap<?,?> getProductStock() {
		HashMap<String, Integer> hm = new HashMap<>();
		hm.put("Ice Cream", Constant.iceCream);
		hm.put("Biscuit", Constant.biscuit);
		hm.put("Cold Drink", Constant.coldDrink);
		return hm;
	}
	@PostMapping("/buy/icecream")
	public String buyIceCream(@RequestParam int qty) {
		
		if(Constant.iceCream < qty) return "Such qty is not available";
		else {
			Constant.iceCream -= qty;
			return "Order Placed Successfully";
		}
	}
	
	
}
