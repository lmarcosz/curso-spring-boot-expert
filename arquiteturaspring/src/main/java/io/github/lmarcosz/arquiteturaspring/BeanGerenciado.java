package io.github.lmarcosz.arquiteturaspring;

import io.github.lmarcosz.arquiteturaspring.todos.TodoEntity;
import io.github.lmarcosz.arquiteturaspring.todos.TodoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanGerenciado {

    //Injeção do validator direto da propriedade (sem construtor)
    @Autowired
    private TodoValidator validator;

    //Injeção do validator através do construtor de BeanGerenciado
    @Autowired
    public BeanGerenciado(TodoValidator validator) {
        this.validator = validator;
    }

    //Injeta o parâmetro no validator desta classe
    @Autowired
    public void setValidator(TodoValidator validator) {
        this.validator = validator;
    }

    //Uso do objeto validator injetado acima
    public void utilizar(){
        var todo = new TodoEntity();
        validator.validar(todo);
    }

}
