package imageEditor;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import comp127graphics.Image;

public class Original implements filterOptions{
    private static BufferedImage originalBi;

    public Original(Image image){
        BufferedImage bi = image.returnBufferedImage();
        this.originalBi = saveOriginal(bi);
    }

    /**
     * Takes a buffered image and replicates the RGB values of each pixel from
     * the saved original copy on that image.
     * Reference: https://www.geeksforgeeks.org/.
     *
     * @param bufferedImage The BufferedImage file of the target image.
     */

    public static void effect(BufferedImage bufferedImage) {

        BufferedImage image = bufferedImage;

        int width = image.getWidth();
        int height = image.getHeight();

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {

                int z = originalBi.getRGB(x, y);

                int a = (z >> 24) & 255;
                int r = (z >> 16) & 255;
                int g = (z >> 8) & 255;
                int b = z & 255;

                z = (a << 24) | (r << 16) | (g << 8) | b;
                image.setRGB(x, y, z);

            }
        }
    }

    /**
     * Creates a copy of the target image to have a original BufferedImage that
     * can be used to restore the image.
     * @param bi The bufferedImage of the imported image.
     * @return The copy of the bufferedImage of the imported image.
     */

    public static BufferedImage saveOriginal(BufferedImage bi) {
        ColorModel cm = bi.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = bi.copyData(null);
        return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
    }

    /**
     * @return "Original" showing that it is the original image
     */

    @Override
    public String getName(){
        return "Original";
    }

}
