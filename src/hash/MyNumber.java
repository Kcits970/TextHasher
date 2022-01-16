package hash;

public class MyNumber {
    String stringForm;
    public int value;
    public int radix;

    public MyNumber(String stringForm, int radix) {
        this.stringForm = stringForm;
        this.radix = radix;
        this.value = Integer.parseInt(stringForm, radix);
    }

    public MyNumber(int value, int radix) {
        this.stringForm = "";
        this.value = value;
        this.radix = radix;

        do {
            stringForm = toCharDigit(value % radix) + stringForm;
            value /= radix;
        } while (value != 0);
    }

    public MyNumber changeRadix(int newRadix) {
        return new MyNumber(value, newRadix);
    }

    @Override
    public String toString() {
        return stringForm;
    }

    public static char toCharDigit(int digit) {
        if (digit < 0) return '-';
        else if (digit < 10) return (char) ('0' + digit);
        else if (digit <= 36) return (char) ('a' + digit - 10);
        else return '#';
    }
}
