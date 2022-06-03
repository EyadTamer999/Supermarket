package giu.supermarket.model.product;

public abstract class GroceryProduct {
	private String name;
	private double price;
	private int discount;
	private GroceryProductListener listener;

	public GroceryProduct(String name, double price, int discount) {
		this.name = name;
		this.price = price;
		this.discount = discount;
	}

	public String getName() {
		return name;
	}

	public void setListener(GroceryProductListener listener) {
		this.listener = listener;
	}

	public final double getActualPrice() {
		return price - price * discount / 100;
	}

	public void buy() {
		// inform interested listener, if any, that the product has been bought
		if (listener != null) {
			listener.onBought(this);
		}
	}

	@Override
	public String toString() {
		return String.format("%s ($%.2f)", name, getActualPrice()); // %.2f limits double values to 2 decimal places
	}
}
