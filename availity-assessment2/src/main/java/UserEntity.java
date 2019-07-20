package main.java;

public class UserEntity implements Comparable<UserEntity>{
	private String userId;
	private String name;
	private int version;
	
	public UserEntity(String userId, String name, int version, String insuraceCompany) {
		super();
		this.userId = userId;
		this.name = name;
		this.version = version;
		this.insuraceCompany = insuraceCompany;
	}
	
	@Override
	public String toString() {
		return userId + "," + name + "," + version + "," + insuraceCompany;
	}
	
	@Override
    public int compareTo(UserEntity user) {
		return this.getName().compareTo(user.getName());
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String getInsuraceCompany() {
		return insuraceCompany;
	}
	public void setInsuraceCompany(String insuraceCompany) {
		this.insuraceCompany = insuraceCompany;
	}
	private String insuraceCompany;
}
