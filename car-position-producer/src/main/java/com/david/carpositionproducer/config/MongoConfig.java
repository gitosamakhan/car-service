package com.david.carpositionproducer.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.lang.NonNull;

@Configuration
@EnableMongoRepositories(basePackages = "com.david.carpositionproducer")
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Override
    @NonNull
    protected String getDatabaseName() {
        return "cars";
    }

    @Override
    @Bean
    @NonNull
    public MongoClient mongoClient() {
        String mongoUri = "mongodb://admin:password@localhost:27017";
        return MongoClients.create(mongoUri);
    }
}
