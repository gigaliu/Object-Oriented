import java.util.Scanner;

class Animal {
    String name;
    float height;
    float weight;
    float speed;

    void showInfo(int x) {
        System.out.print("姓名:" + name);
        System.out.print(" 身高:" + height);
        System.out.print(" 體重:" + weight);
        System.out.print(" 速度:" + speed);
        System.out.print(" 奔跑距離" + x * speed);
        System.out.println();
    }
}

public class A1093370_0324_1 {
    public static void main(String[] argv) {
        Animal firstone = new Animal();
        firstone.name = "snowman";
        firstone.height = 1.1f;
        firstone.weight = 52f;
        firstone.speed = 100f;

        Animal thesecond = new Animal();
        thesecond.name = "donkey";
        thesecond.height = 1.5f;
        thesecond.weight = 99f;
        thesecond.speed = 200f;

        Animal thethird = new Animal();
        thethird.name = "Anna";
        thethird.height = 1.7f;
        thethird.weight = 48f;
        thethird.speed = 120f;

        Animal thefourth = new Animal();
        thefourth.name = "Elsa";
        thefourth.height = 1.7f;
        thefourth.weight = 50f;
        thefourth.speed = 120f;

        System.out.print("輸入動物跑步分鐘:");
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        System.out.print("輸入動物加速度:");
        Scanner sc2 = new Scanner(System.in);
        float y = sc2.nextFloat();

        System.out.print("輸入動物移動速度:");
        Scanner sc3 = new Scanner(System.in);
        float z = sc3.nextFloat();

        System.out.println("動物的奔跑距離：" + x * y * z);

        firstone.showInfo(x);
        thesecond.showInfo(x);
        thethird.showInfo(x);
        thefourth.showInfo(x);
    }
}
