package sample.Model;

import javafx.scene.control.TextArea;

import java.io.*;
import java.net.Socket;
import java.util.Observable;
import java.util.concurrent.ThreadLocalRandom;

public class ThreadClient extends Observable implements Runnable {
    private Socket socket;
    private DataInputStream bufferDeEntrada = null;


    public ThreadClient(Socket socket) {
        this.socket = socket;

    }

    public void run() {

        try {
            bufferDeEntrada = new DataInputStream(socket.getInputStream());

            String st = "";
            do {
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextLong(1000L)+100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    st = bufferDeEntrada.readUTF();
                    String[] array = st.split(":");

                    this.setChanged();
                    this.notifyObservers(st);
                } catch (IOException e) {
                }
            }while (!st.equals("FIN"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

