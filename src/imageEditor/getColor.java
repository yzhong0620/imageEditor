package imageEditor;

import java.awt.*;

/**
 * A class responsible for identification of color based on user's String input.
 */

public class getColor {

    private Color color;

    /**
     * Takes the user color input and return the color code.
     * @param col The name of the color that the user inputs as text.
     * @return The color the user wants in the Color format.
     */

    public Color getColor(String col) {
        color = newColor(col);
        return color;
    }

    /**
     * Creates the Color object according to the user's text input.
     * @param col the name of the color that the user inputs as text.
     * @return The color the user wants in the Color format.
     */

    public Color newColor(String col) {
        switch (col.toLowerCase()) {
            case "blue":
                color = Color.BLUE;
                break;
            case "cyan":
                color = Color.CYAN;
                break;
            case "darkgray":
                color = Color.DARK_GRAY;
                break;
            case "gray":
                color = Color.GRAY;
                break;
            case "green":
                color = Color.GREEN;
                break;

            case "yellow":
                color = Color.YELLOW;
                break;
            case "lightgray":
                color = Color.LIGHT_GRAY;
                break;
            case "magneta":
                color = Color.MAGENTA;
                break;
            case "orange":
                color = Color.ORANGE;
                break;
            case "pink":
                color = Color.PINK;
                break;
            case "red":
                color = Color.RED;
                break;
            case "white":
                color = Color.WHITE;
                break;
            default:
                color = Color.BLACK;
        }
        return color;
    }
}

