package networkingHell;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPServer {
	DatagramSocket socket = null;

	public UDPServer() {
	}
	

	public void createAndListenSocket() {
		try {
			socket = new DatagramSocket(2637);
			byte[] incomingData = new byte[1024];

			socket.receive(incomingPacket);
			DatagramPacket incomingPacket = new DatagramPacket(incomingData, incomingData.length);
			byte[] data = incomingPacket.getData();
			ByteArrayInputStream in = new ByteArrayInputStream(data);
			ObjectInputStream is = new ObjectInputStream(in);
			try {
				VisionObject visionObj = (VisionObject) is.readObject();
				System.out.println("Received = " + visionObj);
			} 
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			} 
			catch (SocketException e) {
				e.printStackTrace();
			} 
			catch (IOException i) {
				i.printStackTrace();
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
}
