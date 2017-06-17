package tester;

import java.net.*;
import java.io.*;
//BASIC SOCKET PROGRAM JUST TO DEMONSTRATE COMMUNICATION BETWEEN A CLIENT AND SERVER VIA SOCKETS
//CLIENT SIDE PPROGRAMMING
//CLIENT CREATES SOCKET ON ITS SIDE
//CLIENT ATTEMPTS TO MAKE CONNECTION WITH SERVER
public class client {
	public static void main(String []args) throws IOException
	{
		Socket csoc = new Socket("127.0.0.1"/*server ip address*/, 9655/*port number to connect to*/);//Creating a socket on client side to connect to server socket at specified port 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br1 = new BufferedReader(new InputStreamReader(csoc.getInputStream()));//Reads data coming into the socket
		PrintStream ps = new PrintStream(csoc.getOutputStream());//Output stream to send data to server socket
		
		while(true){
			System.out.println("Enter string to echo: ");
			String s = br.readLine();//Reads data entered in the system
			ps.println(s);//Sends the entered data to the server socket
			if(s.equals("exit")){
				csoc.close();
				System.exit(1);
				
			}
			
			String echo = br1.readLine();//reads the data that the server sent using the instructions "ps.println(st)"
			System.out.println("Echo: ");
			System.out.println(echo);
		}
		
	}
}
