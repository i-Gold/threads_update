package ThreadsTask;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ListOfRandomNumbers implements Serializable {

    private static final int SIZE_OF_LIST = 1000;

    public List<Integer> generateListOfRandomNumbers() {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < SIZE_OF_LIST; i++) {
            result.add(new Random().nextInt(999));
        }
        return result;
    }

    public synchronized void showList(List<Integer> list) {
        for (Integer value : list) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public synchronized List<Integer> extractNumbersFromRandomList(List<Integer> list) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < list.size() / 20; i++) {
            int value = list.get(i);
            result.add(value);
        }
        return result;
    }

    public List<Integer> sortList(List<Integer> list) {
        Collections.sort(list);
        return list;
    }
}
