Comp127 Project Image Editor
======

Instructions:
1. Put the image into the src folder.
2. Run the code and enter the name of the image when asked. Don't forget to add the .jpg or .png at the end of the image name.
After typing the image name, the user will see a canvas with the image on the left and a list of buttons on the right.

FILTER: click on the filter button, all other buttons will be removed and a group of different filter buttons (“BlackAndWhite”, “Negative”, and “Sepia”) and a back button will be displayed on the canvas. The user will click on one of the filter buttons, see the effect, and then click the back button to return to the previous screen.

DRAWING: click on the drawing button, all buttons will be removed and an addDrawing button and a back button will be displayed on the canvas. To add a drawing to the image, the user needs to click on the addDrawing button first. After entering a color when asked, the user will be able to draw or click the return button to return to the previous screen. The drawing is only available within the bounds of the image. If the color given by the user is not a default one or is misspelled, the color will be set as black automatically.

STICKER: click on the sticker button, all buttons will be removed and a couple of pre-set stickers ("SmileyFace" and "FrownyFace") and a back button will be displayed on the canvas. The user can click on the sticker they wish to use, and then click on the image where they want the sticker to be placed. Stickers could only be put within the bounds of the image and the whole sticker needs to be on the image so do not click too close to the sides of the image. Remember where you click on the image will be the center of the sticker rather than its upper-left corner.

TEXT: click on the text button, all buttons will be removed and an addText button and a back button will be displayed on the canvas. To add text to the image, the user needs to click on the addText button first. After entering text color, text size (which needs to be an integer), and the text, the user will be able to add text or click the return button to return to the previous screen. If the color given by the user is not a default one or is misspelled, the color will be set as black automatically. Also, remember to enter one line of words only. There should be NO SPACE between words or only the first word will be printed.

RESET: click on the reset button, all effects added will be removed and the original image will appear.

SAVE IMAGE: click on the save image button, the program will ask for a text input to name the file, then it will save the image as it currently looks on the canvas in PNG format with the given name.

Limitations:
1. We try to check whether the user gives a valid image name by using the .exists() method and it did not work well. This part is commented out in the Photoshop class. Therefore, we can only check if the image name ends with .jpg, .png, and etc., and if the image does not exist, there will be an error message.
