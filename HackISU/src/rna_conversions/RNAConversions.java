package rna_conversions;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.math.BigInteger;

public class RNAConversions extends JApplet {

	private static final long serialVersionUID = 1L;

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
		tab1.setBackground(new Color(204, 255, 204));
		tabbedPane.addTab("Protein to RNA", null, tab1, null);
		GridBagLayout gbl_tab1 = new GridBagLayout();
		gbl_tab1.columnWidths = new int[]{0, 0};
		gbl_tab1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_tab1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_tab1.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		tab1.setLayout(gbl_tab1);
		
		JLabel tab1Title = new JLabel("Protein to RNA");
		tab1Title.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_tab1Title = new GridBagConstraints();
		gbc_tab1Title.insets = new Insets(0, 0, 5, 0);
		gbc_tab1Title.gridx = 0;
		gbc_tab1Title.gridy = 0;
		tab1.add(tab1Title, gbc_tab1Title);
		
		JLabel lblNewLabel_1 = new JLabel("Input Protein:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
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
		
		final JTextArea proteinFieldInput = new JTextArea();
		proteinFieldInput.setLineWrap(true);
		proteinFieldInput.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		scrollPane_2.setViewportView(proteinFieldInput);
		
		JLabel lblNewLabel = new JLabel("Output RNA:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 3;
		tab1.add(lblNewLabel, gbc_lblNewLabel);
		
		final JButton p2dButton = new JButton("Convert");
		p2dButton.setEnabled(false);
		p2dButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_scrollPane_3 = new GridBagConstraints();
		gbc_scrollPane_3.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_3.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_3.gridx = 0;
		gbc_scrollPane_3.gridy = 4;
		tab1.add(scrollPane_3, gbc_scrollPane_3);
		
		final JTextArea dnaFieldOutput = new JTextArea();
		dnaFieldOutput.setLineWrap(true);
		dnaFieldOutput.setFont(new Font("Times New Roman", Font.PLAIN, 14));
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
				String rna = AminoAcids.RNAsequence(proteinFieldInput.getText());
				BigInteger seqPoss = AminoAcids.countSequences(rna);
				dnaFieldOutput.setText("Compact form represents the following number of possible sequences: " + seqPoss.toString() + "\n\n" + rna);
			}
		});
		
		JPanel tab2 = new JPanel();
		tab2.setBackground(new Color(204, 255, 255));
		tabbedPane.addTab("RNA to Protein", null, tab2, null);
		GridBagLayout gbl_tab2 = new GridBagLayout();
		gbl_tab2.columnWidths = new int[]{0, 0};
		gbl_tab2.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_tab2.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_tab2.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		tab2.setLayout(gbl_tab2);
		
		JLabel lblNewLabel_2 = new JLabel("RNA to Protein");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 0;
		tab2.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("RNA Input:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
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
		
		final JTextArea dnaFieldInput = new JTextArea();
		dnaFieldInput.setLineWrap(true);
		dnaFieldInput.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		scrollPane.setViewportView(dnaFieldInput);
		
		JLabel lblNewLabel_4 = new JLabel("Protein Output:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
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
		
		final JTextArea proteinFieldOutput = new JTextArea();
		proteinFieldOutput.setLineWrap(true);
		proteinFieldOutput.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		proteinFieldOutput.setEditable(false);
		scrollPane_1.setViewportView(proteinFieldOutput);
		
		final JButton d2pButton = new JButton("Convert");
		d2pButton.setEnabled(false);
		d2pButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String protein = Protein.protein(dnaFieldInput.getText());
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
		tab3.setBackground(new Color(204, 204, 255));
		tabbedPane.addTab("Details", null, tab3, null);
		GridBagLayout gbl_tab3 = new GridBagLayout();
		gbl_tab3.columnWidths = new int[]{0, 0};
		gbl_tab3.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_tab3.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_tab3.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		tab3.setLayout(gbl_tab3);
		
		JLabel detailsLabel = new JLabel("Key and Source Information");
		detailsLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		detailsLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_detailsLabel = new GridBagConstraints();
		gbc_detailsLabel.insets = new Insets(0, 0, 5, 0);
		gbc_detailsLabel.gridx = 0;
		gbc_detailsLabel.gridy = 0;
		tab3.add(detailsLabel, gbc_detailsLabel);
		
		JLabel lblRna = new JLabel(" RNA Sequence Key");
		lblRna.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		GridBagConstraints gbc_lblRna = new GridBagConstraints();
		gbc_lblRna.insets = new Insets(0, 0, 5, 0);
		gbc_lblRna.gridx = 0;
		gbc_lblRna.gridy = 1;
		tab3.add(lblRna, gbc_lblRna);
		
		JTextArea txtpnKeyRnaSequnce = new JTextArea();
		txtpnKeyRnaSequnce.setLineWrap(true);
		txtpnKeyRnaSequnce.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtpnKeyRnaSequnce.setText("RNA sequence is in a compacted form where x denotes the possibility of all four bases. \r\nExample:\r\nCCx is the compacted form of: CCC, CCA, CCU, and CCG with all four coding for the same amino acid.\r\nParentheses are used to denote a series of possible base sequences.\r\nExample:\r\n(CAU, CAC) either can be used to code for H.");
		txtpnKeyRnaSequnce.setEditable(false);
		GridBagConstraints gbc_txtpnKeyRnaSequnce = new GridBagConstraints();
		gbc_txtpnKeyRnaSequnce.insets = new Insets(0, 0, 5, 0);
		gbc_txtpnKeyRnaSequnce.fill = GridBagConstraints.BOTH;
		gbc_txtpnKeyRnaSequnce.gridx = 0;
		gbc_txtpnKeyRnaSequnce.gridy = 2;
		tab3.add(txtpnKeyRnaSequnce, gbc_txtpnKeyRnaSequnce);
		
		JLabel lblNewLabel_5 = new JLabel("Sources");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 3;
		tab3.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		JTextArea txtpnAminoAcidCodon = new JTextArea();
		txtpnAminoAcidCodon.setLineWrap(true);
		txtpnAminoAcidCodon.setText("Amino Acid codon matching from 5' to 3' on page 420 of:\r\nPierce, Benjamin A. Genetics A Conceptual Approach. 4th. Houndsmills: W.H. Freeman and Company, 2014.");
		txtpnAminoAcidCodon.setEditable(false);
		txtpnAminoAcidCodon.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		GridBagConstraints gbc_txtpnAminoAcidCodon = new GridBagConstraints();
		gbc_txtpnAminoAcidCodon.insets = new Insets(0, 0, 5, 0);
		gbc_txtpnAminoAcidCodon.fill = GridBagConstraints.BOTH;
		gbc_txtpnAminoAcidCodon.gridx = 0;
		gbc_txtpnAminoAcidCodon.gridy = 4;
		tab3.add(txtpnAminoAcidCodon, gbc_txtpnAminoAcidCodon);
		
		JLabel lblNewLabel_6 = new JLabel("Source Code ");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 5;
		tab3.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		JTextArea txtpnHttpsgithubcomabradihhackisu = new JTextArea();
		txtpnHttpsgithubcomabradihhackisu.setEditable(false);
		txtpnHttpsgithubcomabradihhackisu.setLineWrap(true);
		txtpnHttpsgithubcomabradihhackisu.setText("https://github.com/abradih/HackISU2015");
		txtpnHttpsgithubcomabradihhackisu.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		GridBagConstraints gbc_txtpnHttpsgithubcomabradihhackisu = new GridBagConstraints();
		gbc_txtpnHttpsgithubcomabradihhackisu.fill = GridBagConstraints.BOTH;
		gbc_txtpnHttpsgithubcomabradihhackisu.gridx = 0;
		gbc_txtpnHttpsgithubcomabradihhackisu.gridy = 6;
		tab3.add(txtpnHttpsgithubcomabradihhackisu, gbc_txtpnHttpsgithubcomabradihhackisu);

	}

}
