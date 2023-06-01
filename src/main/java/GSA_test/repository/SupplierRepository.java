package GSA_test.repository;

import GSA_test.domain.supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<supplier,Integer> {

}
