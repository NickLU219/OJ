package oj.hdu;

import java.util.Scanner;

/**
 * @problem Problem 1000
 * @author nick-lu
 *
 */
public class P1000_APlusBProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		//hdoj的java都必要的规范：while
		while (scanner.hasNext()) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			System.out.println(a+b);
		}
		scanner.close();
	}

}
