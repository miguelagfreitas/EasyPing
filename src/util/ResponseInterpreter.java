package util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import ui.PingText;

public class ResponseInterpreter {


	public static PingText s;

	public static void start() {
		String ip = "google.pt -t -4";
		int pingRetrieved = 0;
		s = new PingText();


		String pingCmd = "ping " + ip;
		try {

			//vai buscar o runtime que esta a correr o programa java
			Runtime r = Runtime.getRuntime();
			//cria um processo que é retornado pelo runtime e que corre a string mandada por parametro como comando
			Process p = r.exec(pingCmd);

			BufferedReader in = new BufferedReader(new
					InputStreamReader(p.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				//System.out.println(inputLine);
				pingRetrieved = getPingValueFromPingResult(inputLine);
				takeActionFromPingValue(pingRetrieved);
			}
			in.close();

		} catch (IOException e) {
			System.out.println(e);
		}
	}

	private static void takeActionFromPingValue(int pingRetrieved) {
		s.printNumber(pingRetrieved);
	}

	private static int getPingValueFromPingResult(String inputLine) {
		String[] splitString;
		String timeParameter;
		if (inputLine.contains("ms")) {
			splitString = inputLine.split(" ");
			timeParameter = "";
			if (splitString.length >= 4) {
				timeParameter = splitString[4];
			}
			if (timeParameter.split("=").length >=1) {
				try {
					timeParameter = (timeParameter.split("="))[1];
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.print("Erro: "+ inputLine);
				}
				
			}
			timeParameter = timeParameter.replace("ms", "");
			return Integer.parseInt(timeParameter);
		}
		return 0;
	}
}