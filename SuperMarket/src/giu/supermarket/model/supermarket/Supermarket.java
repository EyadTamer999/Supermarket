package giu.supermarket.model.supermarket;

import java.util.ArrayList;
import java.util.Random;

import giu.supermarket.model.cart.Cart;
import giu.supermarket.model.cart.CartListener;
import giu.supermarket.model.product.Beverage;
import giu.supermarket.model.product.DairyProduct;
import giu.supermarket.model.product.FatType;
import giu.supermarket.model.product.GroceryProduct;
import giu.supermarket.model.product.SugarLevel;

public class Supermarket implements CartListener {
	private ArrayList<GroceryProduct> products;
	private Cart cart;
	private SupermarketListener listener;

	public Supermarket() {
		products = new ArrayList<>();
		cart = new Cart();

		cart.setListener(this);

		// generate some products
		for (int i = 1; i <= 10; i++) {
			// generate a random product
			GroceryProduct product = someRandomProduct(i);

			// make sure the cart is notified when this product is bought
			product.setListener(cart);

			// add the product to the supermarket's list of products
			products.add(product);
		}
	}

	public ArrayList<GroceryProduct> getProducts() {
		return products;
	}

	public Cart getCart() {
		return cart;
	}

	public void setListener(SupermarketListener listener) {
		this.listener = listener;
	}

	/**
	 * Returns a randomly generated {@link GroceryProduct} to be added to the {@link Supermarket}'s list of products
	 * 
	 * @param index
	 *            a number indicating the index of the product being generated, to be used in its name
	 * @return the generated {@link GroceryProduct}
	 */
	private GroceryProduct someRandomProduct(int index) {
		char productType = new char[] { 'D', 'B' }[new Random().nextInt(2)];
		double price = new Random().nextDouble() * 20;
		int discount = new Random().nextInt(6) * 10;

		switch (productType) {
		case 'D':
			FatType fatType = FatType.values()[new Random().nextInt(FatType.values().length)];
			return new DairyProduct("Dairy Product " + index, price, discount, fatType);
		case 'B':
			SugarLevel sugar = SugarLevel.values()[new Random().nextInt(SugarLevel.values().length)];
			return new Beverage("Beverage " + index, price, discount, sugar);
		}

		return null;
	}

	@Override
	public void onCartUpdated() {
		if (listener != null) {
			listener.onCartUpdated(cart);
		}
	}
}
