package com.mastertech.messageboard;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.mastertech.messageboard.models.Message;
import com.mastertech.messageboard.repositories.MessageRepository;
import com.mastertech.messageboard.services.MessageService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=App.class)
public class MessageServiceTest {
	@MockBean 
	MessageRepository messageRepository;
	
	@Autowired
	MessageService messageService;
	
	@Test
	public void shouldNotCreateMessageWithouName(){
		Message message = new Message();
		
		message.setContent("Olá");
		
		boolean result = messageService.save(message);
		
		assertFalse(result);
	}
	
	@Test
	public void shouldNotCreateMessageWithouContent(){
		Message message = new Message();
		
		message.setName("José");
		
		boolean result = messageService.save(message);
		
		assertFalse(result);
	}
	
	@Test
	public void shouldNotCreateMessageWithLargeContent(){
		Message message = new Message();
		
		message.setName("José");
		message.setContent("Essa mensagem é muito grande e repetitiva e portanto não deve ser salva dentro do nosso banco de dados");
		
		boolean result = messageService.save(message);
		
		assertFalse(result);
	}
	
	@Test
	public void shouldCreateCorrectlyFormedMessage(){
		Message message = new Message();
		
		message.setName("José");
		message.setContent("Essa mensagem é adequada.");
		
		boolean result = messageService.save(message);
		
		assertTrue(result);
	}
}
