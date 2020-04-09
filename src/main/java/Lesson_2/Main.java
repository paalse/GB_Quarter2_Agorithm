package Lesson_2;

public class Main {
    public static void main(String[] args) {
        long start;
        long finish;
        int capacity = 100000; //  Емкость массива, а также максимальная разрядность числе в нем

        Array arr = new Array(capacity);

        // Сортировка пузырьком
        arr.clear();
        arr.completelyFillRandomNumber(capacity);
        start = System.currentTimeMillis();
        arr.sortBubbleMethod();
        finish = System.currentTimeMillis();
        System.out.println("Время выполнения сортировки пузырьком: " + (finish - start));

        // Сортировка выбором
        arr.clear();
        arr.completelyFillRandomNumber(capacity);
        start = System.currentTimeMillis();
        arr.sortSelectMethod();
        finish = System.currentTimeMillis();
        System.out.println("Время выполнения сортировки выбором: " + (finish - start));

        // Быстрая сортировка
        arr.clear();
        arr.completelyFillRandomNumber(capacity);
        start = System.currentTimeMillis();
        arr.sortQuickMethod();
        finish = System.currentTimeMillis();
        System.out.println("Время выполнения быстрой сортировки: " + (finish - start));
    }
}