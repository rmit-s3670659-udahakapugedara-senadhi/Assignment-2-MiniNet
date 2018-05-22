import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.FontPosture;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;


//System.out.println(" ");
//System.out.println("            MiniNet Menu");
//System.out.println("=========================================");
//System.out.println(" 1. List everyone");
//System.out.println(" 2. Select a person");
//System.out.println(" 3. Are these two direct friends?");
//System.out.println(" 4. Add a Profile");		
//System.out.println(" ?. Exit");



//---------------------------------------------------------------------------------------------------------------------
public class MiniNet extends Application {

    public User person;
    public static Stage stage;
    public static void main(String[] args) {
    		Driver.addDemoUsers();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    	mainMenu(primaryStage);			
    }
    
    public static void mainMenu(Stage primaryStage) {
    	GridPane pane = new GridPane(); // Create a pane to hold the texts
		pane.setPadding(new Insets(5, 5, 5, 5));
		
		pane.add(new Label("Welcome To MiniNet"), 3, 0);
		
		Button btListEveryone = new Button("List Everyone");
		pane.add(btListEveryone, 1, 3);
		ListEveryoneClass ListEveryonehandler = new ListEveryoneClass();
		btListEveryone.setOnAction(ListEveryonehandler);
		
		Button btSelectPerson = new Button("View Profile");
		pane.add(btSelectPerson, 2, 3);
		SelectPersonClass SelectPersonhandler = new SelectPersonClass();
		btSelectPerson.setOnAction(SelectPersonhandler);

		Button btCheckRelation = new Button("Check The Relation");
		pane.add(btCheckRelation, 3, 3);
		CheckRelationClass CheckRelationhandler = new CheckRelationClass();
		btCheckRelation.setOnAction(CheckRelationhandler);
		
		Button btAddProfile = new Button("Add a Profile");
		pane.add(btAddProfile, 4, 3);
		AddProfileClass AddProfilehandler = new AddProfileClass();
		btAddProfile.setOnAction(AddProfilehandler);
		
		Button bttxt = new Button("Add From .txt File");
		pane.add(bttxt, 5, 3);
		bttxt.setOnAction(o -> {
			Driver.txtUsers();
        });
		
		Button btExit = new Button("Exit");
		pane.add(btExit, 6, 3);
		ExitClass Exithandler = new ExitClass();
		btExit.setOnAction(Exithandler);
		
		Scene scene = new Scene(pane);
		primaryStage.setTitle("MiniNet"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
		MiniNet.stage = primaryStage;
    }
    
    
}
//---------------------------------------------------------------------------------------------------------------------









//---------------------------------------------------------------------------------------------------------------------

class ListEveryoneClass implements EventHandler<ActionEvent> {
	@Override
	public void handle(ActionEvent e) {
		Driver.listProfiles();
	}
}
//---------------------------------------------------------------------------------------------------------------------




//---------------------------------------------------------------------------------------------------------------------
class SelectPersonClass implements EventHandler<ActionEvent> {
	@Override
	public void handle(ActionEvent e) {
		selectaperson();	
	}
	
	public void selectaperson() {
		GridPane pane = new GridPane(); // Create a pane to hold the texts
		pane.setPadding(new Insets(5, 5, 5, 5));
		
		pane.add(new Label("Enter the Profile Name"), 0, 0);
		
		TextField txtProfileName = new TextField();
		pane.add( txtProfileName, 1, 0);
		
		Button btLoadProfile = new Button("View Profile");
		pane.add(btLoadProfile, 1, 1);
		
		btLoadProfile.setOnAction(o -> {
			String profname = txtProfileName.getText();
			User person = Driver.getProfile(profname);
			LoadProfileClass LoadProfilehandler = new LoadProfileClass(person);
			btLoadProfile.setOnAction(LoadProfilehandler);
			btLoadProfile.fire();
        });
		
		//Stage SelectPersonStage = new Stage();
		Scene scene = new Scene(pane);
		MiniNet.stage.setTitle("View Profile"); // Set the stage title
		MiniNet.stage.setScene(scene); // Place the scene in the stage
		MiniNet.stage.show(); // Display the stage	
	}	
}

//---------------------------------------------------------------------------------------------------------------------







//---------------------------------------------------------------------------------------------------------------------

class CheckRelationClass implements EventHandler<ActionEvent> {
	@Override
	public void handle(ActionEvent e) {
		
		GridPane pane = new GridPane(); // Create a pane to hold the texts
		pane.setPadding(new Insets(5, 5, 5, 5));
				

		Label lblParent1 = new Label("Enter The Account 1 Name : ");
		pane.add(lblParent1, 0, 0);
		
		TextField txtParent1Name =  new TextField();
		pane.add(txtParent1Name, 1, 0);
		
		Label lblParent2 = new Label("Enter The Account 2 Name : ");
		pane.add(lblParent2, 0, 1);
		
		TextField txtParent2Name =  new TextField();
		pane.add(txtParent2Name, 1, 1);
		
		//Stage SelectPersonStage = new Stage();
		Scene scene = new Scene(pane);
		MiniNet.stage.setTitle("View Profile"); // Set the stage title
		MiniNet.stage.setScene(scene); // Place the scene in the stage
		MiniNet.stage.show(); // Display the stage
		
		Button btProfile = new Button("Check Relation");
		pane.add(btProfile, 0, 6);
		btProfile.setOnAction(o -> {
			String parent1 = txtParent1Name.getText();
			String parent2 = txtParent2Name.getText();	
			try {
				LoadProfileClass.error(Driver.CheckRelation(parent1, parent2));
			} catch (Exception j) {
				LoadProfileClass.error("They are not related");
				j.printStackTrace();
			}
			
		});	
	}
}

//---------------------------------------------------------------------------------------------------------------------







//---------------------------------------------------------------------------------------------------------------------------
class AddProfileClass implements EventHandler<ActionEvent> {
	@Override
	public void handle(ActionEvent e) {	
		
		addProfileMenu();
		Driver.listProfiles();
	}

	private static void addProfileMenu() {
		
		GridPane pane = new GridPane(); // Create a pane to hold the texts
		pane.setPadding(new Insets(5, 5, 5, 5));
		
		pane.add(new Label("Enter the Username :  "), 0, 0);
		TextField txtProfileName = new TextField();
		pane.add( txtProfileName, 1, 0);
		
		pane.add(new Label("Enter age :  "), 0, 1);
		TextField txtage = new TextField();
		pane.add( txtage, 1, 1);
		
		pane.add(new Label("Enter the Sex ( M/F) :  "), 0, 2);
		final ComboBox<String> sexComboBox = new ComboBox();
        sexComboBox.getItems().addAll( "M", "F");
        pane.add( sexComboBox, 1, 2);
		
        pane.add(new Label(" Enter the State : "), 0, 3);
        TextField txtstate = new TextField();
		pane.add( txtstate, 1, 3);
		
		Button btaddProfile = new Button("Add Profile");
		pane.add(btaddProfile, 1, 4);
		
		btaddProfile.setOnAction(o -> {
			String name = txtProfileName.getText();
			String age =  txtage.getText();
			String sex =  sexComboBox.getValue();
			String state = txtstate.getText();
			
			if (Integer.valueOf(age) <= 16 ) {
				addParentscMenu(name,sex, age, state);
							
			} else {     
				try {
					Driver.addProfile(name,sex, age, state,"","");
					MiniNet.mainMenu(new Stage());	
				} catch (NoParentException e) {
					LoadProfileClass.error("Both the Parents Must be Present and Coupled on MiniNet");
					e.printStackTrace();
				} catch (NoSuchAgeException e) {
					LoadProfileClass.error("User Must be between the age range of 1 to 150");
					e.printStackTrace();
				}
			}
			
        });
		//Stage SelectPersonStage = new Stage();
		Scene scene = new Scene(pane);
		MiniNet.stage.setTitle("View Profile"); // Set the stage title
		MiniNet.stage.setScene(scene); // Place the scene in the stage
		MiniNet.stage.show(); // Display the stage		
	}
	
	
	
	public static void addParentscMenu(String name,String sex, String age, String state) {
		GridPane pane = new GridPane(); // Create a pane to hold the texts
		pane.setPadding(new Insets(5, 5, 5, 5));
				

		Label lblParent1 = new Label("Enter Mother's Name : ");
		pane.add(lblParent1, 0, 0);
		
		TextField txtParent1Name =  new TextField();
		pane.add(txtParent1Name, 1, 0);
		
		Label lblParent2 = new Label("Enter Father's Name : ");
		pane.add(lblParent2, 0, 1);
		
		TextField txtParent2Name =  new TextField();
		pane.add(txtParent2Name, 1, 1);
		
		Button btProfile = new Button("Add Profile");
		pane.add(btProfile, 0, 2);
		
		//Stage SelectPersonStage = new Stage();
		Scene scene = new Scene(pane);
		MiniNet.stage.setTitle("View Profile"); // Set the stage title
		MiniNet.stage.setScene(scene); // Place the scene in the stage
		MiniNet.stage.show(); // Display the stage
		
		
		btProfile.setOnAction(o -> {
			String parent1 = txtParent1Name.getText();
			String parent2 = txtParent2Name.getText();	
			try {
				Driver.addProfile(name,sex, age, state, parent1, parent2);
			} catch (NoParentException e) {
				LoadProfileClass.error("Both the Parents Must be Present and Coupled on MiniNet");
				e.printStackTrace();
			} catch (NoSuchAgeException e) {
				LoadProfileClass.error("User Must be between the age range of 1 to 150");
				e.printStackTrace();
			}
			
		});	
	}
	
}

//---------------------------------------------------------------------------------------------------------------------







//---------------------------------------------------------------------------------------------------------------------

class ExitClass implements EventHandler<ActionEvent> {
	@Override
	public void handle(ActionEvent e) {
		displayclass();
	}
	
	public void displayclass() {
		GridPane pane = new GridPane(); // Create a pane to hold the texts
		pane.setPadding(new Insets(5, 5, 5, 5));
				

		Label lblProfileName = new Label("How Are you");
		pane.add(lblProfileName, 0, 0);
		
		TextField txtFriendsName =  new TextField();
		pane.add(txtFriendsName, 1, 0);
		
		//Stage SelectPersonStage = new Stage();
		Scene scene = new Scene(pane);
		MiniNet.stage.setTitle("View Profile"); // Set the stage title
		MiniNet.stage.setScene(scene); // Place the scene in the stage
		MiniNet.stage.show(); // Display the stage
		
		Button btAddFriends = new Button("Add Friends");
		pane.add(btAddFriends, 0, 6);
		btAddFriends.setOnAction(o -> {
			displayclass();
		});
		
		Button btBacktoMenu = new Button("Back to Menu");
		pane.add(btBacktoMenu, 0, 6);
		btBacktoMenu.setOnAction(o -> {
			MiniNet.mainMenu(new Stage());
		});
		
		
	}
	
}
//---------------------------------------------------------------------------------------------------------------------








//---------------------------------------------------------------------------------------------------------------------
class LoadProfileClass implements EventHandler<ActionEvent> {
	
	static User person;
	
	public LoadProfileClass(User person) {
		this.person = person;	
		}
	
	
	@Override
	public void handle(ActionEvent e) {
		profileMenu();
	}
	
	
	
	public static void profileMenu() {
		
		GridPane pane = new GridPane(); // Create a pane to hold the texts
		pane.setPadding(new Insets(5, 5, 5, 5));
				

		pane.add(new Label("Profile Name : "), 0, 0);
		Label lblProfileName = new Label(person.getUName());
		pane.add(lblProfileName, 1, 0);
		
		pane.add(new Label("Age : "), 0, 1);
		String age = String.valueOf(person.getAge());
		Label lblAge = new Label(age);
		pane.add(lblAge, 1, 1);
		
		pane.add(new Label("Status : "), 0, 2);
		Label lblstatus = new Label(person.getStatus());
		pane.add(lblstatus, 1, 2);
		
		pane.add(new Label("Friend List : "), 0, 3);
		Label lblfriendlist = new Label(person.printAllFriends());
		pane.add(lblfriendlist, 1, 3);
		
		pane.add(new Label("Colleagues : "), 0, 4);
		Label lblcolleagues = new Label(person.printAllColleagues());
		pane.add(lblcolleagues, 1, 4);
		
		pane.add(new Label("Classmates : "), 0, 5);
		Label lblclassmates = new Label(person.printAllClassmates());
		pane.add(lblclassmates, 1, 5);
		
		if ( person.checkPartner() == false) {
			pane.add(new Label("Partner : "), 0, 6);
			Label lblpartner = new
				Label(person.getPartner().getUName());
		    pane.add(lblpartner, 1, 6);
		}
		
		if ( person.CheckParents()) {
			pane.add(new Label("Parents  : "), 0, 7);
			Label lblparents = new
					Label(person.getParentName());
			pane.add(lblparents, 1, 7);
		}
			
		try { String[] children = null;
		for ( int i = 0; i < person.getChildrenName().size(); i++) {
			children[i] = person.getChildrenName().get(i).getUName();			
		}
		pane.add(new Label("Children : "), 0, 8);
		Label lblchildren = new
				Label(children.toString());
		pane.add(lblchildren, 1, 8);
		} catch(Exception e) {
			
		}
		
		
		Button btAddStatus = new Button("Add Status");
		pane.add(btAddStatus, 2, 9);
		btAddStatus.setOnAction(o -> {
			UpdateStatusMenu();
		});
		
		if (person.getType().equals("Child") || person.getType().equals("Adult")) {
		
			Button btAddFriends = new Button("Add Friends");
			pane.add(btAddFriends, 0, 9);
			btAddFriends.setOnAction(o -> {
				addFriendMenu();
			});
			
			Button btRemoveFriends = new Button("Remove Friends");
			pane.add(btRemoveFriends, 1, 9);
			btRemoveFriends.setOnAction(o -> {
				RemoveFriendMenu();
			});	
			
			
			
			
			Button btaddPartner = new Button("Add Partner");
			pane.add(btaddPartner, 3, 9);
			btaddPartner.setOnAction(o -> {
				addPartnerMenu();
				
			});
			
			Button btremovePartner = new Button("Remove Partner");
			pane.add(btremovePartner, 4, 9);
			btremovePartner.setOnAction(o -> {
				RemovePartnerMenu();
				
			});
			
			Button btaddClassmate = new Button("Add a Classmate");
			pane.add(btaddClassmate, 5, 9);
			btaddClassmate.setOnAction(o -> {
				LoadProfileClass.addClassMatesMenu();
				
			});
			
			Button btremoveClassmate = new Button("Remove a Classmate");
			pane.add(btremoveClassmate, 6, 9);
			btremoveClassmate.setOnAction(o -> {
				LoadProfileClass.RemoveClassMatesMenu();
				
			});
			}
			
			if (person.getType().equals("Adult")) {
			
			Button btaddColleagues = new Button("add a Colleague");
			pane.add(btaddColleagues, 7, 9);
			btaddColleagues.setOnAction(o -> {
				LoadProfileClass.addColleaguesMenu();
				
			});
			
			
			Button btremoveColleagues = new Button("Remove a Colleagues");
			pane.add(btremoveColleagues, 8, 9);
			btremoveColleagues.setOnAction(o -> {
				LoadProfileClass.RemoveColleaguesMenu();
				
			});
		
		}
		
		Button btremoveProfile = new Button("Remove Profile");
		pane.add(btremoveProfile, 9, 9);
		btremoveProfile.setOnAction(o -> {
			LoadProfileClass.removeProfileMenu(person.getUName());
			
		});
		
		Button btBacktoMenu = new Button("Back to Menu");
		pane.add(btBacktoMenu, 10, 9);
		btBacktoMenu.setOnAction(o -> {
			MiniNet.mainMenu(new Stage());
		});		
		//Stage SelectPersonStage = new Stage();
		Scene scene = new Scene(pane);
		MiniNet.stage.setTitle("View Profile"); // Set the stage title
		MiniNet.stage.setScene(scene); // Place the scene in the stage
		MiniNet.stage.show(); // Display the stage	
	
	}
	
	
	
	
	
	
	
	
	
	
	public static void addFriendMenu() {
		GridPane Pane = new GridPane(); // Create a pane to hold the texts
		Pane.setPadding(new Insets(5, 5, 5, 5));
		
		Pane.add(new Label("Friend's Account Name :  "), 0, 0);
		
		TextField txtFriendsName =  new TextField();
		Pane.add(txtFriendsName, 1, 0);
		
		Button btEnterFriend = new Button("Add Friend");
		Pane.add(btEnterFriend, 2, 0);
		btEnterFriend.setOnAction(p -> {
			String friendName = txtFriendsName.getText();
			
			try {
				Driver.addingFriends(person.getUName(),friendName);
				profileMenu();
			} catch (TooYoungException e) {				
				e.printStackTrace();
				
				GridPane TooYoungPane = new GridPane(); // Create a pane to hold the texts
				TooYoungPane.setPadding(new Insets(5, 5, 5, 5));
				
				TooYoungPane.add(new Label("Young Children Cannot Make Friends \""), 0, 0);
				
				Button btOk = new Button("OK");
				Pane.add(btOk, 2, 0);
				btOk.setOnAction(i -> {			
					addFriendMenu();	
				});

				//Stage Stage = new Stage();
				Scene scene = new Scene(TooYoungPane);
				MiniNet.stage.setTitle("View Profile"); // Set the stage title
				MiniNet.stage.setScene(scene); // Place the scene in the stage
				MiniNet.stage.show(); // Display the stage
				
			
			} catch (NotToBeFriendsException e) {				
				e.printStackTrace();
				
				GridPane NotToBeFriendsPane = new GridPane(); // Create a pane to hold the texts
				NotToBeFriendsPane.setPadding(new Insets(5, 5, 5, 5));
				
				NotToBeFriendsPane.add(new Label("Child Cannot Be Friends with Adults or Children with an Age gap greater than 3. \""), 0, 0);
				
				Button btOk = new Button("OK");
				NotToBeFriendsPane.add(btOk, 2, 0);
				btOk.setOnAction(q -> {			
					addFriendMenu();	
				});

				//Stage Stage = new Stage();
				Scene scene = new Scene(NotToBeFriendsPane);
				MiniNet.stage.setTitle("View Profile"); // Set the stage title
				MiniNet.stage.setScene(scene); // Place the scene in the stage
				MiniNet.stage.show(); // Display the stage
			}				
		});

		//Stage Stage = new Stage();
		Scene scene = new Scene(Pane);
		MiniNet.stage.setTitle("View Profile"); // Set the stage title
		MiniNet.stage.setScene(scene); // Place the scene in the stage
		MiniNet.stage.show(); // Display the stage
	}
	
	
	
	
public static void RemoveFriendMenu() {
		GridPane Pane = new GridPane(); // Create a pane to hold the texts
		Pane.setPadding(new Insets(5, 5, 5, 5));
		
		Pane.add(new Label("Friend's Account Name To Remove :  "), 0, 0);
		
		TextField txtFriendsName =  new TextField();
		Pane.add(txtFriendsName, 1, 0);
		
		Button btEnterFriend = new Button("Remove Friend");
		Pane.add(btEnterFriend, 2, 0);
		btEnterFriend.setOnAction(p -> {
			String friendName = txtFriendsName.getText();
			
			try {
				Driver.RemoveFriend(person.getUName(),friendName);
				profileMenu();
			} catch (Exception e) {	
				System.out.println("User Doesnt Exist On MiniNet");
				RemoveFriendMenu();	
			}				
		});

		//Stage Stage = new Stage();
		Scene scene = new Scene(Pane);
		MiniNet.stage.setTitle("View Profile"); // Set the stage title
		MiniNet.stage.setScene(scene); // Place the scene in the stage
		MiniNet.stage.show(); // Display the stage
	}
	
	
	private static void removeProfileMenu(String name) {
		GridPane Pane = new GridPane(); // Create a pane to hold the texts
		Pane.setPadding(new Insets(5, 5, 5, 5));
		
		Pane.add(new Label("Are You Sure You Want to Remove " + name  ), 0, 0);
		
		Button btEnterStatus = new Button("Yes Im Sure");
		Pane.add(btEnterStatus, 0, 1);
		btEnterStatus.setOnAction(p -> {	
				try {
					Driver.removeProfile(name);
				} catch (NoParentException e) {
					LoadProfileClass.error("You Already Have a Child, Therefore you cannot remove the profile");
					e.printStackTrace();
				};
				MiniNet.mainMenu(new Stage());			
		});

		//Stage Stage = new Stage();
		Scene scene = new Scene(Pane);
		MiniNet.stage.setTitle("View Profile"); // Set the stage title
		MiniNet.stage.setScene(scene); // Place the scene in the stage
		MiniNet.stage.show(); // Display the stage
	}
	
	
	
	
	private static void UpdateStatusMenu() {
		GridPane Pane = new GridPane(); // Create a pane to hold the texts
		Pane.setPadding(new Insets(5, 5, 5, 5));
		
		Pane.add(new Label("Enter the New Status :  "), 0, 0);
		
		TextField txtStatus =  new TextField();
		Pane.add(txtStatus, 1, 0);
		
		Button btEnterStatus = new Button("Update Status");
		Pane.add(btEnterStatus, 2, 0);
		btEnterStatus.setOnAction(p -> {
			String status = txtStatus.getText();
				Driver.updateStatus(person.getUName(),status);
				profileMenu();				
		});

		//Stage Stage = new Stage();
		Scene scene = new Scene(Pane);
		MiniNet.stage.setTitle("View Profile"); // Set the stage title
		MiniNet.stage.setScene(scene); // Place the scene in the stage
		MiniNet.stage.show(); // Display the stage
	}


	public static void addPartnerMenu() {
		GridPane Pane = new GridPane(); // Create a pane to hold the texts
		Pane.setPadding(new Insets(5, 5, 5, 5));
		
		Pane.add(new Label("Enter The Account Name of Partner  "), 0, 0);
		
		TextField txtpartner =  new TextField();
		Pane.add(txtpartner, 1, 0);
		
		Button btEnterPartner = new Button("Add Partner");
		Pane.add(btEnterPartner, 2, 0);
		btEnterPartner.setOnAction(p -> {
			String partner = txtpartner.getText();
				try {
					Driver.addPartner(person.getUName(),partner);
					profileMenu();
				} catch (NoAvailableException e) {
					error("You or/and Other Person Already have partners");
					e.printStackTrace();
				} catch (NotToBeCoupledException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					error("Children cant be coupled");
				}
								
		});

		//Stage Stage = new Stage();
		Scene scene = new Scene(Pane);
		MiniNet.stage.setTitle("View Profile"); // Set the stage title
		MiniNet.stage.setScene(scene); // Place the scene in the stage
		MiniNet.stage.show(); // Display the stage
		
	}
	
	
	
	
	
	
	
	
	
	
	public static void error(String error) {
		GridPane Pane = new GridPane(); // Create a pane to hold the texts
		Pane.setPadding(new Insets(5, 5, 5, 5));
		
		Pane.add(new Label(error), 0, 0);
		
		Button btEnterPartner = new Button("Ok");
		Pane.add(btEnterPartner, 2, 0);
		

		Stage Stage = new Stage();
		Scene scene = new Scene(Pane);
		Stage.setTitle("View Profile"); // Set the stage title
		Stage.setScene(scene); // Place the scene in the stage
		Stage.show(); // Display the stage
		
		btEnterPartner.setOnAction(p -> {
			Stage.close();
		});
	}

	
	

	public static void RemovePartnerMenu() {
		GridPane Pane = new GridPane(); // Create a pane to hold the texts
		Pane.setPadding(new Insets(5, 5, 5, 5));
		
		Pane.add(new Label("Enter The Account Name of Partner  "), 0, 0);
		
		TextField txtpartner =  new TextField();
		Pane.add(txtpartner, 1, 0);
		
		Button btEnterPartner = new Button("Remove Partner");
		Pane.add(btEnterPartner, 2, 0);
		btEnterPartner.setOnAction(p -> {
			String partner = txtpartner.getText();
				
					try {
						Driver.removePartner(person.getUName(),partner);
						profileMenu();
					} catch (AlreadyCoupledWithChild e) {
						e.printStackTrace();
						error("You two Already have a Child");
					}
					
				
								
		});

		//Stage Stage = new Stage();
		Scene scene = new Scene(Pane);
		MiniNet.stage.setTitle("View Profile"); // Set the stage title
		MiniNet.stage.setScene(scene); // Place the scene in the stage
		MiniNet.stage.show(); // Display the stage
		
	}
	
	
	
	
	
	
	
public static void addClassMatesMenu() {
		
		GridPane Pane = new GridPane(); // Create a pane to hold the texts
		Pane.setPadding(new Insets(5, 5, 5, 5));
		
		Pane.add(new Label("ClassMates Account Name :  "), 0, 0);
		
		TextField txtAccountName =  new TextField();
		Pane.add(txtAccountName, 1, 0);
		
		Button btEnterFriend = new Button("Add Classmate");
		Pane.add(btEnterFriend, 2, 0);
		btEnterFriend.setOnAction(p -> {
		String AccountName = txtAccountName.getText();
			
				try {
					Driver.addingClassmates(person.getUName(),AccountName);
					profileMenu();
				} catch (NotToBeClassmatesException e) {
					e.printStackTrace();
				}
				
							
		});

		//Stage Stage = new Stage();
		Scene scene = new Scene(Pane);
		MiniNet.stage.setTitle("View Profile"); // Set the stage title
		MiniNet.stage.setScene(scene); // Place the scene in the stage
		MiniNet.stage.show(); // Display the stage
	}

public static void addColleaguesMenu() {
	
	GridPane Pane = new GridPane(); // Create a pane to hold the texts
	Pane.setPadding(new Insets(5, 5, 5, 5));
	
	Pane.add(new Label("Colleagues Account Name :  "), 0, 0);
	
	TextField txtAccountName =  new TextField();
	Pane.add(txtAccountName, 1, 0);
	
	Button btEnterFriend = new Button("Add colleague");
	Pane.add(btEnterFriend, 2, 0);
	btEnterFriend.setOnAction(p -> {
	String AccountName = txtAccountName.getText();
		
			try {
				Driver.addingColleagues(person.getUName(),AccountName);
			} catch (NotToBeColleaguesException e) {
				e.printStackTrace();
			}
			profileMenu();
						
	});

	//Stage Stage = new Stage();
	Scene scene = new Scene(Pane);
	MiniNet.stage.setTitle("View Profile"); // Set the stage title
	MiniNet.stage.setScene(scene); // Place the scene in the stage
	MiniNet.stage.show(); // Display the stage
}




public static void RemoveClassMatesMenu() {
	
	GridPane Pane = new GridPane(); // Create a pane to hold the texts
	Pane.setPadding(new Insets(5, 5, 5, 5));
	
	Pane.add(new Label("ClassMates Account Name :  "), 0, 0);
	
	TextField txtAccountName =  new TextField();
	Pane.add(txtAccountName, 1, 0);
	
	Button btEnterFriend = new Button("Remove Classmate");
	Pane.add(btEnterFriend, 2, 0);
	btEnterFriend.setOnAction(p -> {
	String AccountName = txtAccountName.getText();
		
			Driver.RemovingClassmates(person.getUName(),AccountName);
			profileMenu();
						
	});

	//Stage Stage = new Stage();
	Scene scene = new Scene(Pane);
	MiniNet.stage.setTitle("View Profile"); // Set the stage title
	MiniNet.stage.setScene(scene); // Place the scene in the stage
	MiniNet.stage.show(); // Display the stage
}

	
	
public static void RemoveColleaguesMenu() {
	
	GridPane Pane = new GridPane(); // Create a pane to hold the texts
	Pane.setPadding(new Insets(5, 5, 5, 5));
	
	Pane.add(new Label("Colleagues Account Name :  "), 0, 0);
	
	TextField txtAccountName =  new TextField();
	Pane.add(txtAccountName, 1, 0);
	
	Button btEnterFriend = new Button("Remove Colleagues");
	Pane.add(btEnterFriend, 2, 0);
	btEnterFriend.setOnAction(p -> {
	String AccountName = txtAccountName.getText();
		
			Driver.RemovingColleagues(person.getUName(),AccountName);
			profileMenu();
						
	});

	//Stage Stage = new Stage();
	Scene scene = new Scene(Pane);
	MiniNet.stage.setTitle("View Profile"); // Set the stage title
	MiniNet.stage.setScene(scene); // Place the scene in the stage
	MiniNet.stage.show(); // Display the stage
}		
	


}
	
	
	
	
	
	
	







