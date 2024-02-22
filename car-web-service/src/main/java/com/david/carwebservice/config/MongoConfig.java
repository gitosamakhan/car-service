package com.david.carwebservice.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.lang.NonNull;

@Configuration
@EnableMongoRepositories(basePackages = "com.david.carlibrary")
public class MongoConfig extends AbstractMongoClientConfiguration {

    public static final String MONGO_URI = "mongodb://admin:password@mongodb:27017";

    @Override
    @NonNull
    protected String getDatabaseName() {
        return "cars";
    }

    @Override
    @Bean
    @NonNull
    public MongoClient mongoClient() {
        return MongoClients.create(MONGO_URI);
    }
}
