package utils;
import Records.Moneda;

import java.text.DecimalFormat;

public class RealizarCambio {
    public double cambioMoneda(Moneda tipoCambio, double moneda){
        DecimalFormat df = new DecimalFormat("0.00");
        return Double.parseDouble(df.format(moneda * tipoCambio.conversion_rate()));
    }
}
