package com.jasonswitzer.driverslicense.services;

import org.springframework.stereotype.Service;

import com.jasonswitzer.driverslicense.models.License;
import com.jasonswitzer.driverslicense.repositories.LicenseRepository;

@Service
public class LicenseService {
	
	private LicenseRepository licenseRepository;
	
	public LicenseService(LicenseRepository licenseRepository) {
		this.licenseRepository = licenseRepository;
	}
	
	public void addLicense(License license) {
		licenseRepository.save(license);
	}
		
}
