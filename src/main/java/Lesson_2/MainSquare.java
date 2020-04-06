package Lesson_2;

public class MainSquare {
    public static void main(String[] args) {
        int size = 7; // Размерность сторон массива
        int[][] arr = new int[size][size];
        int cnt = size * 2 - 1;
        int n = 1;
        int iDirection = 0;
        int jDirection = 1;
        int i = 0;
        int j = 0;

        while (cnt >= 0) {
            // Горизонталь с лева на право
            if (iDirection == 0 && jDirection == 1) {
                if (j == size - 1 || arr[i][j + 1] != 0) {
                    iDirection = 1;
                    jDirection = 0;
                    cnt--;
                } else {
                    arr[i][j] = n;
                    n++;
                    if (arr[i][j + 1] == 0) {
                        j += jDirection;
                    }
                }
            }
            // Вертикаль сверху в низ
            if (iDirection == 1 && jDirection == 0) {
                if (i == size - 1 || arr[i + 1][j] != 0) {
                    iDirection = 0;
                    jDirection = -1;
                    cnt--;
                } else {
                    arr[i][j] = n;
                    n++;
                    if (arr[i + 1][j] == 0) {
                        i += iDirection;
                    }
                }
            }
            // Горизонталь с право на лево
            if (iDirection == 0 && jDirection == -1) {
                if (j == 0 || arr[i][j - 1] != 0) {
                    iDirection = -1;
                    jDirection = 0;
                    cnt--;
                } else {
                    arr[i][j] = n;
                    n++;
                    if (arr[i][j - 1] == 0) {
                        j += jDirection;
                    }
                }
            }
            // Вертикаль снизу в верх
            if (iDirection == -1 && jDirection == 0) {
                if (i == 0 || arr[i - 1][j] != 0) {
                    iDirection = 0;
                    jDirection = 1;
                    cnt--;
                } else {
                    arr[i][j] = n;
                    n++;
                    if (arr[i - 1][j] == 0) {
                        i += iDirection;
                    }
                }
            }
           // cnt--;
        }
       // n++;
        arr[i][j] = n;  // Вывод последнего числа

        // Вывод на консоль
        for (int k = 0; k < size; k++) {
            for (int l = 0; l < size; l++) {
                System.out.print(arr[k][l] + "\t");
            }
            System.out.println();
        }
    }
}