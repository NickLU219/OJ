package oj.hdu;

import java.util.Scanner;

public class P1005_NumberSequence {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int n = scanner.nextInt();
			if (a == 0 && b == 0 && n == 0) {
				break;
			}
			//7*7之后为循环！！
			System.out.println(fn(a,b,n%48));
		}
		scanner.close();
	}
	
	static int fn(int a,int b,int n) {
		if (n == 1 || n == 2) {
			return 1;
		}
		int nd = fn(a,b,n-1);
		int ndd = fn(a,b,n-2);
		return (a * nd + b * ndd) %7;
	}
}
