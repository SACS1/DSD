//import java.io.BufferedReader;
import java.io.*;


public class Main{
	public static void main(String args[]){
		int n = 4;
		for(int i = 0; i < 4; i++){
			MultiHilos h = new MultiHilos();
			h.start();
		}
	}
}

class MultiHilos extends Thread {
    public void run(){
		try{
            // Displaying the thread that is running
            Runtime rt = Runtime.getRuntime();
			String[] commands = {"curl", "-v", "--header", "X-Debug:true", "--data", "1757600,IPN", "34.67.190.109:80/searchipn"};
			Process proc = rt.exec(commands);

			BufferedReader stdInput = new BufferedReader(new 
			     InputStreamReader(proc.getInputStream()));

			BufferedReader stdError = new BufferedReader(new 
			     InputStreamReader(proc.getErrorStream()));

			System.out.println("Respuesta de la petición:\n");
			String s = null;
			while ((s = stdInput.readLine()) != null) {
			    System.out.println(s);
			}

			System.out.println("Estado de la petición:\n");
			while ((s = stdError.readLine()) != null) {
			  System.out.println(s);
			}
        }catch (Exception e){
            // Throwing an exception
            System.out.println("Exception is caught");
        }
	}
}