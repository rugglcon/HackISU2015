package protienToDNA;

public class ReadAminoAcids {
	File file = new File("blast.txt");
	Scanner scanner = new Scanner(file);
	public static String DNAsequence(file) {
		// result will save the string being built
		String result = "";
		// get rid of spaces
		a.replaceAll(" ", "");
		int i = 0;
		while(scanner.hasNextLine()){
			String line = scanner.nextLine();
		// while loop thats valid till end of the string
		while (i < a.length()) {
			// check for numbers which are skipped
			if (Character.isDigit(a.charAt(i))) {
				i++;
			}
			// if it is a letter find corresponding amino acid
			else if (Character.isLetter(a.charAt(i))) {
				result = result + aminoAcid(a.charAt(i));
			}
			//move on 
			i++;
		}
		}
		return result;

	}

	public static String aminoAcid(char a) {
		String result = "";
		// alanine check
		if (a == 'a' || a == 'A') {
			result = result + "GCx ";
			return result;
		}// serine check
		else if (a == 's' || a == 'S') {
			result = result + "(UCx,AGU,AGC) ";
			return result;
		}// threonine check
		else if (a == 't' || a == 'T') {
			result = result + "ACx ";
			return result;
		}// proline check
		else if (a == 'p' || a == 'P') {
			result = result + "CCx ";
			return result;
		}// valine check
		else if (a == 'v' || a == 'V') {
			result = result + "GUx ";
			return result;
		}// leucine check
		else if (a == 'l' || a == 'L') {
			result = result + "(CUx,UUA,UUG) ";
			return result;
		}// methionine check
		else if (a == 'm' || a == 'M') {
			result = result + "AUG ";
			return result;
		}// tyrosine check
		else if (a == 'y' || a == 'Y') {
			result = result + "(UAU,UAC) ";
			return result;
		}// cysteine check
		else if (a == 'c' || a == 'C') {
			result = result + "(UGU,UGC) ";
			return result;
		}// tryptophane check
		else if (a == 'w' || a == 'W') {
			result = result + "UGG ";
			return result;
		}// aspartic check
		else if (a == 'd' || a == 'D') {
			result = result + "(GAU,GAC) ";
			return result;
		}// glutamine check
		else if (a == 'e' || a == 'E') {
			result = result + "(GAA,GAG) ";
			return result;
		}// asparagine check
		else if (a == 'n' || a == 'N') {
			result = result + "(GAU,GAC) ";
			return result;
		}// glutamine check
		else if (a == 'q' || a == 'Q') {
			result = result + "(CAA,CAG) ";
			return result;
		}// glycine check
		else if (a == 'g' || a == 'G') {
			result = result + "(GGx) ";
			return result;
		}// isoleucine check
		else if (a == 'i' || a == 'I') {
			result = result + "(AUU,AUC,AUA) ";
			return result;
		}// phenylalanine check
		else if (a == 'f' || a == 'F') {
			result = result + "(UUU,UUC) ";
			return result;
		}// arginine check
		else if (a == 'r' || a == 'R') {
			result = result + "(CGx,AGA,AGG) ";
			return result;
		}// lysine check
		else if (a == 'k' || a == 'K') {
			result = result + "(AAA,AAG) ";
			return result;
		}// histidine check
		else if (a == 'h' || a == 'H') {
			result = result + "(CAU,CAC) ";
			return result;
		}
		// no amino acid check
		else {
			return Character.toString(a) + " is not a vailid amino acid ";
		}
	}
}
