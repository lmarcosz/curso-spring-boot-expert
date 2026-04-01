package io.github.lmarcosz.produtosapi.controller;

import io.github.lmarcosz.produtosapi.model.Produto;
import io.github.lmarcosz.produtosapi.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController //Para receber requisições REST
@RequestMapping("/produtos") //define a URL base para chamar o controller
public class ProdutoController {

    private ProdutoRepository produtoRepository;

    //Injetando a classe repository via construtor
    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    //Cadastro de produto
    @PostMapping //envia o recurso produto para o servidor
    public Produto salvar(@RequestBody Produto produto){
        var id = UUID.randomUUID().toString(); //gera uma ID única (um hash)
        produto.setId(id); //setando a ID da classe Produto
        produtoRepository.save(produto); //Metodo para salvar o produto

        System.out.println("Produto salvo: " + produto);
        return produto;
    }

    //Consulta produto por ID
    @GetMapping("/{id}")
    public Produto obterPorId(@PathVariable("id") String id){
        return produtoRepository.findById(id).orElse(null);
    }

    //Deleta produto
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable("id") String id){
        produtoRepository.deleteById(id);
    }

    //Atualiza produto
    @PutMapping("/{id}")
    public void atualizar(@PathVariable String id, @RequestBody Produto produto){
        produto.setId(id); //Define a id no corpo do produto
        produtoRepository.save(produto); //Se o produto existir, será sobrescrito
    }

    //Busca todos os produtos pelo nome
    @GetMapping
    public List<Produto> buscar(@RequestParam("nome") String nome){
        return produtoRepository.findByNome(nome);
    }

}
