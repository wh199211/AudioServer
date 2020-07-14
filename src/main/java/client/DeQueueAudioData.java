package client;

import utils.DataQueue;

import java.util.Arrays;

public class DeQueueAudioData implements Runnable {
    private DataQueue queue = DataQueue.getInstance();

    private void deQueue() throws InterruptedException {

        while (true) {
            Thread.sleep(20);
            System.out.println(Arrays.toString(queue.poll()));
        }
    }

    @Override
    public void run() {
        try {
            deQueue();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
