package com.example.newton;

import java.util.Arrays;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.newton.model.Camera;
import com.example.newton.model.Event;
import com.example.newton.model.Factory;
import com.example.newton.repository.CameraRepository;
import com.example.newton.repository.EventRepository;
import com.example.newton.repository.FactoryRepository;

@SpringBootApplication
public class NewtonApplication implements CommandLineRunner {
	@Autowired
	FactoryRepository factoryRepository;
	@Autowired
	CameraRepository cameraRepository;
	@Autowired
	EventRepository eventRepository;

	private static final Logger logger = LoggerFactory.getLogger(
			NewtonApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(NewtonApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Factory f1 = new Factory("Bang Yai 1", "Nonthaburi");
		factoryRepository.save(f1);

		Camera c1 = new Camera("Front 1", "Front Gate 1", f1);
		Camera c2 = new Camera("Back 2", "Back Gate 2", f1);
		cameraRepository.saveAll(Arrays.asList(c1, c2));

		Event e1 = new Event(500, new Date(), c1);
		Event e2 = new Event(400, new Date(), c1);
		Event e3 = new Event(500, new Date(), c2);
		Event e4 = new Event(400, new Date(), c2);
		eventRepository.saveAll(Arrays.asList(e1, e2, e3, e4));

		logger.info("---------- Factory ----------");
		for (Factory f : factoryRepository.findAll()) {
			logger.info("name: {}, address: {}", f.getName(), f.getAddress());
			logger.info("---------- Cameras ----------");
		}

	}
}
