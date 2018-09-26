package restApi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import restApi.Exceptions.NotFoundException;
import restApi.Model.Account;
import restApi.Model.Product;
import restApi.repository.ProductRepository;

import java.util.List;

@Component
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> find() {
        return productRepository.findAll();
    }

    public Product show(int productId) {
        Product product = productRepository.findOne(productId);

        verifyProduct(product);

        return productRepository.findOne(productId);
    }

    public Product create(String name, int price) {
        return productRepository.save(new Product(name, price));
    }

    public Product update(int productId, String name, int price) {
        Product product = productRepository.findOne(productId);

        verifyProduct(product);

        product.setName(name);
        product.setPrice(price);
        return productRepository.save(product);
    }

    public boolean delete(int productId) {
        Product product = productRepository.findOne(productId);

        verifyProduct(product);

        productRepository.delete(productId);
        return true;
    }

    private void verifyProduct(Product product) {
        if (product == null) {
            throw new NotFoundException("No product found with this id");
        }
    }
}
