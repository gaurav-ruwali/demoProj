package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Configuration;

public interface ConfigurationRepository extends JpaRepository<Configuration, Long> {
   // List<Configuration> findByDeviceId(String deviceId);
    Optional<Configuration> findByDeviceId(String deviceId);
}