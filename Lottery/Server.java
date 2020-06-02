import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {

    static Map <String, ClientHandler> users;
    static long x = ((long) (Math.random() * 90000  + 10000));
    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(1010);
        users = new ConcurrentHashMap<>();
        System.out.println("The answer is : " + x);
        while (true){
            Socket socket = serverSocket.accept();
            ClientHandler ch = new ClientHandler( socket );
            (new Thread(ch)).start();
        }
    }
}

class ClientHandler implements Runnable {

    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;

    ClientHandler(Socket socket) throws Exception {
        this.socket = socket;
        this.dis = new DataInputStream(socket.getInputStream());
        this.dos = new DataOutputStream(socket.getOutputStream());
    }

    @Override
    public void run() {
        String usernameCopy = null;
        try {
            boolean isUsernameOk = false;
            String username = "";
            while (!isUsernameOk) {
                username = this.dis.readUTF();
                usernameCopy = username;
                if (Server.users.containsKey(username)) {
                    String errorMessage = "Error ! Username is already taken !";
                    this.dos.writeUTF(errorMessage);
                } else {
                    String valMessage = "Valid ! Username is valid !";
                    this.dos.writeUTF(valMessage);
                    isUsernameOk = true;
                }
            }
            Server.users.put(username, this);
            System.out.println("User " + username + " Connected!");

            while (true) {
                String message = this.dis.readUTF();
                long ans = Long.parseLong(message);
                if(ans == Server.x) {
                    for (String str : Server.users.keySet()) {
                        if(str.equals(username)) {
                            Server.users.get(str).dos.writeUTF("You won !");
                        }
                        else {
                            Server.users.get(str).dos.writeUTF(username + " won the round !");
                        }
                        Server.users.get(str).dos.writeUTF("Next round is started !");
                        dos.flush();
                    }
                    Server.x = ((long) (Math.random() * 90000  + 10000));
                    System.out.println("The answer is : "+ Server.x);
                }
            }
        } catch (SocketException e) {
            Server.users.remove(usernameCopy);
            System.out.println("User " + usernameCopy + " Disconnected !");
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

