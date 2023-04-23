package com.example.thewebbrowser;

import javafx.beans.binding.Bindings;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MyWebController implements Initializable {
    public Button buttonSettings;
    @FXML
    private ProgressBar progressBar;

    private WebHistory webHistory;
    public Button buttonForward;
    public static String homepage;
    @FXML
    private WebView webView;
    private WebEngine webEngine;

    @FXML

    public AnchorPane base;
    @FXML
    public Button buttonBack;

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    @FXML
    public Button buttonHome;
    public Button buttonLoad;
    public TextField textUrl;
    public Label labelSearch;
    public TextField textSearch;



    @FXML

    protected void onLoad() {
        if (!textUrl.getText().contains("https://") && !textUrl.getText().isEmpty()) {
            textUrl.setText("https://"+ textUrl.getText());
        }
        webEngine.load(textUrl.getText());
        textSearch.setText("");

    }
    @FXML
    protected void onHome() {
        textUrl.setText(homepage);
        onLoad();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        webEngine = webView.getEngine();
        final ProgressBar loading = progressBar;
        loading.setVisible(true);
        homepage = "www.google.com";
        onLoad();

        // this code is for the loading and idk how it works :D
        //................................................................
        loading.progressProperty().bind(webEngine.getLoadWorker().progressProperty());
        loading.visibleProperty().bind(Bindings.when(loading.progressProperty().lessThan(0).or(loading.progressProperty().isEqualTo(1)))
                        .then(false)
                        .otherwise(true)
        );
        //................................................................
        loading.managedProperty().bind(loading.visibleProperty());
        loading.setMaxWidth(Double.MAX_VALUE);
        //................................................................
    }


    public void onSearch() {
        textUrl.setText("www.google.com/search?q="+textSearch.getText());
        onLoad();
    }
    @FXML
    public void onFroward( ) {

        webHistory = webEngine.getHistory();
        ObservableList<WebHistory.Entry> entries = webHistory.getEntries();
        webHistory.go(+1);
        textUrl.setText(webEngine.getLocation());    }

    @FXML
    protected void onBack( ) {
        webHistory = webEngine.getHistory();
        ObservableList<WebHistory.Entry> entries = webHistory.getEntries();
        webHistory.go(-1);
        textUrl.setText(webEngine.getLocation());

    }
    @FXML
    public void onReload( ) {
        textUrl.setText(webEngine.getLocation());
        onLoad();
    }


    public void onSettings( ) throws IOException {
        Parent root =  FXMLLoader.load(getClass().getResource("settings-view.fxml"));
        Scene scene = new Scene(root,300,250);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("settings");
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.getIcons().add(new Image(new File("src/main/resources/com/example/thewebbrowser/a.png").getAbsolutePath()));
        primaryStage.setResizable(false);

    }



}