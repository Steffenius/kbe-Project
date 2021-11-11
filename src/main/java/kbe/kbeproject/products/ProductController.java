package kbe.kbeproject.products;/*
 * @author Hitzek, Steffen; Matr.Nr 566507
 * @author Schöbel, Susann; Matr.Nr 571657
 */

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public class ProductController {


        private final ProductRepository repository;
        private final ProductModelAssembler assembler;

        ProductController(ProductRepository repository, ProductModelAssembler assembler) {
            this.repository = repository;
            this.assembler = assembler;
        }

        // all items
        @GetMapping("/products")
        CollectionModel<EntityModel<Product>> all() {

            List<EntityModel<Product>> products = repository.findAll().stream() //
                    .map(assembler::toModel) //
                    .collect(Collectors.toList());

            return CollectionModel.of(products, linkTo(methodOn(ProductController.class).all()).withSelfRel());
        }

        @PostMapping("/products")
        ResponseEntity<?> newProduct(@RequestBody Product newProduct) {

            EntityModel<Product> entityModel = assembler.toModel(repository.save(newProduct));

            return ResponseEntity //
                    .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
                    .body(entityModel);
        }


        // Single item

        @GetMapping("/products/{id}")
        EntityModel<Product> one(@PathVariable Long id) {

            Product employee = repository.findById(id) //
                    .orElseThrow(() -> new ProductNotFoundException(id));

            return assembler.toModel(employee);
        }

        @PutMapping("/products/{id}")
        ResponseEntity<?> replaceProduct(@RequestBody Product newProduct, @PathVariable Long id) {

            Product updatedProduct = repository.findById(id) //
                    .map(product -> {
                        product.setName(newProduct.getName());
                        return repository.save(product);
                    }) //
                    .orElseGet(() -> {
                        newProduct.setId(id);
                        return repository.save(newProduct);
                    });

            EntityModel<Product> entityModel = assembler.toModel(updatedProduct);

            return ResponseEntity //
                    .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
                    .body(entityModel);
        }

        @DeleteMapping("/products/{id}")
        ResponseEntity<?> deleteProduct(@PathVariable Long id) {

            repository.deleteById(id);

            return ResponseEntity.noContent().build();
        }

}

