package com.apress.todo.validatior;

import com.apress.todo.domain.ToDo;
import jakarta.annotation.Nonnull;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ToDoValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(ToDo.class);
    }

    @Override
    public void validate(@Nonnull Object target, Errors errors) {
        ToDo toDo = (ToDo) target;

        if (toDo.getDescription() == null || toDo.getDescription().isBlank()) {
            errors.rejectValue("description", null, "description cannot be null or empty");
        }
    }
}
