package cashregister;

/**
 * Created by wangxichun on 2018/1/12.
 */
public class PrinterMock extends Printer {
    private boolean isExecuteed = false;

    private String printedString;

    @Override
    public void print(String printThis) {
        isExecuteed = true;

        this.printedString = printThis;
    }

    public boolean verifyPrintExecuted() {
        return isExecuteed;
    }

    public boolean verifyPrintRigth(String s) {
        return printedString.equals(s);
    }
}
