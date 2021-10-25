
import java.util.Scanner;

public class Main {

    private static int[] ints;

    public static void main(String[] args) {
        System.out.println("test");
        MainCommandProccessor proccessor = new MainCommandProccessor();
        proccessor.addSubCommand("Rpail", (s) -> {
            System.out.println("請輸入迴文");
            Scanner input = new Scanner(System.in);
            String line = input.nextLine();
            System.out.println(line + (PalindromeChecker.isPalindromeR(line) ? " " : " 不") + "是迴文");
        });
        proccessor.addSubCommand("Lpail", (s) -> {
            System.out.println("請輸入迴文");
            Scanner input = new Scanner(System.in);
            String line = input.nextLine();
            System.out.println(line + (PalindromeChecker.isPalindromeL(line) ? " " : " 不") + "是迴文");
        });


        proccessor.addSubCommand("exit", (s) -> System.exit(0));

        proccessor.addSubCommand("input", (s) -> setStrs(s));

        proccessor.addSubCommand("ms-a", (s)-> )
        Scanner input = new Scanner(System.in);

        String line;
        do {
            System.out.println("請輸入命令");
            line = input.nextLine();
            proccessor.execute(line);
        } while(!line.equals("exit"));
        return;
    }

    public static void setStrs(String s){
        String[] strs = s.split(",");
        this.ints = new int[strs.length];
        for(int i = 0 ; i < strs.length ; i++){
            ints[i] = Integer.parseInt(strs[i]);
        }
    }
}