package vms.midexam.service;

import vms.midexam.domain.Garden;

import java.util.List;

public interface GardenService {
    Garden save (Garden garden);
    Garden findById(Integer id);
    Garden update(Integer id, Garden garden);
    String delete(Integer id);
    List<Garden> findAll();
}
