import java.util.ArrayList;
import java.util.Scanner;

public abstract class User {
    
	private String name;
	private String sex ;
	private int age;
	private String type; 
	private String status;
	private String state = "";
	private String image = "";
	
    
    
    public User(String username, String sex, String age, String state) {
    	this.name = username;
    	this.age = Integer.valueOf(age);
    	if(this.age <= 16 && this.age > 2) {
    		this.type = "Child";	
    	}
    	if(this.age <= 2) {
    		this.type = "YoungChild";	
    	}
    	if(this.age > 16) {
    		this.type = "Adult";	
    	}
    	this.state = state;
    	this.sex = sex;	
    }  
    
public String getUName() {
	
	return this.name;
	
}

public String getType() {
	
	return this.type;
	
}

public int getAge() {
	
	return this.age;
	
}



public String getStatus() {
	// TODO Auto-generated method stub
	return null;
}

public String printAllFriends() {
	// TODO Auto-generated method stub
	return null;
}

public String printAllColleagues() {
	// TODO Auto-generated method stub
	return null;
}

public String printAllClassmates() {
	// TODO Auto-generated method stub
	return null;
}

public User getPartner() {
	// TODO Auto-generated method stub
	return null;
}

public boolean checkPartner() {
	// TODO Auto-generated method stub
	return true;
}

public boolean checkChildren() {
	// TODO Auto-generated method stub
	return false;
}

public String getParentName() {
	// TODO Auto-generated method stub
	return null;
}

public boolean CheckParents() {
	// TODO Auto-generated method stub
	return false;
}

public ArrayList<User> getChildrenName() {
	// TODO Auto-generated method stub
	return null;
}

public void removePartner() {
	// TODO Auto-generated method stub
	
}

public  void removeChildren(User child){
	
}


    
    
}



