import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        long[] tab = new long[5];
        Scanner in = new Scanner(System.in);

        System.out.println("Podaj 5 liczb, których wartość zero-jedynkową chcesz znaleźć: ");
        for(int i = 0; i < tab.length; i++) {
            try {
                System.out.println(i + 1 + ": ");
                tab[i] = in.nextLong();
                if (tab[i] > 20_000) {
                      
                    throw new Exception();
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Błąd! Zły format, nie podano liczby!");
                return;
            }
            catch (Exception e) {
                System.out.println("Podano liczbę powyżej 20_000!");
                return;
            }
        }

        for(long number : tab) {
            System.out.println(number + " -> " + findMultiple(number));
        }
    }

    public static boolean ifZeroAndOne(String value) {
        char[] Array = value.toCharArray();
        for (int i = 0; i < value.length(); i++) {
            if (Array[i] != '1' && Array[i] != '0') {
                return false;
            }
        }
        return true;
    }

    public static String findMultiple(long number) {
        long multiple = 0;
        while (true) {
            multiple += number;
            if (ifZeroAndOne(String.valueOf(multiple))) {
                return String.valueOf(multiple);
            }
            if (multiple > 1_000_000_000_000L) {
                break;
            }
        }
        return "BRAK";
    }
}
