package Touch_Control_DesktopApplication;
import Touch_Control_DesktopApplication.Server1.Commands;
import Touch_Control_DesktopApplication.Server1.VirtualKey;
import Touch_Control_DesktopApplication.Server1.VirtualKeyConverter;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.net.*;
public class Server {

    private static BufferedReader clientReader;
    private static PrintWriter clientOutputStream;
    private static Socket clientSocket;
    public static ServerSocket serverSocket = null;
    private int port = 0;

    //private long requestTime = 0;

    public Server(int port) {
        this.port = port;
    }

    private  int convertMouseButton(int mouseButton) {
        int button = 0;
        switch (mouseButton) {
            case Commands.MOUSE_KEY_LEFT:
                System.out.println("Button1 Inside  = " + MouseEvent.BUTTON1);
                button = MouseEvent.BUTTON1_MASK;
                break;
            case Commands.MOUSE_KEY_RIGHT:
                System.out.println("Button3");
                button = MouseEvent.BUTTON3_MASK;
                break;
            case Commands.MOUSE_KEY_CENTER:
                System.out.println("Button2");
                button = MouseEvent.BUTTON2_MASK;
                break;
            default:
                button = 0;
                break;
        }
        return button;
    }

//    synchronized public void setRequestTime(long requestTime) {
//        this.requestTime = requestTime;
//    }

    synchronized public static void closeClient() {
        try {
            if (clientReader != null) {
                clientReader.close();
                clientReader = null;
            }
            if (clientOutputStream != null) {
                clientOutputStream.close();
                clientOutputStream = null;
            }
            if (clientSocket != null) {
                clientSocket.close();
                clientSocket = null;
            }
        } catch (IOException io) {
            System.out.println("Error: on closeClient)(), " + io.getMessage());
        }
    }

    public void startServer() {
        String commandStr;
        String resultStr = null;
        Robot robot = null;


        try {
            serverSocket = new ServerSocket(port);
	    port=serverSocket.getLocalPort();
	    String s1= InetAddress.getLocalHost().getHostAddress();
	    String s2= s1.substring(1);
	    Start.tf.setText(s2);
	    Start.tb.setText(Integer.toString(port));
            robot = new Robot();
            System.out.println("started TCP listening on " + String.valueOf(port));
        } catch (IOException ioe) {
            System.out.println("Could not listen on TCP port = " + String.valueOf(port)+ " This port is busy\n Change to other"+ioe.getMessage());
           // ioe.printStackTrace();
        } catch (AWTException awte) {
            awte.printStackTrace();
        }

        try {
            if (serverSocket != null) {
                while (true) {
                    System.out.println("waiting for connection-----------------------");
			Start.td.setText("Waiting for Connection...");
                    clientSocket = serverSocket.accept();
                    System.out.println("connected-----------------------");
			Start.td.setText("Connected....");
                    //setRequestTime(new Date().getTime());
                    clientReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    clientOutputStream = new PrintWriter(clientSocket.getOutputStream(), true);
                    while (clientSocket != null && !clientSocket.isClosed() && (commandStr = clientReader.readLine()) != null) {
                        //setRequestTime(new Date().getTime());
                        System.out.println("Received: " + commandStr);
                        String[] arr = commandStr.split(",");
                        if (arr.length >= 2) {
                            int commandType = Integer.valueOf(arr[0]);
                            int button = 0;
                            int key = 0;
                            VirtualKey vk = null;
                            switch (commandType) {
                                case Commands.COMMAND_TYPE_MOUSE_MOVE:
                                    int x = Integer.valueOf(arr[1]);
                                    int y = Integer.valueOf(arr[2]);
                                    Point point = MouseInfo.getPointerInfo().getLocation();
                                    robot.mouseMove(point.x + x, point.y + y);
                                    resultStr = String.valueOf(Commands.RESULT_OK);
                                    break;
                                case Commands.COMMAND_TYPE_MOUSE_PRESSED:
                                    button = Integer.valueOf(arr[1]);
                                    System.out.println("----" + button);
                                    button = convertMouseButton(button);
                                    System.out.println("----" + button);
                                    robot.mousePress(button);
                                    break;
                                case Commands.COMMAND_TYPE_MOUSE_RElEASED:
                                    button = Integer.valueOf(arr[1]);
                                    robot.mouseRelease(convertMouseButton(button));
                                    break;
                                case Commands.COMMAND_TYPE_MOUSE_WHEEL:
                                    int wheelAmt = Integer.valueOf(arr[1]);
                                    robot.mouseWheel(wheelAmt);
                                    break;
                                case Commands.COMMAND_TYPE_KEY_PRESSED:
                                    try {
                                        key = Integer.valueOf(arr[1]);
                                        System.out.println("On keyChar Press  = " + (char) key);
                                        vk = VirtualKeyConverter.charToVirtualKey(key);
                                        if (vk.getVK() == 0) {
                                            System.out.println("COMMAND_TYPE_KEY_PRESSED: coution: VK_Key = 0");
                                        } else {
                                            if (!vk.isShiftIsOn()) {
                                                System.out.println("VirtKey = " + vk.getVK());
                                                robot.keyPress(vk.getVK());
                                            } else {
                                                System.out.println("Shift is on = ");
                                                robot.keyPress(KeyEvent.VK_SHIFT);
                                                robot.keyPress(vk.getVK());
                                            }
                                        }
                                    } catch (IllegalArgumentException iae) {
                                        robot.keyRelease(KeyEvent.VK_SHIFT);
                                        System.out.println("COMMAND_TYPE_KEY_RELEASED : error: VK_Key = " + vk.getVK()
                                                + "\nMessage = " + iae.getMessage());
                                    }
                                    break;
                                case Commands.COMMAND_TYPE_KEY_RElEASED:
                                    try {
                                        key = Integer.valueOf(arr[1]);
                                        System.out.println("On keyChar Release  = " + (char) key);
                                        vk = VirtualKeyConverter.charToVirtualKey(key);
                                        if (vk.getVK() == 0) {
                                            System.out.println("COMMAND_TYPE_KEY_RELEASED: coution: VK_Key = 0");
                                        } else {
                                            if (!vk.isShiftIsOn()) {
                                                System.out.println("VirtKey = " + vk.getVK());
                                                robot.keyRelease(vk.getVK());
                                            } else {
                                                System.out.println("Shift is on = ");
                                                robot.keyRelease(KeyEvent.VK_SHIFT);
                                                robot.keyRelease(vk.getVK());
                                            }
                                        }
                                    } catch (IllegalArgumentException iae) {
                                        robot.keyRelease(KeyEvent.VK_SHIFT);
                                        System.out.println("COMMAND_TYPE_KEY_RELEASED : error: VK_Key = " + vk.getVK()
                                                + "\nMessage = " + iae.getMessage());
                                    }
                                    break;
                                case Commands.COMMAND_TYPE_KEY_PRESSED_RELEASED:
                                    try {
                                        key = Integer.valueOf(arr[1]);
                                        System.out.println("On keyChar Press Release = " + (char) key);
                                        vk = VirtualKeyConverter.charToVirtualKey(key);
                                        if (vk.getVK() == 0) {
                                            System.out.println("COMMAND_TYPE_KEY_PRESSED_RELEASED : coution: VK_Key = 0");
                                        } else {
                                            if (!vk.isShiftIsOn()) {
                                                System.out.println("VirtKey = " + vk.getVK());
                                                robot.keyPress(vk.getVK());
                                                robot.keyRelease(vk.getVK());
                                            } else {
                                                System.out.println("Shift is on = ");
                                                robot.keyPress(KeyEvent.VK_SHIFT);
                                                robot.keyPress(vk.getVK());
                                                robot.keyRelease(vk.getVK());
                                                robot.keyRelease(KeyEvent.VK_SHIFT);
                                            }
                                        }
                                    } catch (IllegalArgumentException iae) {
                                        robot.keyRelease(KeyEvent.VK_SHIFT);
                                        System.out.println("COMMAND_TYPE_KEY_PRESSED_RELEASED : error: VK_Key = " + vk.getVK()
                                                + "\nMessage = " + iae.getMessage());
                                    }
                                    break;
                                default:
                                    resultStr = String.valueOf(Commands.RESULT_WRONG);
                                    break;
                            }
                        }
                        if (clientOutputStream != null) {
                            clientOutputStream.println(resultStr);
                        }
                    }
			Start.td.setText("Disconnect the Client also....");
                    closeClient();
                    System.out.println("Disconnected-------------------");
			
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                serverSocket.close();
		Start.td.setText("Server Disconnected....");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}