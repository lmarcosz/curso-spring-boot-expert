package io.github.lmarcosz.arquiteturaspring;

import io.github.lmarcosz.arquiteturaspring.todos.TodoEntity;
import io.github.lmarcosz.arquiteturaspring.todos.TodoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

//@Lazy(true)
@Component
//@Scope(BeanDefinition.SCOPE_SINGLETON)
//@Scope(WebApplicationContext.SCOPE_REQUEST)
//@Scope(WebApplicationContext.SCOPE_SESSION)
//@Scope(WebApplicationContext.SCOPE_APPLICATION)
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
