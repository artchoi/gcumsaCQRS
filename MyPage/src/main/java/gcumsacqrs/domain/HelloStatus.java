package gcumsacqrs.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "HelloStatus_table")
@Data
public class HelloStatus {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private Long helloId;
    private Long worldId;
    private String hello;
    private String world;
    private Integer count;
}
