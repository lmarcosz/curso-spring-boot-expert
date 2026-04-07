package io.github.lmarcosz.arquiteturaspring;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
public class Application {

	public static void main(String[] args){
		//SpringApplication.run(Application.class, args);

        //Essa declaracao inicializa a aplicação da mesma forma do metodo padrao acima
        SpringApplicationBuilder builder = new SpringApplicationBuilder(Application.class);

        //Definindo todos os beans como Lazy
        //builder.lazyInitialization(true);

        //Ocultando o banner Spring do console
        //builder.bannerMode(Banner.Mode.OFF);

        //Definição de perfil para execução
        //builder.profiles("producao", "homologacao");

        //Rodando a aplicação
        builder.run(args);

        //Obtendo um bean
        ConfigurableApplicationContext applicationContext = builder.context();
        //var produtoRepository = applicationContext.getBean("produtoRepository");

        //Obtendo o nome da aplicação
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String applicationName = environment.getProperty("spring.application.name");
        //System.out.println(applicationName);

        //Obtendo uma propriedade
        ExemploValue value = applicationContext.getBean(ExemploValue.class);
        value.imprimirVariavel();

	}

}
