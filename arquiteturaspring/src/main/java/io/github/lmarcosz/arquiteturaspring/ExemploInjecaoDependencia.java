package io.github.lmarcosz.arquiteturaspring;

import io.github.lmarcosz.arquiteturaspring.todos.*;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Connection;

public class ExemploInjecaoDependencia {

    public static void main(String[] args) throws Exception{

        //Configuração do banco de dados (note o excesso de código)
        //Tudo isso é feito "por baixo dos panos" através do Repository
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("url");
        dataSource.setUsername("user");
        dataSource.setPassword("pass");

        Connection connection = dataSource.getConnection();

        EntityManager entityManager = null;

        //Estabelecendo as ligações entre Repository, Validator e MailSender (camada mais baixa)
        TodoRepository repository = null; //new SimpleJpaRepository<TodoEntity, Integer>(null, null);
        TodoValidator todoValidator = new TodoValidator(repository);
        MailSender mailSender = new MailSender();

        //Passando Repository, Validator e MailSender para o Service (camada intermediária)
        TodoService todoService = new TodoService(repository, todoValidator, mailSender);

        BeanGerenciado beanGerenciado = new BeanGerenciado(todoValidator);

        //Tudo acima iria para um controller
    }

}
