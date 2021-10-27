
public class Shape {
    
    public Shape(){
        
    }

    public static void printDiamR(int layer){
        printDiamR(0, layer);
    }

    private static void printDiamR(int tab, int num){
        if(num == 0){
            return;
        }

        printDiamR(tab + 1, num - 1);
        for(int i = 0 ; i < tab ; i++){
            System.out.print(" ");
        }
        for(int i = 0 ; i < num * 2 + 1 ; i++){
            System.out.print("+");
        }
        System.out.println();
        printDiamR(tab + 1, num - 1);
    }
    
}