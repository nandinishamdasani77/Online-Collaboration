package online.com.collaborative.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import online.com.collaborative.model.DomainResponse;

@RestController
public class GreetingController {
	
	@RequestMapping("/greeting")
	
		public ResponseEntity<DomainResponse> greeting()
		{
			return new ResponseEntity<DomainResponse> (new DomainResponse("welcome from spring restcontroller!",200),HttpStatus.OK);
		}
	}


