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


