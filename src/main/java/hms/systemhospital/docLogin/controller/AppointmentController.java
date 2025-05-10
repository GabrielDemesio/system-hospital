package hms.systemhospital.docLogin.controller;

import hms.systemhospital.Entity.PatientEntity;
import hms.systemhospital.docLogin.entity.AppointmentEntity;
import hms.systemhospital.docLogin.repository.AppointmentRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.AttributeNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/v2")
public class AppointmentController {
    @Autowired
    AppointmentRepository appointmentRepository;

    @GetMapping("/appointments")
    public List<AppointmentEntity> findAllAppointments() {
        return appointmentRepository.findAll();
    }

    @PostMapping("/appointments")
    public AppointmentEntity addAppointment(@RequestBody AppointmentEntity appointmentEntity) {
        return appointmentRepository.save(appointmentEntity);
    }

    @GetMapping("/appointments/{id}")
    public ResponseEntity<AppointmentEntity> findAppointmentById(@PathVariable Long id) throws AttributeNotFoundException {
        AppointmentEntity appointmentEntity=appointmentRepository.findById(id)
                .orElseThrow(()->new AttributeNotFoundException("appointment not found"));
        return ResponseEntity.ok(appointmentEntity);
    }

    @DeleteMapping("/appointments/{id}")
    public ResponseEntity<Map<String,Boolean>> deletePatient(@PathVariable Long id) throws AttributeNotFoundException {
        AppointmentEntity appointmentEntity = appointmentRepository.findById(id)
                .orElseThrow(() -> new AttributeNotFoundException("Patient not found"));
        appointmentRepository.delete(appointmentEntity);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted",true);
        return ResponseEntity.ok(response);
    }

}
