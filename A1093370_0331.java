import java.util.Scanner;

class Animal {
    String name;
    float height;
    float weight;
    float speed;
    public Animal(String name, float height, float weight, float speed) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.speed = speed;
    }
    static void showInfo(){
        System.out.println("歡迎來到冰雪奇緣");
    }
    float distance(float x,float y){
        return x * y * speed;
    }
    void showInfo(float a1,float a2) {
        System.out.print("姓名:" + name);
        System.out.print(" 身高:" + height);
        System.out.print(" 體重:" + weight);
        System.out.print(" 速度:" + speed);
        System.out.print(" 奔跑距離" + distance(a1,a2));
    }
}

class Human extends Animal {
    public String sex;
    void show(float x,float y){
        showInfo(x,y);
        System.out.print("性別"+sex);
    }
    public Human(String name, float height, float weight, float speed, String sex) {
        super(name,height,weight,speed);
        this.sex = sex;
    }
}

class Snow extends Human{
    public String snowskill;
    public Snow(String name, float height, float weight, float speed, String sex,String snowskill){
        super(name,height,weight,speed,sex);
			this.snowskill= snowskill;
		}
    float distance(float x,float y){
            return x * y * speed *2;
        }
    void show(float x,float y){
        showInfo(x,y);
        System.out.print("性別"+sex);
    }
}

public class A1093370_0331 {
    public static void main(String[] argv) {

        Animal firstone = new Animal("snowman", 1.1f, 52f, 100f);
        Animal thesecond = new Animal("donkey",1.5f, 99f, 200f);
        Human thethird = new Human("Kristoff", 1.9f, 80f, 150f, "male");
        Human thefourth = new Human("Hans", 1.7f, 78f, 130f, "male");
        Human thefifth = new Human("Anna", 1.7f, 48f, 120f, "female");
        Snow thesixth = new Snow("Elsa", 1.7f, 50f, 120f, "female", "ice powers");

        System.out.print("輸入動物跑步分鐘:");
        Scanner sc = new Scanner(System.in);
        float b = sc.nextFloat();

        System.out.print("輸入動物加速度:");
        Scanner sc2 = new Scanner(System.in);
        float y = sc2.nextFloat();

        System.out.print("請輸入性別");
        Scanner sc4 = new Scanner(System.in);
        String a = sc4.next();

        firstone.showInfo(b,y);
        System.out.println();
        thesecond.showInfo(b,y);
        System.out.println();
        thethird.show(b,y);
        System.out.println();
        thefourth.show(b,y);
        System.out.println();
        thefifth.show(b,y);
        System.out.println();
        thesixth.showInfo(b,y);
        System.out.println();
    }
}