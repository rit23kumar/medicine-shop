package com.medicineshop.controller;

import com.medicineshop.model.Medicine;
import com.medicineshop.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/medicines")
public class MedicineController {

    @Autowired
    private MedicineRepository medicineRepository;

    @GetMapping
    public List<Medicine> getAllMedicines() {
        return medicineRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medicine> getMedicineById(@PathVariable Long id) {
        Optional<Medicine> medicine = medicineRepository.findById(id);
        return medicine.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Medicine createMedicine(@RequestBody Medicine medicine) {
        return medicineRepository.save(medicine);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medicine> updateMedicine(@PathVariable Long id, @RequestBody Medicine medicineDetails) {
        Optional<Medicine> optionalMedicine = medicineRepository.findById(id);
        if (optionalMedicine.isPresent()) {
            Medicine medicine = optionalMedicine.get();
            medicine.setName(medicineDetails.getName());
            medicine.setDescription(medicineDetails.getDescription());
            medicine.setPrice(medicineDetails.getPrice());
            final Medicine updatedMedicine = medicineRepository.save(medicine);
            return ResponseEntity.ok(updatedMedicine);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedicine(@PathVariable Long id) {
        if (medicineRepository.existsById(id)) {
            medicineRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}