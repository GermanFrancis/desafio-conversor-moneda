package utils;
import Records.Moneda;

import java.text.DecimalFormat;

public class RealizarCambio {
    public void cambioMoneda(Moneda tipoCambio, double moneda){
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("El tipo de cambio para "+moneda+" ["
                +tipoCambio.base_code()+"] es -> "
                +df.format(moneda * tipoCambio.conversion_rate())
                +" ["+tipoCambio.target_code()+"]");
    }
}
