package GSA_test.controller;

import GSA_test.contract.AddProductRequest;
import GSA_test.domain.product;
import GSA_test.domain.supplier;
import GSA_test.service.ProductService;
import GSA_test.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    SupplierService supplierService;

    @GetMapping("")
    public ResponseEntity<?> list(){
        List<product> products= productService.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/bySupplier/{id}")
    public ResponseEntity<?> findBySupplier(@PathVariable int id){
        List<product> products= productService.findBySupplier(id);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@RequestBody AddProductRequest addProductRequest){
        Optional<supplier> supplierOptional = supplierService.find(addProductRequest.getSupplierId());
        if(supplierOptional.isEmpty()){
            return new ResponseEntity<>("Unable to create product", HttpStatus.BAD_REQUEST);
        }
        product request = new product(addProductRequest.getName(),addProductRequest.getUnitPrice(), addProductRequest.getQuantityInStock(),supplierOptional.get());
        product p = productService.add(request);
        if (p == null) {
            return new ResponseEntity<>("Unable to create product", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getProduct(@PathVariable int id){
        Optional<product> product= productService.find(id);
        if (product.isEmpty()) {
            return new ResponseEntity<>("Product not found", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(product.get(), HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable int id){
        Optional<product> product= productService.delete(id);
        if (product.isEmpty()) {
            return new ResponseEntity<>("Unable to delete product", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(product.get(), HttpStatus.OK);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> updateProduct(@RequestBody AddProductRequest addProductRequest, @PathVariable int id){
        Optional<product> productOptional = productService.find(id);
        product p = productOptional.orElse(null);
        if (p == null) {
            return new ResponseEntity<>("Unable to update product", HttpStatus.BAD_REQUEST);
        }
        p.setName(addProductRequest.getName());
        p.setUnitPrice(addProductRequest.getUnitPrice());
        p.setQuantityInStock(addProductRequest.getQuantityInStock());
        productService.update(p);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }
}
