import java.io.*;
import java.util.ArrayList;

import javafx.stage.Stage;

public class TextReader {
	
	public static ArrayList<Profile> Readpeople() {
		ArrayList<String> peoplearray = null;
		ArrayList<Profile> profiles = null;

		try {
			BufferedReader input = new BufferedReader(new FileReader("people.txt"));
			String next = input.readLine();

			while (next != null) {
				System.out.println(next);
				next = input.readLine();
				
				for(String substring: next.split("(,)")){
			        peoplearray.add(substring);
			   }
				Profile user = new Profile(peoplearray.get(0),peoplearray.get(3),peoplearray.get(4),peoplearray.get(5));
				user.addStatus(peoplearray.get(2));
				profiles.add(user);
				
			}
			input.close();
			

		} catch (IOException e) {
			System.err.println("File Reading Error!");
			System.exit(0);
		}
		return profiles ;
	}
	
	public static void Readrelations() {
		ArrayList<String> relationarray = null;
		ArrayList<Profile> profiles = null;

		try {
			BufferedReader input = new BufferedReader(new FileReader("people.txt"));
			String next = input.readLine();

			while (next != null) {
				System.out.println(next);
				next = input.readLine();
				
				for(String substring: next.split("(,)")){
					relationarray.add(substring);
			   }
				try {
				if (relationarray.get(2).equals("friends")) {
					Driver.addingFriends(relationarray.get(0), relationarray.get(1));
				} else if (relationarray.get(2).equals("couple")) {
					Driver.addPartner(relationarray.get(0), relationarray.get(1));
				} else if (relationarray.get(2).equals("classmates")) {
					Driver.addingClassmates(relationarray.get(0), relationarray.get(1));
				}else if (relationarray.get(2).equals("colleagues")) {
					Driver.addingColleagues(relationarray.get(0), relationarray.get(1));
				}else {
						System.out.println("Do not Support Parent Child through txt");
					}
				} catch (Exception e) {
					System.out.println("Unsupported Relationship");
					LoadProfileClass.error("Unsupported Relationship");
					MiniNet.mainMenu(new Stage());
				}
				
				
			}
			input.close();
			

		} catch (IOException e) {
			System.err.println("File Reading Error!");
			System.exit(0);
		}
		 
	}
	
}