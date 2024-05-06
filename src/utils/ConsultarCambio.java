package utils;

import Records.Moneda;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarCambio {
    public Moneda buscarMoneda(int opcion){
        String urlCambio = "";
        switch (opcion){
            case 1:
                urlCambio = "USD/ARS";
                break;
            case 2:
                urlCambio = "ARS/USD";
                break;
            case 3:
                urlCambio = "USD/BRL";
                break;
            case 4:
                urlCambio = "BRL/USD";
                break;
            case 5:
                urlCambio = "USD/COP";
                break;
            case 6:
                urlCambio = "COP/USD";
                break;
        }
        URI url = URI.create("https://v6.exchangerate-api.com/v6/993ed73d5476d6f7f46484fc/pair/" + urlCambio);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return  new Gson().fromJson(response.body(),Moneda.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("No se encontró el tipo de cambio");
        }
    }
}
