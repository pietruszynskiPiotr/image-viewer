package es.ulpgc.persistance;

import es.ulpgc.model.ImageLoader;
import es.ulpgc.model.Image;

import java.io.*;

import static java.util.Objects.requireNonNull;

public class FileImageLoader implements ImageLoader {

    private final File[] images;

    public FileImageLoader(File folder) {
        this.images = requireNonNull(folder.listFiles(imageType()));
    }

    public FileFilter imageType() {
        return pathname -> pathname.getName().endsWith(".JPG");
    }

    public Image imageAt(int i) {
        return new Image() {
            @Override
            public String name() {
                return images[i].getName();
            }

            @Override
            public InputStream stream() {
                try {
                    return new BufferedInputStream(new FileInputStream(images[i]));
                } catch (FileNotFoundException e) {
                    return null;
                }
            }

            @Override
            public Image next() {
                return i == images.length - 1 ? imageAt(0) : imageAt(i + 1);
            }

            @Override
            public Image prev() {
                return i == 0 ? imageAt(images.length - 1) : imageAt(i - 1);
            }
        };
    }


    @Override
    public Image load() {
        return imageAt(0);
    }
}
