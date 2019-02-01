package fracCalc;
import java.util.Scanner;
/* This class calculates an expression with fractions
 * @author Alexis Lin
 * @version January 26, 2019
 */
public class FracCalc {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String nextStep;
		do {
			String problem = scanner.nextLine();
			System.out.println(produceAnswer(problem));
			nextStep = scanner.next();
		}
		while(!(nextStep.equals("quit")));
		scanner.close();		
	}
	public static String produceAnswer(String input) {
		String[] inputArray = input.split(" ");
		Fraction operand1 = new Fraction(inputArray[0]);
		Fraction operand2 = new Fraction(inputArray[2]);
		String operator = inputArray[1];
		operand1.doMath(operand2, operator);
		operand1.reduce();
		return operand1.toMixedNum();
	}
	
}
