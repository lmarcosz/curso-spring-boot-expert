package io.github.lmarcosz.arquiteturaspring.todos;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

    //Injecoes de dependencias
    private TodoRepository repository;
    private TodoValidator validator;
    private MailSender mailSender;

    public TodoService(TodoRepository repository, TodoValidator validator, MailSender mailSender) {
        this.repository = repository;
        this.validator = validator;
        this.mailSender = mailSender;
    }

    //Salvar
    public TodoEntity salvar(TodoEntity novoTodo){
        validator.validar(novoTodo);
        return repository.save(novoTodo);
    }

    //Atualizar
    public void atualizar(TodoEntity novoTodo){
        repository.save(novoTodo);
        String status = novoTodo.getConcluido() == Boolean.TRUE ? "concluido" : "nao concluido";
        mailSender.enviar("Todo" + novoTodo.getDescricao() + "atualizado!\n- Status: " + status);
     }

    //Buscar por ID
    public TodoEntity buscarPorId(Integer id){
        return repository.findById(id).orElse(null);
    }

}
