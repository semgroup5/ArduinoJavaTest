package RaspberryPi;

import java.io.BufferedReader;
import java.io.OutputStream;

public class SmartCarComm {
	public static BufferedReader input;
	public static OutputStream output;

	public SmartCarComm(){
		SerialConnect obj = new SerialConnect();
		obj.initialize();
		input = SerialConnect.input;
		output = SerialConnect.output;
		setSpeed(100);
		System.out.println("anadasd");
		obj.close();

	}

	public static synchronized void writeData(String data) {
		System.out.println("Sent: " + data);
		try {
			System.out.println(data);
			output.write(data.getBytes());
		} catch (Exception e) {
			System.out.println("could not write to port");
		}
	}

	public static void setSpeed(int speed){

		if((speed <= 100) && (speed >= -100)){
			writeData("w" + speed);
		}
	}
	public void setAngle(int angle){

		if(angle < 400 && angle > -400){
			writeData("a" + angle);
		}
	}
	public void setRotate(int angle){

		if(angle < 400 && angle > -400){
			writeData("r" + angle);
		}
	}
}
