
public class Truck extends Thread{
    int name,k=0,loadingTime,truckTime,race=0;
    double truckCapacity,check,help;
    volatile boolean isHere;
    public Truck(int name,double capacity,double time,int time1){
        this.name=name+1;
        truckCapacity=capacity;
        truckTime= (int) (time*60);
        loadingTime=time1;
    }

    public void run() {
        while(Main.warehouseCapacity>0){
         if(!Main.isEmpty[0] && !Main.isEmpty[1]){
             try {
                 Thread.sleep(loadingTime/10);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }else {
             if(Main.isEmpty[0]) {
                 k=0;
                 Main.isEmpty[k] = false;
             }else{
                 k=1;
                 Main.isEmpty[k]=false;
             }
             check=0;
             while(Main.warehouseCapacity>0&&check<truckCapacity){
                if(truckCapacity-check>1){
                    check++;
                    Main.warehouseCapacity--;
                    try {
                        Thread.sleep(loadingTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    help=truckCapacity-check;
                    Main.warehouseCapacity=Main.warehouseCapacity-check;
                    help=help*10;
                    help=help*(loadingTime/10);
                    check+=help;
                    try {
                        Thread.sleep((long) help);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
             }
             System.out.println(name+" грузовик загружен");
             Main.isEmpty[k]=true;
             isHere=false;
             try {
                 Thread.sleep(truckTime);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
             race++;
             isHere=true;
             System.out.println(name+" грузовик прибыл и ожидает загрузки");
         }
        }
    }
}