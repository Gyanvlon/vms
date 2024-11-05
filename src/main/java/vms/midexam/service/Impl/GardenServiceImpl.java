package vms.midexam.service.Impl;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vms.midexam.Repository.GardenRepository;
import vms.midexam.domain.Garden;
import vms.midexam.service.GardenService;

import java.util.List;

@Service
public class GardenServiceImpl implements GardenService {
    @Autowired
    private GardenRepository gardenRepository;
    @Override
    public Garden save(Garden garden) {
        return gardenRepository.save(garden);
    }
    @Override
    public Garden findById(Integer id) {
        return gardenRepository.findById(id).get();
    }

    @Override
    public Garden update(Integer id, Garden garden) {
        Garden garden1 = gardenRepository.findById(id).get();
        garden1.setName(garden.getName());
        garden1.setSize(garden.getSize());
        return gardenRepository.save(garden1);
    }

    @Override
    public String delete(Integer id) {
        gardenRepository.deleteById(id);
        return "Garden with id " + id + " deleted";
    }


    @Override
    @Transactional
    public List<Garden> findAll() {
        return gardenRepository.findAll();
    }
}
