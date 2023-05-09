package com.github.hannesknutsson.zappbrannigan.config;

import org.openapitools.client.ApiClient;
import org.openapitools.client.api.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiBeans {

    @Bean public ApiClient apiClient(@Value("${token}") String token) {
        return new ApiClient().addDefaultHeader("Authorization", "Bearer " + token);
    }

    @Bean public AgentsApi agentsApi(ApiClient apiClient) {
        return new AgentsApi(apiClient);
    }

    @Bean public ContractsApi contractsApi(ApiClient apiClient) {
        return new ContractsApi(apiClient);
    }

    @Bean public FactionsApi factionsApi(ApiClient apiClient) {
        return new FactionsApi(apiClient);
    }

    @Bean public FleetApi fleetApi(ApiClient apiClient) {
        return new FleetApi(apiClient);
    }

    @Bean public SystemsApi systemsApi(ApiClient apiClient) {
        return new SystemsApi(apiClient);
    }
}
