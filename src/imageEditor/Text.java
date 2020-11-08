package imageEditor;

import comp127graphics.CanvasWindow;
import comp127graphics.GraphicsText;
import comp127graphics.Image;
import comp127graphics.ui.Button;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class is responsible for the Text function of the ImageEditor,
 * it asks the user to type in the color, size, and content of the text and
 * creates and adds the text to the canvas.
 */

public class Text {

    private CanvasWindow canvas;
    private Image image;
    private double l;
    private List<Button> listb;

    private Button b1;
    private Button b2;

    private String text;
    private GraphicsText txt;
    private getColor gc;
    private boolean isPressed;

    /**
     * Creates the Text interface with a list of buttons and adds them to the canvas.
     * @param canvas The CanvasWindow of the main program.
     * @param image The image being processed.
     * @param l A double value used to correctly align the buttons on the canvas.
     * @param listb A list of the Text buttons.
     */

    public Text(CanvasWindow canvas, Image image, double l,List<Button> listb){
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

        b1 = new Button("AddText    ");
        b2 = new Button("Back       ");

        b1.setPosition(image.getWidth()+l+10,0);
        b2.setPosition(image.getWidth()+l+10,25);

        List<Button> list = new ArrayList();
        list.add(b1);
        list.add(b2);

        canvas.add(b1);
        canvas.add(b2);
        canvas.draw();

        b1.onClick(()->addText());
        b2.onClick(()->{for (Button b : list) canvas.remove(b);canvas.draw();});
        b2.onClick(()->{for (Button b : listb) canvas.add(b);canvas.draw();});
        b2.onClick(()->isPressed=true);
    }

    /**
     * Asks for the user to type in the color, size, and content of the text
     * and creates the text; it then adds the text to the canvas where
     * the user clicks.
     */

    public void addText(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text color: ");
        String color = sc.next();
        Color c = gc.newColor(color);
        System.out.println("Enter text size: ");
        String input = sc.next();
        while (!isInteger(input)){
            System.out.println("Enter text size: ");
            input = sc.next();
        }
        int size = Integer.parseInt(input);
        System.out.println("Enter text: ");
        text = sc.next();
        txt = new GraphicsText(text);
        txt.setText(text);
        txt.setFillColor(c);
        txt.setFontSize(size);

        canvas.onMouseDown(event -> {
            if (!isPressed&&event.getPosition().getX()>0&&event.getPosition().getY()-txt.getHeight()>0&&
                    event.getPosition().getX()+txt.getWidth()<image.getWidth()&&
                    event.getPosition().getY()<image.getHeight()) {
                txt.setPosition(event.getPosition());}});

        canvas.add(txt);
        canvas.draw();
    }

    /**
     * To check whether the given text size is an integer,
     * the boolean isInteger returns true if the input is an integer,
     * and returns false if not.
     * Reference: https://stackoverflow.com/questions/5439529/determine-if-a-string-is-an-integer-in-java.
     */

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }
}
