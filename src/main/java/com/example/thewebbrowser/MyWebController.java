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

    public Button buttonForward;
    ArrayList<String > history = new ArrayList<String>();
    private String homepage;
    private static int tabs;
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
        history.add(textUrl.getText());
        tabs++;
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

    }

    @FXML
    protected void onBack( ) {

    }

    public void onReload( ) {
        textUrl.setText(webEngine.getLocation());
        onLoad();
    }


//    public void zoomIn() {
//        webView.setZoom(1.25);
//    }
//
//    public void zoomOut() {
//        webView.setZoom(0.75);
//    }


}