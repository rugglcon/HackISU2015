package rna_conversions;

import java.io.File;
import java.util.Scanner;

public class AminoAcidTest {

	public static void main(String[] args) throws Exception {
		String data = "";
		File file = new File("blast.txt");
		Scanner scanner = new Scanner(file);
		while(scanner.hasNextLine()){
			String line = scanner.nextLine();
			line = line.trim();
			data = data + line;
		}
		scanner.close();
		String seq = AminoAcids.RNAsequence(data);
		System.out.println(seq);
		System.out.println(AminoAcids.countSequences(seq));
	}
}
