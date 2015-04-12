package rna_conversions;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RNAConversions extends JApplet {

	/**
	 * Create the applet.
	 */
	public RNAConversions() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 0;
		getContentPane().add(tabbedPane, gbc_tabbedPane);
		
		JPanel tab1 = new JPanel();
		tabbedPane.addTab("Protein to DNA", null, tab1, null);
		GridBagLayout gbl_tab1 = new GridBagLayout();
		gbl_tab1.columnWidths = new int[]{0, 0};
		gbl_tab1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_tab1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_tab1.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		tab1.setLayout(gbl_tab1);
		
		JLabel tab1Title = new JLabel("Protein to DNA");
		tab1Title.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_tab1Title = new GridBagConstraints();
		gbc_tab1Title.insets = new Insets(0, 0, 5, 0);
		gbc_tab1Title.gridx = 0;
		gbc_tab1Title.gridy = 0;
		tab1.add(tab1Title, gbc_tab1Title);
		
		JLabel lblNewLabel_1 = new JLabel("Input Protein:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		tab1.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.gridx = 0;
		gbc_scrollPane_2.gridy = 2;
		tab1.add(scrollPane_2, gbc_scrollPane_2);
		
		JTextPane proteinFieldInput = new JTextPane();
		scrollPane_2.setViewportView(proteinFieldInput);
		
		JLabel lblNewLabel = new JLabel("Output DNA:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 3;
		tab1.add(lblNewLabel, gbc_lblNewLabel);
		
		JButton p2dButton = new JButton("Convert");
		p2dButton.setEnabled(false);
		p2dButton.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_scrollPane_3 = new GridBagConstraints();
		gbc_scrollPane_3.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_3.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_3.gridx = 0;
		gbc_scrollPane_3.gridy = 4;
		tab1.add(scrollPane_3, gbc_scrollPane_3);
		
		JTextPane dnaFieldOutput = new JTextPane();
		dnaFieldOutput.setEditable(false);
		scrollPane_3.setViewportView(dnaFieldOutput);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 5;
		tab1.add(p2dButton, gbc_btnNewButton);
		
		proteinFieldInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				if(!proteinFieldInput.getText().trim().isEmpty()){
					p2dButton.setEnabled(true);
				} else {
					p2dButton.setEnabled(false);
				}
			}
		});
		
		p2dButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String dna = AminoAcids.RNAsequence(proteinFieldInput.getText());
				dnaFieldOutput.setText(dna);
			}
		});
		
		JPanel tab2 = new JPanel();
		tabbedPane.addTab("DNA to Protein", null, tab2, null);
		GridBagLayout gbl_tab2 = new GridBagLayout();
		gbl_tab2.columnWidths = new int[]{0, 0};
		gbl_tab2.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_tab2.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_tab2.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		tab2.setLayout(gbl_tab2);
		
		JLabel lblNewLabel_2 = new JLabel("DNA to Protein");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 0;
		tab2.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("DNA Input:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 1;
		tab2.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		tab2.add(scrollPane, gbc_scrollPane);
		
		JTextPane dnaFieldInput = new JTextPane();
		scrollPane.setViewportView(dnaFieldInput);
		
		JLabel lblNewLabel_4 = new JLabel("Protein Output:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 3;
		tab2.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 4;
		tab2.add(scrollPane_1, gbc_scrollPane_1);
		
		JTextPane proteinFieldOutput = new JTextPane();
		proteinFieldOutput.setEditable(false);
		scrollPane_1.setViewportView(proteinFieldOutput);
		
		JButton d2pButton = new JButton("Convert");
		d2pButton.setEnabled(false);
		d2pButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String protein = AminoAcids.RNAsequence(dnaFieldInput.getText());
				proteinFieldOutput.setText(protein);
			}
		});
		d2pButton.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 5;
		tab2.add(d2pButton, gbc_btnNewButton_1);
		
		dnaFieldInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!dnaFieldInput.getText().trim().isEmpty()){
					d2pButton.setEnabled(true);
				} else {
					d2pButton.setEnabled(false);
				}
			}
		});
		JPanel tab3 = new JPanel();
		tabbedPane.addTab("Details", null, tab3, null);

	}

}
