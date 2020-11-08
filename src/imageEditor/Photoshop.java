package imageEditor;

import comp127graphics.CanvasWindow;
import comp127graphics.ui.Button;
import comp127graphics.Image;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * The main class that runs the imageEditor Program with a canvas window.
 */
public class Photoshop {

    private static final int CANVAS_WIDTH = 1000;
    private static final int CANVAS_HEIGHT = 1000;

    private CanvasWindow canvas;
    private Image image;
    private List<Button> listb;

    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private Button b5;
    private Button b6;

    /**
     * Opens a new CanvasWindow showing the image with the file name that the user inputs
     */
    public Photoshop() {
        canvas = new CanvasWindow("ImageEditor!", CANVAS_WIDTH, CANVAS_HEIGHT);
        fileImport();
    }

    /**
     * Creates a new ImageEditor/Photoshop to start the program.
     */
    public static void main(String[] args) {
        new Photoshop();
    }

    /**
     * fileImport() asks the user to type in the file name of the image
     * they want to edit, including the image format.
     * If the user enters a wrong file name, the program continues asking
     * until a correct name is given.
     */
    public void fileImport() {
        Boolean validInput = false;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter image name: ");
            String file = sc.next();
            if (file.endsWith("jpg") ||
                    file.endsWith("jpeg") ||
                    file.endsWith("png") ||
                    file.endsWith("tif") ||
                    file.endsWith("tiff")) {
                setUp(file);
                validInput=true;
            }
            else {
                System.out.println("please include valid file format; i.e. jpg, png, tif.");
            }
        }while(!validInput);
    }
    //        Scanner sc = new Scanner(System.in);
    //        System.out.println("Enter image name: ");
    //        String file = sc.next();
    //        File f = new File(file);
    //        boolean exists = f.getAbsoluteFile().exists();
    //        while (!exists) {
    //            System.out.println("Enter image name: ");
    //            file = sc.next();
    //            f = new File(file);
    //            exists = f.getAbsoluteFile().exists();
    //            System.out.println(exists);
    //        }
    //        setUp(file);

    /**
     * Saves the image as it looks currently on the canvas into a png file with
     * the file name entered by the user.
     */
    public void fileExport(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter image name to save (no need to include format): ");
        String fileName = sc.next();
        for (Button b : listb){
            canvas.remove(b);
        }
        canvas.draw();
        canvas.saveImage(fileName+".png",image.returnBufferedImage());
        for (Button b : listb){
            canvas.add(b);
        }
        canvas.draw();
    }

    /**
     * Imports, adds the image and the buttons for each function onto the canvas.
     * Saves a copy of the imported image with the Original class.
     * @param file the file name of the image that the user inputs.
     */
    public void setUp(String file){
        image = new Image(0, 0, file);
        canvas.add(image);
        Original orgCopy = new Original(image);

        b1 = new Button ("Filter      ");
        b1.setPosition(image.getWidth()+10,0);
        canvas.add(b1);
        double b1l = b1.getBounds().getWidth();

        b2 = new Button ("Drawing     ");
        b2.setPosition(image.getWidth()+10,25);
        double b2l = b2.getBounds().getWidth();
        canvas.add(b2);

        b3 = new Button ("Sticker     ");
        b3.setPosition(image.getWidth()+10,50);
        canvas.add(b3);
        double b3l = b3.getBounds().getWidth();

        b4 = new Button ("Text        ");
        b4.setPosition(image.getWidth()+10,75);
        double b4l = b4.getBounds().getWidth();
        canvas.add(b4);

        b5 = new Button ("Reset       ");
        b5.setPosition(image.getWidth()+10,100);
        double b5l = b5.getBounds().getWidth();
        canvas.add(b5);

        b6 = new Button ("Save Image  ");
        b6.setPosition(image.getWidth()+10,125);
        double b6l = b6.getBounds().getWidth();
        canvas.add(b6);


        listb = new ArrayList();
        listb.add(b1);
        listb.add(b2);
        listb.add(b3);
        listb.add(b4);
        listb.add(b5);
        listb.add(b6);

        List list = new ArrayList();
        list.add(b1l);
        list.add(b2l);
        list.add(b3l);
        list.add(b4l);
        list.add(b5l);
        list.add(b6l);
        double max = (double) Collections.max(list);

        canvas.draw();

        b1.onClick(()->new Filter(canvas,image,max,listb));
        b2.onClick(()->new Drawing(canvas,image,max,listb));
        b3.onClick(()->new Sticker(canvas,image,max,listb));
        b4.onClick(()->new Text(canvas,image,max,listb));
        b5.onClick(()->{
            orgCopy.effect(image.returnBufferedImage());canvas.removeAll();setUp(file);});
        b6.onClick(()->fileExport());

    };




}