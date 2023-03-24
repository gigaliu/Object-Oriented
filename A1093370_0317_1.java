import java.util.Scanner;

public class A1093370_0317_1 {
    public static void main(String[] argv) {
        Scanner sc = new Scanner(System.in);
        System.out.print("請輸入二維陣列的大小，以空格分隔：");
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] a = new int[m][n];
        System.out.println("請輸入二維陣列的元素，以空格分隔：");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        System.out.println("輸入的二維陣列為：");
        for (int[] i : a) {
            for (int j : i) {
                System.out.print(j + "\t");
            }
            System.out.println();
        }
    }
}
