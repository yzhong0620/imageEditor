package imageEditor;

import java.awt.image.BufferedImage;

/**
 * This class applies the Sepia filter.
 */

public class Sepia implements filterOptions{

    /**
     * Takes a buffered image and applies the Negative filter by changing the
     * RGB values accroding to the Sepia style for each pixel on that image.
     * Reference: https://www.geeksforgeeks.org/image-procesing-
     * java-set-6-colored-image-sepia-image-conversion/?ref=rp.
     * @param bufferedImage The BufferedImage file of the target image.
     */

    public static void effect(BufferedImage bufferedImage) {

        BufferedImage image = bufferedImage;

        int width = image.getWidth();
        int height = image.getHeight();

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int z = image.getRGB(x, y);

                int a = (z >> 24) & 255;
                int R = (z >> 16) & 255;
                int G = (z >> 8) & 255;
                int B = z & 255;

                int newRed = (int) (0.393 * R + 0.769 * G + 0.189 * B);
                int newGreen = (int) (0.349 * R + 0.686 * G + 0.168 * B);
                int newBlue = (int) (0.272 * R + 0.534 * G + 0.131 * B);

                if (newRed > 255)
                    R = 255;
                else
                    R = newRed;

                if (newGreen > 255)
                    G = 255;
                else
                    G = newGreen;

                if (newBlue > 255)
                    B = 255;
                else
                    B = newBlue;

                z = (a << 24) | (R << 16) | (G << 8) | B;

                image.setRGB(x, y, z);
            }
        }
    }

    /**
     * @return the name of this filter
     */

    @Override
    public String getName() {
        return "Sepia";
    }
}
