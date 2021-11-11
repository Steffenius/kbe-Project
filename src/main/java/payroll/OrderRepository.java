package payroll;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Hitzek, Steffen; Matr.Nr 566507
 * @author Schöbel, Susann; Matr.Nr 571657
 */
interface OrderRepository extends JpaRepository<Order, Long> {
}
