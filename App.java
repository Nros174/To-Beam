import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App extends JPanel implements ActionListener {
    private JFrame F;
    private ImageIcon icon, img1, img2;
    private JLabel myLabel, Final;
    private CreateBG BG;
    private Font Font;
    private JButton yesButton, noButton;
    private int wY = 150;
    private int hY = 120;
    private int wN = 150;
    private int hN = 120;

    public App() {
        BG = new CreateBG();
        Font = new Font("kamook01", Font.PLAIN, 40);
        icon = new ImageIcon("img\\heart.png");
        img1 = new ImageIcon(this.getClass().getResource("img\\heart.gif"));
        img2 = new ImageIcon("img\\Fin.jpg");
        yesButton = new JButton("Yes");
        noButton = new JButton("No!!");
        myLabel = new JLabel();
        Final = new JLabel();

        myLabel.setIcon(img1);
        myLabel.setText("I miss you ,Can you come to me??");
        myLabel.setFont(Font);
        myLabel.setForeground(Color.WHITE);
        myLabel.setHorizontalTextPosition(JLabel.CENTER);
        myLabel.setVerticalTextPosition(JLabel.BOTTOM);
        myLabel.setVerticalAlignment(JLabel.CENTER);
        myLabel.setHorizontalAlignment(JLabel.CENTER);

        Final.setIcon(img2);
        Final.setForeground(Color.WHITE);
        Final.setText("Yeah!!! I will be waiting for you at my room Don't rush, I can wait! See you!");
        Final.setFont(Font);
        Final.setHorizontalTextPosition(JLabel.CENTER);
        Final.setVerticalTextPosition(JLabel.BOTTOM);
        Final.setVerticalAlignment(JLabel.CENTER);
        Final.setHorizontalAlignment(JLabel.CENTER);

        yesButton.setPreferredSize(new Dimension(wY, hY));
        noButton.setPreferredSize(new Dimension(wN, hN));
        yesButton.addActionListener(this);
        noButton.addActionListener(this);
        yesButton.setFocusable(false);
        noButton.setFocusable(false);
        yesButton.setBorder(BorderFactory.createEtchedBorder());
        noButton.setBorder(BorderFactory.createEtchedBorder());
        yesButton.setForeground(Color.WHITE);
        yesButton.setBackground(new Color(253, 138, 138));
        noButton.setForeground(Color.WHITE);
        noButton.setBackground(new Color(138, 253, 138));

        F = new JFrame();
        F.setTitle("Beam to P'Bank<3");
        F.setSize(1280, 720);
        F.setIconImage(icon.getImage());
        F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // F.setResizable(false);
        F.setLocationRelativeTo(null);

        BG.add(myLabel);
        BG.add(yesButton);
        BG.add(noButton);

        F.add(BG);
        F.setVisible(true);
    }

    void addSize() {
        yesButton.setVisible(true);
        noButton.setVisible(true);
        wN -= 5;
        hN -= 5;
        wY += 5;
        hY += 5;

        yesButton.setPreferredSize(new Dimension(wY, hY));
        noButton.setPreferredSize(new Dimension(wN, hN));

        BG.add(yesButton);
        BG.add(noButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == yesButton) {
            myLabel.setVisible(false);
            yesButton.setVisible(false);
            noButton.setVisible(false);
            BG.add(Final);
        }
        if (e.getSource() == noButton) {
            yesButton.setVisible(false);
            noButton.setVisible(false);
            addSize();
        }
    }

}