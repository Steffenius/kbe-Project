package kbe.kbeproject.products;

/**
 * @author Hitzek, Steffen; Matr.Nr 566507
 * @author Schöbel, Susann; Matr.Nr 571657
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.List;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    // Creates List of Product taking from CsvImporter
    private List<Product> productList = new CsvImporter("pineAppleProducts.csv").getProductsFromCSV();

    LoadDatabase() throws FileNotFoundException, URISyntaxException {
    }


    @Bean
    CommandLineRunner initDatabase(@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection") ProductRepository productRepository) {
        // an Error like "Could not autowire. No beans of 'ClassRepository' type found." can be ignored,
        // because it exists in ClassRepository-Interface.
        // see @ ProductRepository (interface)
        return args -> {
            log.info("Preloading " + productRepository.save(
                    new Product("phone",
                                1500,
                                "blau",
                                6.0,
                                "A15",
                                "150GB",
                                3,
                                "Berlin",
                                "Tolles Phone",
                                "krasse Cam",
                                2020)));
            // puts every Object from productList in Database
            productList.forEach(product -> log.info("Preloading " + productRepository.save(product)));
            productRepository.findAll().forEach(product -> log.info("Preloaded " + product));


        };
    };
}
