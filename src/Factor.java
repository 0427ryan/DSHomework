
import java.util.Map;
import java.util.HashMap;

public class Factor{

    public static Map<Integer, Integer> factorR(int num){
        return factorR(num, 2, 0);
    }

    private static Map<Integer, Integer> factorR(int num, int current, int count){
        if(num % current == 0){
            return factorR(num / current, current, count + 1);
        }
        Map<Integer, Integer> temp = (num == 1) ? new HashMap<>() : factorR(num, current + 1, 0);

        if(count != 0){
            temp.put(current, count);   
        }

        return temp;
    }
    public static Map<Integer, Integer> factorL(int num){
        Map<Integer, Integer> ret = new HashMap<>();
        for(int i = 2; i < num ; i++){
            int count = 0;
            while(num % i == 0){
                count++;
                num /= i;
            }
            if(count != 0){
                ret.put(i, count);
            }
        }
        return ret;
    }
}