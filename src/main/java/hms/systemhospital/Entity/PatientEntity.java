package hms.systemhospital.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "patients")
@AllArgsConstructor
@Getter
@Setter
public class PatientEntity {
    public PatientEntity() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String name;

    @Column(name = "age")
    private String age;

    @Column(name = "blood_group")
    private String blood;

    @Column(name = "prescription")
    private String prescription;

    @Column(name = "dose")
    private String dose;

    @Column(name = "fees")
    private String fees;

    @Column(name = "urgency")
    private String urgency;


}
