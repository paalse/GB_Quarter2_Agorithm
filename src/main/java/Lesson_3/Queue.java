package Lesson_3;

public class Queue<T> {
    private T[] arr;
    private int capacity;
    private int size;
    private int begin;
    private int end;

    public Queue(int capacity) {
        this.arr = (T[]) new Object[capacity];
        this.capacity = capacity;
        this.begin = 0;
        this.end = -1;
        this.size = 0;
    }

    /**
     * Проверка заполнена очередь или нет
     *
     * @return
     */
    public boolean isFull() {
        return (this.capacity == this.size ? true : false);
    }

    /**
     * Проверка пустая очередь или нет
     * @return
     */
    public boolean isEmpty() {
        return this.size == 0 ? true : false;
    }

    public int size() {
        return size;
    }

    /**
     * Вставка элемента в очередь
     * @param elem
     */
    public void insert (T elem) {
        if (!isFull()) {
            if (this.end == this.capacity - 1) {
                this.end = -1;
            }
            this.arr[++this.end] = elem;
            this.size++;
        } else {
            throw new StackOverflowError();
        }

    }

    /**
     *
     * @return
     */
    public T remove () {
       T tmp;
        if (this.begin == this.capacity) {
            this.begin = 0;
        }
        tmp = this.arr[this.begin];
        this.arr[this.begin] = null;
        this.begin++;
        this.size--;
        return tmp;
     }

     public void printQueue() {
         for (int i = 0; i < this.capacity; i++) {
             System.out.print(this.arr[i] + " ");
         }
         System.out.println();
     }
}
