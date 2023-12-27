package com.example.newton.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.newton.model.Camera;
import com.example.newton.model.Event;
import com.example.newton.repository.CameraRepository;
import com.example.newton.repository.EventRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/camera")
public class CameraController {
    @Autowired CameraRepository cameraRepository;
    @Autowired EventRepository eventRepository;

    @GetMapping("")
    public Iterable<Camera> getAll() {
        return cameraRepository.findAll();
    }
    
    @GetMapping("/{id}/event")
    public Iterable<Event> getEventByCameraId(@PathVariable int id){
        Camera camera = cameraRepository.findById(id).get();
        Iterable<Event> events = eventRepository.findByCamera(camera);
        return events;
    }
    
}
