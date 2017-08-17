package eu.alocquet.poc.jenkinsproject.resource;

import eu.alocquet.poc.jenkinsproject.domain.Sirene;
import eu.alocquet.poc.jenkinsproject.repository.SireneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Resource 'sirene'.
 *
 * @author alocquet
 */
@RestController
@RequestMapping("/sirene")
public class SireneResource {

    /**
     * repository
     */
    @Autowired
    private SireneRepository repo;

    /**
     * find all sirene. Filters are allowed in request param
     *
     * @param nomenLong filter on nomenLong
     * @param nic       filter on nic
     * @return sirenes
     */
    @GetMapping
    public Flux<Sirene> findAll(@RequestParam(required = false) final String nomenLong, @RequestParam(required = false) final String nic) {
        final Sirene sirene = new Sirene();
        sirene.setNomenLong(nomenLong);
        sirene.setNic(nic);
        return repo.findAll(Example.of(sirene, ExampleMatcher.matching().withIgnoreNullValues().withIgnoreCase().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)));
    }

    /**
     * create a sirene
     *
     * @param sirene sirene to create
     * @return created sirene
     */
    @PostMapping
    public Mono<Sirene> create(final @RequestBody Sirene sirene) {
        return repo.save(sirene);
    }

    /**
     * update a sirene
     *
     * @param sirene sirene to update
     * @return updated sirene
     */
    @PutMapping("/{id}")
    public Mono<Sirene> update(final @RequestBody Sirene sirene) {
        return repo.save(sirene);
    }

    /**
     * delete a sirene
     * @param id sirene's id to delete
     * @return nothing
     */
    @DeleteMapping("/{id}")
    public Mono<Void> delete(final @PathVariable("id") String id) {
        return repo.deleteById(id);
    }
}
