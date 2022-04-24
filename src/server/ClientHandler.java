package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientHandler extends Thread{
    private final Socket client;
    public ClientHandler(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try{
            ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(client.getInputStream());
            while (client.isConnected()){
                Object input = in.readObject();
                System.out.println(input);
                out.writeObject(input);
            }
        }catch (IOException | ClassNotFoundException ignored){ }
    }


}
