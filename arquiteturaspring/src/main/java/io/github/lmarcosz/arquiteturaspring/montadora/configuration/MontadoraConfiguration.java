package io.github.lmarcosz.arquiteturaspring.montadora.configuration;

import io.github.lmarcosz.arquiteturaspring.montadora.Motor;
import io.github.lmarcosz.arquiteturaspring.montadora.TipoMotor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MontadoraConfiguration {

    @Bean(name = "motorAspirado")
    public Motor motorAspirado(@Value("${app.montadora.motor-padrao}") Integer cavalos){
        var motor = new Motor();
        motor.setCavalos(cavalos);
        motor.setCilindros(4);
        motor.setLitragem(1.6);
        motor.setTipo(TipoMotor.ASPIRADO);
        motor.setModelo("XPTO-0");
        return motor;
    }

    @Primary
    @Bean(name = "motorEletrico")
    public Motor motorEletrico(){
        var motor = new Motor();
        motor.setCavalos(110);
        motor.setCilindros(3);
        motor.setLitragem(1.4);
        motor.setTipo(TipoMotor.ELETRICO);
        motor.setModelo("TH-40");
        return motor;
    }

    @Bean(name = "motorTurbo")
    public Motor motorTurbo(){
        var motor = new Motor();
        motor.setCavalos(160);
        motor.setCilindros(4);
        motor.setLitragem(2.0);
        motor.setTipo(TipoMotor.TURBO);
        motor.setModelo("V8");
        return motor;
    }

}
