package ua.opnu;

public class MyOptional<T> {
    private T value;
    private boolean present;

    // Конструктор без параметрів (порожній)
    public MyOptional() {
        this.value = null;
        this.present = false;
    }

    // Конструктор з параметром
    public MyOptional(T value) {
        if (value == null) {
            throw new IllegalArgumentException("MyOptional не приймає null");
        }
        this.value = value;
        this.present = true;
    }

    // Метод перевірки наявності значення
    public boolean isPresent() {
        return present;
    }

    // Метод перевірки відсутності значення
    public boolean isEmpty() {
        return !present;
    }

    // Метод отримання значення
    public T get() {
        if (!present) {
            throw new IllegalStateException("Cannot get value from empty MyOptional");
        }
        return value;
    }

    // Метод отримання значення або значення за замовчуванням
    public T orElse(T defaultValue) {
        return present ? value : defaultValue;
    }

    // Метод toString
    @Override
    public String toString() {
        if (present) {
            return "MyOptional[value=" + value + "]";
        } else {
            return "MyOptional[empty]";
        }
    }
}
