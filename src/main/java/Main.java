import domain.Store;
import thread.User;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.LinkedTransferQueue;

public class Main {

	public static void main(String[] args) {

		int threadCount = 100;
		int productCount = 100000;

		// Store Open 준비
		BlockingQueue<Long> products = new LinkedBlockingQueue<>();
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
			new Thread(runnable).start();
		}
	}
}
