package com.onelauncher;

import java.io.IOException;
import java.net.URI;
import java.net.http.*;

public class Downloader {

    private HttpClient client;

    public Downloader() {
        client = HttpClient.newHttpClient();
    }

    public String get(String url) throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

}