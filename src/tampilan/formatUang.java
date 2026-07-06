package utils;

import java.text.NumberFormat;
import java.util.Locale;

public class formatUang {

    private static final NumberFormat nf;

    static {
        nf = NumberFormat.getInstance(new Locale("id", "ID"));
        nf.setMaximumFractionDigits(0);
    }

    public static String format(double angka) {
        return nf.format(angka);
    }
}