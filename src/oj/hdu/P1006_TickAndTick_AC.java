package oj.hdu;

import java.util.Scanner;

public class P1006_TickAndTick_AC {
	public static void main(String[] args) {
		Scanner sin = new Scanner(System.in);
		while (true) {
			double s_m[][] = new double[720][2];//记录秒_小时 夹角小于N的时间段 
			double s_h[][] = new double[720][2];//秒_小时 [i][0] 记录开始时间
			double m_h[][] = new double[12][2]; //分_小时 [i][1] 记录结束
			int n = sin.nextInt();
			if (n == -1)
				break;
			int temp_s = -3600;
			for (int i = 0; i < 12; i++) {
				temp_s += 3600;
				m_h[i][0] = (12 * (temp_s) - n * 120) / 11.0;
				m_h[i][1] = (n * 120 + 12 * (temp_s)) / 11.0;
			}
			m_h[0][0] = 0.0;
			m_h[11][1]=temp_s + 3600;
			temp_s = -60;
			for (int i = 0; i < 720; i++) {
				temp_s += 60;
				s_h[i][0] = (720 * temp_s - n * 120) / 719.0;
				s_h[i][1] = (720 * temp_s + n * 120) / 719.0;
				s_m[i][0] = (3600 * i - 10 * n - ((int)(i / 60))* 3600)/ 59.0;
				s_m[i][1] = (10 * n + 3600 * i - ((int)(i / 60))* 3600)/ 59.0;
			}
			s_h[0][0]=0.0;
			s_m[0][0]=0.0;
			s_h[719][1]=m_h[11][1];
			s_m[719][1]=m_h[11][1];
			double temp[][] = new double[720 + 720 + 12][2];
			for (int i = 0; i < 720; i++) {
				temp[i][0] = s_m[i][0];
				temp[i][1] = s_m[i][1];
			}
			for (int i = 0; i < 720; i++) {
				temp[i + 720][0] = s_h[i][0];
				temp[i + 720][1] = s_h[i][1];
			}
			for (int i = 0; i < 12; i++) {
				temp[i + 720 + 720][0] = m_h[i][0];
				temp[i + 720 + 720][1] = m_h[i][1];
			}
			ShellSort ss = new ShellSort(temp,720 + 720 + 12);
			temp = ss.sort();
			double time = temp[0][0]-0;
			double tempTime = 0.0;
			double endTime = 0.0;
			for(int i = 0; i <720 + 720 + 11;i++){
				if(endTime<temp[i][1])
					endTime=temp[i][1];
				tempTime =temp[i+1][0]-endTime;
				if(tempTime>0)
					time +=tempTime;
			}
			time = time +(12*3600-temp[720 + 720 + 11][1]);
			System.out.println(String.format("%.3f", time/(12*36)));
		}
		sin.close();
	}
}

class ShellSort {
	private int n;
	private double data[][];

	ShellSort(double data[][], int n) {
		this.data = data;
		this.n = n;
	}

	public double[][] sort() {
		int i, j, d;
		double temp[] = new double[2];
		d = n / 2;
		while (d > 0) {
			for (i = d; i < n; i++) {
				j = i - d;
				while (j >= 0 && data[j][0] > data[j + d][0]) {
					temp = data[j];
					data[j] = data[j + d];
					data[j + d] = temp;
					j = j - d;
				}
			}
			d = d / 2;
		}
		return data;
	}
}