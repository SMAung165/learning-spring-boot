package com.learn;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftwareEngineerService {

    private final SoftwareEngineerRepository softwareEngineerRepository;

    //constructors
    public SoftwareEngineerService(SoftwareEngineerRepository softwareEngineerRepository) {
        this.softwareEngineerRepository = softwareEngineerRepository;
    }

    //getters
    public List<SoftwareEngineer> getAllSoftwareEngineers() {
        return softwareEngineerRepository.findAll();
    }

    public void insertSoftwareEngineer(SoftwareEngineer softwareEngineer) {
        softwareEngineerRepository.save(softwareEngineer);
    }

    public SoftwareEngineer getSoftwareEngineerById(Integer id) {
        return softwareEngineerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("SoftwareEngineer id not found!"));
    }

    public void deleteSoftwareEngineerById(Integer id) {
        if (softwareEngineerRepository.existsById(id)) {
            softwareEngineerRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("SoftwareEngineer id not found!");
        }
    }

    public void updateSoftwareEngineerById(Integer id, SoftwareEngineer update) {
        SoftwareEngineer queriedSoftwareEngineer = softwareEngineerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("SoftwareEngineer id not found!"));
        queriedSoftwareEngineer.setName(update.getName());
        queriedSoftwareEngineer.setTechStack(update.getTechStack());
        softwareEngineerRepository.save(queriedSoftwareEngineer);
    }
}
