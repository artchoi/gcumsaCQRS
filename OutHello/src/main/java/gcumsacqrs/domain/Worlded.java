package gcumsacqrs.domain;

import gcumsacqrs.domain.*;
import gcumsacqrs.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Worlded extends AbstractEvent {

    private Long id;
    private String world;

    public Worlded(World aggregate) {
        super(aggregate);
    }

    public Worlded() {
        super();
    }
}
