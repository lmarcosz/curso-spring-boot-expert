package io.github.lmarcosz.arquiteturaspring.montadora;

import java.awt.*;

public class HondaHRV extends Carro{
    public HondaHRV(Motor motor) {
        super(motor);
        setModelo("HRV");
        setMontadora(Montadora.HONDA);
        setCor(Color.BLACK);
    }
}
