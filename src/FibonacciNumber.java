import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FibonacciNumber {
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

    public static List<FibonacciNumber> generateFibonacciNumbers(int n) {
        List<FibonacciNumber> fibonacciNumbers = new LinkedList<>();
        long a = 1;
        long b = 1;
        for (int i = 1; i <= n; i++) {
            fibonacciNumbers.add(new FibonacciNumber(i, a));
            if (i >= 2) {
                long temp = a;
                a = a + b;
                b = temp;
            }
        }
        return fibonacciNumbers;
    }

    public static void printFibonacciNumbers(List<FibonacciNumber> fibonacciNumbers) {
        System.out.println("Згенерованi числа Фiбоначчi:");
        for (FibonacciNumber fibNumber : fibonacciNumbers) {
            System.out.println(fibNumber);
        }
    }

    public static void printValidFibonacciNumbers(List<FibonacciNumber> fibonacciNumbers) {
        System.out.println("Числа Фібоначчi, якi можна представити у формi w^2+1:");
        for (FibonacciNumber fibNumber : fibonacciNumbers) {
            long value = fibNumber.getValue();
            long sqrtValue = (long) Math.sqrt(value - 1);
            if (sqrtValue * sqrtValue + 1 == value) {
                System.out.println(fibNumber);
            }
        }
    }

    public static void main(String[] args) {
        int n;
        if (args.length == 1) {
            n = Integer.parseInt(args[0]);
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введiть кiлькiсть чисел Фiбоначчi, якi ви хочете згенерувати: ");
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
            } else {
                System.out.println("Некоректний формат числа N.");
                return;
            }
        }

        List<FibonacciNumber> fibonacciNumbers = generateFibonacciNumbers(n);
        printFibonacciNumbers(fibonacciNumbers);
        printValidFibonacciNumbers(fibonacciNumbers);
    }
}