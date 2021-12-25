package es.ulpgc.controller;

import es.ulpgc.model.Image;
import es.ulpgc.persistance.FileImageLoader;

import java.io.File;
public class Main {
    public static void main(String[] args) {
        File file = new File("images");
        FileImageLoader imageLoader = new FileImageLoader(file);
        Image image = imageLoader.load();
        MainFrame mainFrame = new MainFrame();
        mainFrame.getImageDisplay().show(image);
    }
}