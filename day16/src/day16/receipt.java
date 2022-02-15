package day16;

import java.util.Scanner;

class Buger {
	String name = "";
	int[] price = { 2500, 3800, 1500, 1000 };
	String[] menu = { "치즈버거", "새우버거", "감자튀김", "코카콜라" };
	int[] cnt = new int[4];
	int total = 0;

	void cal(int n) {
		cnt[n - 1] += 1;
		total += price[n - 1];
	}
}

public class receipt {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Buger b = new Buger();
		b.name = "맘스터치";
		System.out.println("      " + b.name);
		System.out.println("------------------");
		while (true) {
			System.out.println("      메뉴선택");
			for (int i = 0; i < 4; i++) {
				System.out.println((i + 1) + ". " + b.menu[i] + "--" + b.price[i] + "원");
			}
			System.out.println("0. 영수증 출력");
			int slt = sc.nextInt();
			if (slt == 0) {
				System.out.println("------------------");
				System.out.println("ITEM   QTY   AMT");
				for (int i = 0; i < 4; i++) {
					System.out.println(b.menu[i] + "   " + b.cnt[i] + "   " + b.price[i]);
				}
				System.out.println("------------------");
				System.out.println("합계금액        " + b.total);
				System.out.print("받은금액        ");
				int money = sc.nextInt();
				System.out.println("------------------");
				System.out.println("잔   돈        " + (money - b.total));
				break;
			}
			if ((slt >= 1) && (slt <= 4)) {
				b.cal(slt);
			}
		}
	}
}
