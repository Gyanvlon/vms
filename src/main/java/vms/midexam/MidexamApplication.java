package vms.midexam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import vms.midexam.domain.Garden;
import vms.midexam.domain.Plant;
import vms.midexam.service.GardenService;
import vms.midexam.service.PlantService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class MidexamApplication implements CommandLineRunner {
	@Autowired
	private GardenService gardenService;
	@Autowired
	private PlantService plantService;

	public static void main(String[] args) {
		SpringApplication.run(MidexamApplication.class, args);
	}@Override
	public void run(String... args) throws Exception {
		Garden garden = new Garden();
		garden.setName("vegetable patch");
		garden.setSize(50.0);
		Garden garden1 = new Garden();
		garden1.setName("Herb patch");
		garden1.setSize(20.0);
		Plant plant = new Plant();
		plant.setName("Tomato");
		plant.setType("Vegetable");

		Plant plant1 = new Plant();
		plant1.setName("carrot");
		plant1.setType("Vegetable");
		Plant plant2 = new Plant();
		plant2.setName("basil");
		plant2.setType("herb");
		List<Plant> plants = new ArrayList<Plant>();
		garden1.setPlants(plants);
		garden.setPlants(plants);
		// save garden
		System.out.println("===============================");
		System.out.println("Garden saved");
		gardenService.save(garden);
		gardenService.save(garden1);
		// update garden
//		Garden garden2 = gardenService().findById(1);

//		Plant plant = new Plant();
//		plant.setName("Plant 1");
//		plant.setSize(1.0);
//		plantService.save(plant);
//		System.out.println("===============================");
//		System.out.println("Plant saved");
//		System.out.print(plant);
//		System.out.println("===============================");
//        // get plant by id
//		Plant plant1 = plantService.findById(1);
//		System.out.println("===============================");
//		System.out.println("Plant get by id");
//		System.out.print(plant1);
//		System.out.println("===============================");
//		// update plant
//		Plant plant2 = new Plant();
//		plant2.setName("Plant 2");
//		plant2.setSize(6.0);
//		System.out.println("===============================");
//		System.out.println("Plant updated");
//		System.out.print(plantService.update(1, plant2));
//		System.out.println("===============================");
//		// delete plant
//		System.out.print(plantService.delete(1));
//		System.out.println("===============================");
//		// get all plants
//		System.out.println("===============================");
//		System.out.println("All plants");
//		System.out.println(plantService.findAll());
//		System.out.println("===============================");
		// save garden



	}
}