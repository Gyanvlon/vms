package vms.midexam.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vms.midexam.domain.Garden;

public interface GardenRepository extends JpaRepository<Garden, Integer> {
}
