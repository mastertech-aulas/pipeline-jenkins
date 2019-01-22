package com.mastertech.messageboard.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mastertech.messageboard.models.Message;

public interface MessageRepository extends CrudRepository<Message, Integer>{

	public Iterable<Message> findAllByOrderByIdDesc();
}
