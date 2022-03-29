package model;

public class Address {
	public String street;
	public int number;
	public String cep;
	public String city;
	
	public Address(String street, int number, String cep, String city) {
		super();
		this.street = street;
		this.number = number;
		this.cep = cep;
		this.city = city;
	}
}
