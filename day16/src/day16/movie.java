package day16;

import java.util.Scanner;

class Theater {
	Scanner sc = new Scanner(System.in);
	String name = "";
	int[] seat = new int[10];
	int cnt = 0;

	void program() {
		System.out.print("seat = ");
		for (int i = 0; i < seat.length; i++) {
			System.out.print(seat[i] + " ");
		}
		System.out.println();
		System.out.println("좌석선택 :");
		int slts = sc.nextInt();
		if (seat[slts] == 1) {
			System.out.println("이미 예매가 완료된 자리입니다.");
		} else {
			seat[slts] = 1;
			cnt++;
		}
	}
	void money() {
		System.out.println("매출액 : " + (cnt * 12000) + "원");
	}
}

public class movie {
	public static void main(String[] args) {
		Theater t = new Theater();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("=============");
			System.out.println("[MEGA MOVIE]");
			System.out.println("[1]좌석예매");
			System.out.println("[2]종료하기");
			System.out.println("=============");
			int slt = sc.nextInt();
			if (slt == 1) {
				t.program();
			}
			if (slt == 2) {
				t.money();
				break;
			}
		}
	}
}
