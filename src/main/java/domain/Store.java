package domain;

import java.util.concurrent.BlockingQueue;

public class Store {
	private BlockingQueue<Long> productsList;

	public Store(BlockingQueue<Long> productsList) {
		this.productsList = productsList;
	}

	public void sellProduct() {
		this.productsList.remove();
	}

	public int getProductCount() {
		return this.productsList.size();
	}
}
