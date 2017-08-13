public class Phone {
	String owner;
	String phoneNumber;
	//TODO
	//public Phone() {
	//	Phone("Unowned");
	//}
	public Phone(String o) {
		owner = o;
		phoneNumber = "123456789";
	}
	public Phone(String o, String pn) {
		owner = o;
		phoneNumber = pn;
	}
	public void setOwner(String o) { 
		owner = o;
	}
	public void setNumber(String pn) { 
		phoneNumber = pn;
	}
	public String getOwner() {
		return owner;
	}
	public String getNumber() {
		return phoneNumber;
	}

}