package hms.systemhospital.Controller;


import hms.systemhospital.Entity.PatientEntity;
import hms.systemhospital.Repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.AttributeNotFoundException;
import javax.naming.directory.AttributeInUseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class PatientController {

    @Autowired
    PatientRepository patientRepository;

    @GetMapping("/patients")
     public List<PatientEntity> getAllPatients() {
        return patientRepository.findAll();
    }

    @GetMapping("/patients/{id}")
    public ResponseEntity<PatientEntity> getPatientById(@PathVariable Long id) throws AttributeNotFoundException {
        PatientEntity patientEntity = patientRepository.findById(id)
                .orElseThrow(() -> new AttributeNotFoundException("Patient not found"));
        return ResponseEntity.ok(patientEntity);
    }

    @PostMapping("/patients")
    public PatientEntity createPatient(@RequestBody PatientEntity patientEntity) {
        return patientRepository.save(patientEntity);
    }


    @PutMapping("/patients/{id}")
    public  ResponseEntity<PatientEntity> updatePatient(@PathVariable Long id, @RequestBody PatientEntity patientDetails) throws AttributeNotFoundException {
        PatientEntity patientEntity = patientRepository.findById(id)
                .orElseThrow(() -> new AttributeNotFoundException("Patient not found"));

        patientEntity.setAge(patientDetails.getAge());
        patientEntity.setName(patientDetails.getName());
        patientEntity.setBlood(patientDetails.getBlood());
        patientEntity.setFees(patientDetails.getFees());
        patientEntity.setUrgency(patientDetails.getUrgency());
        patientEntity.setDose(patientDetails.getDose());
        patientEntity.setPrescription(patientDetails.getPrescription());
        patientEntity.setId(patientDetails.getId());

        PatientEntity patientUpdated = patientRepository.save(patientEntity);
        return ResponseEntity.ok(patientUpdated);
    }

    @DeleteMapping("/patients/{id}")
    public ResponseEntity<Map<String,Boolean>> deletePatient(@PathVariable Long id) throws AttributeNotFoundException {
        PatientEntity patientEntity = patientRepository.findById(id)
                .orElseThrow(() -> new AttributeNotFoundException("Patient not found"));
        patientRepository.delete(patientEntity);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted",true);
        return ResponseEntity.ok(response);
    }






}
