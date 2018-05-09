package edu.orangecoastcollege.cs272.ic13.view;

import java.net.URL;
import java.util.ResourceBundle;

import edu.orangecoastcollege.cs272.ic13.controller.Controller;
import edu.orangecoastcollege.cs272.ic13.model.VideoGame;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

/*
 * 
 *  Initializable interface: a method that allows you prefill (initialize)
 *  any controls on your scene.
 */
public class VideoGamesListScene implements Initializable {

	private static Controller controller = Controller.getInstance();

	@FXML
	private ListView<VideoGame> allVideoGamesLV;
	@FXML
	private ComboBox<String> publishersCB;
	@FXML
	private ComboBox<String> platformsCB;
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// 1) set the items of the videogamesLV to all the video games from the controller
		allVideoGamesLV.setItems(controller.getAllVideoGames());
		// 2 set the items for the platforms
		platformsCB.setItems(controller.getDistinctPlatforms());
		// 3) and publishers
		publishersCB.setItems(controller.getDistinctPublishers());
		
	}
	
	@FXML
	public Object addGameToInventory()
	{
		// List views have selected index, and selected item
		// Index: index is position
		// Item: item is the object
		VideoGame vg = allVideoGamesLV.getSelectionModel().getSelectedItem();
		controller.addGameToUsersInventory(vg);
		return this;
	}
	
	@FXML
	public Object viewInventory()
	{
		// Use the ViewNavigator to load the VIEW_INVENTORY_SCENE with the titlle Users Video Games
		ViewNavigator.loadScene("User's Video Games", ViewNavigator.VIEW_INVENTORY_SCENE);
		return this;
	}

}
