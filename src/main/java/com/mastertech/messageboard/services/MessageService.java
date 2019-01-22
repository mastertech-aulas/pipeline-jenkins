package com.mastertech.messageboard.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mastertech.messageboard.models.Message;
import com.mastertech.messageboard.repositories.MessageRepository;

@Service
public class MessageService {

	@Autowired
	MessageRepository messageRepository;
	
	public boolean save(Message message) {
		if(message.getName() == null || message.getName().isEmpty()) {
			return false;
		}
		
		if(message.getContent() == null || message.getContent().isEmpty()) {
			return false;
		}
		
		if(message.getContent().length() > 100) {
			return false;
		}
		
		messageRepository.save(message);
		
		return true;
	}
	
	public Iterable<Message> findAll() {
		return messageRepository.findAllByOrderByIdDesc();
	}
}
