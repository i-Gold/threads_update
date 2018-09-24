package ThreadsTask;

import java.util.List;

public class MyThread implements Runnable {

    @Override
    public void run() {
        List<Integer> generatedRandomList = new ListOfRandomNumbers().generateListOfRandomNumbers();
        List<Integer> extractNumbers = new ListOfRandomNumbers().extractNumbersFromRandomList(generatedRandomList);
        new ListOfRandomNumbers().sortList(extractNumbers);
        showExtractedList(extractNumbers);
    }

    public void generateThreads() {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new MyThread());
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void showExtractedList(List<Integer> list) {
        System.out.print(new Thread().getName() + ": \t");
        for (Integer value : list) {
            System.out.print(value + "\t");
        }
        System.out.println();
    }
}
