
/**
 * reverse a foo
 * 
 * @author amacleod
 * @version 11192019
 */
public class Reverse {

    /**
     * reverses a string of foos
     * 
     * @param foo
     * @return reversed foo
     */
    public static Foo reverse(Foo foo) {

        if (foo.isEmpty()) {
            return foo;
        }

        return reverse(foo.cdr()).concat(foo.car());

    }

}
