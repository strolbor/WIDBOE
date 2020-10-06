package os.reg.start;

import java.io.IOException;

public class Execute {
	@SuppressWarnings("unused")
	private static void win(String Pfad) {
		System.out.println("[Datenbank] Try Windows");
		try {
			Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + Pfad);
		} catch (IOException e) {
			System.out.println("win");
			// e.printStackTrace();
			uni(Pfad);
		}
	}

	private static void uni(String Pfad) {
		System.out.println("[Datenbank] Try Linux/Unisex");
		try {
			Runtime.getRuntime().exec(" " + Pfad);
		} catch (IOException e) {
			System.out.println("Unix/Linux:");
			// e.printStackTrace();
			mac(Pfad);
		}
	}

	private static void mac(String Pfad) {
		System.out.println("[Datenbank] Try mac");
		try {
			Runtime.getRuntime().exec(" " + Pfad);
		} catch (IOException e) {
			System.out.println("Mac:");
			// e.printStackTrace();

		}
	}
}
