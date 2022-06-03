package giu.supermarket.model.supermarket;

import giu.supermarket.model.cart.Cart;

public interface SupermarketListener {
	void onCartUpdated(Cart cart);
}
