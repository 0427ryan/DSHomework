
public class GCDandLCM{
    
    public GCDandLCM(){
        
    }

    public static int gcd1(int a, int b){
        return b == 0 ? a : gcd1(b, a % b);
    }

    public static int gcd2(int a, int b){
        return b == 0 ? a : gcd2(b, a - b);
    }

    public static int gcd3(int a, int b){
        int i = a > b ? b : a;
        while(a % i != 0 || b % i != 0){
            i--;
        }
        return i;
    }

    public static int lcm1(int a, int b){
        return a / gcd1(a, b) * b;
    }

    public static int lcm2(int a, int b){
        return a / gcd2(a, b) * b;
    }
    
    public static int lcm3(int a, int b){
        int i = a > b ? a : b;
        while(i % a != 0 || i % b != 0){
            i++;
        }
        return i;
    }
}