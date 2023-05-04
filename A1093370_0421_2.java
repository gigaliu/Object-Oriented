import java.util.*;

public class A1093370_0421_2 {
    public static void main(String[] argv) {
        Scanner sc = new Scanner(System.in);

        String username;
        String pattern = "[a-z]+";

        System.out.print("請輸入信箱:");
        username = sc.next();

        if (username.matches(pattern)) {
            System.out.print("符合");
        } else {
            System.out.print("不相符");
        }
    }
}
