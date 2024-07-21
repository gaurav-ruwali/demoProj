package com.example.demo.service;

import java.util.List;
import com.example.demo.model.Configuration;

public interface ConfigurationService {
    Configuration saveConfiguration(Configuration configuration);
    Configuration getConfigurations(String deviceId);
}