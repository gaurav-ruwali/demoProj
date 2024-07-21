package com.example.demo.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Entity
@Table(name = "configurations")
@Getter
@Setter
@ToString
public class Configuration {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "device_id", nullable = false)
   private String deviceId;

   @Column(name = "config_data", nullable = false)
   private String configData;

   @Column(name = "version", nullable = false)
   private int version;

   @Column(name = "created_at", nullable = false)
   private LocalDateTime createdAt;
   // Getters and setters

   public Object getDeviceId() {
      // TODO Auto-generated method stub
      return null;
   }
}