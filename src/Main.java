
import java.util.Scanner;
import java.util.LinkedList;

public class Main {

    private static LinkedList<Integer> ints;

    public static void main(String[] args) {
        MainCommandProccessor proccessor = new MainCommandProccessor();

        proccessor.addSubCommand("pail", (s) -> {
            System.out.println("請輸入迴文");
            Scanner input = new Scanner(System.in);
            String line = input.nextLine();
            boolean result;
            if(s.contains("R")) {
                result = PalindromeChecker.isPalindromeR(line);
            } else {
                result = PalindromeChecker.isPalindromeL(line);
            }
            System.out.println(line + (result ? " " : " 不") + "是迴文");
        });



        proccessor.addSubCommand("exit", s -> System.exit(0));

        proccessor.addSubCommand("input", s -> {System.out.println("已輸入數字"); setStrs(s);});

        proccessor.addSubCommand("ms", s-> {
            if(s.equals("-a")) {
                Sorts.mergeSort(ints, (a, b) -> a < b);
            } else if(s.equals("-d")) {
                Sorts.mergeSort(ints, (a, b) -> a > b);
            } else {
                System.out.println("參數錯誤");
                return;
            }
            for(int i : ints) {
                System.out.print(i + " ");
            }
            System.out.println();
        });

        proccessor.addSubCommand("gcd", s -> {
            int option = 0;
            try {
                option = Integer.parseInt(s);
            } catch(Exception e) {
                return;
            }
            if(option > 0 || option < 4){
                return;
            }
            System.out.println("請輸入兩正整數");
            Scanner input = new Scanner(System.in);
            switch(Integer.parseInt(s)) {
            case 1:
                System.out.printf("GCD為 %d\n", GCDandLCM.gcd1(input.nextInt(), input.nextInt()));
                break;
            case 2:
                System.out.printf("GCD為 %d\n", GCDandLCM.gcd2(input.nextInt(), input.nextInt()));
                break;
            case 3:
                System.out.printf("GCD為 %d\n", GCDandLCM.gcd3(input.nextInt(), input.nextInt()));
                break;

            }
        });

        proccessor.addSubCommand("lcm", s -> {
            System.out.println("請輸入兩正整數");
            Scanner input = new Scanner(System.in);
            switch(Integer.parseInt(s)) {
            case 1:
                System.out.printf("LCM為 %d\n", GCDandLCM.lcm1(input.nextInt(), input.nextInt()));
                input.nextLine();
                break;
            case 2:
                System.out.printf("LCM為 %d\n", GCDandLCM.lcm2(input.nextInt(), input.nextInt()));
                input.nextLine();
                break;
            case 3:
                System.out.printf("LCM為 %d\n", GCDandLCM.lcm3(input.nextInt(), input.nextInt()));
                input.nextLine();
                break;
            default:
                System.out.println("參數錯誤");
            }
        });

        proccessor.addSubCommand("diam", s -> {
            System.out.println("請輸入層數");
            Scanner input = new Scanner(System.in);
            if(s.startsWith("R")){
                Shape.printDiamR(input.nextInt());
            }
            else{
                Shape.printDiamL(input.nextInt());
            }
            input.nextLine();
        });

        proccessor.addSubCommand("star", s -> {
            System.out.println("請輸入層數");
            Scanner input = new Scanner(System.in);
            if(s.startsWith("R")){
                Shape.printTriangleR(input.nextInt());
            }
            else{
                Shape.printTriangleL(input.nextInt());
            }
            input.nextLine();
        });

        Scanner input = new Scanner(System.in);

        String line;
        do {
            System.out.println("請輸入命令");
            line = input.nextLine();
            proccessor.execute(line);
        } while(!line.equals("exit"));
        return;
    }

    public static void setStrs(String s) {
        s = s.replace(" ", "");
        String[] strs = s.split(",");
        ints = new LinkedList<>();
        for(int i = 0 ; i < strs.length ; i++) {
            ints.push(Integer.parseInt(strs[i]));
        }
    }
}