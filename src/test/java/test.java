import client.AudioClient;
import client.DeQueueAudioData;

import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {

        AudioClient skt = new AudioClient("192.168.0.202", 49153, 10001);
        skt.send("start");
        Thread recvDataThread = new Thread(skt);
        Thread deQueue = new Thread(new DeQueueAudioData());
        recvDataThread.start();

        deQueue.start();

    }
}
