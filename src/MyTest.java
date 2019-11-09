import org.junit.Test;
import static org.junit.Assert.*;

public class MyTest {

    @Test
    public void testStatement() {
        Movie m1 = new Movie("Naruto", 2);
        Movie m2 = new Movie("Dragon Prince", 1);
        Movie m3 = new Movie("3-gatsu no Lion", 0);

        Customer c1 = new Customer("Tay");

        Rental r1 = new Rental(m1, 15);
        Rental r2 = new Rental(m2, 3);
        Rental r3 = new Rental(m3, 30);

        assertEquals(c1.statement(), "Rental Record for Tay\nAmount owed is 0.0\nYou earned 0 frequent renter points");

        c1.addRental(r3);
        assertEquals(c1.statement(), "Rental Record for Tay\n\t3-gatsu no Lion\t44.0\nAmount owed is 44.0\nYou earned 1 frequent renter points");

        c1.addRental(r1);
        c1.addRental(r2);
        assertEquals(c1.statement(), "Rental Record for Tay\n\t3-gatsu no Lion\t44.0\n\tNaruto\t19.5\n\tDragon Prince\t9.0\nAmount owed is 72.5\nYou earned 4 frequent renter points");
    }

}