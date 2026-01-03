import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {

        String url = "https://v6.exchangerate-api.com/v6/";
        String chave = "";
        String url_extra = "/pair/";
        String moeda1 = "USD";
        String moeda2 = "BRL";

        String urlFinal = url + chave + url_extra + moeda1 + "/" + moeda2;

        HttpClient client = HttpClient.newHttpClient(); //Criação do cliente
        HttpRequest request = HttpRequest.newBuilder() //requisição
                .uri(URI.create(urlFinal))
                .GET()
                .build();

        HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

        //Conversão para Json
        JsonElement elemento = JsonParser.parseString(response.body());
        JsonObject objectRoot = elemento.getAsJsonObject();

        double taxaDeConversao = objectRoot.get("conversion_rate").getAsDouble();
        double valorUSD = 50;

        double resultado = valorUSD * taxaDeConversao;
        System.out.println(taxaDeConversao);
        System.out.println(resultado);
    }
}
