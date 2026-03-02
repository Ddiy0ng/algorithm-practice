package algo_prac;

import java.util.Scanner;

public class Problems {

	final Scanner sc = new Scanner(System.in);
	
	// 숫자 개수와, 공백으로 구분없는 숫자들을 입력받고 숫자 합 출력하기
	protected void problem001() {
		System.out.print("1. enter the size: ");
		int N = sc.nextInt();
		
		System.out.print("2. enter the numbers: ");
		String nums = sc.next();
		
		int sum = 0;
		for (int i = 0; i < N; i++)
			sum += nums.charAt(i)-'0';	// '0' == 48, 0 == 0	ASCII
		
		System.out.println(sum);
	}
	
	// 과목 개수와 공백으로 구분된 성적들을 입력받고 맞춤형 계산법으로 평균 구해 출력하기
	protected void problem002() {
		System.out.print("1. enter the lectures count: ");
		int N = sc.nextInt();
		
		System.out.print("2. enter the scores: ");
		double[] scores = new double[N];
		double max = 0;
		for(int i = 0; i < N; i++) {
			scores[i] = sc.nextDouble();
			if (max < scores[i])
				max = scores[i];
		}
		
		// 성적 수정하기
		double sum = 0.0;
		for (int i = 0; i < N; i++) {
			scores[i] = scores[i] / max * 100;
			sum += scores[i];
		}

		System.out.println(sum / N);
	}
	
	// 구간합 구하기1
	protected void problem003() {
		int N = sc.nextInt();	// 수 개수
		int count = sc.nextInt(); // 질의 개수
		
		int[] arr = new int[N];
		arr[0] = sc.nextInt();
		for (int i = 1; i < N; i++)
			arr[i] = arr[i - 1] + sc.nextInt();
		
		int[] results = new int[count];
		for (int k = 0; k > count; k++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			
			if( i == 0)
				results[k] = arr[j];
			else
				results[k] = arr[j] - arr[i - 1];
		}
		
		for(int i = 0; i < count; i++)
			System.out.println(results[i]);
	}
}
