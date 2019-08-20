
public class User {
	String name;
	String password;

// Setters
	public void setName(String n) {
		name = n;
	}

	public void setPassword(String p) {
		password = p;
	}

	public User(String n, String p) {
		name = n;
		password = p;
	}

// Getters
	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}
}
