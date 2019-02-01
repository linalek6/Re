package fracCalc;
/* This class is an object that operates on fractional expressions
 * @author Alexis Lin
 * @version January 26, 2019
 */
public class Fraction {
	private int whole;
	private int numerator;
	private int denominator = 1;
	private String fractionStr;

	public Fraction(String operand) {
		fractionStr = operand;
		if (fractionStr.contains("_")) {
			String[] wholeSplit = fractionStr.split("_");
			whole = Integer.parseInt(wholeSplit[0]);
			fractionStr = wholeSplit[1];
		}
		if (fractionStr.contains("/")) {
			String[] fracSplit = fractionStr.split("/");
			numerator = Integer.parseInt(fracSplit[0]);
			denominator = Integer.parseInt(fracSplit[1]);
		} else {
			whole = Integer.parseInt(fractionStr);
		}
		//to improper fraction
		if (whole < 0) {
			numerator = (whole * denominator) - numerator;
		} else {
			numerator = (whole * denominator) + numerator;
		}
		whole = 0;
	}
	//performs various operations on two operands
	public void doMath(Fraction operand, String operator) {
		if (operator.equals("+") || operator.equals("-")) {
			int numer1 = numerator * operand.denominator;
			int numer2 = operand.numerator * denominator;
			if (operator.equals("+")) {
				numerator = numer1 + numer2;
			} else {
				numerator = numer1 - numer2;
			}
			denominator = denominator * operand.denominator;
		} else if (operator.equals("/") || operator.equals("*")) {
			int denom2 = operand.numerator;
			if (operator.equals("/")) {
				operand.numerator = operand.denominator;
				operand.denominator = denom2;

			}
			numerator *= operand.numerator;
			denominator *= operand.denominator;
		}
	}
	//reduces a fraction to its simplest (mixed) form
	public void reduce() {
		int gcf = 1;
		for (int cf = 1; cf <= Math.abs(Math.min(numerator, denominator)); cf++) {
			if (numerator % cf == 0 && denominator % cf == 0) {
				gcf = cf;
			}
		}
		numerator = numerator / gcf;
		denominator = denominator / gcf;
	}
	//converts improper fraction to a mixed number
	public String toMixedNum() {
		if (numerator % denominator == 0) {
			return numerator / denominator + "";
		} else if (numerator / denominator == 0) {
			if (denominator <= 0) {
				return -numerator % denominator + "/" + Math.abs(denominator);
			}
			return numerator % denominator + "/" + Math.abs(denominator);
		} else {
			return (numerator / denominator) + "_" + Math.abs(numerator % denominator) + "/" + Math.abs(denominator);
		}
	}
}
