package vms.midexam;

import jakarta.transaction.Transactional;
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
import java.util.Formattable;
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
	@Transactional
	public void run(String... args) throws Exception {
		Garden garden = new Garden();
		garden.setName("Vegetable Patch");
		garden.setSize(50.0);
		Garden savedGarden = gardenService.save(garden);

		Garden garden1 = new Garden();
		garden1.setName("Herb Patch");
		garden1.setSize(20.0);
		Garden savedGarden1 = gardenService.save(garden1);

		System.out.println("===============================");
		System.out.println("Gardens saved");
		System.out.println(savedGarden);
		System.out.println(savedGarden1);

		// find garden by id
//		System.out.println("===============================");
//		System.out.println("Garden found by id");
//		System.out.println(gardenService.findById(1));

		// update garden by id
//		System.out.println("===============================");
//		Garden garden3 = new Garden();
//		garden3.setName("Vegetable Patch");
//		garden3.setSize(30.0);
//		System.out.println(gardenService.update(1, garden3));



		// find  garden by id

		Garden managedGarden1 = gardenService.findById(savedGarden1.getId());
		Garden managedGarden2 = gardenService.findById(savedGarden.getId());


		// Step 2: Create and Associate Plants with Managed Gardens
		Plant plant = new Plant();
		plant.setName("Tomato");
		plant.setType("Vegetable");
		plant.setPlantedDate(LocalDate.of(2024, 3, 10));
		plant.setGarden(managedGarden1);

		Plant plant1 = new Plant();
		plant1.setName("Carrot");
		plant1.setType("Vegetable");
		plant1.setPlantedDate(LocalDate.of(2024, 1, 10));
		plant1.setGarden(managedGarden2);

		Plant plant2 = new Plant();
		plant2.setName("Basil");
		plant2.setType("Herb");
		plant2.setPlantedDate(LocalDate.of(2024, 2, 10));
		plant2.setGarden(managedGarden1);

		// Step 3: Save Plants
		System.out.println("===============================");
		System.out.println("Plants saved");
		System.out.println(plantService.save(plant));
		System.out.println(plantService.save(plant1));
		System.out.println(plantService.save(plant2));

//		System.out.println("===============================");
//		System.out.println("Plants found by id");
//		System.out.println(plantService.findById(2));

		// update plant by id
//		System.out.println("===============================");
//		System.out.println("Plants updated with id");
//		Plant plant3 = new Plant();
//		plant3.setName("Lettuce");
//		plant3.setType("Vegetable");
//		plant3.setPlantedDate(LocalDate.of(2024, 3, 10));
//		plant3.setGarden(managedGarden1);
//		System.out.println(plantService.update(1, plant3)); plantService.update(2, plant3);

		// delete plant by id
//		System.out.println("===============================");
//		System.out.println("Plants deleted with id");
//		System.out.println(plantService.delete(3));

		// find all gardens
		System.out.println("===============================");
		System.out.println("Gardens list sort with size");
		List<Garden> gardens = gardenService.findAll();
		gardens.sort((g1, g2) -> g1.getSize().compareTo(g2.getSize()));
		for (Garden g : gardens) {
			System.out.println(g);
		}
		// Step 4: Find all Plants
		System.out.println("===============================");
		System.out.println("Plants list sort with planted date");
		List<Plant> plants = plantService.findAll();
		plants.sort((p1, p2) -> p1.getPlantedDate().compareTo(p2.getPlantedDate()));
		for (Plant p : plants) {
			System.out.println(p);
		}

	}
}
