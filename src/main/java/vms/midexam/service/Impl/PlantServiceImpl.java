package vms.midexam.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vms.midexam.Repository.PlantRepository;
import vms.midexam.domain.Plant;
import vms.midexam.service.PlantService;

import java.util.List;

@Service
public class PlantServiceImpl implements PlantService {
    @Autowired
    private PlantRepository plantRepository;
    @Override
    public Plant save(Plant plant) {
        return plantRepository.save(plant);
    }

    @Override
    public Plant findById(Integer id) {
        return plantRepository.findById(id).get();
    }

    @Override
    public Plant update(Integer id, Plant plant) {
        Plant oldPlant = plantRepository.findById(id).get();
        oldPlant.setName(plant.getName());
        oldPlant.setSize(plant.getSize());
        return plantRepository.save(oldPlant);
    }

    @Override
    public String delete(Integer id) {
        plantRepository.deleteById(id);
        return "Plant deleted with id" + id;
    }

    @Override
    public List<Plant> findAll() {
        return plantRepository.findAll();
    }
}
