package com.example.thewebbrowser;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import  javafx.scene.media.MediaPlayer;

import java.io.File;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class SettingsView implements Initializable {

    @FXML
    public ListView<String> myListView;
    @FXML
    public CheckBox darkMode;
    @FXML
    public Label label;
    public Label labelCurrentSearch;

    @FXML
    public String currentSearch;
    public Button apply;
    public Label darkModeLabel;
    public Button dont;
    String[] searchEngine = {"google", "bing", "yahoo"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        myListView.getItems().addAll(searchEngine);
        myListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                currentSearch = myListView.getSelectionModel().getSelectedItem();

                labelCurrentSearch.setText(currentSearch);

            }
        });


    }


    public void onApply() {
        MyWebController.homepage = "www." + currentSearch + ".com";
        labelCurrentSearch.setText(currentSearch);
    }

    public void onDark() {
        darkModeLabel.setText("idk how to make it 😂😂");
    }
    MediaPlayer mediaPlayer;
    @FXML
    public void onNot() {
        String fileName = "song.mp3";
        playHitSound(fileName);
    }


    private void playHitSound(String fileName){
        String path = getClass().getResource(fileName).getPath();
        Media media = new Media(new File(path).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.setVolume(70);
        mediaPlayer.play();
    }
}


