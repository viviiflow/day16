package day16;

import java.util.Scanner;
import java.util.Random;

class Game {
	Scanner sc = new Scanner(System.in);
	Random ran = new Random();
	String name = "";
	int[] game = new int[10];
	int now = -1;

	void start(int n, int m) {
		for (int i = 0; i < m; i++) {
			game[ran.nextInt(10)] = n;
		}
	}

	void move(int n) {
		try {
			if (game[now + (n)] == 1) {
				System.out.println("벽을 만나 움직일 수 없습니다.");
				System.out.println("벽 부수기 -> 3");
			} else {
				game[now] = 0;
				game[now + (n)] = 8;
				now = now + n;
			}
		} catch (Exception e) {
			if ((game[9] == 1) || (game[0] == 1)) {
				System.out.println("벽을 만나 움직일 수 없습니다.");
				System.out.println("벽 부수기 -> 3");
			} else if (n == -1) {
				game[now] = 0;
				game[9] = 8;
				now = 9;
			} else if (n == 1) {
				game[now] = 0;
				game[0] = 8;
				now = 0;
			}
		}
	}

	void breaks() {
		try {
			if (game[now - 1] == 1) {
				game[now - 1] = 0;
			} else if (game[now + 1] == 1) {
				game[now + 1] = 0;
			}
		} catch (Exception e) {
			if (now == 0) {
				game[9] = 0;
			} else if (now == 9) {
				game[0] = 0;
			}
		}
	}
}

public class moveNum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Game g = new Game();
		g.start(1, 3);
		g.start(8, 1);
		for (int i = 0; i < 10; i++) {
			if (g.game[i] == 8) {
				g.now = i;
			}
		}
		System.out.println(g.now);
		while (true) {
			for (int i = 0; i < 10; i++) {
				if (g.game[i] == 0) {
					System.out.print("0 ");
				} else if (g.game[i] == 1) {
					System.out.print("벽 ");
				} else if (g.game[i] == 8) {
					System.out.print("나 ");
				}
			}
			System.out.println("");
			System.out.println("왼쪽(1) 오른쪽(2) 종료(0)");
			int num = sc.nextInt();

			if (num == 0) {
				System.out.println("게임 종료");
				break;
			}
			if (num == 1) {
				g.move(-1);
			}
			if (num == 2) {
				g.move(1);
			}
			if (num == 3) {
				g.breaks();
			}
		}
	}
}
