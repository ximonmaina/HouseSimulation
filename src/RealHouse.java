
import java.awt.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.io.FileNotFoundException;
import java.util.Formatter;

public class RealHouse extends java.applet.Applet
        implements ActionListener // A graphics demo applet that draws a simple house.
{

    Graphics paint;
    Color blue = new Color(244, 76, 65);
    Graphics g;
    Canvas c;
    Button b2;
    Graphics2D g2;
    private  Formatter output; //object to write to file
    
    //set text coordinates
    int width=0;
    int height=0;
    int hx, hy; // The x and y coordinates of the upper left
    // corner of the house.
    int hwidth, hheight;  // The house width and height.

    int increaseYCoord = 300; //increase y-coordinate
    //base colors
    int base1 = 0;
    int base2 = 0;
    int base3 = 0;

    //
//    roof color
    int roof1 = 0;
    int roof2 = 0;
    int roof3 = 0;

    int flower1 = 0;
    int flower2 = 0;
    int flower3 = 0;

    //method to generate random color
    public Color randomColor(String type) {

        int R = (int) (Math.random() * 256);
        int G = (int) (Math.random() * 256);
        int B = (int) (Math.random() * 256);

        Color color = new Color(R, G, B);
        if (type.equals("flowers")) {
            flower1 = R;
            flower2 = G;
            flower3 = G;
        }

        if (type.equals("base")) {
            base1 = R;
            base2 = G;
            base3 = B;
        }
        if (type.equals("triangle")) {
            roof1 = R;
            roof2 = G;
            roof3 = B;
        }

        return color;

    }

    //initialize the program
    public void init() {
        c = new Canvas();
        c.setSize(1000, 1000);
        add(c);
        g = c.getGraphics();
        g2 = (Graphics2D) c.getGraphics();

        b2 = new Button("House");
        b2.addActionListener(this);
        add(b2);
       
    }

    //listen for action
    public void actionPerformed(ActionEvent event) {
        Object cause = event.getSource();

        if (cause == b2) // Set background.
        {
             openOutputFile();
            
            g.setColor(Color.white);
            g.fillRect(0, 0, 1000, 1000);

            //random house size generator
            int max = 200;
            int min = 50;
            int length = 0;
            boolean check = true;
            for (; check;) {
                length = (int) (Math.random() * 1000);
                if (length >= min && length <= max) {
                    check = false;
                }
            }

            hwidth = length;
            hheight = length  + (length/4);

            hx = 300;
            hy = 90; // x,y coordinates for upper
            // left corner of the house.

            g.setColor(randomColor("flower")); // Color of front of house.
            g.fillRect(hx, hy, hwidth, hheight);
            // Draw front of house.
            g.setColor(randomColor("triangle")); // Color of roof.
            g.fillRect(hx - (hwidth / 20), hy-(hheight / 3),
                    hwidth + (hwidth / 10), hheight / 3);
            // Roof with some overhang.
            g.setColor(randomColor("flower")); // Color for door and window.
            g.fillRect(hx + (2 * hwidth / 3), hy + hheight / 4,
                    hwidth / 4, (hheight *3)/4); // Draw the door.
            g.fillRect(hx + (hwidth / 8), hy + hheight / 4,
                    hwidth / 4, hheight / 4); // Draw the window.
            g.setColor(randomColor("base")); // Colr of chimney.

            
            //color for the petals
            Color petals = randomColor("flower");
            Color leaves = randomColor("triangle");
            //loop to draw more flowers
            for (int space = 0; space <= 400;) {

                //Draw flower
                g2 = (Graphics2D) g;

                //Draw stem of the flower
                //to draw a stem, I used rectangle method.
                Rectangle stem = new Rectangle((290 + space), (200 + increaseYCoord), 5, 100);
                g2.setColor(Color.GRAY);
                g2.fill(stem);

                Ellipse2D.Double petal1 = new Ellipse2D.Double((240 + space), (180 + increaseYCoord), 35, 35);
                g2.setColor(petals);
                g2.fill(petal1);
                Ellipse2D.Double petal2 = new Ellipse2D.Double((250 + space), 155 + increaseYCoord, 35, 35);
                g2.setColor(petals);
                g2.fill(petal2);
                Ellipse2D.Double petal3 = new Ellipse2D.Double((274 + space), 145 + increaseYCoord, 35, 35);
                g2.setColor(petals);
                g2.fill(petal3);
                Ellipse2D.Double petal4 = new Ellipse2D.Double((299 + space), 154 + increaseYCoord, 35, 35);
                g2.setColor(petals);
                g2.fill(petal4);
                Ellipse2D.Double petal5 = new Ellipse2D.Double((305 + space), 182 + increaseYCoord, 35, 35);
                g2.setColor(petals);
                g2.fill(petal5);
                Ellipse2D.Double petal6 = new Ellipse2D.Double((285 + space), 203 + increaseYCoord, 35, 35);
                g2.setColor(petals);
                g2.fill(petal6);
                Ellipse2D.Double petal7 = new Ellipse2D.Double((259 + space), 200 + increaseYCoord, 32, 32);
                g2.setColor(petals);
                g2.fill(petal7);

//Draw central part of the flower using Ellipse
                Ellipse2D.Double flower = new Ellipse2D.Double((270 + space), 172 + increaseYCoord, 40, 40);
                g2.setColor(randomColor("flowers"));
                g2.fill(flower);

//Draw leaf of the flower
//TO draw a leaf, I used polygon so that I can have different points to construct a leaf.
                Polygon leaf1 = new Polygon();
                leaf1.addPoint((293 + space), 276 + increaseYCoord);
                leaf1.addPoint((270 + space), 280 + increaseYCoord);
                leaf1.addPoint((274 + space), 275 + increaseYCoord);
                leaf1.addPoint((260 + space), 278 + increaseYCoord);
                leaf1.addPoint((266 + space), 274 + increaseYCoord);
                leaf1.addPoint((246 + space), 270 + increaseYCoord);
                leaf1.addPoint((266 + space), 270 + increaseYCoord);
                leaf1.addPoint((260 + space), 265 + increaseYCoord);
                g2.setColor(leaves);
                g2.fill(leaf1);

//Draw another leaf
                Polygon leaf2 = new Polygon();
                leaf2.addPoint((295 + space), 258 + increaseYCoord);
                leaf2.addPoint((308 + space), 250 + increaseYCoord);
                leaf2.addPoint((303 + space), 254 + increaseYCoord);
                leaf2.addPoint((325 + space), 248 + increaseYCoord);
                leaf2.addPoint((320 + space), 253 + increaseYCoord);
                leaf2.addPoint((342 + space), 248 + increaseYCoord);
                leaf2.addPoint((322 + space), 256 + increaseYCoord);
                leaf2.addPoint((335 + space), 259 + increaseYCoord);
                g2.setColor(leaves);
                g2.fill(leaf2);
                space += 100;
            }
            
            //write text to file
           output.format("House simulation %n");
           output.format("Length: %d%n",hheight);
           output.format("Width: %d%n", hwidth);
           output.format("Base color: rgb(%d %d %d)%n",base1,base2,base3);
           output.format("Flower color: (%d %d %d)",flower1,flower2,flower2);
           
           output.flush();
           
            closeFiles();
        }
    }
    
    public  void openOutputFile(){
           /*Open file to write to*/
        try{
          output = new Formatter("/home/greendelta/NetBeansProjects/HouseSimulation/housesimulation.txt"); //open file
        }
        catch (FileNotFoundException fileNotFounfException){
           System.err.println("Error opening file two. Terminating");
           System.exit(1);
        }
    }
    
    //close files
    public void closeFiles(){
        if(output != null){
           output.close();
        }
        
        
    }

}
