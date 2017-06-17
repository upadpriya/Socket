# Client

import java.io.*;
import java.net.*;

//FIRST RUN SERVER PROGRAM
//SERVER PROGRAM MUST FIRST SPECIFY WHICH PORT COMMUNICATION IS TAKING PLACE AT
public class server {
	public static void main(String []args) throws IOException
	{
		ServerSocket ssoc = new ServerSocket(9655);//Creating a server socket at port 9655
		Socket client=ssoc.accept(); //accept returns a new socket through which the server can communicate with the newly connected client. The old socket (on which accept was called) stays open, on the SAME port, listening for new connections.
		BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));//Reads data coming into the socket returned by the accept method
		PrintStream ps = new PrintStream(client.getOutputStream());//To send data to the client socket
		
		while(true){
			String st = br.readLine();//Reads data coming from the client socket because of the instruction "ps.println(s)" and stores it in variable st
			if(st.equals("exit")){
				System.out.println("Connection lost");
				ssoc.close();
				System.exit(1);
				
			}
			
			ps.println(st);//If the user did not ask for an exit, the server socket sends the read data back to the client socket where the data is read and printed
		
		}
	}
}

