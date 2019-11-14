import static org.junit.Assert.*;
import java.lang.reflect.Field;
import org.junit.Test;

/**
 * Updated Reverse tests.
 * 
 * @author raf
 * @version 20191113
 */
public class ReverseTest {

    private static final String CLASS = "Reverse";


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


    private final static class FooBar
        implements Foo {

        private final String string;


        private FooBar(String string) {
            this.string = string;
        }


        @Override
        public boolean isEmpty() {
            return string.isEmpty();
        }


        @Override
        public Foo car() {
            String head = string.substring(0, 1);
            return new FooBar(head);
        }


        @Override
        public Foo cdr() {
            String tail = string.length() < 2 ? "" : string.substring(1);
            return new FooBar(tail);
        }


        @Override
        public Foo concat(Foo a) {
            String concat =
                string + (a instanceof FooBar ? ((FooBar)a).string : "");
            return new FooBar(concat);
        }


        @Override
        public String toString() {
            return String.format("Foo [%s]", string);
        }


        @Override
        public boolean equals(Object obj) {
            if (obj != null) {
                if (obj == this) {
                    return true;
                }
                if (obj.getClass() == getClass()) {
                    FooBar other = (FooBar)obj;
                    if (string.equals(other.string)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }


    @Test
    public void test0() {
        Foo input = new FooBar("abc");
        Object actual = Reverse.reverse(input);
        Object expected = new FooBar("cba");
        assertEquals("unexpected result", expected, actual);
    }


    @Test
    public void test1() {
        Foo input = new FooBar("escape");
        Object actual = Reverse.reverse(input);
        Object expected = new FooBar("epacse");
        assertEquals("unexpected result", expected, actual);
    }


    @Test
    public void test2() {
        Foo input = new FooBar("open arms");
        Object actual = Reverse.reverse(input);
        Object expected = new FooBar("smra nepo");
        assertEquals("unexpected result", expected, actual);
    }


    @Test
    public void test3() {
        Foo input = new FooBar("only the young");
        Object actual = Reverse.reverse(input);
        Object expected = new FooBar("gnuoy eht ylno");
        assertEquals("unexpected result", expected, actual);
    }


    @Test
    public void test4() {
        Foo input = new FooBar("don't stop believin'");
        Object actual = Reverse.reverse(input);
        Object expected = new FooBar("'niveileb pots t'nod");
        assertEquals("unexpected result", expected, actual);
    }


    @Test
    public void test5() {
        Foo input = new FooBar("dabale arroz a la zorra el abad");
        Object actual = Reverse.reverse(input);
        Object expected = new FooBar("daba le arroz al a zorra elabad");
        assertEquals("unexpected result", expected, actual);
    }
}
