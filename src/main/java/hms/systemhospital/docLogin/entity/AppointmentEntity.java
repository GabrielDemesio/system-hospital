package hms.systemhospital.docLogin.entity;


import hms.systemhospital.docLogin.controller.AppointmentController;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "appointment")
@Getter
@Setter
public class AppointmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private String age;

    @Column(name = "symptoms")
    private String symptoms;

    @Column(name = "number")
    private String number;
}
