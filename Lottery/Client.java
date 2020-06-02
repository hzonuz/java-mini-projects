import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {


    public static void main(String[] args) throws Exception{

        Socket socket = new Socket("localhost",1010);
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        DataInputStream dis = new DataInputStream(socket.getInputStream());

        Scanner in = new Scanner( System.in );
        boolean isUsernameOk = false;
        while (!isUsernameOk){
            System.out.println("Enter your username please : ");
            String username = in.nextLine();
            dos.writeUTF(username);
            String userValidation = dis.readUTF();
            if (userValidation.startsWith("Val")) {
                isUsernameOk = true;
                System.out.println("The Game is on");
            }
            else
                System.out.println("Username already exists");
        }

        Thread messageListener = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        String message = dis.readUTF();
                        System.out.println(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        messageListener.start();

        while (true) {
            System.out.println("Enter a number : ");
            long s = in.nextLong();
            dos.writeUTF(String.valueOf(s));
        }

    }
}
