import java.util.ArrayList;
import java.util.Scanner;

public class FibonacciNumbers {
    private static class FibonacciNumber {
        private int number;
        private long value;

        public FibonacciNumber(int number, long value) {
            this.number = number;
            this.value = value;
        }

        public int getNumber() {
            return number;
        }

        public long getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "Fibonacci Number " + number + ": " + value;
        }
    }

    public static void main(String[] args) {
        int n;
        if (args.length == 1) {
            n = Integer.parseInt(args[0]);
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введіть кількість чисел Фібоначчі, які ви хочете згенерувати: ");
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
            } else {
                System.out.println("Некоректний формат числа N.");
                return;
            }
        }

        ArrayList<FibonacciNumber> fibonacciNumbers = new ArrayList<>();
        long a = 1;
        long b = 1;

        System.out.println("Згенеровані числа Фібоначчі:");
        for (int i = 1; i <= n; i++) {
            fibonacciNumbers.add(new FibonacciNumber(i, a));
            System.out.println("Fibonacci Number " + i + ": " + a);
            if (i >= 2) {
                long temp = a;
                a = a + b;
                b = temp;
            }
        }

        System.out.println("Числа Фібоначчі, які можна представити у формі w^2+1:");
        for (FibonacciNumber fibNumber : fibonacciNumbers) {
            long value = fibNumber.getValue();
            long sqrtValue = (long) Math.sqrt(value - 1);
            if (sqrtValue * sqrtValue + 1 == value) {
                System.out.println(fibNumber);
            }
        }
    }
}