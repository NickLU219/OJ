package oj.hdu;

/**
 * this problem can also be resolved by using Map 
 */
import java.util.ArrayList;
import java.util.Scanner;

public class P1004_LetTheBalloonRise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextLine()) {
			ArrayList<Integer> numArr = new ArrayList<>();
			ArrayList<String> arr = new ArrayList<>();
			int num = scanner.nextInt();
			if (num == 0) {
				break;
			}
			for (int i = 0; i < num; i++) {
				String str = scanner.next();
				if(!arr.contains(str)) {
					arr.add(str);
					numArr.add(1);
				} else {
					int index = arr.indexOf(str);
					int index_value = numArr.get(index)+1;
					numArr.set(index, index_value);
				}
			}
			int max_index = 0;
			int tmp = 0;
			for (int i = 0; i < numArr.size(); i++) {
				if (numArr.get(i).intValue() > tmp) {
					tmp = numArr.get(i).intValue();
					max_index = i;
				}
			}
			System.out.println(arr.get(max_index));
		}
		scanner.close();
	}

}
