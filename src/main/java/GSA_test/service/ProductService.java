package GSA_test.service;

import GSA_test.domain.product;
import GSA_test.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public product add(product product){
        return productRepository.save(product);
    }

    public Optional<product> find(int id){
        return productRepository.findById(id);
    }

    public Optional<product> delete(int id){
        Optional<product> optionalProduct = productRepository.findById(id);

        optionalProduct.ifPresent(product -> productRepository.delete(product));

        return optionalProduct;
    }

    public product update(product product){
        return productRepository.save(product);
    }

    public List<product> findAll(){
        return productRepository.findAll();
    }

    public List<product> findBySupplier(int id){
        return productRepository.findBySupplierId(id);
    }
}
