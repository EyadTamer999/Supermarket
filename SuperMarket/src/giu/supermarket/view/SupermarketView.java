package giu.supermarket.view;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.TextArea;

import javax.swing.*;

@SuppressWarnings("serial")
public class SupermarketView extends JFrame {
	
	private JPanel products;  
	private JTextArea cart;
	
	public SupermarketView() {
		this.setBounds(400,100,800,600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		products = new JPanel();
		products.setPreferredSize(new Dimension(600,this.getHeight()));
		products.setLayout(new GridLayout(0,3));
		this.add(products,BorderLayout.CENTER);
		
		
		
		cart = new JTextArea();
		cart.setPreferredSize(new Dimension(200, this.getHeight()));
		cart.setEditable(false);
		cart.setText("Cart: ");
		this.add(cart,BorderLayout.EAST);
		this.revalidate();
		this.repaint();
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new SupermarketView();
	}
	public JPanel getProducts() {
		return this.products;
	}
	public JTextArea getCart() {
		return this.cart;
	}
}
