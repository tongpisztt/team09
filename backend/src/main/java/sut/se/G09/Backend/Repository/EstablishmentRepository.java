package sut.se.G09.Backend.Repository;
import sut.se.G09.Backend.Entity.Establishment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource
public interface EstablishmentRepository extends JpaRepository<Establishment, Long>{
    Establishment findByID(Long id);
    Establishment findByEstabName(String estabName);
}
