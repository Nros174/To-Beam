import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class CreateBG extends JPanel implements Runnable {
    private BufferedImage buffer = new BufferedImage(1281, 721, BufferedImage.TYPE_INT_ARGB);
    private Graphics2D g2 = buffer.createGraphics();

    CreateBG() {
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        GradientPaint GP = new GradientPaint(0, 0, new Color(247, 202, 201), 0, 720, new Color(145, 168, 209));
        g2.setPaint(GP);
        g2.fillRect(0, 0, 1280, 720);

        RandomPlot(g2, 150, new Color(255, 250, 250, 90));
        RandomSparkle(g2, 100, new Color(255, 250, 250,100));

        g.drawImage(buffer, 0, 0, null);
    }

    @Override
    public void run() {
        while (true) {
            repaint();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void RandomPlot(Graphics g, int cnt, Color color) {
        g.setColor(color);
        Random rand = new Random();
        for (int i = 0; i < cnt; i++) {
            int xRandom = rand.nextInt(1279);
            int yRandom = rand.nextInt(719);
            int sizeRandom = rand.nextInt(5) + 1;
            g.fillOval(xRandom, yRandom, sizeRandom, sizeRandom);
        }
    }

    public void RandomSparkle(Graphics g, int cnt, Color color) {
        g.setColor(color);
        Random rand = new Random();
        for (int i = 0; i < cnt; i++) {
            
            int xRandom = rand.nextInt(1279);
            int yRandom = rand.nextInt(719);
            int sizeRandom = rand.nextInt(5) + 1;
            g.drawLine(xRandom, yRandom-sizeRandom,xRandom, yRandom+sizeRandom);
            g.drawLine(xRandom-sizeRandom, yRandom,xRandom+sizeRandom, yRandom);
        }
    }
}
