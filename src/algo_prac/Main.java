package algo_prac;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		final Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// 수 개수
		int count = sc.nextInt(); // 질의 개수
		
		int[] arr = new int[N];
		arr[0] = sc.nextInt();
		for (int i = 1; i < N; i++)
			arr[i] = arr[i - 1] + sc.nextInt();
		
		int[] results = new int[count];
		for (int k = 0; k < count; k++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			
			if(i == 1)
				results[k] = arr[j - 1];
			else
				results[k] = arr[j - 1] - arr[i - 2];
		}
		
		for(int i = 0; i < count; i++)
			System.out.println(results[i]);
	}

}
