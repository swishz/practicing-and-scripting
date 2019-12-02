package testes;

import java.io.IOException;

public class TesteLog {

	public static void main(String[] args) {
		WriteLogToFile lala = new WriteLogToFile("CREDZ", "/tmp", TesteLog.class);
		try {
			lala.logSuccess("OK");
			lala.logError("NOT OK");
		} catch (SecurityException | IOException e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
	}

}
