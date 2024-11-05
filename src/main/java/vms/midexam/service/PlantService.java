package vms.midexam.service;

import vms.midexam.domain.Plant;

import java.util.List;

public interface PlantService {
    Plant save(Plant plant);
    Plant findById(Integer id);
    Plant update(Integer id, Plant plant);
    String delete(Integer id);
    List<Plant> findAll();
}
