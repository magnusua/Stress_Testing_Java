package Task4;

import java.util.Arrays;

/**
 * сравнивает 2 строки одинаковые ли они. Результат: вывод «ОК»,
 * если строки идентичны, «КО», если не идентичны.
 * Строки подаются в виде аргументов командной строки.
 * Во второй строке может быть символ ‘*’ – он заменяет собой любое количество любых символов.
 *
 * @author Kugot Nick
 * @version 1.0
 */

public class Main {
    public static void main(String[] cmdLineArgs) {
        if (cmdLineArgs.length == 2) { //проверка наличия 2 строк
            char any = '*'; //любое количество любых символов т.е. 0 символов включительно
            char[] one = cmdLineArgs[0].toCharArray();
            char[] two = cmdLineArgs[1].toCharArray();
            if (Arrays.equals(one, two)) ok(); //полное соответствие
            for (int i = 0; i < Math.min(one.length, two.length); i++) {
                if (one[i] != two[i] && (two[i] != any)) ko();
                if (two[i] == any) ok();
            }
            if ((one.length < two.length && (two[one.length] != any)) || (one.length > two.length)) {
                ko();
            } else ok(); // в конце второй строки присутствие "любого" символа
        } else Usage();
    }

    public static void ok() {
        System.out.println("ОK");
        System.exit(0);
    }

    public static void ko() {
        System.out.println("KО");
        System.exit(0);
    }

    public static void Usage() {
        System.out.println("Usage:" + System.lineSeparator() +
                "Параметры для работы программы следует передавать в виде двух строк, например:" + System.lineSeparator() +
                "«аааа» «аааа»" + System.lineSeparator() +
                "«аааа» «аа*»" + System.lineSeparator() +
                "«a» «*****»" + System.lineSeparator() +
                "где * заменяет собой любое количество любых символов.");
        System.exit(1);
    }
}
