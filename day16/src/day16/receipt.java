package day16;

import java.util.Scanner;

class Buger {
	String name = "";
	int[] price = { 2500, 3800, 1500, 1000 };
	String[] menu = { "ġ�����", "�������", "����Ƣ��", "��ī�ݶ�" };
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
		b.name = "������ġ";
		System.out.println("      " + b.name);
		System.out.println("------------------");
		while (true) {
			System.out.println("      �޴�����");
			for (int i = 0; i < 4; i++) {
				System.out.println((i + 1) + ". " + b.menu[i] + "--" + b.price[i] + "��");
			}
			System.out.println("0. ������ ���");
			int slt = sc.nextInt();
			if (slt == 0) {
				System.out.println("------------------");
				System.out.println("ITEM   QTY   AMT");
				for (int i = 0; i < 4; i++) {
					System.out.println(b.menu[i] + "   " + b.cnt[i] + "   " + b.price[i]);
				}
				System.out.println("------------------");
				System.out.println("�հ�ݾ�        " + b.total);
				System.out.print("�����ݾ�        ");
				int money = sc.nextInt();
				System.out.println("------------------");
				System.out.println("��   ��        " + (money - b.total));
				break;
			}
			if ((slt >= 1) && (slt <= 4)) {
				b.cal(slt);
			}
		}
	}
}
