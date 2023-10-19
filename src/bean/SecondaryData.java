package bean;

public class SecondaryData {
	private String mobilenumber;
	private String address;

	public SecondaryData() {

	}

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "SecondaryData [mobilenumber=" + mobilenumber + ", address=" + address + "]";
	}

}
