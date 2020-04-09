package Lesson_2;

public class Array {
    private int[] arr;
    private int capacity;
    private int size;

    public Array(int capacity) {
        this.arr = new int[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    /**
     * Получить элемент массива по индексу
     *
     * @param n
     * @return
     */
    public int get(int n) {
        return arr[n];
    }

    /**
     * Установить значение элемента массива по индексу
     *
     * @param n
     * @param val
     */
    public boolean set(int n, int val) {
        if (size >= n) {
            arr[n] = val;
            return true;
        }
        return false;
    }

    /**
     * Добавить элемент в конец массива
     *
     * @param val
     */
    public boolean add(int val) {
        if (size < capacity) {
            arr[size] = val;
            size++;
            return true;
        }
        return false;
    }

    /**
     * Удаление элемента по индексу
     *
     * @param n
     * @return
     */
    public boolean delete(int n) {
        if (n < size) {
            for (int i = n; i < size; i++) {
                arr[i] = arr[i + 1];
            }
            size--;
            return true;
        }
        return false;
    }

    /**
     * Получить размер массива
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * Очистить массив
     */
    public void clear() {
        size = 0;
    }

    /**
     * Простой поиск по массиву
     *
     * @param value
     * @return
     */
    public boolean find(int value) {
        int i;
        for (i = 0; i < size; i++) {
            if (arr[i] == value) {
                return true;
            }
        }
        return false;
    }

    /**
     * Двоичный поиск по массиву
     *
     * @param value
     * @return
     */
    public boolean binaryFind(int value) {
        int low = 0;
        int high = size - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (value == arr[mid]) {
                return true;
            } else {
                if (value < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return false;
    }

    /**
     * Вывод массива в консоль
     */
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    /**
     * Заполнение массива случайными числами если массив пустой
     *
     * @return
     */
    public boolean completelyFillRandomNumber(int numCap) {
        if (size == 0) {
            for (int i = 0; i < capacity; i++) {
                arr[i] = (int) (Math.random() * numCap);
            }
            size = capacity;
            return true;
        }
        return false;
    }

    /**
     * Сортировка массива методом пузырька
     */
    public void sortBubbleMethod() {
        int temp;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Сортировка методом выбора
     */
    public void sortSelectMethod() {
        int temp;
        for (int i = 0; i < size - 1; i++) {
            int indexMin = i;
            for (int j = i; j < size; j++) {
                if (arr[j] < arr[indexMin]) {
                    indexMin = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[indexMin];
            arr[indexMin] = temp;
        }
    }

    /**
     * Быстрая сортировка
     */
    public void sortQuickMethod() {
        quickSort(arr, 0, size - 1);
    }

    public void quickSort(int[] array, int low, int high) {
        if (array.length == 0)
            return;//завершить выполнение если длина массива равна 0
        if (low >= high)
            return;//завершить выполнение если уже нечего делить
        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        int opora = array[middle];

        //Деление на на два массива которые больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < opora) {
                i++;
            }
            while (array[j] > opora) {
                j--;
            }
            //Проверяем значения и мменяем местами
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        // Сортировка частей массива
        if (low < j)
            quickSort(array, low, j);
        if (high > i)
            quickSort(array, i, high);
    }
}
