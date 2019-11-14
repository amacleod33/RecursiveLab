import static org.junit.Assert.*;
import java.lang.reflect.Field;
import org.junit.Test;

public class PathTest {

    private static final String CLASS = "Path";


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
    public void testOnTarget0() {
        int[][] array = new int[][] { { 5, 5, 4, 1 }, { 7, 4, 3, 2 },
            { 6, 5, 7, 3 }, { 6, 6, 5, 4 } };
        String actual = Path.path(array, 2, 2, 7);
        String expected = "";
        assertEquals("unexpected result", expected, actual);
    }


    @Test
    public void testOnTarget1() {
        int[][] array = new int[][] { { 5, 5, 4, 1 }, { 7, 4, 3, 2 },
            { 6, 5, 7, 3 }, { 6, 6, 5, 4 } };
        String actual = Path.path(array, 0, 3, 1);
        String expected = "";
        assertEquals("unexpected result", expected, actual);
    }


    @Test
    public void testOneAwayUp() {
        int[][] array = new int[][] { { 5, 5, 4, 1 }, { 7, 4, 3, 2 },
            { 6, 5, 7, 3 }, { 6, 6, 5, 4 } };
        String actual = Path.path(array, 2, 0, 7);
        String expected = "^";
        assertEquals("unexpected result", expected, actual);
    }


    @Test
    public void testOneAwayDown() {
        int[][] array = new int[][] { { 5, 5, 4, 1 }, { 7, 4, 3, 2 },
            { 6, 5, 7, 3 }, { 6, 6, 5, 4 } };
        String actual = Path.path(array, 2, 3, 4);
        String expected = "v";
        assertEquals("unexpected result", expected, actual);
    }


    @Test
    public void testOneAwayLeft() {
        int[][] array = new int[][] { { 5, 5, 4, 1 }, { 7, 4, 3, 2 },
            { 6, 5, 7, 3 }, { 6, 6, 5, 4 } };
        String actual = Path.path(array, 3, 2, 6);
        String expected = "<";
        assertEquals("unexpected result", expected, actual);
    }


    @Test
    public void testOneAwayRight() {
        int[][] array = new int[][] { { 5, 5, 6, 1 }, { 7, 4, 3, 2 },
            { 6, 5, 7, 3 }, { 6, 6, 5, 4 } };
        String actual = Path.path(array, 0, 1, 6);
        String expected = ">";
        assertEquals("unexpected result", expected, actual);
    }


    @Test
    public void test0() {
        int[][] array = new int[][] { { 5, 5, 4, 1 }, { 7, 4, 3, 2 },
            { 6, 5, 7, 3 }, { 6, 6, 5, 4 } };
        String actual = Path.path(array, 0, 3, 7);
        String expected = "v<<v<^";
        assertEquals("unexpected result", expected, actual);
    }


    @Test
    public void test1() {
        int[][] array = new int[][] { { 2, 3, 4, 5 }, { 5, 4, 7, 6 },
            { 6, 9, 9, 9 }, { 7, 8, 8, 6 } };
        String actual = Path.path(array, 0, 0, 9);
        String expected = ">v<vv>^";
        assertEquals("unexpected result", expected, actual);
    }


    @Test
    public void test2() {
        int[][] array = new int[][] { { 9, 8, 7, 6 }, { 7, 6, 5, 5 },
            { 7, 8, 5, 4 }, { 6, 5, 4, 3 } };
        String actual = Path.path(array, 3, 3, 9);
        String expected = "^^^<<<";
        assertEquals("unexpected result", expected, actual);
    }


    @Test
    public void test3() {
        int[][] array = new int[][] { { 6, 5, 4, 3 }, { 7, -4, -5, 2 },
            { 8, -3, -6, 1 }, { 9, -2, -1, 0 } };
        String actual = Path.path(array, 2, 2, 9);
        String expected = "^<vv>>^^^<<<vvv";
        assertEquals("unexpected result", expected, actual);
    }


    @Test
    public void test4() {
        int[][] array = new int[][] { { 1, 8, 9, 16 }, { 2, 7, 10, 15 },
            { 3, 6, 11, 14 }, { 4, 5, 12, 13 } };
        String actual = Path.path(array, 0, 0, 16);
        String expected = "vvv>^^^>vvv>^^^";
        assertEquals("unexpected result", expected, actual);
    }
}
