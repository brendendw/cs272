package edu.orangecoastcollege.cs272.ic13.view;

import javafx.fxml.FXML;

import javafx.scene.control.TextField;
import edu.orangecoastcollege.cs272.ic13.controller.Controller;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.input.MouseEvent;

public class SignUpScene {
	private static Controller controller = Controller.getInstance();

	@FXML
	private Label emailRequiredLabel;
	@FXML
	private Label passwordRequiredLabel;
	@FXML
	private Label signInFailedLabel;
	@FXML
	private Label fullNameRequiredLabel;
	@FXML
	private TextField fullNameTF;
	@FXML
	private TextField emailAddressTF;
	@FXML
	private TextField passwordTF;
	@FXML
	private Label fieldRequiredLabel;

	// Event Listener on Button.onAction
	@FXML
	public boolean signUp(ActionEvent event) {
		
		String name = fullNameTF.getText();
		String email = emailAddressTF.getText();
		String password = passwordTF.getText();
		
		fullNameRequiredLabel.setVisible(name.isEmpty());
		emailRequiredLabel.setVisible(email.isEmpty());
		passwordRequiredLabel.setVisible(password.isEmpty());
		
		if (fullNameRequiredLabel.isVisible() || emailRequiredLabel.isVisible() || passwordRequiredLabel.isVisible())
			return false;
		
		String result = controller.signUpUser(name, email, password);
		
		if (result.equalsIgnoreCase("SUCCESS")) {
			fieldRequiredLabel.setVisible(false);
			ViewNavigator.loadScene("Video Game Inventory", ViewNavigator.VIDEO_GAME_LIST_SCENE);
			return true;
		}
		
		fieldRequiredLabel.setText(result);
		fieldRequiredLabel.setVisible(true);
		
		return false;
		
		
		
	}
	// Event Listener on Button.onMouseClicked
	@FXML
	public void loadVideoGameList(MouseEvent event) {
		// TODO Autogenerated
	}
	
	@FXML 
	public void goBack(MouseEvent event)  {
		ViewNavigator.loadScene("Sign Up", ViewNavigator.SIGN_IN_SCENE);
	}
}
