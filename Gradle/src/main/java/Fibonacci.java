
/**
 * fibonacci
 * 
 * @author amacleod
 * @version 11172019
 */
public class Fibonacci {

    /**
     * returns fibonacci formula of number
     * 
     * @param number
     *            input long
     * @return fibonacci of number
     */
    public static long fibonacci(long number) {
        long finalAns = 0;
        if (number < 0) {
            throw new IllegalArgumentException("number cannot be negative");
        }
        if (number == 0) {
            return 0;
        }
        if (number == 1) {
            return 1;
        }
        else {

            return fibonacci(number - 1) + fibonacci(number - 2);
        }
    }
}
