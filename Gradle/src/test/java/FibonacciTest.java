import static org.junit.Assert.*;
import java.lang.reflect.Field;
import org.junit.Test;

/**
 * Updated tests.
 * 
 * @author raf
 * @version 20191113
 */
public class FibonacciTest {

    private static final String CLASS = "Fibonacci";


    private Class<?> getClass(String name) {
        try {
            Package pkg = getClass().getPackage();
            String path = (pkg == null || pkg.getName().isEmpty())
                ? ""
                : pkg.getName() + ".";
            return Class.forName(path + name);
        }
        catch (ClassNotFoundException e) {
            fail(String.format("Class '%s' doesn't exist", name));
        }
        return null;
    }


    @Test
    public void testNoFields() {
        Field[] iFields = getClass(CLASS).getDeclaredFields();

        for (Field f : iFields) {
            if (!f.isSynthetic()) {
                fail(
                    "No fields must be defined. Field \"" + f.getName()
                        + "\" found.");
            }
        }
    }


    @Test
    public void testWithNegativeThrowsException() {
        for (long number : new long[] { -1, -42, Integer.MIN_VALUE }) {
            try {
                Fibonacci.fibonacci(number);
                fail("no illegal argument exception detected");
            }
            catch (IllegalArgumentException e) {
                String expected = "number cannot be negative";
                String actual = e.getMessage();
                assertEquals("unexpected result", expected, actual);
            }
        }
    }


    @Test
    public void testWith0() {
        long number = 0;
        long expected = 0;
        long actual = Fibonacci.fibonacci(number);
        assertEquals("unexpected result", expected, actual);
    }


    @Test
    public void testWith1() {
        long number = 1;
        long expected = 1;
        long actual = Fibonacci.fibonacci(number);
        assertEquals("unexpected result", expected, actual);
    }


    @Test
    public void testWith6() {
        long number = 6;
        long expected = 8;
        long actual = Fibonacci.fibonacci(number);
        assertEquals("unexpected result", expected, actual);
    }


    @Test
    public void testWith10() {
        long number = 10;
        long expected = 55;
        long actual = Fibonacci.fibonacci(number);
        assertEquals("unexpected result", expected, actual);
    }


    @Test
    public void testWith20() {
        long number = 20;
        long expected = 6765;
        long actual = Fibonacci.fibonacci(number);
        assertEquals("unexpected result", expected, actual);
    }


    @Test
    public void testWith42() {
        long number = 42;
        long expected = 267914296L;
        long actual = Fibonacci.fibonacci(number);
        assertEquals("unexpected result", expected, actual);
    }
}
