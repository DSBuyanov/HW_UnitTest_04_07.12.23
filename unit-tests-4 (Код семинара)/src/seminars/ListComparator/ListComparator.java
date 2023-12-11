package seminars.ListComparator;

import java.util.List;

public class ListComparator {
    public String compareAverage(List<Integer> list1, List<Integer> list2) {
        double avg1 = average(list1);
        double avg2 = average(list2);

        if (avg1 > avg2) {
            return "Первый список имеет большее среднее значение";
        } else if (avg2 > avg1) {
            return "Второй список имеет большее среднее значение";
        } else {
            return "Средние значения равны";
        }
    }

    private double average(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return 0;
        }
        return list.stream().mapToInt(Integer::intValue).average().orElse(0);
    }
}
    