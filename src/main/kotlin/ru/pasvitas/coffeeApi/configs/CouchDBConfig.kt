package ru.pasvitas.coffeeApi.configs

import org.lightcouch.CouchDbClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration


@Configuration
@ComponentScan
class CouchDBConfig {
    @Bean(destroyMethod = "shutdown")
    fun dbClient(): CouchDbClient {
        return CouchDbClient("couchdb.properties")
    }

}