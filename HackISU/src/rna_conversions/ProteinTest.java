package rna_conversions;

import java.io.File;
import java.util.Scanner;

public class ProteinTest {

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
		System.out.println(AminoAcids.DNAsequence(data));
	}
}
