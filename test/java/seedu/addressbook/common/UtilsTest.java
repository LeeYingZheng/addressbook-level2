package seedu.addressbook.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class UtilsTest {


    @Test
    public void elementsAreUnique() throws Exception {
        // empty list
        assertAreUnique();

        // only one object
        assertAreUnique((Object) null);
        assertAreUnique(1);
        assertAreUnique("");
        assertAreUnique("abc");

        // all objects unique
        assertAreUnique("abc", "ab", "a");
        assertAreUnique(1, 2);

        // some identical objects
        assertNotUnique("abc", "abc");
        assertNotUnique("abc", "", "abc", "ABC");
        assertNotUnique("", "abc", "a", "abc");
        assertNotUnique(1, new Integer(1));
        assertNotUnique(null, 1, new Integer(1));
        assertNotUnique(null, null);
        assertNotUnique(null, "a", "b", null);

        //one null object
        assertNull(null);

        //at least one null object
        assertNull("abc", null, "ab", "a");
        assertNull("ABC", "AB", null, "A");
        assertNull("a", "b", "c", null);
        assertNull(null, "C", "B", "A");

        //one non-null object
        assertNoNull("ABC");

        //no null objects
        assertNoNull("ABC", "AB", "A");
        assertNoNull("a", "ab", "abc");
        assertNoNull("A", "B", "C");
        assertNoNull(1, 2, new Integer(3));
    }

    private void assertAreUnique(Object... objects) {
        assertTrue(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertNotUnique(Object... objects) {
        assertFalse(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertNull(Object... objects) { assertTrue(Utils.isAnyNull(Arrays.asList(objects))); }

    private void assertNoNull(Object... objects) { assertFalse(Utils.isAnyNull(Arrays.asList(objects))); }
}
