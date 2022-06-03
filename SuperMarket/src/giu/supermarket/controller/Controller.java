package giu.supermarket.controller;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import giu.supermarket.model.cart.Cart;
import giu.supermarket.model.product.GroceryProduct;
import giu.supermarket.model.supermarket.Supermarket;
import giu.supermarket.model.supermarket.SupermarketListener;
import giu.supermarket.view.SupermarketView;

public class Controller implements SupermarketListener {
	private Supermarket model;
	private SupermarketView view;
	private ArrayList<JButton> buttons;
	
	public Controller() {
		model = new Supermarket();
		model.setListener(this);
		view = new SupermarketView();
		buttons = new ArrayList<JButton>();
		for(int i = 0; i < model.getProducts().size(); i++) {
			JButton b = new JButton(model.getProducts().get(i).toString());
			view.getProducts().add(b);
			b.addActionListener(e -> model.getProducts().get(buttons.indexOf(b)).buy());
			buttons.add(b);
			b.setFocusable(false);
			b.setBackground(Color.white);
		}
		view.getCart().setText("Cart:-\n------------------\nTotal: ");
		view.revalidate();
		view.repaint();
	}
	public static void main(String[] args) {
		new Controller();
	}
	@Override
	public void onCartUpdated(Cart cart) {
		String s = "Cart:-\n------------------\n";
		for(int i = 0; i < cart.getProducts().size(); i++) {
			GroceryProduct p = cart.getProducts().get(i);
			s += p.toString() + '\n'; 
		}
		s+= "------------------\nTotal: $" + cart.getTotal();
		view.getCart().setText(s);
	}
}
