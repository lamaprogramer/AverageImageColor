package net.iamaprogrammer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        try {
            int redSum = 0;
            int greenSum = 0;
            int blueSum = 0;
            int blankPixels = 0;

            int resolutionX = 1;
            int resolutionY = 1;


            File file = new File(Main.class.getResource("/red_dye.png").toURI());
            BufferedImage image = ImageIO.read(file);

            for (int y = 0; y < image.getHeight()-1; y+=resolutionY) {
                for (int x = 0; x < image.getWidth()-1; x+=resolutionX) {
                    int clr = image.getRGB(x, y);
                    int red = (clr & 0x00ff0000) >> 16;
                    int green = (clr & 0x0000ff00) >> 8;
                    int blue = clr & 0x000000ff;

                    if (red != 0 && green != 0 && blue != 0) {
                        redSum += red;
                        greenSum += green;
                        blueSum += blue;

                        System.out.println("Red Color value = " + red);
                        System.out.println("Green Color value = " + green);
                        System.out.println("Blue Color value = " + blue);
                    } else {
                        blankPixels++;
                    }
                }
            }
            redSum = redSum / (
                    (image.getHeight() / resolutionY)*
                    (image.getWidth() / resolutionX)
                    - blankPixels
            );

            greenSum = greenSum / (
                    (image.getHeight() / resolutionY)*
                    (image.getWidth() / resolutionX)
                    - blankPixels
            );
            blueSum = blueSum / (
                    (image.getHeight() / resolutionY)*
                    (image.getWidth() / resolutionX)
                    - blankPixels
            );

            System.out.println("Red Color value = " + redSum);
            System.out.println("Green Color value = " + greenSum);
            System.out.println("Blue Color value = " + blueSum);

        } catch (Exception ignored){
            System.out.println(ignored);
        }
    }
}