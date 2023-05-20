package gcumsacqrs.domain;

import gcumsacqrs.domain.*;
import gcumsacqrs.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Hellod extends AbstractEvent {

    private Long id;
    private String hello;

    public Hellod(Hello aggregate) {
        super(aggregate);
    }

    public Hellod() {
        super();
    }
}
