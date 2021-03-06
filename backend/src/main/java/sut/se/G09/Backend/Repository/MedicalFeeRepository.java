package sut.se.G09.Backend.Repository;

import sut.se.G09.Backend.Entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface MedicalFeeRepository extends JpaRepository<MedicalFee, Long> {

  MedicalFee findById(long Id);
  MedicalFee findByMedicalFeeCost(int medicalFeeCost);
}
