package oj.hdu;

import java.util.Scanner;

public class P1001_SumProblem {

	public static int sum(int n) {
        if(n % 2 == 0) return n/2*(n+1);
        else return (n+1)/2*n;
        
    }
    public static void main(String args[])
    {
        Scanner cin = new Scanner(System.in);
        int n;
        while(cin.hasNextInt()) {
            n = cin.nextInt();
            System.out.println(sum(n));
            System.out.println();
        }
        cin.close();
    }

}
