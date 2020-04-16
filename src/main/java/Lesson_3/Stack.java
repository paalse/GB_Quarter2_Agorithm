package Lesson_3;


public class Stack<T> {
    private T[] arr;
    private int capacity;
    private int top = -1;

    public Stack(int capacity) {
        this.arr = (T[]) new Object[capacity];
        this.capacity = capacity;
    }

    /**
     * Проверка пустой стек или нет
     *
     * @return
     */
    public boolean isEmpty() {
        return (this.top == 0);
    }

    /**
     * Проверка переполнения стека
     *
     * @return
     */
    public boolean isFull() {
        return (this.top == this.capacity - 1);
    }

    /**
     * Положить элемент в стек
     *
     * @param elem
     */
    public void push(T elem) {
        if (isFull()) {
            throw new StackOverflowError();
        }
        this.arr[++this.top] = elem;
    }

    /**
     * Забрать элемент из стека
     * @return
     */
    public T pop() {
        T tmp = this.arr[top];
        this.arr[this.top] = null;
        this.top--;
        return tmp;
    }

    /**
     * Получить последний положенный в стек элемент без его изъятия
     * @return
     */
    public T peek(){
        return this.arr[this.top];
    }


    public void printStack() {
        for (int i = 0; i <= top; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


}
