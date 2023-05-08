package com.github.hannesknutsson.zappbrannigan;

import org.openapitools.client.ApiClient;
import org.openapitools.client.api.AgentsApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;

@Service
public class TestService {

    @Value("${token}")
    private String token;

    @Scheduled(cron = "0/5 * * * * *")
    public void runEveryHour() {
        System.out.println("This method will run every minute");
        AgentsApi api = new AgentsApi(new ApiClient(new RestTemplate(new ClientHttpRequestFactory() {
            @Override
            public ClientHttpRequest createRequest(URI uri, HttpMethod httpMethod) throws IOException {
                ClientHttpRequest request = new SimpleClientHttpRequestFactory().createRequest(uri, httpMethod);
                request.getHeaders().add("Authorization", "Bearer " + token);
                return request;
            }
        })));
        System.out.println(api.getMyAgent().getData());
    }
}
