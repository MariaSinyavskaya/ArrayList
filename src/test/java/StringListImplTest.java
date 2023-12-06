import org.example.exceptions.InvalidIndexException;
import org.example.impl.StringListImpl;
import org.example.interfaces.StringList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class StringListImplTest {
    private StringList out = new StringListImpl();

    @BeforeEach
    public void setUp() {
        out = new StringListImpl(3);
    }

    @Test
    public void shouldReturnItemForAddMethod() {
        String result = out.add("one");
        assertEquals("one", result);
    }

//    @Test
//    public void shouldReturnItemForAddMethodWithIndex() {
//        String result = out.add(2, "one");
//        assertEquals("one", result);
//    }

    @Test
    public void shouldThrowsInvalidIndexException() {
        out.add("one");
        out.add("two");
        out.add("three");
        assertThrows(InvalidIndexException.class, () -> out.add(3, "four"));
        assertThrows(InvalidIndexException.class, () -> out.set(3, "four"));
        assertThrows(InvalidIndexException.class, () -> out.remove(3));
        assertThrows(InvalidIndexException.class, () -> out.get(3));
    }

    @Test
    public void shouldReturnItemForRemoveMethodWithItem() {
        out.add("one");
        String result = out.remove("one");
        assertEquals("one", result);
    }

    @Test
    public void shouldReturnItemForRemoveMethodWithIndex() {
        out.add("one");
        out.add("two");
        out.add("three");
        String result = out.remove(1);
        assertEquals("two", result);
    }

    @Test
    public void shouldReturnItemForSetMethod() {
        out.add("one");
        out.add("two");
        out.add("three");
        String result = out.set(2, "four");
        assertEquals("four", result);
    }

    @Test
    public void shouldReturnTrueForContainsMethod() {
        out.add("one");
        out.add("two");
        out.add("three");
        assertTrue(out.contains("two"));
    }

    @Test
    public void shouldReturnMinesOneForIndexOfMethod() {
        assertEquals(-1, out.indexOf("one"));
    }

    @Test
    public void shouldReturnIndexForIndexOfMethod() {
        out.add("one");
        out.add("two");
        out.add("three");
        assertEquals(2, out.indexOf("three"));
    }

    @Test
    public void shouldReturnMinesOneForLastIndexOfMethod() {
        assertEquals(-1, out.lastIndexOf("one"));
    }

    @Test
    public void shouldReturnIndexForLastIndexOfMethod() {
        out.add("one");
        out.add("two");
        out.add("three");
        assertEquals(2, out.lastIndexOf("three"));
    }

    @Test
    public void shouldReturnItemForGetMethod() {
        out.add("one");
        out.add("two");
        out.add("three");
        assertEquals("one", out.get(0));
    }
}
