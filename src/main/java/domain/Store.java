package domain;

import java.util.ArrayList;
import java.util.List;

public class Store {
	private List<Long> productsList;

	public Store(List<Long> productsList) {
		this.productsList = productsList;
	}

	public synchronized void sellProduct() {
		this.productsList.remove(0);
	}

	public int getProductCount() {
		return this.productsList.size();
	}
}
