import java.util.Arrays;

public class Main {
    public static int SIZE = 10;

    public static void main(String[] args) {

        System.out.println("Рейтинги игроков в региональных командах v.01:");
        int[][] regionalTeams = {
                {45, 31, 24, 22, 20, 17, 14, 13, 12, 10},
                {31, 18, 15, 12, 10, 8, 6, 4, 2, 1},
                {51, 30, 10, 9, 8, 7, 6, 5, 2, 1}
        };
        printArr(regionalTeams);
        int[] nationalTeam = nationalTeam(regionalTeams, SIZE);
        System.out.println("Рейтинги игроков в национальной команде:");
        printArr(nationalTeam);
    }

    public static int[] merge(int[] arrA, int[] arrB, int lengthArr) {
        int[] arrC = new int[lengthArr];

        int countA = 0;
        int countB = 0;
        int countC = 0;

        while ((countA < arrA.length || countB < arrB.length) && countC < lengthArr) {
            if (countA == arrA.length || arrA[countA] <= arrB[countB]) {
                arrC[countC] = arrB[countB];
                countB++;
            } else {
                arrC[countC] = arrA[countA];
                countA++;
            }
            countC++;
        }
        return arrC;
    }

    public static int[] nationalTeam(int[][] regionalTeams, int lengthArr) {
        int[] team = regionalTeams[0];
        for (int i = 1; i < regionalTeams.length; i++) {
            team = merge(team, regionalTeams[i], lengthArr);
        }
        return team;
    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.format("%4d", arr[i]);
        }
        System.out.println();
    }

    public static void printArr(int[][] arr) {
        for (int[] arr1 : arr) {
            printArr(arr1);
        }
    }
}