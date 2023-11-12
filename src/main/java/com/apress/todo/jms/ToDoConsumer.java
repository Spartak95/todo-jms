package com.apress.todo.jms;

import com.apress.todo.domain.ToDo;
import com.apress.todo.repository.ToDoRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ToDoConsumer {
    private final ToDoRepository repository;

    @JmsListener(destination = "${todo.jms.destination}", containerFactory = "jmsFactory")
    public void processToDo(@Valid ToDo toDo) {
        log.info("Consumer > {}", toDo);
        log.info("ToDo created > {}", this.repository.save(toDo));
    }
}
