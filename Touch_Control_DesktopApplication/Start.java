package Touch_Control_DesktopApplication;
import Touch_Control_DesktopApplication.Server;
import javax.swing.*;
import java.awt.*;
import java.net.*;
import java.util.Date;
import java.awt.event.*;
import java.io.IOException;
import java.io.OutputStream;
import javax.swing.text.MaskFormatter;
import java.io.*;

public class Start extends JFrame implements ActionListener,Runnable{
   // static Thread thread;
//	public static JFormattedTextField tb;
	public static JLabel ta,tc,td,tb,tf,te;
	public static JButton jc,jd;
	public int port;
	public int length=0;
	public String value="";
	MaskFormatter numformatt;
	Thread t,t1;
	int check=0;
	Start()
	{
		try{
			jc=new JButton("Start Server");
			jc.setBounds(50,250,140,30);
			jc.addActionListener(this);
			jd=new JButton("Disconnect");
			jd.setBounds(230,250,130,30);
			jd.addActionListener(this);
			ta=new JLabel("Touch_Control (Made By Akhil)");
			ta.setBounds(100,1,240,70);
			ta.setFont(new Font("Calibri", Font.BOLD, 16));
			tc=new JLabel("Available Port for Client");
			tc.setBounds(195,51,170,60);
			tc.setFont(new Font("Calibri", Font.BOLD, 16));
			te=new JLabel("IP Address");
			te.setBounds(25,51,150,60);
			te.setFont(new Font("Calibri", Font.BOLD, 16));
			td=new JLabel("Server not Connected....");
			td.setBounds(120,300,200,50);
			td.setFont(new Font("Calibri", Font.BOLD, 16));
	//		numformatt = new MaskFormatter("#####");
			tb=new JLabel("");
			tb.setBounds(195,110,170,30);
			tb.setFont(new Font("Calibri", Font.BOLD, 16));
			tf=new JLabel("");
			tf.setBounds(25,110,170,30);
			tf.setFont(new Font("Calibri", Font.BOLD, 16));
			
			
	//		add(jb);
			add(jc);
			add(jd);
			add(ta);
			add(tb);
			add(tc);
			add(td);
			add(te);
			add(tf);


		} catch(Exception e)
		{
			System.out.println("Exception in Frame : "+e);
		}
	}
	
	public void actionPerformed(ActionEvent e)
	{
	//	if(e.getSource()==jb)
		{
		//	
		}
		if(e.getSource()==jc)
		{	
			if(check!=1)
			{
				jd.setText("Disconnect");
			if( t == null ) {
			      t = new Thread( this );
			      check=1;
			      t.start();
			}
			}
		}
		else if(e.getSource()==jd)
		{
			try {
	//			jc.setText("Disconnect Client"); 
				Server.closeClient();
				System.out.println(port+"9");
	//			Server.serverSocket.close();
			} catch(Exception ex1)
			{
				System.out.println("Exception in socket close : "+ex1);
			}
			
		}
	}
	public void run() {
		if(length > 0){
     		 try{
	//		System.out.println(Integer.parseInt(tb.getText()));
			port = Integer.parseInt("0");
     			System.out.println(port);
          		port = Integer.parseInt(value);
      		}catch(NumberFormatException nfe){
          			System.out.println("Default port 6000");
      			}
		}
		 try {
		
   		Server server = new Server(port);
   		
   	//	 System.out.println(port);
   		server.startServer();
   //		System.out.println(port);
		 } catch(Exception ex)
		 {
			 System.out.println("Exception in Server : "+ex);
		 }
		
	}
    public static void main(String argv[]) {
	Start st=new Start();
	
	try{	
		st.setSize(400,400);
		st.getContentPane().setBackground(new Color(255,153,0));
		st.setLocationRelativeTo(null);  
		st.setLayout(null);
		st.setVisible(true);
		st.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	} catch(Exception e)
	{
		System.out.println("Exception in Frame : "+e);
	}
	st.length=argv.length;
	if(st.length>0)
		st.value=argv[0];
	}
}



