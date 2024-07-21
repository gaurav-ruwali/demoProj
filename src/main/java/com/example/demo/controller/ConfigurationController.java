package com.example.demo.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Configuration;
import com.example.demo.model.ConfigVersion;
import com.example.demo.service.ConfigurationService;
import com.example.demo.service.ConfigurationServiceImpl;

@RestController
@RequestMapping("/api/configurations")
public class ConfigurationController {

	@Autowired
	private ConfigurationService configurationService;

	@Autowired
	private ConfigurationServiceImpl configurationServiceImpl;

	// Endpoint to create a configuration
	@PostMapping("/addconfig")
	public ResponseEntity<Configuration> createConfiguration(@RequestBody Configuration configuration) {
		configuration.setId(0L);
		Configuration savedConfig = configurationService.saveConfiguration(configuration);
		return ResponseEntity.ok(savedConfig);
	}

	// Endpoint to get configurations by device ID
//	@GetMapping("/{deviceId}")
//	public ResponseEntity<List<Configuration>> getConfigurations(@PathVariable String deviceId) {
//		List<Configuration> configurations = configurationServiceImpl.getConfigurations(deviceId);
//		return ResponseEntity.ok(configurations);
//	}
//
//	// Endpoint to create a config version

	@GetMapping("/{deviceId}")
	public ResponseEntity<Configuration> getConfigurations(@PathVariable String deviceId) {
		Configuration configurations = configurationServiceImpl.getConfigurations(deviceId);

		if (configurations == null) {
			// Return 404 Not Found if no configurations found for the deviceI
			return ResponseEntity.notFound().build();
		} else {
			// Return 200 OK with configurations if found
			return ResponseEntity.ok(configurations);
		}
	}

	@PostMapping("/versions")
	public ResponseEntity<ConfigVersion> createConfigVersion(@RequestBody ConfigVersion configVersion) {
		ConfigVersion savedConfigVersion = configurationServiceImpl.saveConfigVersion(configVersion);
		return ResponseEntity.ok(savedConfigVersion);
	}

	// Endpoint to get config versions by configuration ID
	@GetMapping("/versions/{configId}")
	public ResponseEntity<List<ConfigVersion>> getConfigVersions(@PathVariable Long configId) {
		List<ConfigVersion> configVersions = configurationServiceImpl.getConfigVersions(configId);
		return ResponseEntity.ok(configVersions);
	}
}