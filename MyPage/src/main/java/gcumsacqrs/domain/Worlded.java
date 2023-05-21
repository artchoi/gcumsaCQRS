package gcumsacqrs.domain;

import gcumsacqrs.infra.AbstractEvent;
import java.util.*;
import lombok.Data;

@Data
public class Worlded extends AbstractEvent {

    private Long id;
    private String world;
}
