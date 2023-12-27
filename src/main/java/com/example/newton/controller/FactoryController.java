package com.example.newton.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.newton.model.Camera;
import com.example.newton.model.Factory;
import com.example.newton.repository.CameraRepository;
import com.example.newton.repository.FactoryRepository;

@RestController
@RequestMapping("/factory")
public class FactoryController {
    @Autowired FactoryRepository factoryRepository;
    @Autowired CameraRepository cameraRepository;
    @GetMapping("")
    public Iterable<Factory> getAll(){
        return factoryRepository.findAll();
    }

    @GetMapping("/{id}/camera")
    public Iterable<Camera> findCameraByFactory(@PathVariable int id){
        Factory factory = factoryRepository.findById(id).get();
        Iterable<Camera> cameras = cameraRepository.findByFactory(factory);
        return cameras;
    }

}
