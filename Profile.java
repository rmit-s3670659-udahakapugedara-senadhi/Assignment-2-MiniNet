import java.util.ArrayList;
import java.util.Iterator;

public class Profile extends User {
	private ArrayList<String> friends = new ArrayList();
	private ArrayList<String> colleagues = new ArrayList();
	private ArrayList<String> classmates = new ArrayList();
	private String pname;
	private String displaypic;
	private String status;
	private User partner;
	private ArrayList<User> childrens =  new ArrayList();
	private ArrayList<User> parents = new ArrayList();
	
	
	public Profile(String username, String sex, String age, String state) {
		super(username, sex,  age, state);
		this.pname = username;
	}
	
	
	
	public void addFriends(String pname) {
		friends.add(pname);	
	}
	
	
	public void removeFriends(String pname) {
		friends.remove(pname);	
	}
	
	
	public void addColleagues(String pname) {
		colleagues.add(pname);	
	}
	
	
	public void removeColleagues(String pname) {
		colleagues.remove(pname);	
	}
	
	
	public void addClassmates(String pname) {
		classmates.add(pname);	
	}
	
	
	public void removeClassmates(String pname) {
		classmates.remove(pname);	
	}
	
	
	
	
	
	
	public ArrayList<String> getFriendlist() {
		
		return friends;
		
	}
	
	
public ArrayList<String> getClassmates() {
		
		return classmates;
		
	}


public ArrayList<String> getColleagues() {
	
	return colleagues;
	
}
	
	
	
	
	
	
	
	
	
	
	public String getName() {
		
		return this.pname;
		
	}
	
	
	public String printAllFriends() {
		
			String print = friends.toString();
			return print;				
				
		}
	
	public String printAllColleagues() {
		
		String print = colleagues.toString();
		return print;				
			
	}
	
	public String printAllClassmates() {
		
		String print = classmates.toString();
		return print;				
			
	}

	
	public boolean searchFriends(String pname) {
		
		if (friends.contains(pname)) {
			return true;
		}
		else {
			return false;
		}
				
	}
	
	
public boolean searchClassMate(String pname) {
		
		if (classmates.contains(pname)) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
public boolean searchColleagues(String pname) {
	
	if (colleagues.contains(pname)) {
		return true;
	}
	else {
		return false;
	}
	
}
	
	
	
	
	
	
	public void addStatus(String status) {
		this.status = status;	
	}
	
	public String getStatus() {
		return status;
	}
	
	public void changeName(String pname) {
		this.pname = pname;	
	}
	
	
	public void setDisplayPic(String dp) {
		this.displaypic = dp;
	}
	
	public void setPartner(User partner) {
		this.partner = partner;	
	}
	
	public void removePartner() {
		this.partner = null;	
	}
	
	
	public User getPartner() {
		return this.partner;	
	}
	
	public boolean checkPartner() {
		if (this.partner == null) {
			return true;	
		}else {return false;}
		
	}
	
	public boolean checkPartnerOf(User partner) {
		if (this.partner == partner ) {
			return true;	
		}else {return false;}
		
	}
	
	public boolean checkChildren() {
		if (this.childrens.isEmpty()) {
			return true;		
		} else { return false;}	
	}
	
	
	public void setChildren(User child) {
		childrens.add(child);
	}
	
	public ArrayList<User> getChildrens() {
		return this.childrens;
	}
	
	public boolean checkParent(User parent) {
		if ( this.parents.contains(parent)) {
			return true;		
		} else { return false; }
	
	}
	
	public boolean checkChildrenof(User child) {
		if ( this.childrens.contains(child)) {
			return true;		
		} else { return false; }
	
	}
	
	public void addParent(User parent) {
		this.parents.add(parent);
	}
	
	public boolean CheckParents() {
		if (this.parents.isEmpty()) {
			return false;
		} else { return true; }
	}
	
	public boolean CheckChildren() {
		if (this.childrens.isEmpty()) {
			return false;
		} else { return true; }
	}
	
	public String getParentName(){
		String p1 = this.parents.get(0).getUName();
		String p2 = this.parents.get(1).getUName();
		
		return p1 + "   : " + p2;
		
	}
	
	public  ArrayList<User> getChildrenName(){
		
		return this.childrens;
		
	}
	
	public  ArrayList<User> getParents(){
		
		return this.parents;
	}
	
	public  void removeChildren(User child){
		this.childrens.remove(child);
	}
	
	
	
	
  
}
