
package simpleconnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class simpleConnection {

    public static void main(String[] args) throws IOException {
        try {
            InetAddress addr;
            // 2605:a000:1301:80ae:69cc:cf0f:e2d5:e721
            try (Socket sock = new Socket("192.168.1.108", 45322)) {
                // 2605:a000:1301:80ae:69cc:cf0f:e2d5:e721
                addr = sock.getInetAddress();
                System.out.println("Connected to " + addr);
                PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
                String userInput;
                while ((userInput = stdIn.readLine()) != null) {
                    out.println(userInput);
                    System.out.println("echo: " + in.readLine());
                    out.flush();

                }
            }

        } catch (java.io.IOException e) {
            //System.out.println("Can't connect to " + args[0]);
            System.out.println(e);
        }

    }
}
