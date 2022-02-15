package day16;

import java.util.Scanner;
import java.util.Random;

class Memorygame {
	Scanner sc = new Scanner(System.in);
	Random ran = new Random();
	int[] front = { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5 };
	int[] back = new int[10];
	int cnt = 0;

	void shuffle() {
		int x = 0;
		while (x < 1000) {
			int r = ran.nextInt(10);
			int temp = front[0];
			front[0] = front[r];
			front[r] = temp;
			x++;
		}
	}
	
	void game() {
		int n=sc.nextInt();
		int m=sc.nextInt();
		if(front[n]==front[m]) {
			back[n]=front[n];
			back[m]=front[m];
			cnt++;
		}else {
			System.out.println("숫자가 다릅니다.");
		}
	}
	void print(int[] a) {
		System.out.print("[ ");
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println("]");
	}
	
}

public class remember {
	public static void main(String[] args) {
		Memorygame m = new Memorygame();
		m.shuffle();
		while(m.cnt<5) {
			System.out.print("front = ");
			m.print(m.front);
			System.out.print("back = ");
			m.print(m.back);
			m.game();
		}
		System.out.println("게임 종료");
	}
}
