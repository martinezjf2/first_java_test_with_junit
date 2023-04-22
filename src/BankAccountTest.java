import static org.junit.Assert.*;

public class BankAccountTest {
    private BankAccount account;
    private static int count;

    @org.junit.BeforeClass
    public static void beforeClass(){
        System.out.println("\n");
        System.out.println("This executes before any test cases...");
        System.out.println("\n");
    }

    @org.junit.Before
    public void setup(){
        account = new BankAccount("Jeffrey", "Martinez", 1000.00, BankAccount.CHECKING);
        System.out.println("Running a test...");
    }


    @org.junit.Test
    public void check_attributes_if_exists(){
        assertEquals("Missing getter or attribute of firstName", "Jeffrey", account.getFirstName());
        assertEquals("Missing getter or attribute of lastName", "Martinez" , account.getLastName());
        assertEquals(1000.00, account.getBalance(), 0);
    }

    @org.junit.Test
    public void deposit() {
        double balance = account.deposit(200.00, true);
        assertEquals(1200.00, balance, 0);
    }

    @org.junit.Test
    public void getBalance_deposit() {
        account.deposit(200.00, true);
        assertEquals(1200.00, account.getBalance(),0);
    }
    @org.junit.Test
    public void getBalance_withdraw() {
        account.withdraw(200.00, true);
        assertEquals(800.00, account.getBalance(),0);
    }

    @org.junit.Test
    public void withdraw_branch() throws Exception {
        double balance = account.withdraw(600.00, true);
        assertEquals(400.00, balance, 0);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void withdraw_not_branch() throws Exception {
            account.withdraw(600.00, false);
            fail("Should have thrown IllegalArgumentException if branch does not exist");
    }

    @org.junit.Test
    public void isChecking_true(){
        assertTrue("The account is NOT a checking account", account.isChecking());
    }


    @org.junit.AfterClass
    public static void afterClass(){
        System.out.println("\n");
        System.out.println("Great Job on Passing all the Tests! Tests Passed: " + count + "/5");
    }

    @org.junit.After
    public void increment_when_test_passed(){
        count++;
    }
}
