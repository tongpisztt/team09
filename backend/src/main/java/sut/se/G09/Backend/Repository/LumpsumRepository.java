package sut.se.G09.Backend.Repository;
import com.example.demo.entity.Lumpsum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface LumpsumRepository extends JpaRepository<Lumpsum, Long>{
}
