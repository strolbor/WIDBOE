package os.reg.start;

import ursjan.weristderbeste.PCgui;
import ursjan.weristderbeste.Datenbank;

public final class PC {
	public static void main(String[] args) {

		PCgui Rahmen = new PCgui();
		Rahmen.setSize(700, 410);// 800, 410
		Rahmen.setDefaultCloseOperation(3);
		Rahmen.setVisible(true);
		Rahmen.setFocusable(true);
		Datenbank.NameE();
		Rahmen.setTitle(config.AppName + "; Willkommen " + Datenbank.Spieler);
		System.out.println("[PC] GUI aktiviert");
	}
}
