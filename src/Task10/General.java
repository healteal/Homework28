package Task10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class General {
    static LinkedList<Integer> array = new LinkedList<>();
    static LinkedList<Integer> employee = new LinkedList<>();
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {

        System.out.println("Введите количество элементов:");
        int count = input();
        for (int i = 0; i < count; i++) {
            System.out.println("Введите элемент, осталось: " + (count - i));
            array.add(input());
        }
        while (array.size() > 1) {
            for (int i = 1; i < array.size(); i++) {
                employee.add(array.get(i) + array.get(i - 1));
                i++;
            }
            array.clear();
            array.addAll(employee);
            employee.clear();
            System.out.println("Шаг:\n" + array);
        }
    }

    static int input() {
        int number;
        while (true) {
            try {
                number = Integer.parseInt(reader.readLine());
                break;
            } catch (NumberFormatException | IOException e) {
                System.out.println("Неверный ввод, попробуйте ещё раз");
            }
        }
        return number;
    }
}
