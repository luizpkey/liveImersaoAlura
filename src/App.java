import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class App {
    private static final String URL_ENDPOINT = "URL_ENDPOINT";

    public static void main(String[] args) throws Exception {
        var url=System.getenv(URL_ENDPOINT);
        URI uri = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request=HttpRequest.newBuilder(uri).build();
        String json = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
        System.out.println(json);
    }
}
