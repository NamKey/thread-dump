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
		for (int i = 0; i < 10000; i++) {
			seeProduct();
		}
	}

	private void seeProduct() {
		int productCount = this.store.getProductCount();
		System.out.println(userName + " / store = " + productCount);
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
