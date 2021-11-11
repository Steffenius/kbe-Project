

/**
 * @author Hitzek, Steffen; Matr.Nr 566507
 * @author Schöbel, Susann; Matr.Nr 571657
 */
package payroll;

import java.util.UUID;

class EmployeeNotFoundException extends RuntimeException {

    EmployeeNotFoundException(UUID id) {
        super("Could not find employee " + id);
    }
}
