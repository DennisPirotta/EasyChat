package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(1234);
        ArrayList<ClientHandler> clients = new ArrayList<>();

        while(!server.isClosed()){
            Socket clientSocket = server.accept();
            ClientHandler client = new ClientHandler(clientSocket);
            client.start();
            clients.add(client);
        }
    }
}
