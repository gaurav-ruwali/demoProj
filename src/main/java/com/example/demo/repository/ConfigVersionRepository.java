package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.ConfigVersion;

public interface ConfigVersionRepository extends JpaRepository<ConfigVersion, Long> {
    // Query by config_id instead of device_id
    List<ConfigVersion> findByConfigId(Long configId);
}