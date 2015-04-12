package rna_conversions;

public class Protein {
	public static String protein(String a) {
		// result will save the string being built
		String result = "";
		// get rid of spaces
		a = a.replaceAll(" ", "");

		int i = 0;
		// while loop thats valid till end of the string
		while (i < a.length()) {
			String s = "";
			// check for numbers which are skipped
			if (Character.isDigit(a.charAt(i))) {
				i++;
			}
			// if it is a letter find corresponding amino acid
			else if (a.charAt(i) == '(') {
				int j = i + 1;
				while (a.charAt(j) != ')') {
					j++;
				}
				s = a.substring(i, j+1);
				i = j + 1;
				result = result + getProtein(s);
			} else if (Character.isAlphabetic(a.charAt(i))) {
				s = a.substring(i, i + 3);
				i = i + 3;
				result = result + getProtein(s);
			}
		}
		return result;
	}

	public static String getProtein(String a) {
		String result = "";
		// alanine check
		if (a.equalsIgnoreCase("GCU") || a.equalsIgnoreCase("GCC") || a.equalsIgnoreCase("GCA")
				|| a.equalsIgnoreCase("GCG") || a.equalsIgnoreCase("GCx")) {
			result = result + "A";
			return result;
		}// serine check
		else if (a.equalsIgnoreCase("UCA") || a.equalsIgnoreCase("UCU") || a.equalsIgnoreCase("UCG")
				|| a.equalsIgnoreCase("AGU") || a.equalsIgnoreCase("AGC")
				|| a.equalsIgnoreCase("(UCx,AGU,AGC)")) {
			result = result + "S";
			return result;
		}// threonine check
		else if (a.equalsIgnoreCase("ACC") || a.equalsIgnoreCase("ACA") || a.equalsIgnoreCase("ACU")
				|| a.equalsIgnoreCase("ACG") || a.equalsIgnoreCase("ACx")) {
			result = result + "T";
			return result;
		}// proline check
		else if (a.equalsIgnoreCase("CCx") || a.equalsIgnoreCase("CCC") || a.equalsIgnoreCase("CCA")
				|| a.equalsIgnoreCase("CCU") || a.equalsIgnoreCase("CCG")) {
			result = result + "P";
			return result;
		}// valine check
		else if (a.equalsIgnoreCase("GUA") || a.equalsIgnoreCase("GUG") || a.equalsIgnoreCase("GUU")
				|| a.equalsIgnoreCase("GUC") || a.equalsIgnoreCase("GUx")) {
			result = result + "V";
			return result;
		}// leucine check
		else if (a.equalsIgnoreCase("(CUx,UUA,UUG)") || a.equalsIgnoreCase("CUU")
				|| a.equalsIgnoreCase("CUC") || a.equalsIgnoreCase("CUA") || a.equalsIgnoreCase("CCG")
				|| a.equalsIgnoreCase("UUA") || a.equalsIgnoreCase("UUG")) {
			result = result + "L";
			return result;
		}// methionine check
		else if (a.equalsIgnoreCase("AUG")) {
			result = result + "M";
			return result;
		}// tyrosine check
		else if (a.equalsIgnoreCase("UAU") || a.equalsIgnoreCase("UAC") || a.equalsIgnoreCase("(UAU,UAC)")) {
			result = result + "Y";
			return result;
		}// cysteine check
		else if (a.equalsIgnoreCase("UGU") || a.equalsIgnoreCase("UGC") || a.equalsIgnoreCase("(UAU,UAC)")) {
			result = result + "C";
			return result;
		}// tryptophane check
		else if (a.equalsIgnoreCase("UGG")) {
			result = result + "W";
			return result;
		}// aspartic check
		else if (a.equalsIgnoreCase("GAU") || a.equalsIgnoreCase("GAC") || a.equalsIgnoreCase("(UGU,UGC)")) {
			result = result + "D";
			return result;
		}// glutamine check
		else if (a.equalsIgnoreCase("GAA") || a.equalsIgnoreCase("GAG") || a.equalsIgnoreCase("(GAA,GAG)")) {
			result = result + "E";
			return result;
		}// asparagine check
		else if (a.equalsIgnoreCase("GAU") || a.equalsIgnoreCase("GAC") || a.equalsIgnoreCase("(GAU,GAC)")) {
			result = result + "N";
			return result;
		}// glutamine check
		else if (a.equalsIgnoreCase("CAA") || a.equalsIgnoreCase("CAG") || a.equalsIgnoreCase("(CAA,CAG)")) {
			result = result + "Q";
			return result;
		}// glycine check
		else if (a.equalsIgnoreCase("GGG") || a.equalsIgnoreCase("GGU") || a.equalsIgnoreCase("GGC")
				|| a.equalsIgnoreCase("GGA") || a.equalsIgnoreCase("GGx")) {
			result = result + "G";
			return result;
		}// isoleucine check
		else if (a.equalsIgnoreCase("AUU") || a.equalsIgnoreCase("AUC") || a.equalsIgnoreCase("AUA")
				|| a.equalsIgnoreCase("(AUU,AUC,AUA)")) {
			result = result + "I";
			return result;
		}// phenylalanine check
		else if (a.equalsIgnoreCase("UUU") || a.equalsIgnoreCase("UUC") || a.equalsIgnoreCase("(UUU,UUC)")) {
			result = result + "F";
			return result;
		}// arginine check
		else if (a.equalsIgnoreCase("CGx") || a.equalsIgnoreCase("CGC") || a.equalsIgnoreCase("CGG")
				|| a.equalsIgnoreCase("CGA") || a.equalsIgnoreCase("CGU") || a.equalsIgnoreCase("AGA")
				|| a.equalsIgnoreCase("AGG") || a.equalsIgnoreCase("(CGx,AGA,AGG)")) {
			result = result + "R";
			return result;
		}// lysine check
		else if (a.equalsIgnoreCase("AAA") || a.equalsIgnoreCase("AAG") || a.equalsIgnoreCase("(AAA,AAG)")) {
			result = result + "K";
			return result;
		}// histidine check
		else if (a.equalsIgnoreCase("CAU") || a.equalsIgnoreCase("CAC") || a.equalsIgnoreCase("(CAU,CAC)")) {
			result = result + "H";
			return result;
		}
		// no amino acid check
		else {
			return a + " is not a valid RNA sequence ";
		}
	}
}
