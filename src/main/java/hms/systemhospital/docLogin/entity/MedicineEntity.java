package hms.systemhospital.docLogin.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "medicines")
@Getter
@Setter
public class MedicineEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "drugName")
    private String drugName;

    @Column(name = "stock")
    private String stock;
}
