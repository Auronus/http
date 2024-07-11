package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;


public class NasaMain {

    public static final String TOKEN = "6n98s1HK6PtRJMashfQRpjNEmFtcLA1EsbxtKy0N";
    public static final String REMOTE_SERVICE_URI = "https://api.nasa.gov/planetary/apod?api_key=" + TOKEN;
    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000) // максимальное время ожидание подключения к серверу
                        .setSocketTimeout(30000) // максимальное время ожидания получения данных
                        .setRedirectsEnabled(false) // возможность следовать редиректу в ответе
                        .build())
                .build();
        HttpGet request = new HttpGet(REMOTE_SERVICE_URI);
        CloseableHttpResponse response = httpClient.execute(request);
        NasaResponse nasaResponse = OBJECT_MAPPER.readValue(response.getEntity().getContent(), new TypeReference<NasaResponse>() {
        });
        response = httpClient.execute(new HttpGet(nasaResponse.getUrl()));

        try (OutputStream outStream = new FileOutputStream("src/main/resources/" + nasaResponse.getUrl().replaceFirst(".*/", ""))) {
            byte[] buffer = new byte[8 * 1024];
            int bytesRead;
            while ((bytesRead = response.getEntity().getContent().read(buffer)) != -1) {
                outStream.write(buffer, 0, bytesRead);
            }
        } catch (Exception e) {
            throw e;
        }
    }
}