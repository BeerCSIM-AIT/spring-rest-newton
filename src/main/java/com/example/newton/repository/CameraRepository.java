package com.example.newton.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.newton.model.Camera;
import com.example.newton.model.Factory;

import java.util.List;


public interface CameraRepository extends CrudRepository<Camera, Integer> {
    List<Camera> findByFactory(Factory factory);
}
