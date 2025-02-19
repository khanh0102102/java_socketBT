import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            Socket clientSocket = serverSocket.accept();
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

            String clientMessage;
            String serverMessage;

            // Bắt đầu vòng lặp để gửi và nhận tin nhắn
            while (true) {
                // Nhập tin nhắn từ server và gửi tới client
                System.out.print("Server: ");
                serverMessage = consoleReader.readLine();
                writer.println(serverMessage);

                // Đọc tin nhắn từ client
                if ((clientMessage = reader.readLine()) != null) {
                    System.out.println("Client: " + clientMessage);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
