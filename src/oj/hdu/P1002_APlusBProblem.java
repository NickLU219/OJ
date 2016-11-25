package oj.hdu;

import java.math.BigInteger;
import java.util.Scanner;

public class P1002_APlusBProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int num = 0;
		if (scanner.hasNext()) {
			num = scanner.nextInt();
		}
		for (int i = 1; i <= num; i++) {
			BigInteger a = scanner.nextBigInteger();
			BigInteger b = scanner.nextBigInteger();
			System.out.println("Case "+i+":");
			System.out.println(a+" + "+b+" = "+(a.add(b)));
			if (i!=num) {
				System.out.println();
			}
		}
		scanner.close();
	}

}
