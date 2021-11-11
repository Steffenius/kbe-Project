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
import payroll.*;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);


    @Bean
    CommandLineRunner initDatabase(@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection") ProductRepository productRepository) {
        // an Error like "Could not autowire. No beans of 'ClassRepository' type found." can be ignored,
        // because it exists in ClassRepository-Interface.
        // see @ EmployeeRepository (interface) or/and  OrderRepository (interface)

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
                                "krasse Cam")));

            productRepository.findAll().forEach(product -> log.info("Preloaded " + product));


        };
    };
}
