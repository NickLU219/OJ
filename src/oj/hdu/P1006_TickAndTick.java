package oj.hdu;

import java.util.Scanner;
/**
 * 本题应使用几何概型，非古典概型
 * @author nick-lu
 *
 */
public class P1006_TickAndTick {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			double totalSeconds = 60 *60 *12.00000000;//sec * min * hour
//			double hand_hour_degree = 0.00000000;//360 / 60 *60 *12   degree per second --> 1/120
//			double hand_minite_degree = 0.00000000;//360 *24 / 60 *60 *24  degree per second --> 1/10
//			double hand_second_degree = 0.00000000;//360 *24 *60 / 60 *60 *24  degree per second --> 6
			//relative speed
			double h_m = 11.00000000/120;
			double m_s = 59.00000000/10;
			double s_h = 719.00000000/120;
			double match_time_count = 0.00000000;
			double degree = scanner.nextDouble();
			if(degree != -1){
				for (int i = 0; i < totalSeconds; i++) {
					
					double hour_minus_min = i*h_m %360;
					double min_minus_sec = i*m_s %360;
					double sec_minus_hour = i*s_h %360;
					
					hour_minus_min = hour_minus_min>180?360-hour_minus_min:hour_minus_min;
					min_minus_sec = min_minus_sec>180?360-min_minus_sec:min_minus_sec;
					sec_minus_hour = sec_minus_hour>180?360-sec_minus_hour:sec_minus_hour;
					
					if (hour_minus_min >= degree && min_minus_sec >= degree && sec_minus_hour >= degree) {
						match_time_count++;
					}
				}
			}else {
				break;
			}
			System.out.println(String.format("%.3f", (match_time_count/totalSeconds) *100));
		}
		scanner.close();
	}

}
