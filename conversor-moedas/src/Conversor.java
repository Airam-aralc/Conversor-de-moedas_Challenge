import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {

    private final String chaveApi = ""; //"final" transforma a variável em uma constante, define imutabilidade
    private final String url = "https://v6.exchangerate-api.com/v6/";

    public double buscarConversao(String moedaOrigem, String moedaConversao){
        String urlFinal = url + chaveApi + "/pair/" + moedaOrigem + "/" + moedaConversao;

    try {
        HttpClient client = HttpClient.newHttpClient(); //Criação do cliente
        HttpRequest request = HttpRequest.newBuilder() //requisição
                .uri(URI.create(urlFinal))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        JsonElement elemento = JsonParser.parseString(response.body());
        JsonObject objectRoot = elemento.getAsJsonObject();
        return objectRoot.get("conversion_rate").getAsDouble();
    } catch (Exception e){
        throw new RuntimeException("Não consegui obter a taxa de conversão: " + e.getMessage());
    }
    }
}
