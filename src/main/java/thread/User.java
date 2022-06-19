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
			buyProduct();
		}
	}

	private void buyProduct() {
		try {
			Thread.sleep(random.nextInt(100));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.store.sellProduct();
		System.out.println(userName + " / store = " + store.getProductCount());
	}
}
