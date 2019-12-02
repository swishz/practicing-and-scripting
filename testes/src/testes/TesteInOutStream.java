package testes;

public class TesteInOutStream {
	public static void main(String[] args){
		LogsPan logsPan = new LogsPan("PAN","/tmp", TesteInOutStream.class);
		boolean aux = false;
		try {
			for (int i = 0; i < 1000; i++) {
				if (aux == false) {
					logsPan.logError("GIVEBADMAFRIEND");
					aux = true;
				} else {
					logsPan.logSuccess("DEUCERTOGRAZADEUS");
					aux = false;
				}					
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("cabo");
	}
}
