
public class Shape {
    
    public Shape(){
        
    }

    public static void printDiamR(int layer){
        printDiamR(layer - 1, 1);
    }

    private static void printDiamR(int tab, int num){
        for(int i = 0 ; i < tab ; i++){
            System.out.print(" ");
        }
        for(int i = 0 ; i < num * 2 - 1 ; i++){
            System.out.print("+");
        }          
        System.out.println();
        if(tab == 0){
            return;
        }
        
        printDiamR(tab - 1, num + 1);
        
        for(int i = 0 ; i < tab ; i++){
            System.out.print(" ");
        }
        for(int i = 0 ; i < num * 2 - 1 ; i++){
            System.out.print("+");
        }
        System.out.println();
    }

    public static void printDiamL(int layer){
        printTriangleL(layer);

        for(int i = layer - 2 ; i >= 0 ; i--){
            for(int j = 0 ; j < layer - i - 1 ; j++){
                System.out.print(" ");
            }
            for(int j = 0 ; j < i * 2 + 1 ; j++){
                System.out.print("+");
            }
            System.out.println();
        }
    }

    public static void printTriangleL(int layer){
        for(int i = 0 ; i < layer ; i++){
            for(int j = 0 ; j < layer - i - 1 ; j++){
                System.out.print(" ");
            }
            for(int j = 0 ; j < i * 2 + 1 ; j++){
                System.out.print("+");
            }
            System.out.println();
        }
    }

    public static void printTriangleR(int layer){
        printTriangleR(1, layer - 1);
    }

    private static void printTriangleR(int layer, int tab){
        if(tab < 0){
            return;
        }
        for(int i = 0 ; i < tab ; i++){
            System.out.print(" ");
        }
        for(int i = 0 ; i < layer * 2 - 1 ; i++){
            System.out.print("+");
        }
        System.out.println();
        printTriangleR(layer + 1, tab - 1);
    }
    
}