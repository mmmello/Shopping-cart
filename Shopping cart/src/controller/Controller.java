package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import model.*;

public class Controller {

	static ArrayList<Product> products = new ArrayList<Product>();
	public static void main(String[] args) {
		
		obj_default();
		@SuppressWarnings("resource")
		Scanner read = new Scanner(System.in);
		Cart cart = new Cart();
		int op;
		
		// manually inserting an item in the cart so that it is already filled in the screen 
		cart.items.add(products.get(1));
		cart.quantity_per_item.add(2);
		
		do {
			show_menu(cart);
			op = read.nextInt();
			switch(op) {
				case 1:
					int id_product_selected, qtt, controll = 0;
					System.out.println("\nProducts available.\n");
					
					for(int i = 0; i < products.size(); i++)
						if(!cart.isset_in_car(i, products)) {
							System.out.println("\nProduct identification: "+products.get(i).getId());
							products.get(i).show_products();
							controll++;
						}
					
					if(controll>0) {
						System.out.printf("\nEnter the ID of the product you wish to add to the cart: ");
						id_product_selected = read.nextInt();
						
						Product p = Product.search_product(products, id_product_selected);
						
						if(p!=null) {
							Date date = new Date();
							
							if( date.before(p.expiration_date) ) {
								System.out.printf("\nEnter the quantity of this product you wish to add to the cart: ");
								qtt = read.nextInt();
								
								cart.add_in_cart(p, qtt);
							}else 
								System.out.println("\nTHE PRODUCT INFORMED IS OUT OF DATE.\n");
						}else
							System.out.println("\nTHE REPORTED PRODUCT WAS NOT FOUND.\n");
					}else 
						System.out.println("\nALL PRODUCTS ARE ALREADY IN YOUR SHOPPING CART.\n");
					break;
					
				case 2:
					if(cart.items.size()!=0) {
						System.out.println("\nThese are the products in your cart.\n");
						
						for(int i = 0; i < cart.items.size(); i++) {
							System.out.println("\nProduct identification: "+cart.items.get(i).getId());
							cart.items.get(i).show_products(cart.quantity_per_item.get(i));
						}
						System.out.println("\n");
						try { Thread.sleep (2000); } catch (InterruptedException ex) {}
					}else 
						System.out.println("\nTHE CART IS EMPTY.\n");
					
					break;
				case 3:
					int id_product;
					System.out.println("\n");
					
					for(Product product:cart.items) {
						System.out.println("\nProduct identification: "+product.getId());
						product.show_products();
					}
					
					System.out.printf("\nEnter the ID of the product you wish to exclude from the cart: ");
					id_product = read.nextInt();
					
					Product p = Product.search_product(cart.items, id_product);
					
					if(p!=null) 
						cart.delete(p);
					else
						System.out.println("\nTHE REPORTED PRODUCT WAS NOT FOUND.\n");
					
					System.out.println("\n");
					break;
				case 0:
					System.out.println("\n+-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=+");
					System.out.println("|        TERMINATED PROGRAM        |");
					System.out.println("+-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=+\n");
					break;
				default:
					System.out.println("\n+-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=+");
					System.out.println("|          INVALID OPTION          |");
					System.out.println("+-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=+\n");
					break;
			}
		}while(op!=0);
	}
	
	public static void show_menu(Cart cart) {
		System.out.println("+----------------------------------+");
		System.out.println("|   WELCOME TO THE SHOPPING CART   |");
		System.out.println("+----------------------------------+");
		System.out.printf("| INFO - Total: R$ %.2f  Items: %d \n",cart.return_total(), cart.amount_items_cart());
		System.out.println("| Total quantity of items: "+cart.total_amount_items());
		System.out.println("+----------------------------------+");
		System.out.println("1 - Add to cart.");
		System.out.println("2 - Show Cart.");
		System.out.println("3 - Exclude from cart.");
		System.out.println("0 - Exit the system.");
		System.out.printf("\nEnter your option: ");
	}
	
	public static void obj_default() {
		Address address1 = new Address("Rua carmela dutra", 648, "23465-857", "Rio de Janeiro");
		Address address2 = new Address("Av. Marechal Rondon", 871, "13087-561", "Rio de Janeiro");
		
		Provider provider1 = new Provider("Nestlé", "(21) 2134-5869", "54.136.023/0001-88", address1);
		Provider provider2 = new Provider("Qualy", "(21) 2581-3217", "13.250.467/0852-74", address2);
		
		
		@SuppressWarnings("deprecation")
		Date date = new Date(121, 1, 15); // Using this disused function to facilitate expiration date allocation
		Product product1 = new Product("Nescau", 11.22, date, provider1);
		
		@SuppressWarnings("deprecation")
		Date date2 = new Date(122, 6, 28);
		Product product2 = new Product("Requeijão", 5.69, date2, provider1);
		
		@SuppressWarnings("deprecation")
		Date date3 = new Date(122, 10, 22); // This object will purposely have an expired expiration date
		Product product3 = new Product("Margarina", 8.29, date3, provider2);
		
		products.add(product1);
		products.add(product2);
		products.add(product3);
	}
}