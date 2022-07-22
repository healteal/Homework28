package Task17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class General {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static Comparator<Integer> comparator = Comparator.naturalOrder();
    static TreeSet<Integer> numbers = new TreeSet<>(comparator);

    public static void main(String[] args) {
        while (true) {
            menu();
        }
    }

    static void menu() {
        System.out.println("1. Посмотреть числа");
        System.out.println("2. Получить число К-ое по минимальности из ряда чисел");
        System.out.println("3. Добавить число во множество");
        System.out.println("4. Выход");
        int choice;
        try {
            choice = Integer.parseInt(reader.readLine());
        } catch (NumberFormatException | IOException e) {
            throw new RuntimeException(e);
        }
        switch (choice) {
            case 1: {
                showNumbers();
                break;
            }
            case 2: {
                getPosInQueue();
                break;
            }
            case 3: {
                addNumber();
                break;
            }
            case 4: {
                System.exit(1);
            }
            default: {
                System.out.println("Неверный ввод");
            }
        }
    }

    static void showNumbers() {
        numbers.forEach(x -> System.out.print(x + " "));
        System.out.println();
    }

    static void getPosInQueue() {
        System.out.println("Введите позицию числа:");
        int index;
        try {
            index = Integer.parseInt(reader.readLine());
        } catch (NumberFormatException | IOException e) {
            throw new RuntimeException(e);
        }
        if (index >= numbers.size()) {
            System.out.println("Столько чисел нет во множестве");
            return;
        }
        Iterator<Integer> integerIterator = numbers.iterator();
        int counter = 0;
        while (integerIterator.hasNext()) {
            if (index == counter) {
                System.out.println("В нашем множестве на позиции " + index + " стоит число " + integerIterator.next());
                return;
            }
            integerIterator.next();
            counter++;
        }
        System.out.println("Вашего числа нету во множестве");
    }

    static void addNumber() {
        System.out.println("Введите число:");
        int number;
        try {
            number = Integer.parseInt(reader.readLine());
        } catch (NumberFormatException | IOException e) {
            throw new RuntimeException(e);
        }
        numbers.add(number);
    }
}
