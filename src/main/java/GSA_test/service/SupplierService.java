package GSA_test.service;

import GSA_test.domain.product;
import GSA_test.domain.supplier;
import GSA_test.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {

    @Autowired
    SupplierRepository supplierRepository;

    public supplier add(supplier supplier){
        return supplierRepository.save(supplier);
    }

    public Optional<supplier> find(int id){
        return supplierRepository.findById(id);
    }

    public Optional<supplier> delete(int id){
        Optional<supplier> supplierProduct = supplierRepository.findById(id);

        supplierProduct.ifPresent(supplier -> supplierRepository.delete(supplier));

        return supplierProduct;
    }

    public supplier update(supplier supplier){
        return supplierRepository.save(supplier);
    }

    public List<supplier> findAll(){
        return supplierRepository.findAll();
    }
}
