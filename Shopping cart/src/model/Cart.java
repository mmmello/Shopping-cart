package model;
import java.util.ArrayList;

public class Cart {
	public ArrayList<Product> items = new ArrayList<Product>();
	public ArrayList<Integer> quantity_per_item = new ArrayList<Integer>();
	
	public void delete (Product p) {
		this.quantity_per_item.remove(this.items.indexOf(p));
		this.items.remove(p);
		System.out.println("\nPRODUCT DELETED SUCCESSFULLY.");
	}
	
	public boolean isset_in_car(int position, ArrayList<Product> products) {
		boolean back = false;
		
		for(int i = 0; i < this.items.size(); i++){
			if(products.get(position).getId() == this.items.get(i).getId()) {
				back = true;
				break;
			}
		}
		return back;
	}
	
	public void add_in_cart(Product p, int quantity) {
		this.items.add(p);
		this.quantity_per_item.add(quantity);
		
		System.out.println("\nPRODUCT SUCCESSFULLY ENTERED.\n");
	}
	
	public double return_total() {
		double back = 0;
		for(int i = 0; i < this.items.size(); i++) 
			back += this.items.get(i).purchase_price * this.quantity_per_item.get(i);
		
		return back;
	}
	
	public int total_amount_items() {
		int back = 0;
		for(Integer item:this.quantity_per_item)
			back += item;
		return back;
	}
	
	public int amount_items_cart() {
		return this.items.size();
	}
}