package algo_prac;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class Problems {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	// 숫자 개수와, 공백으로 구분없는 숫자들을 입력받고 숫자 합 출력하기
	public void problem001() throws IOException {
		int N = Integer.parseInt(br.readLine());
		String nums = br.readLine();
		int sum = 0;
		for (int i = 0; i < N; i++)
			sum += nums.charAt(i)-'0';	// '0' == 48, 0 == 0	ASCII
		
		System.out.println(sum);
	}
	
	// 과목 개수와 공백으로 구분된 성적들을 입력받고 맞춤형 계산법으로 평균 구해 출력하기
	public void problem002() throws IOException {
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		double[] scores = new double[N];
		double max = 0;
		for(int i = 0; i < N; i++) {
			scores[i] = Double.parseDouble(st.nextToken());
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
	public void problem003() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new  StringTokenizer(br.readLine());
		arr[0] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < N; i++)
			arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
		
		int[] results = new int[M];
		for (int k = 0; k < M; k++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			
			if(i == 1)
				results[k] = arr[j - 1];
			else
				results[k] = arr[j - 1] - arr[i - 2];
		}
		
		for(int i = 0; i < M; i++)
			System.out.println(results[i]);
	}
	
	// 구간합 구하기2
	public void problem004() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] rangeSum = new int[N + 1][N + 1];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) 
				rangeSum[i][j] = rangeSum[i - 1][j] + rangeSum[i][j - 1] - rangeSum[i - 1][j - 1] + Integer.parseInt(st.nextToken());
		}

		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			System.out.println(rangeSum[x2][y2] - rangeSum[x2][y1 - 1] - rangeSum[x1 - 1][y2] + rangeSum[x1 - 1][y1 - 1]);
		}
	}
}
