import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] bookSizes = {14, 16, 19, 32, 32, 32, 56, 69, 72};
        System.out.println("Размеры книг на отсортированной полке: " + Arrays.toString(bookSizes) + "\n"
                + "Введите размер книги для поиска книг большего размера на отсортированной полке");
        String input = scanner.nextLine();
        int inputSize = Integer.parseInt(input);

        int numberOfLargeBooks = numberOfLargeBooks(bookSizes, inputSize);

        System.out.println("Книг большего размера на отсортированной полке: " + numberOfLargeBooks);
    }

    public static int numberOfLargeBooks(int[] arr, int findIndex) {
        int index = -1;
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;
            if (arr[middle] == findIndex) {
                if (arr[middle] == arr[middle + 1]) {
                    left = middle + 1;
                    continue;
                } else {
                    index = middle;
                    break;
                }
            } else if (arr[middle] > findIndex) {
                right = middle - 1;
                if (arr[right] == index) {
                    index = right;
                    break;
                }
            } else if (arr[middle] < findIndex) {
                left = middle + 1;
            }
        }

        int numberOfLargeBooks;
        if (index != -1) {
            numberOfLargeBooks = arr.length - (index + 1);
        } else {
            numberOfLargeBooks = arr.length - left;
        }
        return numberOfLargeBooks;
    }
}

