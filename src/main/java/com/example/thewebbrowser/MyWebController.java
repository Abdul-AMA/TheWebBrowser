package com.example.thewebbrowser;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class MyWebController implements Initializable {
    @FXML
    private WebView webView;
    private WebEngine webEngine;

    @FXML

    public AnchorPane base;
    @FXML
    public Button buttonBack;
    @FXML
    public Button buttonHome;
    public Button buttonLoad;
    public Button buttonReload;
    public TextField textUrl;
    public Label labelSearch;
    public TextField textSearch;
    public Label labelURL;
    @FXML
    private Label label1;

    @FXML
    protected void onReload(ActionEvent event) {

        System.out.println("hello");
    }
    @FXML
    protected void onLoad() {

        webEngine.load("https://www.youtube.com/");
    }
    @FXML
    protected void onHome(ActionEvent event) {

        System.out.println("hello");
    }
    @FXML
    protected void onBack(ActionEvent event) {

        System.out.println("hello");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        webEngine = webView.getEngine();
        onLoad();
    }
}