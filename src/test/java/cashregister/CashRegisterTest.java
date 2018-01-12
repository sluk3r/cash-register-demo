package cashregister;

import org.junit.Test;
import static org.junit.Assert.*;

public class CashRegisterTest {


    @Test
    public void should_print_null_purchase() {
        //initialize CashRegister and fake Printer

        CashRegister cashRegister = new  CashRegister(new Printer());
        try {
            cashRegister.process(null);
            fail("‘here");
        } catch (Exception e) {

        }
        //verify that printer was called
    }

    @Test
    public void should_print_execute() {
        PrinterMock printerMock = new PrinterMock();
        CashRegister cashRegister = new  CashRegister(printerMock);
        Item item = new Item("" ,11.3d);
        cashRegister.process(new Purchase(new Item[] {item}));
        assertEquals(true, printerMock.verifyPrintExecuted());
    }



    @Test
    public void should_print_rightly() {
        PrinterMock printerMock = new PrinterMock();
        CashRegister cashRegister = new  CashRegister(printerMock);

        final String c = "content";
        Purchase purchaseSub = new Purchase(null) {
            public String asString() {
                return c;
            }
        };

        cashRegister.process(purchaseSub);

        assertEquals(true, printerMock.verifyPrintRigth(c));
    }
}