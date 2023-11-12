package com.apress.todo.jms;

import com.apress.todo.domain.ToDo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ToDoProducer {
    private final JmsTemplate jmsTemplate;

    public void sendTo(String destination, ToDo toDo) {
        this.jmsTemplate.convertAndSend(destination, toDo);
        log.info("Producer > Message Sent");
    }
}
