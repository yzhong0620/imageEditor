package imageEditor;

import comp127graphics.CanvasWindow;
import comp127graphics.Image;
import comp127graphics.ui.Button;
import comp127graphics.Point;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for the Sticker function of the ImageEditor,
 * it creates and adds the smile and cry sticker to the canvas.
 */

public class Sticker {

    private CanvasWindow canvas;
    private Image image;
    private double l;
    private List<Button> listb;

    private Button b1;
    private Button b2;
    private Button b3;

    private boolean isPressed;

    /**
     * Creates a new list of buttons for the Sticker interface and add them
     * to the canvas.
     * @param canvas The CanvasWindow of the main program.
     * @param image The image being processed.
     * @param l A double value used to correctly align the buttons on the canvas.
     * @param listb A list of the Sticker buttons.
     */

    public Sticker(CanvasWindow canvas, Image image, double l, List<Button> listb) {
        isPressed = false;

        this.canvas = canvas;
        this.image = image;
        this.l = l;
        this.listb = listb;
        for (Button b : listb) {
            canvas.remove(b);
            canvas.draw();
        }

        b1 = new Button("SmileyFace     ");
        b2 = new Button("FrownyFace     ");
        b3 = new Button("Back           ");

        b1.setPosition(image.getWidth() + l + 10, 0);
        b2.setPosition(image.getWidth() + l + 10, 25);
        b3.setPosition(image.getWidth() + l + 10, 50);

        List<Button> list = new ArrayList();
        list.add(b1);
        list.add(b2);
        list.add(b3);

        canvas.add(b1);
        canvas.add(b2);
        canvas.add(b3);
        canvas.draw();

        run(list);
    }

    /**
     * Enable the buttons in the list for the Sticker function.
     * @param list The list of the Sticker buttons.
     */

    public void run(List<Button> list) {
        b1.onClick(() -> addSticker("smile.png"));
        b2.onClick(() -> addSticker("cry.jpg"));
        b3.onClick(() -> {
            for (Button b : list) canvas.remove(b);
            canvas.draw();
        });
        b3.onClick(() -> {
            for (Button b : listb) canvas.add(b);
            canvas.draw();
        });
        b3.onClick(()->isPressed=true);
    }

    /**
     * Imports and creates the images for the stickers and add them to the canvas.
     * The sticker will only be added if the user click within the bounds of the
     * image so no sticker outside the image.
     *
     * @param position The position of the center of the sticker on the canvas.
     * @param stickerName The name of the desired type of sticker.
     */

    public void pic(Point position, String stickerName) {
        if (canvas.getElementAt(position) == image) {
            Image pic1 = new Image(0, 0, stickerName);
            pic1.setMaxHeight(80);
            pic1.setMaxWidth(80);
            pic1.setCenter(position);
            if(pic1.getX()+80<image.getWidth()&&
                    pic1.getY()+80<image.getHeight()&&
                    pic1.getX()>0&&
                    pic1.getY()>0){
                canvas.add(pic1);
                canvas.draw();
            }
        }
    }

    /**
     * Detect the location on the canvas where the user clicks and adds
     * a sticker at that location by calling pic().
     * @param stickerName The name of the desired type of sticker.
     */

    public void addSticker(String stickerName){
        canvas.onMouseDown(event -> {
            if (isPressed==false) {
                pic(event.getPosition(), stickerName);}});
    }

}
