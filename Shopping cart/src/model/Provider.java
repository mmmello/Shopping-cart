package model;

public class Provider {
	public String name;
	public String telephone;
	public String cnpj;
	public Address address;
	
	public Provider(String name, String telephone, String cnpj, Address address) {
		super();
		this.name = name;
		this.telephone = telephone;
		this.cnpj = cnpj;
		this.address = address;
	}
}