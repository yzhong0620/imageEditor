package imageEditor;

import java.awt.*;
import java.awt.image.BufferedImage;


/**
 * This class applies the Negative filter.
 */

public class Negative implements filterOptions{

    /**
     * Takes a buffered image and applies the Negative filter by switching +/- signs
     * of the RGB values for each pixel on that image.
     * Reference: https://www.geeksforgeeks.org/
     * image-processing-java-set-4-colored-image-negative-image-conversion/?ref=rp
     * @param bufferedImage The BufferedImage file of the target image.
     */

    public static void effect(BufferedImage bufferedImage) {

        BufferedImage image = bufferedImage;

        int width = image.getWidth();
        int height = image.getHeight();

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {

                int z = image.getRGB(x, y);
                int r = (z >> 16) & 255;
                int g = (z >> 8) & 255;
                int b = z & 255;
                int a = (z >> 24) & 255;

                r = 255 - r;
                g = 255 - g;
                b = 255 - b;

                z = (a << 24) | (r << 16) | (g << 8) | b;
                image.setRGB(x, y, z);
            }
        }
    }

    /**
     * @return the name of this filter
     */

    @Override
    public String getName() {
        return "Negative";
    }
}
