package cashregister;

import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Created by wangxichun on 2018/1/12.
 */
public class CashRegisterWithMockitoTest {

    @Test
    public void should_print_execute() {
        Printer printerMocked = mock(Printer.class);
        CashRegister cashRegister = new  CashRegister(printerMocked);
        Item item = new Item("" ,11.3d);
        cashRegister.process(new Purchase(new Item[] {item}));

        verify(printerMocked, times(1)).print(anyString());
    }


    @Test
    public void should_print_rightly() {
        Printer printerMocked = mock(Printer.class);
        CashRegister cashRegister = new  CashRegister(printerMocked);

        final String c = "content";
        Purchase purchaseSub = mock(Purchase.class);
        when(purchaseSub.asString()).thenReturn(c);

        cashRegister.process(purchaseSub);

        verify(printerMocked, times(1)).print(c);
    }

}
