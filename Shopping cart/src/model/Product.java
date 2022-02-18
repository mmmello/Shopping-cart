package model;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Product {
	private static int increment=20; // variable to control each generated object
	
	private int id;
	public String name;
	public double purchase_price;
	public double sale_value;
	public Date expiration_date;
	public Provider provider;
	
	public int getId() {
		return id;
	}

	public Product(String name, double purchase_price, Date expiration_date, Provider provider) {
		super();
		this.id = increment++;
		this.name = name;
		this.purchase_price = purchase_price;
		this.sale_value = purchase_price * 1.3;
		this.expiration_date = expiration_date;
		this.provider = provider;
	}

	public void show_products(int quantity_in_cart){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(this.expiration_date);
		
		System.out.println("+------------------------------+");
		System.out.println("| Name: "+this.name);
		System.out.printf("| Purchase price: R$ %.2f\n", this.purchase_price);
		System.out.printf("| Sale value: R$ %.2f\n", this.sale_value);
		System.out.println("| Expiration date: "+ calendar.get(Calendar.DAY_OF_MONTH) +"/"+ (1+calendar.get(Calendar.MONTH)) +"/"+ calendar.get(Calendar.YEAR));
		System.out.println("| Provider: "+this.provider.name);
		System.out.println("| Quantity in cart: "+quantity_in_cart);
		System.out.println("+------------------------------+");
	}
	
	public void show_products() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(this.expiration_date);
		
		System.out.println("+------------------------------+");
		System.out.println("| Name: "+this.name);
		System.out.printf("| Purchase price: R$ %.2f\n", this.purchase_price);
		System.out.printf("| Sale value: R$ %.2f\n", this.sale_value);
		System.out.println("| Expiration date: "+ calendar.get(Calendar.DAY_OF_MONTH) +"/"+ (1+calendar.get(Calendar.MONTH)) +"/"+ calendar.get(Calendar.YEAR));
		System.out.println("| Provider: "+this.provider.name);
		System.out.println("+------------------------------+");
	}
	
	public static Product search_product(ArrayList<Product> products, int id) {
		Product p = null;
		for(Product product:products) 
			if(product.id == id) p = product;

		return p;
	}
}