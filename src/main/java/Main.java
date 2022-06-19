import domain.Store;
import thread.User;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		int threadCount = 100;
		int productCount = 10000;

		// Store Open 준비
		ArrayList<Long> products = new ArrayList<>(productCount);
		for (int i = 0; i < productCount; i++) {
			products.add((long) i);
		}
		Store store = new Store(products);

		// 손님 입장 줄 선 긋는 중
		Runnable[] customers = new Runnable[threadCount];

		// 손님들을 입장 줄에 세워놓기
		for (int i = 0; i < threadCount; i++) {
			customers[i] = new User(store, "User-" + i);
		}

		// 손님들 입장
		for (Runnable runnable : customers) {
			Thread newThread = new Thread(runnable);
			newThread.start();
		}
	}
}
