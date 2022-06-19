package thread;

import domain.Store;

public class User implements Runnable {

	private Store store;
	private String userName;

	public User(Store store, String name) {
		this.store = store;
		this.userName = name;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			buyProduct();
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void buyProduct() {
		this.store.sellProduct();
		System.out.println(userName +" / store = " + store.getProductCount());
	}
}
