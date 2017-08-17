package eu.alocquet.poc.jenkinsproject.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import eu.alocquet.poc.jenkinsproject.domain.Sirene;
import eu.alocquet.poc.jenkinsproject.repository.SireneRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

/**
 * mongodb configuration
 *
 * @author alocquet
 */
@Configuration
@EnableReactiveMongoRepositories(basePackages = "eu.alocquet.poc.jenkinsproject")
public class MongoConfiguration {

    /**
     * initialize database
     * @param sireneRepository repository
     * @return database initialization script
     */
    @Bean
    CommandLineRunner initData(final SireneRepository sireneRepository) {
        return (p) -> {
            sireneRepository.deleteAll().block();
            sireneRepository.save(new Sirene("Siren 1")).block();
            sireneRepository.save(new Sirene("Siren 2")).block();
            sireneRepository.save(new Sirene("Siren 3")).block();
        };
    }
}