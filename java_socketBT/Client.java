import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 12345);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

            String serverMessage;
            String clientMessage;

            // Bắt đầu vòng lặp để gửi và nhận tin nhắn
            while (true) {
                // Đọc tin nhắn từ server
                if ((serverMessage = reader.readLine()) != null) {
                    System.out.println("Server: " + serverMessage);
                }

                // Nhập tin nhắn từ client và gửi tới server
                System.out.print("Client: ");
                clientMessage = consoleReader.readLine();
                writer.println(clientMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
