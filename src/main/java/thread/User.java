package thread;

import domain.Store;

import java.util.Random;

public class User implements Runnable {

	private Store store;
	private String userName;
	private Random random = new Random(5);

	public User(Store store, String name) {
		this.store = store;
		this.userName = name;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			pending(100000);
			buyProduct();
		}
	}

	private void buyProduct() {
		this.store.sellProduct();
		System.out.println(userName + " / store = " + store.getProductCount());
	}

	private void pending(int limit) {
		// Sleep 대신 사용
		int dummy = 0;
		for (int j = 0; j < limit; j++) {
			dummy++;
			System.out.println("dummy = " + dummy);
		}
	}
}
