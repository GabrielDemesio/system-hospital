package hms.systemhospital.docLogin.repository;

import hms.systemhospital.docLogin.entity.MedicineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineRepository extends JpaRepository<MedicineEntity,Long> {
}
