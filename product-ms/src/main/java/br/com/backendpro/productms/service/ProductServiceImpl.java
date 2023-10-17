package br.com.backendpro.productms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.backendpro.productms.dto.ProductDTO;
import br.com.backendpro.productms.model.Product;
import br.com.backendpro.productms.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Optional<ProductDTO> create(ProductDTO request) {
        // Request -> Mode/Entidade -> Response

        // com o model mapper -> MAIS CLEAN
        Product product = mapper.map(request, Product.class);

        ProductDTO response = mapper.map(product, ProductDTO.class);

        repository.saveAndFlush(product);

        // Sem o model mapper:
        // Product product = new Product();

        // product.setName(request.getName());
        // product.setPrice(request.getPrice());
        // product.setDescription(request.getDescription());
        // product.setAvailable(request.isAvailable());

        // repository.saveAndFlush(product);

        // ProductDTO response = new ProductDTO();
        // response.setName(product.getName());
        // response.setPrice(product.getPrice());
        // response.setDescription(product.getDescription());
        // response.setAvailable(product.isAvailable());

        return Optional.of(response);
    }

    @Override
    public List<ProductDTO> getAll() {

        List<Product> products = repository.findAll();
        List<ProductDTO> responses = new ArrayList<>();

        products.forEach(product -> {
            ProductDTO response = mapper.map(product, ProductDTO.class);
            responses.add(response);
        });

        // or
        // for (Product product : products) {
        // ProductDTO response = mapper.map(product, ProductDTO.class);
        // responses.add(response);
        // }

        return responses;
    }

    @Override
    public Optional<ProductDTO> getById(Long id) {
        Optional<Product> product = repository.findById(id);
        if (product.isPresent()) {
            return Optional.of(mapper.map(product.get(), ProductDTO.class));
        }
        return Optional.empty();
    }

    @Override
    public Optional<ProductDTO> update(Long id, ProductDTO request) {
        Optional<Product> optionalProduct = repository.findById(id);
        if (optionalProduct.isPresent()) {
            Product productToUpdate = optionalProduct.get();
            mapper.map(request, productToUpdate); // Update the fields of the existing product
            Product savedProduct = repository.save(productToUpdate);
            ProductDTO response = mapper.map(savedProduct, ProductDTO.class);
            return Optional.of(response);
        }
        return Optional.empty();
    }





    // implementação de um DELETE lógico:
    @Override
    public boolean inactive(Long id) {

        Optional<Product> product = repository.findById(id);

        if(product.isPresent()){
            product.get().setAvailable(false);
            return true;
        }
        return false;
    }

    // // implementação de um DELETE físico:
    // @Override
    // public boolean delete(Long id) {
    //     Optional<Product> product = repository.deleteById(id);

    //     if(product.isPresent()){
    //         repository.deleteById(id);
    //         return true;
    //     }
    //     return false;
    // }

}
