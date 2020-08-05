package Touch_Control_DesktopApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client {

    Socket socket = null;
    PrintWriter outPrintWriter = null;
    BufferedReader inReader = null;

    static public void main(String arg[]) {
        Client client = new Client("192.168.1.103", 51979);
        System.out.println(client.sendRequest("do"));
        client.close();
    }

    public Client(String ipStr, int port) {
        try {
            socket = new Socket(ipStr, port);
            outPrintWriter = new PrintWriter(socket.getOutputStream(), true);
            inReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    String sendRequest(String command) {
        String strFromServer = null;
        try {
            outPrintWriter.println(command);
            if ((strFromServer = inReader.readLine()) != null) {
                //System.out.println("from server = " + strFromServer);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return strFromServer;
    }

    void close() {
        try {
            outPrintWriter.close();
            inReader.close();
            socket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
