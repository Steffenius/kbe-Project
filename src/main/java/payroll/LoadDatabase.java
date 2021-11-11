package payroll;

/**
 * @author Hitzek, Steffen; Matr.Nr 566507
 * @author Schöbel, Susann; Matr.Nr 571657
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);


    @Bean
    CommandLineRunner initDatabase(@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection") EmployeeRepository employeeRepository,
                                   @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection") OrderRepository orderRepository) {
        // an Error like "Could not autowire. No beans of 'ClassRepository' type found." can be ignored,
        // because it exists in ClassRepository-Interface.
        // see @ EmployeeRepository (interface) or/and  OrderRepository (interface)

        return args -> {
            log.info("Preloading " + employeeRepository.save(new Employee("Bilbo", "Baggins", "burglar")));
            log.info("Preloading " + employeeRepository.save(new Employee("Frodo", "Baggins", "thief")));
            log.info("Preloading " + employeeRepository.save(new Employee("Gandalf", "Graurock", "wizard")));

            //employeeRepository.findAll().forEach(employee -> log.info("Preloaded " + employee));


            orderRepository.save(new Order("MacBook Pro", Status.COMPLETED));
            orderRepository.save(new Order("iPhone", Status.IN_PROGRESS));

            orderRepository.findAll().forEach(order -> {
                log.info("Preloaded " + order);
            });
        };
    };
}