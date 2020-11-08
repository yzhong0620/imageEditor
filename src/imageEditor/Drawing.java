package imageEditor;

import comp127graphics.CanvasWindow;
import comp127graphics.Ellipse;
import comp127graphics.Point;
import comp127graphics.Image;
import comp127graphics.ui.Button;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class is responsible for the Drawing function of the ImageEditor.
 */

public class Drawing {

    private CanvasWindow canvas;
    private Image image;
    private double l;
    private List<Button> listb;

    private Button b1;
    private Button b2;

    private getColor gc;
    private boolean isPressed;

    /**
     * Creates the Drawing function interface and list of buttons; detects which
     * button is pressed and allows to draw or remove the buttons from the canvas
     * accordingly.
     * @param canvas The CanvasWindow of the main program.
     * @param image The image being processed.
     * @param l A double value used to correctly align the buttons on the canvas.
     * @param listb A list of the Drawing buttons.
     */

    public Drawing(CanvasWindow canvas, Image image, double l,List<Button> listb){
        gc = new getColor();
        isPressed = false;

        this.canvas = canvas;
        this.image = image;
        this.l = l;
        this.listb = listb;
        for (Button b : listb){
            canvas.remove(b);
            canvas.draw();
        }

        b1 = new Button("AddDrawing    ");
        b2 = new Button("Back          ");

        b1.setPosition(image.getWidth()+l+10,0);
        b2.setPosition(image.getWidth()+l+10,25);

        List<Button> list = new ArrayList();
        list.add(b1);
        list.add(b2);

        canvas.add(b1);
        canvas.add(b2);
        canvas.draw();

        b1.onClick(()->dr());
        b2.onClick(()->{for (Button b : list) canvas.remove(b);canvas.draw();});
        b2.onClick(()->{for (Button b : listb) canvas.add(b);canvas.draw();});
        b2.onClick(()->isPressed=true);
    }

    /**
     * Creates a circle at the position with the set color.
     * @param position The location on the canvas where the user
     *                 press and drag the mouse.
     * @param color The color of the drawing.
     */

    public void paint(Point position, Color color){
        if (canvas.getElementAt(position)!=null) {
            Ellipse circle = new Ellipse(0, 0, 7, 7);
            circle.setStrokeColor(color);
            circle.setFillColor(color);
            circle.setCenter(position);
            canvas.add(circle);
            canvas.draw();
        }
    }

    /**
     * Asks the user to type in the color and set it for their drawing pen;
     * detects the location on the canvas where the user press and drag.
     */

    public void dr(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter drawing color: ");
        String color = sc.next();
        Color c = gc.newColor(color);

        canvas.onMouseDown(event -> {
            if (isPressed==false) {
                paint(event.getPosition(),c);}});
        canvas.onDrag(event -> {
            if (isPressed==false) {
                paint(event.getPosition(),c);}});
    }

}
