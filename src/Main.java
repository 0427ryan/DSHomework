
import java.util.Scanner;
import java.util.LinkedList;

public class Main {

    private static LinkedList<Integer> ints;

    public static void main(String[] args) {
        System.out.println("test");
        MainCommandProccessor proccessor = new MainCommandProccessor();
        proccessor.addSubCommand("Rpail", (s) -> {
            System.out.println("�п�J�j��");
            Scanner input = new Scanner(System.in);
            String line = input.nextLine();
            System.out.println(line + (PalindromeChecker.isPalindromeR(line) ? " " : " ��") + "�O�j��");
        });
        proccessor.addSubCommand("Lpail", (s) -> {
            System.out.println("�п�J�j��");
            Scanner input = new Scanner(System.in);
            String line = input.nextLine();
            System.out.println(line + (PalindromeChecker.isPalindromeL(line) ? " " : " ��") + "�O�j��");
        });


        proccessor.addSubCommand("exit", s -> System.exit(0));

        proccessor.addSubCommand("input", s -> setStrs(s));

        proccessor.addSubCommand("ms-a", s-> {
            Sorts.mergeSort(ints, (a, b) -> a < b); 
            for(int i : ints){
                System.out.print(i + " ");
            }
            System.out.println();
        });
        proccessor.addSubCommand("ms-d", s-> {
            Sorts.mergeSort(ints, (a, b) -> a > b);
            for(int i : ints){
                System.out.print(i + " ");
            }
            System.out.println();
        });
        Scanner input = new Scanner(System.in);

        String line;
        do {
            System.out.println("�п�J�R�O");
            line = input.nextLine();
            proccessor.execute(line);
        } while(!line.equals("exit"));
        return;
    }

    public static void setStrs(String s){
        String[] strs = s.split(",");
        ints = new LinkedList<>();
        for(int i = 0 ; i < strs.length ; i++){
            ints.push(Integer.parseInt(strs[i]));
        }
    }
}