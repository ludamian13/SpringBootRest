package restApi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
import restApi.Model.Account;
import restApi.Model.Product;
import restApi.Service.ProductService;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public List<Product> find() {
        return productService.find();
    }

    @GetMapping("/product")
    public Product show(@RequestParam int productId) {
        return productService.show(productId);
    }

    @RequestMapping(value = "/product", method = RequestMethod.PUT)
    public Product create(@RequestParam("name") String name, @RequestParam("price") int price) {
        return productService.create(name, price);
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public Product update(@RequestParam int productId, @RequestParam("name") String name, @RequestParam("price") int price) {
        return productService.update(productId, name, price);
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
    public boolean delete(@RequestParam int accountId) {
        return productService.delete(accountId);
    }

}
