package com.github.hannesknutsson.zappbrannigan;

import org.openapitools.client.api.AgentsApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    private AgentsApi agentsApi;

    @Scheduled(cron = "0/5 * * * * *")
    public void runEveryHour() {
        System.out.println(agentsApi.getMyAgent().getData());
    }
}
