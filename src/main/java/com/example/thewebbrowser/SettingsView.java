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
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import javax.swing.*;


public class SettingsView implements Initializable {

    @FXML
    public ListView<String> myListView;
    @FXML
    public CheckBox darkMode;
    @FXML
    public Label label;
    public Label labelCurrentSearch;


    private  Media media;
    private MediaPlayer mediaPlayer;
    @FXML
    public String currentSearch;
    public Button apply;
    public Label darkModeLabel;
    public Button dont;
    String[] searchEngine = {"google", "bing", "yahoo"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        labelCurrentSearch.setText(currentSearch);
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
        darkModeLabel.setText("لماذا الوضع المظلم" + "\n" +"والله اخرجنا من الظلمات الى النور");
    }
    @FXML
    public void onNot() {
        media = new Media(new File("src\\main\\resources\\com\\example\\thewebbrowser\\oh.mp3").toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
        int x = JOptionPane.showConfirmDialog(null, "هل صليت على النبي محمد اليوم؟", "", JOptionPane.YES_NO_OPTION);
        if (x ==0 ){
            JOptionPane.showMessageDialog(null,"💟 صلي على النبي محمد كمان 💟", "", JOptionPane.INFORMATION_MESSAGE);
        } else if (x == 1) {
            JOptionPane.showMessageDialog(null,"💟 صلي على النبي محمد 💟", "", JOptionPane.INFORMATION_MESSAGE);
        } else if (x == -1) {
            JOptionPane.showMessageDialog(null,"💟 صلي على النبي محمد ولا تتهرب 💟", "", JOptionPane.INFORMATION_MESSAGE);

        }
    }




}



