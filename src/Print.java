import java.util.Scanner;

public class Print {
   static int time,amount;
    static Scanner scan = new Scanner(System.in);
    public static double[][] input(){
        System.out.println("Введите кол-во грузовиков");
        amount =scan.nextInt();
        System.out.println("Введите вместимость склада (в тоннах)");
        Main.warehouseCapacity=scan.nextInt();
        System.out.println("Введите время погрузки 1 тонны (в минутах)");
        time= scan.nextInt();
        time*=60;
        double[][] truckOption = new double[amount][2];
        for(int i=0;i<amount;i++){
            System.out.println("Введите вместимость " +(i+1)+ " грузовика (в тоннах)");
            truckOption[i][0]=scan.nextDouble();
            System.out.println("Введите время доставки груза " +(i+1)+ " грузовика (в минутах)");
            truckOption[i][1]=scan.nextDouble();
        }
        return truckOption;
    }
    public int getAmount(){
        return amount;
    }
    public int getTime() {
        return time;
    }
}
