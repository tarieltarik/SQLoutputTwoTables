import java.io.Reader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DbWorker dbWorker = new DbWorker();
        dbWorker.connect();

        System.out.println("1-таблица sport 2-таблица: coach");
        System.out.println("Введите номер таблицы: ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if(num==1){
            System.out.println(dbWorker.showSport());
        }else if(num==2){
            System.out.println(dbWorker.showCoach());
        }else{
            System.out.println("Error!");
        }

    }
}
