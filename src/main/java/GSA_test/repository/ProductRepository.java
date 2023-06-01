package GSA_test.repository;

import GSA_test.domain.product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<product,Integer> {

    @Query("Select p from product p where p.supplier.supplierId= :supplierId")
    List<product> findBySupplierId(@Param("supplierId") int supplierId);
}
