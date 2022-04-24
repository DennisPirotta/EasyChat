package client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class EasyChat {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost",1234);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        Scanner in = new Scanner(System.in);

        while(socket.isConnected()){
            Welcome.main(null);
            String input = in.next();
            System.out.println(input);
            out.writeObject(input);
        }
    }
}
