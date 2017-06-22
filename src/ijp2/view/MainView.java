package ijp2.view;



import ijp2.other.ParkWalker;
import ijp2.controller.MainController;
import ijp2.other.Item;
import ijp2.other.Params;
import ijp2.other.Picture;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class MainView  {
	
	protected MainController controller;
	
	@FXML 
	protected ImageView mainImage;

	@FXML
	protected ImageView standByItemImage;
	
	@FXML
	protected ImageView placedItemImage;
	
	@FXML
	protected Button moveForwardButton;
	
	@FXML
	protected Button lookUpButton;
	
	@FXML
	protected Button lookDownButton;
	
	@FXML
	protected Button turnRightButton;
	
	@FXML
	protected Button turnLeftButton;
	
	@FXML
	protected Button turnBackButton;
	
	@FXML
	protected Label standByItemLabel;
	
	@FXML
	protected Menu chooseItem;
	
	@FXML
	protected Menu handleItem;
	
	@FXML
	protected MenuItem placeItem;
	
	@FXML
	protected MenuItem getItem;
	
	@FXML
	protected MenuItem discardItem;
	
	@FXML
	protected MenuItem ballChoice;
	
	@FXML
	protected MenuItem fruitChoice;
	
	@FXML
	protected MenuItem squirrelChoice;
	
	@FXML
	protected ImageView southeast;
	
	@FXML
	protected ImageView east;
	
	@FXML
	protected ImageView northeast;
	
	@FXML
	protected ImageView southwest;
	
	@FXML
	protected ImageView west;
	
	@FXML
	protected ImageView northwest;
	
	
	
		
	public void start() {
		//buttons
		moveForwardButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		        controller.forward();
		        controller.updateInterfaceOnNewStatus();
		    }
		});
		
		lookUpButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		        controller.lookUp();
		        controller.updateInterfaceOnNewStatus();
		    }
		});
		
		lookDownButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		        controller.lookDown();
		        controller.updateInterfaceOnNewStatus();
		    }
		});
		
		turnRightButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		        controller.turnRight();
		        controller.updateInterfaceOnNewStatus();
		    }
		});
		
		turnLeftButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		        controller.turnLeft();
		        controller.updateInterfaceOnNewStatus();
		    }
		});
		
		turnBackButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		        controller.turnAround();
		        controller.updateInterfaceOnNewStatus();
		    }
		});
		
		//menuitems
		placeItem.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		        controller.placeItem();
		        controller.updateInterfaceOnNewStatus();
		    }
		});
		
		getItem.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		        controller.getItem();
		        controller.updateInterfaceOnNewStatus();
		    }
		});
		
		discardItem.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		        controller.disposeItem();
		        controller.updateInterfaceOnNewStatus();
		    }
		});
		
		ballChoice.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		        controller.selectItem(Params.FOOTBALL_INDEX);
		        controller.updateInterfaceOnNewStatus();
		    }
		});
		
		fruitChoice.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		        controller.selectItem(Params.FRUIT_INDEX);
		        controller.updateInterfaceOnNewStatus();
		    }
		});
		
		squirrelChoice.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		        controller.selectItem(Params.SQUIRRELL_INDEX);
		        controller.updateInterfaceOnNewStatus();
		    }
		});
		
		
		controller.updateInterfaceOnNewStatus();
		ParkWalker.mainStage.show();
		
		
	}
	
	

	
	public void setController(MainController controller) {
		this.controller = controller;

	}

	
	public void showMainImage(Picture picture) {
		mainImage.setImage(new Image(picture.getSource()));
	}

	
	public void showStandByItemImage(Item item) {
		if(item != null) {
			Image image = new Image(item.getPicture().getSource());
			standByItemImage.setImage(image);
			standByItemImage.setVisible(true);
			standByItemLabel.setVisible(true);
		}
		else {
			standByItemImage.setImage(null);
			standByItemLabel.setVisible(false);
		}
	}

	
	public void showPlacedItemImage(Item item) {
		if(item != null) {
			Image image = new Image(item.getPicture().getSource());
			placedItemImage.setImage(image);
			placedItemImage.setVisible(true);
		}
		else {
			placedItemImage.setVisible(false);
		}
		
	}

	
	public void disableEnableDirectionButtons(Boolean[] buttonStatus) {
		if(!buttonStatus[Params.MOVE_FORWARD_BUTTON_CODE]) {
			moveForwardButton.setDisable(true);
		}
		else {
			moveForwardButton.setDisable(false);
		}
		if(!buttonStatus[Params.LOOK_UP_BUTTON_CODE]) {
			lookUpButton.setDisable(true);
		}
		else {
			lookUpButton.setDisable(false);
		}
		if(!buttonStatus[Params.LOOK_DOWN_BUTTON_CODE]) {
			lookDownButton.setDisable(true);
		}
		else {
			lookDownButton.setDisable(false);
		}
	}

	
	public void disableEnableMenus(Boolean[] menuStatus, Boolean[] menuItemStatus) {
		if (!menuStatus[Params.CHOOSE_ITEM_CODE]) {
			chooseItem.setDisable(true);
		}
		else {
			chooseItem.setDisable(false);
			if(!menuItemStatus[Params.FOOTBALL_ITEM_CODE]) {
				ballChoice.setDisable(true);
			}
			else {
				ballChoice.setDisable(false);
			}
			if(!menuItemStatus[Params.FRUIT_ITEM_CODE]) {
				fruitChoice.setDisable(true);
			}
			else {
				fruitChoice.setDisable(false);
			}
			if(!menuItemStatus[Params.SQUIRREL_ITEM_CODE]) {
				squirrelChoice.setDisable(true);
			}
			else {
				squirrelChoice.setDisable(false);
			}
		}
		if (!menuStatus[Params.HANDLE_ITEM_CODE]) {
			handleItem.setDisable(true);
		}
		else {
			handleItem.setDisable(false);
			if(!menuItemStatus[Params.GET_ITEM_CODE]) {
				getItem.setDisable(true);
			}
			else {
				getItem.setDisable(false);
			}
			if(!menuItemStatus[Params.PLACE_ITEM_CODE]) {
				placeItem.setDisable(true);
			}
			else {
				placeItem.setDisable(false);
			}
			if(!menuItemStatus[Params.DISCARD_ITEM_CODE]) {
				discardItem.setDisable(true);
			}
			else {
				discardItem.setDisable(false);
			}
		}
		
	}
	
	public void showMap(Picture[] mapStatus) {
		southeast.setImage(new Image(mapStatus[0].getSource()));
		east.setImage(new Image(mapStatus[1].getSource()));
		northeast.setImage(new Image(mapStatus[2].getSource()));
		southwest.setImage(new Image(mapStatus[3].getSource()));
		west.setImage(new Image(mapStatus[4].getSource()));
		northwest.setImage(new Image(mapStatus[5].getSource()));
	}


}
