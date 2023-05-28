import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        char[][] field = {
                {'Щ', '-', '-', '*', '*', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '*', '-', '*', '*', '-', '-'},
                {'-', '-', '-', '*', '-', '*', '-', '-', '-', '*'},
                {'-', '*', '-', '-', '-', '-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-', '-', '*', '-', '-', '-'},
                {'-', '-', '*', '-', '-', '*', '-', '-', '-', '-'},
                {'-', '-', '-', '*', '-', '-', '*', '*', '*', '-'},
                {'-', '-', '-', '-', '-', '-', '-', '*', '-', '-'},
                {'-', '-', '-', '-', '-', '-', '-', '*', '-', '-',},
                {'-', '-', '-', '-', '-', '*', '*', '-', '-', '-'},
        };
        System.out.println("Начальное поле");
        printArr(field);
        System.out.println("Путь щенка к человеку, который находится в координатах x=8, y = 3");
        findPath(field, 8, 6);
    }
    public static void printArr(char[][] arr) {
        for (char[] chars : arr) {
            for (char aChar : chars) {
                System.out.format("%2c", aChar);
            }
            System.out.println();
        }
    }

    public static void findPath(char[][] field, int x0, int y0) {
        boolean[][] path = new boolean[field.length][field[0].length];
        char[][] memory = new char[field.length][field[0].length];

        for (char[] chars : memory) {
            Arrays.fill(chars, '0');
        }
        int x = x0;
        int y = y0;
        while (x != 0 || y != 0) {
            char direction = whereFrom(field, x, y, memory);
            if (direction == 'N') {
                System.out.println("Нет такого пути");
                break;
            } else if (direction == 'U') {
                path[x][y] = true;
                y -= 1;
            } else if (direction == 'L') {
                path[x][y] = true;
                x -= 1;
            }
        }
        for (x = 0; x < path.length; x++) {
            for (y = 0; y < path[0].length; y++) {
                if (x == x0 && y == y0) {
                    System.out.printf("%2c", 'Ч');
                } else if (path[x][y]) {
                    System.out.printf("%2c", 'Х');
                } else {
                    System.out.printf("%2c", field[x][y]);
                }
            }
            System.out.println();
        }
    }

    public static char whereFrom(char[][] field, int x, int y, char[][] memory) {
        if (memory[x][y] != '0') {
            return memory[x][y];
        }
        if (x > 0) {
            int leftX = x - 1;
            int leftY = y;
            if (leftX == 0 && leftY == 0) {
                memory[x][y] = 'L';
                return 'L';
            }
            if (field[leftX][leftY] != '*') {
                if (whereFrom(field, leftX, leftY, memory) != 'N') {
                    memory[x][y] = 'L';
                    return 'L';
                }
            }
        }
        if (y > 0) {
            int upX = x;
            int upY = y - 1;
            if (upX == 0 && upY == 0) {
                memory[x][y] = 'U';
                return 'U';
            }
            if (field[upX][upY] != '*') {
                if (whereFrom(field, upX, upY, memory) != 'N') {
                    memory[x][y] = 'U';
                    return 'U';
                }
            }
        }
        memory[x][y] = 'N';
        return 'N';
    }
}