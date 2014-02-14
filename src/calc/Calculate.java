package calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculate {

	double number1 = 0, number2 = 0;
	String action = null;
	String mathPattern = "(^[0-9]+[.]?[0-9]{0,3})([+,\\-,*,/,^]{1})([0-9]+[.]?[0-9]{0,3})$";

	public void parseInput(String inputMath) throws Exception {
		Pattern p = Pattern.compile(this.mathPattern);
		Matcher m = p.matcher(inputMath);
		if (!m.find()) {
			throw new Exception("Incorrect input string");
		}
		this.number1 = Float.parseFloat(m.group(1));
		this.number2 = Float.parseFloat(m.group(3));
		this.action = m.group(2);
	}

	public double calculate() throws Exception {
		double score = 0;
		switch (this.action) {
		case "+":
			score = this.add(this.number1, this.number2);
			break;
		case "-":
			score = this.subtract(this.number1, this.number2);
			break;
		case "*":
			score = this.multiply(this.number1, this.number2);
			break;
		case "^":
			score = this.power(this.number1, this.number2);
			break;
		case "/":
			score = this.divide(this.number1, this.number2);
			break;
		default:
			throw new Exception("Incorrect action");
		}
		return score;
	}

	private double add(double n1, double n2) {
		return n1 + n2;
	}

	private double subtract(double n1, double n2) {
		return n1 - n2;
	}

	private double multiply(double n1, double n2) {
		return n1 * n2;
	}

	private double divide(double n1, double n2) throws Exception {
		if (n2 == 0) {
			throw new Exception("Division by zero");
		}
		return n1 / n2;
	}

	private double power(double n1, double n2) {
		return Math.pow(n1, n2);
	}

}
