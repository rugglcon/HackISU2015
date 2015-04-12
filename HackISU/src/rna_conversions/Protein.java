package rna_conversions;

public class Protein{
	public static String protein(String a) {
	// result will save the string being built
	String result = "";
	// get rid of spaces
	a.replaceAll(" ", "");
	int i = 0;
	// while loop thats valid till end of the string
	while (i < a.length()) {
		// check for numbers which are skipped
		if (Character.isDigit(a.charAt(i))) {
			i++;
		}
		// if it is a letter find corresponding amino acid
		else if (Character.isLetter(a.charAt(i))) {
			//result = result + getProtein(a.charAt(i));
		}
		// move on
		i=+3;
	}
	return result;
}

public static String getProtein(String a) {
	String result = "";
	a = a.toUpperCase();
	// alanine check
	if (a.equals("GCU") || a.equals("GCC") || a.equals("GCA") || a.equals("GCG") || a.equals("GCx")) {
		result = result + "A";
		return result;
	}// serine check
	else if (a.equals("UCA") || a.equals("UCU") || a.equals("UCG") || a.equals("AGU") || a.equals("AGC") || a.equals("(UCx,AGU,AGC)")) {
		result = result + "S"; 
		return result;
	}// threonine check
	else if (a.equals("ACC") || a.equals("ACA") || a.equals("ACU")|| a.equals("ACG") || a.equals("ACx")) {
		result = result + "T";
		return result;
	}// proline check
	else if (a.equals("CCx") || a.equals("CCC") || a.equals("CCA") || a.equals("CCU") || a.equals("CCG")) {
		result = result + "P";
		return result;
	}// valine check
	else if (a.equals("GUA") || a.equals("GUG") || a.equals("GUU") || a.equals("GUC") || a.equals("GUx")) {
		result = result + "V";
		return result;
	}// leucine check
	else if (a.equals("(CUx,UUA,UUG)") || a.equals("CUU") || a.equals("CUC") || a.equals("CUA") || a.equals("CCG") || a.equals("UUA") || a.equals("UUG")) {
		result = result + "L";
		return result;
	}// methionine check
	else if (a.equals("AUG")) {
		result = result + "M";
		return result;
	}// tyrosine check
	else if (a.equals("UAU") || a.equals("UAC") || a.equals("(UAU,UAC)")) {
		result = result + "Y";
		return result;
	}// cysteine check
	else if (a.equals("UGU") || a.equals("UGC") || a.equals("(UAU,UAC)")) {
		result = result + "C";
		return result;
	}// tryptophane check
	else if (a.equalsIgnoreCase("UGG")) {
		result = result + "W";
		return result;
	}// aspartic check
	else if (a.equals("GAU") || a.equals("GAC") ||a.equals("(UGU,UGC)")) {
		result = result + "D";
		return result;
	}// glutamine check
	else if (a.equals("GAA") || a.equals("GAG") || a.equals("(GAA,GAG)")) {
		result = result + "E";
		return result;
	}// asparagine check
	else if (a.equals("GAU") || a.equals("GAC") || a.equals("(GAU,GAC)")) {
		result = result + "N";
		return result;
	}// glutamine check
	else if (a.equals("CAA") || a.equals("CAG") || a.equals("(CAA,CAG)")) {
		result = result + "Q";
		return result;
	}// glycine check
	else if (a.equals("GGG") || a.equals("GGU") || a.equals("GGC") || a.equals("GGA") || a.equals("GGx")) {
		result = result + "G";
		return result;
	}// isoleucine check
	else if (a.equals("AUU") || a.equals("AUC") || a.equals("AUA") || a.equals("(AUU,AUC,AUA)")) {
		result = result + "I";
		return result;
	}// phenylalanine check
	else if (a.equals("UUU") || a.equals("UUC") || a.equals("(UUU,UUC)")) {
		result = result + "F";
		return result;
	}// arginine check
	else if (a.equals("CGx") || a.equals("CGC") || a.equals("CGG") || a.equals("CGA") || a.equals("CGU") || a.equals("AGA") || a.equals("AGG") || a.equals("(CGx,AGA,AGG)")) {
		result = result + "R";
		return result;
	}// lysine check
	else if (a.equals("AAA") || a.equals("AAG") || a.equals("(AAA,AAG)")) {
		result = result + "K";
		return result;
	}// histidine check
	else if (a.equals("CAU") || a.equals("CAC") || a.equals("(AAA,AAG)")) {
		result = result + "H";
		return result;
	}
	// no amino acid check
	else {
		return a + " is not a vailid amino acid ";
	}
}
}


