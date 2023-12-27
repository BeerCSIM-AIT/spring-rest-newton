package com.example.newton.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.newton.model.Camera;
import com.example.newton.model.Event;
import java.util.List;


public interface EventRepository extends CrudRepository<Event, Integer> {
    List<Event> findByCamera(Camera camera);
}
