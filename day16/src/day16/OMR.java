package day16;

import java.util.Random;

class ScoreMng {
	Random ran = new Random();
	int[] answer = { 1, 3, 4, 2, 5 };
	int[] hgd = new int[5];
	int cnt = 0, score = 0;

	void test() {
		for (int i = 0; i < hgd.length; i++) {
			hgd[i] = ran.nextInt(5) + 1;
		}
	}

	int[] ox(int[] a) {
		for (int i = 0; i < hgd.length; i++) {
			if (hgd[i] == answer[i]) {
				a[i] = 1;
				cnt++;
			} else {
				a[i] = -1;
			}
		}
		return a;
	}

	void print(int[] a) {
		System.out.print("{");
		String temp ="";
		for (int i = 0; i < hgd.length; i++) {
			temp+=a[i] + ", ";
		}
		temp = temp.substring(0,temp.length()-2);
		System.out.println(temp+"}");
	}

	void print2(int[] a) {
		System.out.print("{");
		String temp ="";
		for (int i = 0; i < hgd.length; i++) {
			if (a[i] == 1) {
				temp+="O, ";
				cnt++;
			} else {
				temp+="X, ";
			}
		}
		temp = temp.substring(0,temp.length()-2);
		System.out.println(temp+"}");
	}
}

public class OMR {
	public static void main(String[] args) {
		ScoreMng sr = new ScoreMng();
		int[] temp = new int[5];
		sr.test();
		temp = sr.ox(temp);
		System.out.print("answer = ");
		sr.print(sr.answer);
		System.out.print("hgd = ");
		sr.print(sr.hgd);
		System.out.print("정오표 = ");
		sr.print2(temp);
		System.out.print("성적 = " + (sr.cnt * 20)+"점");
	}
}
