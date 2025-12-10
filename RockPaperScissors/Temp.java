import java.util.ArrayList;
import java.util.List;

public class Temp {
    public static void main(String[] args) {
        System.out.println(CheckFactor(24));
        System.out.println(CheckFactor(20));
        System.out.println(CheckFactor(15));
    }

    public static List<Double> CheckFactor(double number) {
        List<Double> factors = new ArrayList<Double>();
        for (Double factor = 2.0; factor < Math.floor(Math.sqrt(number)); factor++) {
            if (number % factor == 0) {
                factors.add(factor);
            }
        }
        return factors;
    }
}