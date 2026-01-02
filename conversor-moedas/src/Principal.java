import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Principal {
    public static void main(String[] args){

        String url = "https://v6.exchangerate-api.com/v6/7ba7b46870e91fad9c54bf0b/latest/USD";

        HttpClient client = HttpClient.newHttpClient(); //Criação do cliente

        HttpRequest request = HttpRequest.newBuilder() //requisição
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String json = response.body();
        System.out.println(json);
    }
}
