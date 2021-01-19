
import java.awt.Color;
import java.awt.image.BufferedImage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Volume_2inC
 */
public class enc {

    public long avg(BufferedImage bi) {
        int hg = bi.getWidth();
        int wd = bi.getHeight();
        BufferedImage img=new BufferedImage(bi.getWidth(), bi.getHeight(), bi.getType());
        long sum = 0, count = 0, r;
        Color pixel;
        for (int i = 0; i < hg; i++) {
            for (int j = 0; j < wd; j++) {
                pixel = new Color(bi.getRGB(i, j));
                r = (pixel.getRed() + pixel.getBlue() + pixel.getGreen()) / 3;
                sum += r;
                count++;
            }
        }
        return (sum / count);
    }
}
