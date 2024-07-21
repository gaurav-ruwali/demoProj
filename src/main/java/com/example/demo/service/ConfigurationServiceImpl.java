package com.example.demo.service;

import com.example.demo.model.ConfigVersion;
import com.example.demo.model.Configuration;
import com.example.demo.repository.ConfigVersionRepository;
import com.example.demo.repository.ConfigurationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigurationServiceImpl implements ConfigurationService {

    @Autowired
    private ConfigurationRepository configurationRepository;

    @Autowired
    private ConfigVersionRepository configVersionRepository;

    @Override
    public Configuration saveConfiguration(Configuration configuration) {
        // Save the configuration to the database
        return configurationRepository.save(configuration);
    }

    @Override
    public Configuration getConfigurations(String deviceId) {
        // Fetch configurations by deviceId from the database
        return configurationRepository.findByDeviceId(deviceId).get();
    }

    public ConfigVersion saveConfigVersion(ConfigVersion configVersion) {
        // Save the config version to the database
        return configVersionRepository.save(configVersion);
    }

    public List<ConfigVersion> getConfigVersions(Long configId) {
        // Fetch config versions by configId from the database
        return configVersionRepository.findByConfigId(configId);
    }
}