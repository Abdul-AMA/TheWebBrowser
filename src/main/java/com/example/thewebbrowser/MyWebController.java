package com.example.thewebbrowser;

import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MyWebController implements Initializable {

    private WebHistory webHistory;
    public Button buttonForward;
    private String homepage;
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
    public TextField textUrl;
    public Label labelSearch;
    public TextField textSearch;


    @FXML

    protected void onLoad() {
        if (textUrl.getText().isEmpty()) {
            webEngine.load(textUrl.getText());
        } else if (textUrl.getText().contains("https://")){
            webEngine.load(textUrl.getText());
        }else {
            textUrl.setText("https://"+ textUrl.getText());
            webEngine.load(textUrl.getText());

        }
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
        homepage = "www.google.com";
        onLoad();
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

    public void onReload( ) {
        textUrl.setText(webEngine.getLocation());
        onLoad();
    }



}