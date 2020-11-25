package Task1;

/**
 * конвертировать число из десятичной системы исчисления в любую другую
 * Запуск с аргументами: "nb base" - где nb – это подаваемое число, base – система исчисления
 * конвертировать число из указанной системы исчисления в любую другую
 * "nb baseSrc baseDst" - где baseSrc система счисления nb, а baseDst целевая система");
 *
 * @author Kugot Nick
 * @version 1.0
 */

import java.util.Optional;

public class Main {
    public static void main(String[] cmdLineArgs) {

        if (cmdLineArgs.length <= 1) {
            Usage();
        }
        String nb = cmdLineArgs[0];
        String numberSystemDst = cmdLineArgs[cmdLineArgs.length - 1]; //целевая система
        if (cmdLineArgs.length == 2) {
            System.out.println(itoBase(nb, Optional.empty(), numberSystemDst)); // itoBase();
        }
        if (cmdLineArgs.length == 3) {
            String baseSrc = cmdLineArgs[1];
            System.out.println(itoBase(nb, Optional.ofNullable(baseSrc), numberSystemDst));
        }
    }

    public static String itoBase(String nb, Optional<String> baseSrc, String baseDst) {
        int n = 0;
        String decimal = "0123456789";
        String charsSrc = baseSrc.orElse(decimal); // используется если передается 2 аргумента
        if (!charsSrc.equals(decimal)) { //hex2Decimal
            charsSrc = charsSrc.toUpperCase();
            nb = nb.toUpperCase();
            for (int i = 0; i < nb.length(); i++) {
                char c = nb.charAt(i);
                int d = charsSrc.indexOf(c);
                n = charsSrc.length() * n + d;
            }
        } else {
            try {
                n = Integer.parseInt(nb); //если не указана система нумерации то 1 число должно decimal
            } catch (Exception e) {
                Usage();
            }
        }
        if (n <= 0) Usage();
        String hex = ""; //decimal2Hex
        while (n > 0) {
            int digit = n % baseDst.length();   // rightmost digit
            hex = baseDst.charAt(digit) + hex;  // string concatenation
            n = n / baseDst.length();
        }
        return hex;
    }

    public static void Usage() {
        System.out.println("Usage:" + System.lineSeparator() +
                "Параметры для работы программы следует передавать в виде:" + System.lineSeparator() +
                "nb base" + System.lineSeparator() +
                "где nb это подаваемое число, base система исчисления. Или " + System.lineSeparator() +
                "nb baseSrc baseDst" + System.lineSeparator() +
                "где baseSrc - система счисления nb, а baseDst - целевая система" + System.lineSeparator() +
                "пример, «01» - двоичная, «012» - троичная, «0123456789abcdef» - " +
                "шеснадцатиричная, «котики» - система исчисления в котиках");
        System.exit(1);
    }
}