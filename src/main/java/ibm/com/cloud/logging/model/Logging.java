package ibm.com.cloud.logging.model;

public class Logging {

	/*
	 * private Long id; private Long organizationId; private Long departmentId;
	 */
	private Long id;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private String name;
	private String password;
	
	public Logging() {

	}
	
	public Logging(String name, String password) {
		
		this.name = name;
		this.password = password;
		
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	@Override
	public String toString() {
		return "Event [ name=" + name + ", Password=" + password +"]";
	}

}
