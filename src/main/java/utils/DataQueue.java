package utils;

import java.util.Arrays;
import java.util.concurrent.LinkedBlockingQueue;

public class DataQueue extends LinkedBlockingQueue<String []> {

    private DataQueue() {
        super();
    }

    private static class holder {
        public static DataQueue instance = new DataQueue();
    }

    public static DataQueue getInstance() {
        return holder.instance;
    }
}
