package ursjan.weristderbeste;

import javax.swing.JOptionPane;

import os.reg.start.config;

public class Datenbank {
	public static final String Programmierer = "Urs Braun - ursb.de";
	public static final String HighscoreName = "Highscore.txt";
	public static final String URI = "https://ursb.de/";
	public static String Station = null;
	public static String Spieler = null;

	public static void godb() {
		System.out.println("[Datenbank] " + config.AppName + " von " + Programmierer);
		System.out.println("[Datenbank] Die Datenbank ist aktiv");
		System.out.println("[Datenbank] Die Datenbank wird noch programmiert");
		System.out.println("[Datenbank] Javadoc: https://src.ursb.de/widb");
	}

	public static void fehler(int k) {
		JOptionPane.showMessageDialog(null, "Bitte oeffnen sie den Java-Log um das Problem festzustellen");
		if (k == 1) {// Fragenbank
			System.err.println("[Fehler] Probleme mit die [*reader.java] oder [datenbank.java]");
			System.err.println("[Fehler] Es konnten die Daten nicht geladen werden");
		} else if (k == 2) {// Ausfuehrung
			System.err.println("[Fehler] Konnte nicht ausgefuehrt werden");
			System.err.println("[Fehler] Es geht zurzeit nur unter Windows");
		} else if (k == 3) {
			System.err.println("[Fehler] Es funktioniert der Highscore nicht richtig,");
			System.err.println("[Fehler] denn es wurde kein Namen eingeben.");
		}

		else {
			System.err.println(
					"[Fehler over Fehler] Entschultigung mit Java-Fehlertext, denn der Programmierer hat geschlafen");
		}
	}

	public static void NameE() {
		Spieler = JOptionPane.showInputDialog("Bitte geben sie ein ihren Namen an.");
		System.out.println(Spieler + " spielt " + config.AppName + " jetzt");
	}

	public static int FragenGenerator() {
		double max = 5;
		double min = Math.random()*max+1;
		int sprung = (int) ((Math.random()*5)+min);
		return  sprung;
	}
}
