package org.queiroz;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.nio.charset.StandardCharsets;

public class SmsSender {

    public static void enviarSms(String from, String to, String message, String url, String authToken) {

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost request = new HttpPost(url);

            // Configura os headers
            request.setHeader("Authorization", "Basic " + authToken);
            request.setHeader("Content-Type", "application/x-www-form-urlencoded");

            // Configura o corpo da requisição
            StringEntity params = new StringEntity("To=" + to + "&From=" + from + "&Body=" + message, StandardCharsets.UTF_8);
            request.setEntity(params);

            // Executa a requisição
            try (CloseableHttpResponse ignored = httpClient.execute(request)) {
                System.out.println("Enviado sms para: " + to);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
