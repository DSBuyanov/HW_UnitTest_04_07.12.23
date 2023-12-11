package seminars.five.ListComparator;

import org.junit.jupiter.api.Test;
import seminars.ListComparator.ListComparator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;

public class ListComparatorTest {
    private final ListComparator comparator = new ListComparator();

    @Test
    public void testFirstListGreater() {
        assertEquals("Первый список имеет большее среднее значение",
            comparator.compareAverage(Arrays.asList(1, 2, 3), Arrays.asList(1, 1)));
    }

    @Test
    public void testSecondListGreater() {
        assertEquals("Второй список имеет большее среднее значение",
            comparator.compareAverage(Arrays.asList(1, 1), Arrays.asList(1, 2, 3)));
    }

    @Test
    public void testEqualAverage() {
        assertEquals("Средние значения равны",
            comparator.compareAverage(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3)));
    }

    @Test
    public void testEmptyOrNullList() {
        assertEquals("Средние значения равны",
            comparator.compareAverage(Arrays.asList(), Arrays.asList()));
        assertEquals("Средние значения равны",
            comparator.compareAverage(null, null));
    }
}
    