package eu.alocquet.poc.jenkinsproject.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.Serializable;

/**
 * Sirene.
 *
 * @author alocquet
 */
@Document
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "siren")
public class Sirene implements Serializable {
    @Id
    private String id;
    @NonNull
    private String siren;
    private String nic;
    private String nomenLong;
    private String codePos;
    private String comet;

}
