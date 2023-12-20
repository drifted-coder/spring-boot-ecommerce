package com.luv2code.ecommerce.controller;

import com.luv2code.ecommerce.dto.PaymentInfo;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.ecommerce.dto.Purchase;
import com.luv2code.ecommerce.dto.PurchaseResponse;
import com.luv2code.ecommerce.service.CheckoutService;

import java.util.logging.Logger;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

	private Logger logger = Logger.getLogger(getClass().getName());
	@Autowired
	private CheckoutService checkOutService;
	
	@PostMapping("/purchase")
	public PurchaseResponse placeOrder(@RequestBody Purchase purchase) {
		PurchaseResponse purchaseResponse = checkOutService.placeOrder(purchase);
		return purchaseResponse;
	}

	@PostMapping("/payment-intent")
	public ResponseEntity<String> createPaymentIntent(@RequestBody PaymentInfo paymentInfo) throws StripeException {
		logger.info("payment info amount: "+paymentInfo.getAmount());
		logger.info("email is: "+paymentInfo.getReceiptEmail());
		PaymentIntent paymentIntent = checkOutService.createPaymentIntent(paymentInfo);
		String paymentStr = paymentIntent.toJson();

		return  new ResponseEntity<>(paymentStr, HttpStatus.OK);
	}
}
