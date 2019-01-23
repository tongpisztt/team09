package sut.se.G09.Backend.Repository;
import sut.se.G09.Backend.Entity.BusinessSize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface BusinessSizeRepository extends JpaRepository<BusinessSize, Long>{
    BusinessSize findByID(long id);
}
