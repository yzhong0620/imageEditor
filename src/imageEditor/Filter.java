package imageEditor;

import comp127graphics.CanvasWindow;
import comp127graphics.Image;
import comp127graphics.ui.Button;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for the Filter function of the ImageEditor.
 */

public class Filter {

    private CanvasWindow canvas;
    private Image image;
    private double l;
    private List<Button> listb;

    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;

    private BlackAndWhite bw;
    private Negative ng;
    private Sepia sp;

    /**
     * Creates the filter interface and creates an instance for each filter class
     * and applies the effect to the image when the corresponding button is pressed.
     * @param canvas The CanvasWindow of the main program.
     * @param image The image being processed.
     * @param l A double value used to correctly align the buttons on the canvas.
     * @param listb A list of the Filter buttons.
     */

    public Filter(CanvasWindow canvas, Image image, double l,List<Button> listb) {
        this.canvas = canvas;
        this.image = image;
        this.l = l;
        this.listb = listb;
        for (Button b : listb){
            canvas.remove(b);
            canvas.draw();
        }

        b1 = new Button("BlackAndWhite    ");
        b2 = new Button("Negative         ");
        b3 = new Button("Sepia            ");
        b4 = new Button("Back             ");

        bw = new BlackAndWhite();
        ng = new Negative();
        sp = new Sepia();

        b1.setPosition(image.getWidth()+l+10,0);
        b2.setPosition(image.getWidth()+l+10,25);
        b3.setPosition(image.getWidth()+l+10,50);
        b4.setPosition(image.getWidth()+l+10,75);

        List<Button> list = new ArrayList();
        list.add(b1);
        list.add(b2);
        list.add(b3);
        list.add(b4);

        canvas.add(b1);
        canvas.add(b2);
        canvas.add(b3);
        canvas.add(b4);
        canvas.draw();

        draw(list);
    }

    /**
     * Detects which button the user presses and apply the filter effects or
     * remove the Filter interface from the canvas accordingly.
     * @param list The list of the Filter buttons.
     */

    public void draw(List<Button> list){
        b1.onClick(()->bw.effect(image.returnBufferedImage()));
        b2.onClick(()->ng.effect(image.returnBufferedImage()));
        b3.onClick(()->sp.effect(image.returnBufferedImage()));
        b4.onClick(()->{for (Button b : list) canvas.remove(b);canvas.draw();});
        b4.onClick(()->{for (Button b : listb) canvas.add(b);canvas.draw();});
    }

}