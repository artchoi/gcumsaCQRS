package gcumsacqrs.infra;

import gcumsacqrs.domain.*;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "helloStatuses",
    path = "helloStatuses"
)
public interface HelloStatusRepository
    extends PagingAndSortingRepository<HelloStatus, Long> {
    List<HelloStatus> findByWorldId(Long worldId);
    List<HelloStatus> findByHelloId(Long helloId);
}
