package ursjan.weristderbeste;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class BackPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private Image img;

	public BackPanel(String PathToFile) {

		try {

			img = ImageIO.read(getClass().getResource(PathToFile));

			System.out.println("Bild wurde geladen");

		} catch (IOException e) {

			// e.printStackTrace();

			System.out.println("Kein Bild wurde geladen/gefunden");

		}

	}

	@Override

	protected void paintComponent(Graphics g) {

		super.paintComponent(g);

		g.drawImage(img, 0, 0, this);

	}

	public Image getBackgroundImage() {
		return img;

	}

}
