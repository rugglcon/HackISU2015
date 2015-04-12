package rna_conversions;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;

public class RNAConversionsApplication extends JFrame {

	private static final long serialVersionUID = 1L;

	public RNAConversionsApplication() {
		init();
	}

	private void init() {
		setTitle("RNA Conversions");
		setSize(650, 450);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				RNAConversionsApplication app = new RNAConversionsApplication();
				RNAConversions applet = new RNAConversions();
				applet.init();
				app.add(applet, BorderLayout.CENTER);
				app.setVisible(true);
			}
		});
	}

}
