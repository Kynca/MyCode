public class Main {
    public static volatile double warehouseCapacity;
    public static volatile boolean isEmpty[]={true,true};
    public static void main(String[] args) {
        double timer = 0;
        Print print = new Print();
        double [][] truckOption=print.input();
        int amount = print.getAmount();
        boolean isHere = true, isHere1 = true;
        Truck trucks[] = new Truck[amount];
        for (int i = 0; i < amount; i++) {
            trucks[i] = new Truck(i, truckOption[i][0],truckOption[i][1], print.getTime());
        }
        for (int i = 0; i < amount; i++) trucks[i].start();
        while (warehouseCapacity > 0 || !isHere) {
            isHere = true;
            for (int i = 0; i < amount; i++) {
                if (isHere1 != trucks[i].isHere) isHere = false;
            }
            try {
                Thread.sleep(6);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            timer += 6;
        }
        timer /= 60;
        String ahaha = " ______________\n" +
                "|              ||\"\"\"|\"\"\\__,_\n" +
                "| ____________ ||__ |__|__ |)\n" +
                "|(@) |(@)\"\"\"**|(@)(@)****|(@)";
        System.out.println(ahaha);
        System.out.println("Отгрузка завершена за " + timer + " минут");
        for (int i = 0; i < amount; i++) {
            System.out.println(trucks[i].name + " грузовик совершил " + trucks[i].race + " поездок");
        }
    }
}
