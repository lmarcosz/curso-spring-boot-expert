package io.github.lmarcosz.arquiteturaspring.todos;

import org.springframework.stereotype.Component;

@Component
public class MailSender {

    public void enviar(String mensagem){
        System.out.println("Enviar mensagem: " + mensagem);
    }

}
