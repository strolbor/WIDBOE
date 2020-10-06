package ursjan.weristderbeste;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Fragenbank extends Datenbank implements ActionListener {
	JLabel frage = new JLabel();
	JRadioButton F11 = new JRadioButton();
	JRadioButton F12 = new JRadioButton();
	JRadioButton F13 = new JRadioButton();
	JRadioButton F14 = new JRadioButton();

	JButton fertig = new JButton("Fertig");
	ButtonGroup Frag1L = new ButtonGroup();
	JPanel panel;
	JPanel fr;
	int zahlerout = 1;
	String Name;
	int Frage = 0, zahler = 0;
	Fragen frsss;

	JPanel kn;
	JButton a;

	public Fragenbank(JPanel Frage, JPanel Antwort, JPanel k, JButton aa) {
		fr = Frage;
		panel = Antwort;

		Frag1L.add(F11);
		Frag1L.add(F12);
		Frag1L.add(F13);
		Frag1L.add(F14);
		fr.add(this.frage);
		fr.add(this.fertig);
		fertig.addActionListener(this);
		this.panel.add(this.F11);
		this.panel.add(this.F12);
		this.panel.add(this.F13);
		this.panel.add(this.F14);
		Frag1L.clearSelection();

		kn = k;
		a = aa;
		stelleNaechsteFrage();

	}

	@SuppressWarnings("static-access")
	@Override
	public void actionPerformed(ActionEvent e) {
		Enumeration<AbstractButton> buttons = this.Frag1L.getElements();

		while (buttons.hasMoreElements()) {
			AbstractButton button = (AbstractButton) buttons.nextElement();

			if (button.isSelected())
				if (button.getText().equalsIgnoreCase(frsss.CLSG[zahler])) {
					System.out.println("OK");
					zahlerout++;
					System.out.println(zahler);
					stelleNaechsteFrage();
				} else {
					entferneAusPanel();
				}
		}

	}

	int k = 1;

	@SuppressWarnings("static-access")
	private void stelleNaechsteFrage() {
		new Fragen();
		if (zahlerout == 15) {
			entferneAusPanel();
			return;
		}
		zahler = zahler + FragenGenerator();

		if (frsss.CFrage.length <= zahler) {
			zahler = 1;
			stelleNaechsteFrage();
			return;
		}

		this.frage.setText(frsss.CFrage[zahler]);
		this.F11.setText(frsss.CAntwort1[zahler]);
		this.F12.setText(frsss.CAntwort2[zahler]);
		this.F13.setText(frsss.CAntwort3[zahler]);
		this.F14.setText(frsss.CAntwort4[zahler]);
		Frag1L.clearSelection();

	}

	private void entferneAusPanel() {

		fr.remove(this.frage);
		fr.remove(this.fertig);
		this.panel.remove(this.F11);
		this.panel.remove(this.F12);
		this.panel.remove(this.F13);
		this.panel.remove(this.F14);

		Frage = 0;
		zahler = 1;
		this.zahlerout = 0;
		this.panel.repaint();
		this.fr.repaint();

		kn.add(a);
		kn.repaint();

	}

}
