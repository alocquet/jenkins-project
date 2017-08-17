package eu.alocquet.poc.jenkinsproject.repository;

import eu.alocquet.poc.jenkinsproject.domain.Sirene;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * Sirene Repository.
 *
 * @author alocquet
 */
public interface SireneRepository extends ReactiveMongoRepository<Sirene, String> {

}
