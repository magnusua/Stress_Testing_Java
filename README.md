# Stress_Testing_Java
task1
Реализуйте функцию, которая конвертирует число (без знака) из десятичной системы исчисления в любую другую. Ваша функция должна иметь следующий прототип:
String itoBase(unsigned int nb, String base); nb – это подаваемое число, base – система исчисления.
На пример, «01» - двоичная, «012» - троичная, «0123456789abcdef» - шеснадцатиричная, «котики» - система исчисления в котиках.
Дополнительно*: перегрузите функцию, чтобы она могла конвертировать число из любой системы исчисления в любую другую: String itoBase(String nb, String baseSrc, String baseDst);
Для проверки задания, напишите метод main, который принимает необходимые значения из аргументов командной строки, и выводит результат на экран. При некорректном вводе аргументов должен выводится usage.
<br></br>
Напишите программу, которая сравнивает 2 строки одинаковые ли они. Результат: вывод «ОК», если строки идентичны, «КО», если не идентичны. Строки подаются в виде аргументов командной строки.
Примечание: во второй строке может быть символ ‘*’ – он заменяет собой любое количество любых символов.
На пример:
«аааа» «аааа» - ОК
«аааа» «аа*» - ОК
«a» «*****» - ОК