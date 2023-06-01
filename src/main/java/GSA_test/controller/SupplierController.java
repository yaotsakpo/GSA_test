package GSA_test.controller;

import GSA_test.domain.product;
import GSA_test.domain.supplier;
import GSA_test.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    SupplierService supplierService;

    @GetMapping("")
    public ResponseEntity<?> list(){
        List<supplier> suppliers= supplierService.findAll();
        return new ResponseEntity<>(suppliers, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addSupplier(@RequestBody supplier supplier){
        supplier s = supplierService.add(supplier);
        if (s == null) {
            return new ResponseEntity<>("Unable to create supplier", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(s, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getSupplier(@PathVariable int id){
        Optional<supplier> supplier= supplierService.find(id);
        if (!supplier.isPresent()) {
            return new ResponseEntity<>("Supplier not found", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(supplier.get(), HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> deleteSupplier(@PathVariable int id){
        Optional<supplier> supplier= supplierService.delete(id);
        if (!supplier.isPresent()) {
            return new ResponseEntity<>("Unable to delete supplier", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(supplier.get(), HttpStatus.OK);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> updateSupplier(@RequestBody supplier supplier, @PathVariable int id){
        Optional<supplier> supplierOptional = supplierService.find(id);
        supplier s = supplierOptional.orElse(null);
        if (s == null) {
            return new ResponseEntity<>("Unable to update supplier", HttpStatus.BAD_REQUEST);
        }
        s.setName(supplier.getName());
        s.setContactPhone(supplier.getContactPhone());
        supplierService.update(s);
        return new ResponseEntity<>(s, HttpStatus.OK);
    }
}
