import java.io.*;

public class A1093370_0421_1 {

    public static void main(String[] argv) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;
        boolean ismail;
        do {
            ismail = true;
            System.out.print("請輸入電子信箱:");
            str = br.readLine();

            if (!str.matches("[a-z]{9}")) {
                System.out.println("信箱只能有小寫英文字母，且必須是9個字母");
                ismail = false;
            }
        } while (!ismail);
    }
}
