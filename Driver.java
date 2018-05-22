
import java.util.*;


public class Driver {
	
	private static ArrayList<Profile> profiles = new ArrayList<Profile>();
	private static ArrayList<String> index = new ArrayList<String>();
	
	public  Driver() {		
	
	}
	
	public static void txtUsers() {
		ArrayList<Profile> people = TextReader.Readpeople();
		TextReader.Readrelations();
		
		for(int i = 0; i < people.size(); i++) {
			profiles.add(people.get(i));
			index.add(people.get(i).getUName());
		}
		
	}
	
	
	
	public static void addDemoUsers() {
		//Creating Demo Users
				Profile Allice = new Profile("Allice","F","25","VIC");
				Profile Don = new Profile("Don","M","28","VIC");
				Profile Bob = new Profile("Bob","M","35","VIC");
				Profile Cathy = new Profile("Cathy","F","45","VIC");
				Profile Jill = new Profile("Jill","M","13","VIC");
				Profile John = new Profile("John","M","8","VIC");
				Profile Nate = new Profile("Nate","M","1","VIC");
				
				profiles.add(Allice);
				index.add("Allice");
				
				profiles.add(Don);
				index.add("Don");
				
				profiles.add(Bob);
				index.add("Bob");
				profiles.get(index.indexOf("Bob")).addStatus("Hey IM good");
				
				profiles.add(Cathy);
				index.add("Cathy");
				
				profiles.get(index.indexOf("Bob")).setPartner(profiles.get(index.indexOf("Cathy")));
				profiles.get(index.indexOf("Cathy")).setPartner(profiles.get(index.indexOf("Bob")));
				
				profiles.add(Jill);
				index.add("Jill");
				profiles.get(4).addParent(Allice);
				profiles.get(4).addParent(Don);
				profiles.get(0).setChildren(Jill);
				profiles.get(1).setChildren(Jill);
				
				profiles.add(John);
				index.add("John");
				profiles.get(5).addParent(Cathy);
				profiles.get(5).addParent(Bob);
				profiles.get(2).setChildren(John);
				profiles.get(3).setChildren(John);
				
				profiles.add(Nate);
				index.add("Nate");
				profiles.get(6).addParent(Cathy);
				profiles.get(6).addParent(Bob);
				profiles.get(2).setChildren(Nate);
				profiles.get(3).setChildren(Nate);
				

				profiles.get(0).addFriends("Don");
				profiles.get(1).addFriends("Allice");
				
				profiles.get(2).addFriends("Cathy");
				profiles.get(3).addFriends("Bob");
				
				profiles.get(4).addFriends("John");
				profiles.get(5).addFriends("Jill");	
				
	}
	
		

	
	

	
	
	
	public static User getProfile(String name) {
		return profiles.get(index.indexOf(name));
	}

	

	
	
	public static void listProfiles(){
		for (int i = 0; i < index.size(); i++) {	
			System.out.println("Profile "+ i + " : " + index.get(i));			
		}
			
	}
	
	
	
	
	
	
	public  static void addProfile(String username, String sex, String sage, String state, String parent1, String parent2) throws NoParentException, NoSuchAgeException{
		//creating user
		int age = Integer.valueOf(sage);
		
		if (age <= 16 && age > 0) {
		
		if ((profiles.get(index.indexOf(parent1)).getType() == profiles.get(index.indexOf(parent2)).getType() ) && (profiles.get(index.indexOf(parent1)).getType() == "Adult") ) {
			
			if (profiles.get(index.indexOf(parent1)).getPartner() == profiles.get(index.indexOf(parent2))) {	
	
				Profile user = new Profile(username,sex,sage,state);	
				user.addParent(profiles.get(index.indexOf(parent1)));
				user.addParent(profiles.get(index.indexOf(parent2)));
				profiles.get(index.indexOf(parent1)).setChildren(user);
				profiles.get(index.indexOf(parent2)).setChildren(user);
				profiles.add(user);
				index.add(username);	
			} else {
				throw new NoParentException();
			}			
		} else {
			throw new NoParentException();
			
		}
		} else if (age <= 0 || age > 150) {
			throw new NoSuchAgeException();
		} else { 
			Profile user = new Profile(username,sex,sage,state);
			profiles.add(user);
			index.add(username);	
		}
		
			
		
		
    }
	
	
	public static void removeProfile(String profilename) throws NoParentException{
		//removing user
		int store = index.indexOf(profilename);
		
		if ( profiles.get(store).checkChildren() == false ) {
		 
		ArrayList<String> friends = profiles.get(store).getFriendlist();
		for (int i = 0; i < friends.size(); i++) {
			String name = friends.get(i);
			profiles.get(index.indexOf(name)).removeFriends(profilename);		
		}
		
		ArrayList<String> classmates = profiles.get(store).getClassmates();
		for (int i = 0; i < classmates.size(); i++) {
			String name = classmates.get(i);
			profiles.get(index.indexOf(name)).removeClassmates(profilename);		
		}
		
		ArrayList<String> colleagues = profiles.get(store).getColleagues();
		for (int i = 0; i < colleagues.size(); i++) {
			String name = colleagues.get(i);
			profiles.get(index.indexOf(name)).removeColleagues(profilename);		
		}
		
		if (profiles.get(store).checkPartner() == false) {
				profiles.get(store).getPartner().removePartner();
		}
		
		if (profiles.get(store).CheckParents() == true) {
			ArrayList<User> parents = profiles.get(store).getParents();
			for (int i = 0; i < parents.size(); i++) {
				User name = parents.get(i);
				name.removeChildren(profiles.get(store));		
			}
		}
		
		profiles.remove(store);
		index.remove(store);
		
		} else {
			
			throw new NoParentException();
		}
		
		
		
		
		
				
		
    }
	
	
	public static void removeMyProfile(String profilename){
		//removing user
		
		int store = index.indexOf(profilename);
		 
		ArrayList<String> friends = profiles.get(store).getFriendlist();
		
		for (int i = 0; i < friends.size(); i++) {
			String name = friends.get(i);
			
			profiles.get(index.indexOf(name)).removeFriends(profilename);	
			
		}

		profiles.remove(store);
		index.remove(store);
		
		System.out.println("Profile has been Successfully Removed");
		System.out.println("Click Enter to go back to Profile");
		Scanner reader = new Scanner(System.in);
		String input = reader.nextLine();

			
		
    }
	
	

	public static void addingFriends(String name,String profilename) throws TooYoungException, NotToBeFriendsException{
		//adding friends
		try {
	
			if (profiles.get(index.indexOf(name)).getAge() <= 3 || profiles.get(index.indexOf(profilename)).getAge() <= 3) {
				throw new TooYoungException();		
			} else if((profiles.get(index.indexOf(name)).getAge() <= 16 && profiles.get(index.indexOf(name)).getAge() > 3) && (profiles.get(index.indexOf(profilename)).getAge() <= 16 && profiles.get(index.indexOf(profilename)).getAge() > 3) ) {
			
						if(Math.abs(profiles.get(index.indexOf(profilename)).getAge() - profiles.get(index.indexOf(name)).getAge()) <=3) {
			
						profiles.get(index.indexOf(name)).addFriends(profilename);
						profiles.get(index.indexOf(profilename)).addFriends(name);
						
						} else {  throw  new NotToBeFriendsException();}
						
			} else if ((profiles.get(index.indexOf(name)).getAge() > 16) && (profiles.get(index.indexOf(profilename)).getAge() > 16)){

						profiles.get(index.indexOf(name)).addFriends(profilename);
						profiles.get(index.indexOf(profilename)).addFriends(name);

			} else {
				throw new NotToBeFriendsException();
				
			}
		} catch(IndexOutOfBoundsException e) {
			System.out.println("User Doesnt Exist On MiniNet");
			LoadProfileClass.addFriendMenu();
		}	
	}
	
	
	
	public static void RemoveFriend(String name,String profilename) {
		//Remove a friend
		
			profiles.get(index.indexOf(name)).removeFriends(profilename);
			profiles.get(index.indexOf(profilename)).removeFriends(name);	
			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void printFriendList(String name) {
		profiles.get(index.indexOf(name)).printAllFriends();
		
		
	}
	
	public static void searchFriends(String name) {
		// Searching if a person is a friend of the profile owner
		Scanner reader = new Scanner(System.in);	
		System.out.println("Please Enter the Profile Name of the Person you need to Search");
		String profilename = reader.nextLine();
		
		
		if(profiles.get(index.indexOf(name)).searchFriends(profilename)) {
			System.out.println("Yes " + name + " is a friend of "+ profilename);	
		}else {
			System.out.println("No " + name + " is not a friend of "+ profilename);
		}
		
		System.out.println("Click Enter to go back to Menu");
		
		String input = reader.nextLine();

			
	
	}
		
		public static String CheckRelation(String profilename1, String profilename2) {
			//Searching two People are friends with each other

			if(profiles.get(index.indexOf(profilename1)).searchFriends(profilename2)) {
				return 	"Friend";
			}else if(profiles.get(index.indexOf(profilename1)).searchClassMate(profilename2)) {
				return "Classmate";
			}else if(profiles.get(index.indexOf(profilename1)).searchColleagues(profilename2)) {
				return "Colleague";	
			}else if( profiles.get(index.indexOf(profilename1)).checkParent(profiles.get(index.indexOf(profilename2)))  ) {
				return profiles.get(index.indexOf(profilename1)).getName() + "  is a Child of  " +  profiles.get(index.indexOf(profilename2)).getName();	
			}else if( profiles.get(index.indexOf(profilename1)).checkChildrenof(profiles.get(index.indexOf(profilename2)))  ) {
				return profiles.get(index.indexOf(profilename1)).getName() + "  is a parent of  " +  profiles.get(index.indexOf(profilename2)).getName();	
			} else if( profiles.get(index.indexOf(profilename1)).checkPartnerOf(profiles.get(index.indexOf(profilename2)))){
							return profiles.get(index.indexOf(profilename1)).getUName() + "  and " + profiles.get(index.indexOf(profilename2)).getUName() + "  are a Couple";	
			} else {
				
				return " They are not related in anyway" ;
			}
			
	
	}
		
		public static void updateStatus(String name,String status)  {
		profiles.get(index.indexOf(name)).addStatus(status);
		}	
		
		
		public static void addPartner(String name, String partnername) throws NoAvailableException, NotToBeCoupledException {
			
			try {
			if ((profiles.get(index.indexOf(name)).checkPartner()) || profiles.get(index.indexOf(partnername)).checkPartner()) {
				profiles.get(index.indexOf(name)).setPartner(profiles.get(index.indexOf(partnername)));
				profiles.get(index.indexOf(partnername)).setPartner(profiles.get(index.indexOf(name)));		
			} else if ((profiles.get(index.indexOf(name)).getAge() <=16) || (profiles.get(index.indexOf(name)).getAge() <=16)) {
				throw new NotToBeCoupledException();
			}
			else  {
				throw new NoAvailableException();			
			}
			} catch(IndexOutOfBoundsException e) {
				System.out.println("User Doesnt Exist On MiniNet");
				LoadProfileClass.addPartnerMenu();
			}
		
		}
		
		
		public static void removePartner(String name, String partnername) throws AlreadyCoupledWithChild {
			
			try {
			if ((profiles.get(index.indexOf(name)).checkChildren() && profiles.get(index.indexOf(partnername)).checkChildren())) {
				
				profiles.get(index.indexOf(name)).removePartner();
				profiles.get(index.indexOf(partnername)).removePartner();			
			}
			else  {
				throw new AlreadyCoupledWithChild();			
			}
			} catch(IndexOutOfBoundsException e) {
				System.out.println("User Doesnt Exist On MiniNet");
				LoadProfileClass.RemovePartnerMenu();
			}
		
		}
		
		
		
		
		
		public static void addingClassmates(String name,String profilename) throws NotToBeClassmatesException {
			//adding friends
			try {
				
				if (profiles.get(index.indexOf(name)).getType() == "YoungChild" || profiles.get(index.indexOf(profilename)).getType() == "YoungChild") {
					LoadProfileClass.error("Infants Cannot Have Classmates");
					throw  new NotToBeClassmatesException();	
				} else if (profiles.get(index.indexOf(name)).getType() == profiles.get(index.indexOf(profilename)).getType()) {
					profiles.get(index.indexOf(name)).addClassmates(profilename);
					profiles.get(index.indexOf(profilename)).addClassmates(name);
				} else {
					LoadProfileClass.error("Classmates are not permitted for you");
				}
			} catch(IndexOutOfBoundsException e) {
				System.out.println("User Doesnt Exist On MiniNet");
				LoadProfileClass.addClassMatesMenu();
			}	
			
			
			
		}
		
		public static void addingColleagues(String name,String profilename) throws NotToBeColleaguesException  {
			//adding friends
			try {
				
				if (profiles.get(index.indexOf(name)).getType() == "Adult" || profiles.get(index.indexOf(profilename)).getType() == "Adult") {
					profiles.get(index.indexOf(name)).addColleagues(profilename);
					profiles.get(index.indexOf(profilename)).addColleagues(name);
				} else {
					LoadProfileClass.error("Colleagues are  permitted only for adults");
					throw new NotToBeColleaguesException();
					
				}
			} catch(IndexOutOfBoundsException e) {
				System.out.println("User Doesnt Exist On MiniNet");
				LoadProfileClass.addColleaguesMenu();
			}	
			
			
			
		}
		
		
		
		public static void RemovingColleagues(String name,String profilename) {
			//adding friends
			try {			
				if (profiles.get(index.indexOf(name)).getType() == "Adult") {
					
					profiles.get(index.indexOf(name)).removeColleagues(profilename);
					profiles.get(index.indexOf(profilename)).removeColleagues(name);
				} else {
					LoadProfileClass.error("You dont have Colleagues since you are not an adult");
				}
			} catch(IndexOutOfBoundsException e) {
				System.out.println("User not an Colleague of yours");
				LoadProfileClass.RemoveColleaguesMenu();
			}	
			
			
			
		}
		
		
		public static void RemovingClassmates(String name,String profilename) {
			//adding friends
			try {			
				if (profiles.get(index.indexOf(name)).getType() == "Child") {
					LoadProfileClass.error("Infants cannot have Classmates");
				} else if (profiles.get(index.indexOf(name)).getType() == profiles.get(index.indexOf(profilename)).getType()) {
					profiles.get(index.indexOf(name)).removeClassmates(profilename);
					profiles.get(index.indexOf(profilename)).removeClassmates(name);	
					
					
				} else {
					LoadProfileClass.error("User is not your classmate");
				}
			} catch(IndexOutOfBoundsException e) {
				System.out.println("User not a Class mate of yours");
				LoadProfileClass.RemoveClassMatesMenu();
			}	
			
			
			
		}
		
		
		
		
		
		
		
		
		
				
		
}
	
		


		
		
		
	

