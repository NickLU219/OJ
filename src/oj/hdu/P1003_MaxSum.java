package oj.hdu;

import java.util.Scanner;

public class P1003_MaxSum {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();   //输入测试次数
		for (int i = 1; i <= n; i++) {
			int temp = 1;
			int startIndex = 1;     //开始位置
			int endIndex = 1;		//结束位置
			int sum = 0;			//和
			int max = -0xfffffff;
			int m = sc.nextInt();     
			for (int j = 1; j <= m; j++) {
				sum += sc.nextInt();
				if (sum >  max) {
					max = sum;
					startIndex = temp;
					endIndex = j;
				}
				//key
				if (sum<0) {
					sum=0;
					temp = j+1;
				}
			}
			System.out.println("Case "+i+":");
			System.out.println(max + " " + startIndex + " " + endIndex);
			if (i != n) {
				System.out.println();
			}
		}
		sc.close();
	}

}
