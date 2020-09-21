package MainGraphing;

public class EquationHandler {

	public static String EquationAtPoint(String equation, double x) {
		String y = "";
		int i = 0;
		int j = 0;
		int startSearch = 0;
		int endSearch = 0;
		
		//Fixing little problems - Adding Multiplication Signs and Replacing value for X
		equation = equation.replaceAll(" ", "");
		for (int l = 0; l < equation.length()-1; l++) {
			if ((equation.substring(l, l+1)).equals(")") && (equation.substring(l+1, l+2)).equals("(")) {
				String frontSection = equation.substring(0,l);
				String endSection = equation.substring(l);
				equation = frontSection + "*" + endSection;
			}
			if ((equation.substring(l, l+1)).equals("x") && ((equation.substring(l-1,l)).equals("0") || (equation.substring(l-1,l)).equals("1") || (equation.substring(l-1,l)).equals("2") || (equation.substring(l-1,l)).equals("3") || (equation.substring(l-1,l)).equals("4") || (equation.substring(l-1,l)).equals("5") || (equation.substring(l-1,l)).equals("6") || (equation.substring(l-1,l)).equals("7") || (equation.substring(l-1,l)).equals("8") || (equation.substring(l-1,l)).equals("9"))) {
				String frontSection = equation.substring(0, l);
				String endSection = equation.substring(l);
				equation = frontSection + "*" + endSection;
			}
		}
		equation = equation.replaceAll("x", String.valueOf(x));
		
		//Parenthesis
		for (i = 0; i < equation.length()-1; i++) {
			if ((equation.substring(i,i+1)).equals("(")) {
				startSearch = i;
				int parenthesisCount = 0;
				for (j = i+1; j < equation.length(); j++) {
					if ((equation.substring(j, j+1)).equals("(")) {
						parenthesisCount++;
					}
					if ((equation.substring(j, j+1)).equals(")") && parenthesisCount == 0) {
						endSearch = j+1;
						break;
					}
					if ((equation.substring(j, j+1)).equals(")") && parenthesisCount != 0) {
						parenthesisCount--;
					}
				}
				
				String endSection = "";
				String simplifiedPart = EquationAtPoint(equation.substring(startSearch+1,endSearch-1), x);
				String frontSection = equation.substring(0,i);
				if (equation.length() <= endSearch) {
					endSection = "";
				} else {
					endSection = equation.substring(j+1);
				}
				equation = frontSection + simplifiedPart + endSection;
			}
		}
		
		//Trigonometry = sin,soc,tan,sec,csc,cot
		for (int k = 0; k < equation.length()-3; k++) {
			if ((equation.substring(k, k+3)).equals("sin")) {
				double sinNumber = EquationHandler.NumberFinder(equation, k+3);
				String trigAnswer = String.valueOf(Math.sin(sinNumber));
				equation = equation.replaceFirst("sin" + String.valueOf(sinNumber), trigAnswer);
			}
			if ((equation.substring(k, k+3)).equals("cos")) {
				double cosNumber = EquationHandler.NumberFinder(equation, k+3);
				String trigAnswer = String.valueOf(Math.cos(cosNumber));
				equation = equation.replaceFirst("sin" + String.valueOf(cosNumber), trigAnswer);
			}
			if ((equation.substring(k, k+3)).equals("tan")) {
				double tanNumber = EquationHandler.NumberFinder(equation, k+3);
				String trigAnswer = String.valueOf(Math.tan(tanNumber));
				equation = equation.replaceFirst("sin" + String.valueOf(tanNumber), trigAnswer);
			}
			if ((equation.substring(k, k+3)).equals("csc")) {
				double cscNumber = EquationHandler.NumberFinder(equation, k+3);
				String trigAnswer = String.valueOf(Math.asin(cscNumber));
				equation = equation.replaceFirst("sin" + String.valueOf(cscNumber), trigAnswer);
			}
			if ((equation.substring(k, k+3)).equals("sec")) {
				double secNumber = EquationHandler.NumberFinder(equation, k+3);
				String trigAnswer = String.valueOf(Math.acos(secNumber));
				equation = equation.replaceFirst("sin" + String.valueOf(secNumber), trigAnswer);
			}
			if ((equation.substring(k, k+3)).equals("cot")) {
				double cotNumber = EquationHandler.NumberFinder(equation, k+3);
				String trigAnswer = String.valueOf(Math.atan(cotNumber));
				equation = equation.replaceFirst("sin" + String.valueOf(cotNumber), trigAnswer);
			}
		}
		
		//Roots and Exponents
		for (int l = 0; l < equation.length(); l++) {
			
		}
		
		return(equation);
	}
	
	public static double NumberFinder(String equation, int startPos) {
		String tempNumber = "";
		for ( int counter = startPos; counter < equation.length(); counter++) {
			String testNum = equation.substring(counter, counter+1);
			if (testNum.equals("-") || testNum.equals("1") || testNum.equals("2") || testNum.equals("3") || testNum.equals("4") || testNum.equals("5") || testNum.equals("6") || testNum.equals("7") || testNum.equals("8") || testNum.equals("9") || testNum.equals("0") || testNum.equals(".")) {
				tempNumber = tempNumber + testNum;
			} else {
				break;
			}
		}
		double xvalue = Double.parseDouble(tempNumber);
		return xvalue;
	}
	
}
