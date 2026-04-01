package io.github.lmarcosz.arquiteturaspring.todos;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("todos")
public class TodoController {

    //Injecao de dependencia Service
    private TodoService service;
    public TodoController(TodoService service) {
        this.service = service;
    }

    //Tratamento da requisicao POST para salvar
    @PostMapping
    public TodoEntity salvar(@RequestBody TodoEntity todo){
        try{
            return this.service.salvar(todo);
        } catch (IllegalArgumentException e){
            var mensagemErro = e.getMessage();
            throw new ResponseStatusException(HttpStatus.CONFLICT, mensagemErro);
        }
    }

    //Atualizar dados
    @PutMapping("{id}")
    public void atualizar(@PathVariable Integer id, @RequestBody TodoEntity todo){
        todo.setId(id);
        service.atualizar(todo);
    }

    //Buscar_todo
    @GetMapping("{id}")
    public TodoEntity buscar(@PathVariable Integer id){
        return service.buscarPorId(id);
    }



}
