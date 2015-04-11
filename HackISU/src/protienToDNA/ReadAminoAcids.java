package protienToDNA;

public class ReadAminoAcids {

	public String sequence(String a) {
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
				result = result + aminoAcid(a.charAt(i));
			} else {

			}

			i++;
		}
		return result;

	}

	public String aminoAcid(char a) {
		String result = "";
		// alanine check
		if (a == 'a' || a == 'A') {
			result = result + "GCx";
			return result;
		}// serine check
		 else if (a == 's' || a == 'S') {
			result = result + "UCx";
			return result;
		}// threonine check
		 else if ( a == 't' || a == 'T') {
			 result = result + "ACx";
			 return result;
		 }// proline check
		 else if (a == 'p' || a == 'P'){
			 result = result + "CCx";
			 return result;
		 }
		return result;
	}
}
