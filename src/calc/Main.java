package calc;

import java.util.Scanner;

public class Main {

	private static Scanner scan;

	public static void main(String[] args) {
		boolean yn = true;
		String again;
		double score = 0;

		while (yn) {
			System.out.println("Insert operation");
			scan = new Scanner(System.in);
			String inputMath = scan.nextLine();
			System.out.println("Input string: " + inputMath);
			try {
				Calculate calculator = new Calculate();
				calculator.parseInput(inputMath);
				score = calculator.calculate();
				System.out.printf("Score: %.3f\n", score);
				System.out.println("Again (y/n): ");
				again = scan.nextLine();
				if (again.equals("y")) {
					yn = true;
				} else {
					yn = false;
				}
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
	}
}
