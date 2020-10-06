package ursjan.weristderbeste;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import os.reg.start.config;
//import urs.addons.Minispiel;

public class PCgui extends JFrame implements ActionListener {
	private static final long serialVersionUID = 4476502584698615472L;
	JPanel /* BackPanel */ Platte;
	JPanel Gruppe2;
	JPanel Frage;
	JPanel Antwort;
	JPanel ganzoben;
	Box Oben;
	Box Unten;
	Box Knoepfe;
	JButton Fragenss, PC;
	JLabel zeichen;
	JLabel cook;
	Datenbank date;

	public PCgui(int nul) {

	}

	public PCgui() {
		// this.Platte = new BackPanel("gfx/hin.png");
		Platte = new JPanel();
		this.Platte.setLayout(new FlowLayout());

		createComponents();
		setFormLayout();

		setContentPane(this.Platte);

		// SMenu();

		this.Platte.add(this.Oben);
		this.Platte.add(this.Gruppe2);
		this.Platte.add(this.Frage);
		this.Platte.add(this.Antwort);
		widb();
		Datenbank.godb();

		setTitle(config.AppName + "; Willkommen " + Datenbank.Spieler);

		System.out.println("[GUI] Erledigt Gui");
	}

	public void createComponents() {
		this.ganzoben = new JPanel();
		this.Frage = new JPanel();
		this.Antwort = new JPanel();
		this.Gruppe2 = new JPanel();
		this.Oben = Box.createHorizontalBox();
		this.Knoepfe = Box.createHorizontalBox();
		this.Unten = Box.createHorizontalBox();
		this.cook = new JLabel("Punkt: ");
	}

	public void setFormLayout() {
		this.ganzoben.setPreferredSize(new Dimension(650, 50));
		this.Gruppe2.setPreferredSize(new Dimension(650, 60));
		this.Antwort.setPreferredSize(new Dimension(650, 150));
		this.Oben.setPreferredSize(new Dimension(430, 10));
		this.Unten.setPreferredSize(new Dimension(430, 10));
		this.Frage.setPreferredSize(new Dimension(650, 90));
		this.Gruppe2.setBorder(BorderFactory.createTitledBorder("Fragen"));
		this.Antwort.setBorder(BorderFactory.createTitledBorder("Hier die Frage beantworten:"));
		this.Frage.setBorder(BorderFactory.createTitledBorder("Frage:"));
	}

	private void widb() {
		this.zeichen = new JLabel("Bitte waehlen sie Ihr Quiz-Bereich aus, die Sie Spielen wollen. Stand:");
		this.Fragenss = new JButton("Spiel starten");
		PC = new JButton("PC vs. You");
		System.out.println("erledigt '" + config.AppName + "' aktivieren");
		addAfra();
		Fragenss.addActionListener(this);
		PC.addActionListener(this);
	}

	public void addAfra() {
		Gruppe2.add(Fragenss);
		// Gruppe2.add(PC);
		Gruppe2.repaint();
	}

	public void reAfra() {
		Gruppe2.remove(Frage);
		Gruppe2.repaint();
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == Fragenss) {
			System.out.println("[Action] Wird gestartet, Fragen");

			Datenbank.Station = "Fragen";
			Gruppe2.remove(Fragenss);
			Gruppe2.repaint();
			new Fragenbank(Frage, Antwort, Gruppe2, Fragenss);
		} else if (ae.getSource() == PC) {
			// Minispiel.Gluck();
		}
	}
}