package es.ulpgc.ui;

import es.ulpgc.model.Image;

public interface ImageDisplay {
    Image current();
    void show(Image image);
}