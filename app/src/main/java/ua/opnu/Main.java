package ua.opnu;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        // 1. Порожнє значення (наприклад, у користувача немає по-батькові)
        MyOptional<String> middleName = new MyOptional<>();
        System.out.println(middleName); // MyOptional[empty]
        System.out.println("isPresent: " + middleName.isPresent()); // false
        System.out.println("orElse: " + middleName.orElse("немає")); // "немає"

        // 2. Заповнене значення (наприклад, логін користувача)
        MyOptional<String> username = new MyOptional<>("admin");
        System.out.println(username); // MyOptional[value=admin]
        System.out.println("isPresent: " + username.isPresent()); // true
        System.out.println("get(): " + username.get()); // "admin"
        System.out.println("orElse: " + username.orElse("guest")); // "admin"

        // 3. Перевіримо, що get() на порожньому об'єкті кидає помилку
        try {
            String test = middleName.get(); // має кинути IllegalStateException
            System.out.println("unexpected: " + test);
        } catch (IllegalStateException ex) {
            System.out.println("Очікуваний виняток: " + ex.getMessage());
        }

        // 4. Перевіримо, що конструктор не приймає null
        try {
            MyOptional<String> broken = new MyOptional<>(null);
            System.out.println("unexpected: " + broken);
        } catch (IllegalArgumentException ex) {
            System.out.println("Правильно не дозволив null: " + ex.getMessage());
        }
        System.out.println();

        // task3
        Printer myPrinter = new Printer();
        Integer[] intArray = {1, 2, 3};
        String[] stringArray = {"Hello", "World"};
        myPrinter.printArray(intArray);
        myPrinter.printArray(stringArray);

        // task 6
        System.out.println();
        GenericTwoTuple<String, Integer> student = new GenericTwoTuple<>("Марія", 95);
        System.out.println("Студент: " + student);

        GenericTwoTuple<String, Integer> product = new GenericTwoTuple<>("Телефон", 20000);
        System.out.println("Товар: " + product);

        GenericThreeTuple<String, Integer, String> productWithBrand =
                new GenericThreeTuple<>("Телефон", 20000, "Samsung");
        System.out.println("Товар з брендом: " + productWithBrand);
    }


    //task4
    public static <T> T[] filter(T[] input, Predicate<T> p) {
        T[] array = (T[]) new Object[input.length];
        int counter = 0;
        for (T item : input) {
            if (p.test(item)) {
                array[counter] = item;
                counter++;
            }
        }
        return Arrays.copyOfRange(array, 0, counter);
    }
    //task5
    public static <T extends Comparable<T>, V extends T> boolean contains(T[] array, V element) {
        for (T str : array)
            if (str.equals(element))
                return true;

        return false;
    }
}

class Printer {
    public <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }
}

class GenericTwoTuple<T, V> {
    public final T first;
    public final V second;

    public GenericTwoTuple(T first, V second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "(" + first + "," + second + ')';
    }
}

class GenericThreeTuple<T, V, S> {
    public final GenericTwoTuple<T, V> firstTwo;
    public final S three;

    public GenericThreeTuple(T first, V second, S three) {
        this.firstTwo = new GenericTwoTuple<>(first, second);
        this.three = three;
    }

    @Override
    public String toString() {
        return "(" + firstTwo.first + "," + firstTwo.second + "," + three + ')';
    }
}
