package vms.midexam.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vms.midexam.domain.Plant;

public interface PlantRepository extends JpaRepository<Plant, Integer> {
}
