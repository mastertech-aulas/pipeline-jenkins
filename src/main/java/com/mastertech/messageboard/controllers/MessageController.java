package com.mastertech.messageboard.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mastertech.messageboard.models.Message;
import com.mastertech.messageboard.services.MessageService;

@RestController
@RequestMapping("/message")
public class MessageController {
	
	@Autowired
	MessageService messageService;
	
	@GetMapping
	public Iterable<Message> getMessages() {
		return messageService.findAll();
	}
	
	@PostMapping
	public ResponseEntity<?> saveMessage(@RequestBody Message message) {
		if(messageService.save(message)) {
			return ResponseEntity.status(201).build();
		}
		
		return ResponseEntity.status(400).build();
	}
}
