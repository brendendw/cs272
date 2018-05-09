package edu.orangecoastcollege.cs272.ic13.view;

import javafx.fxml.FXML;

import javafx.scene.control.TextField;
import edu.orangecoastcollege.cs272.ic13.controller.Controller;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.input.MouseEvent;

public class SignInScene {
	
	private static Controller controller = Controller.getInstance();
	@FXML
	private Label emailErrorLabel;
	@FXML
	private Label passwordErrorLabel;
	@FXML
	private Label signInErrorLabel;
	@FXML
	private TextField emailAddressTF;
	@FXML
	private TextField passwordTF;

	// Event Listener on Button.onAction
	@FXML
	public boolean signIn() {
		
		// Read the information from the user
		String email = emailAddressTF.getText();
		String password = passwordTF.getText();
		
		emailErrorLabel.setVisible(email.isEmpty());
		passwordErrorLabel.setVisible(password.isEmpty());
		
		signInErrorLabel.setVisible(true);
		
		if (emailErrorLabel.isVisible() || passwordErrorLabel.isVisible())
				return false;
		
		// Let's try to log the user in
		String result = controller.signInUser(email, password);
		if (result.equalsIgnoreCase("SUCCESS"))
		{
			ViewNavigator.loadScene("Video Game Inventory", ViewNavigator.VIDEO_GAME_LIST_SCENE);
			return true;
		}
		return false;
		
	}
	// Event Listener on Button.onMouseClicked
	@FXML
	public void loadSignUp(MouseEvent event) {
		ViewNavigator.loadScene("Sign-Up", ViewNavigator.SIGN_UP_SCENE);
	}
}
