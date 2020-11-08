package imageEditor;

import java.awt.image.BufferedImage;

/**
 * This class applies the Black and White filter.
 */

public class BlackAndWhite implements filterOptions{

    /**
     * Takes a buffered image and applies the Negative filter by applying the
     * averaged value to the RGB values for each pixel on that image.
     * Reference: https://www.geeksforgeeks.org/image-processing-in-java-set-3-colored-
     * image-to-greyscale-image-conversion/?ref=rp.
     * @param bufferedImage The BufferedImage file of the target image.
     */

    public static void effect(BufferedImage bufferedImage){

        BufferedImage image = bufferedImage;

        int width = image.getWidth();
        int height = image.getHeight();

        for (int x = 0; x < width; x++)
        {
            for (int y = 0; y < height; y++)
            {

                int z = image.getRGB(x,y);

                int r = (z>>16) & 255;
                int g = (z>>8) & 255;
                int b = z & 255;
                int a = (z>>24) & 255;

                // calculate average
                int avg = (r+g+b)/3;

                // replace RGB value with avg
                z = (a<<24) | (avg<<16) | (avg<<8) | avg;

                image.setRGB(x, y, z);
            }
        }

    }

    /**
     * @return the name of this filter
     */

    @Override
    public String getName() {
        return "Black and White";
    }
}
