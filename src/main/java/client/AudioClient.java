package client;


import utils.DataQueue;
import java.io.IOException;
import java.net.*;
import java.util.Arrays;

public class AudioClient implements Runnable{
    private String serverIP;
    private int serverPort;
    private DatagramSocket socket;
    private DataQueue queue = DataQueue.getInstance();

    public AudioClient(String serverIP, int serverPort, int hostPort) throws SocketException {
        this.serverIP = serverIP;
        this.serverPort = serverPort;
        this.socket = new DatagramSocket(hostPort);
    }

    public void send(String msg) throws IOException {
        byte [] s = msg.getBytes();
        DatagramPacket send = new DatagramPacket(s, s.length, InetAddress.getByName(serverIP), serverPort);
        socket.send(send);
    }


    public void recvData() throws IOException {

        while (true) {
            DatagramPacket recv = new DatagramPacket(new byte[4096], 4096);
            socket.receive(recv);
            byte [] byteData = recv.getData();

            String [] hexData = new String[recv.getLength()];
            StringBuilder line = new StringBuilder();
            for (int i = 0; i < recv.getLength(); i++){
                String strHex = Integer.toHexString(byteData[i] & 0xff);
                hexData[i] = (strHex.length() == 1) ? "0" + strHex : strHex; //高位补0
                line.append(hexData[i]).append(" ");
            }
            queue.add(hexData);
            //System.out.println(line.toString().trim());
        }
    }

    @Override
    public void run() {
        try {
            recvData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

