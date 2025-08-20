package sorravit.springtutorial.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sorravit.springtutorial.mapper.ProductMapper;
import sorravit.springtutorial.model.Product;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductMapper productMapper;

    public List<Product> getAllProducts() {
        return productMapper.findAll();
    }

    public Product getProduct(Long id) {
        return productMapper.findById(id);
    }

    public void createProduct(Product product) {
        productMapper.insert(product);
    }

    public void updateProduct(Product product) {
        productMapper.update(product);
    }

    public void deleteProduct(Long id) {
        productMapper.delete(id);
    }
}
