package hms.systemhospital.docLogin.controller;


import hms.systemhospital.docLogin.entity.AppointmentEntity;
import hms.systemhospital.docLogin.entity.MedicineEntity;
import hms.systemhospital.docLogin.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.AttributeNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v2")
public class MedicineController {
    @Autowired
    MedicineRepository medicineRepository;

    @GetMapping("/medicines")
    public List<MedicineEntity> findAllMedicines() {
        return medicineRepository.findAll();
    }

    @PostMapping("/medicines")
    public MedicineEntity createMedicine(@RequestBody MedicineEntity medicineEntity) {
        return medicineRepository.save(medicineEntity);
    }

    @GetMapping("/medicines/{id}")
    public ResponseEntity<MedicineEntity> findMedicineById(@PathVariable Long id) throws AttributeNotFoundException {
        MedicineEntity medicineEntity=medicineRepository.findById(id)
                .orElseThrow(()->new AttributeNotFoundException("appointment not found"));
        return ResponseEntity.ok(medicineEntity);
    }

    @DeleteMapping("/medicines/{id}")
    public ResponseEntity<Map<String,Boolean>> deletePatient(@PathVariable Long id) throws AttributeNotFoundException {
        MedicineEntity medicineEntity = medicineRepository.findById(id)
                .orElseThrow(() -> new AttributeNotFoundException("Patient not found"));
        medicineRepository.delete(medicineEntity);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted",true);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/medicines/{id}")
    public ResponseEntity<MedicineEntity> updateMedicine(@PathVariable Long id, @RequestBody MedicineEntity medicineDetails) throws AttributeNotFoundException {
        MedicineEntity medicineEntity =  medicineRepository.findById(id)
                .orElseThrow(() -> new AttributeNotFoundException("Patient not found"));
        medicineEntity.setDrugName(medicineDetails.getDrugName());
        medicineEntity.setStock(medicineDetails.getStock());
        medicineEntity.setId(medicineDetails.getId());

        MedicineEntity updatedMedicine = medicineRepository.save(medicineEntity);
        return ResponseEntity.ok(updatedMedicine);
    }

}
