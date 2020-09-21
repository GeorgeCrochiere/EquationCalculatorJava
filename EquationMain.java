package MainGraphing;

public class EquationMain {

	public static void main(String[] args) {
		
		EquationHandler ed = new EquationHandler();
		
		String result = ed.EquationAtPoint("7x + (sin(4.234))", 3);
		System.out.println(result);
	}

}
