
//import javax.imageio.ImageIO;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.BorderLayout;
//import java.awt.Color;
import java.awt.Color;

//import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
//import javax.swing.border.EmptyBorder;

//import jdk.javadoc.internal.doclets.formats.html.resources.standard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
//import java.awt.Graphics;
//import java.awt.Image;
//import java.awt.Toolkit;
//import java.awt.Toolkit;

public class GUI implements ActionListener {

    private JFrame frame;
    private static JFrame frameSplit;
    private ImagePanel panel;
    private JPanel panelSplit;
    private static JLabel myHandTitle;
    private static JLabel dealerHandTitle;
    private static JLabel recomendation;
    private static JLabel runningCount;
    private static JLabel trueCount;
    private static JLabel mesc;
    private static Counter c;
    private JTextField deckIn;

    private static boolean isSplit = false;
    private JTextField myHandSplit1In;
    private JTextField myHandSplit2In;
    private static boolean runSplitOnce = false;

    private static JLabel myHandSplit1;
    private static JLabel myHandSplit2;
    private static JLabel splitRect1;
    private static JLabel splitRect2;
    private static int splitHandCount1;
    private static int splitHandCount2;
    private static Counter sp1;
    private static Counter sp2;

    JLabel backgroundImg;

    JButton myHand1;
    JButton myHand2;
    JButton myHand3;
    JButton myHand4;
    JButton myHand5;
    JButton myHand6;
    JButton myHand7;
    JButton myHand8;
    JButton myHand9;
    JButton myHand10;

    JButton DealerHand1;
    JButton DealerHand2;
    JButton DealerHand3;
    JButton DealerHand4;
    JButton DealerHand5;
    JButton DealerHand6;
    JButton DealerHand7;
    JButton DealerHand8;
    JButton DealerHand9;
    JButton DealerHand10;

    JButton card1;
    JButton card2;
    JButton card3;
    JButton card4;
    JButton card5;
    JButton card6;
    JButton card7;
    JButton card8;
    JButton card9;
    JButton card10;

    JButton newHandButton;

    public GUI() {

        // import images

        Icon twoOfSpades = new ImageIcon("lib\\CardImgs\\2SpadesSmall.png");
        Icon threeOfSpades = new ImageIcon("lib\\CardImgs\\3SpadesSmall.png");
        Icon fourOfSpades = new ImageIcon("lib\\CardImgs\\4SpadesSmall.png");
        Icon fiveOfSpades = new ImageIcon("lib\\CardImgs\\5SpadesSmall.png");
        Icon sixOfSpades = new ImageIcon("lib\\CardImgs\\6SpadesSmall.png");
        Icon sevenOfSpades = new ImageIcon("lib\\CardImgs\\7SpadesSmall.png");
        Icon eightOfSpades = new ImageIcon("lib\\CardImgs\\8SpadesSmall.png");
        Icon nineOfSpades = new ImageIcon("lib\\CardImgs\\9SpadesSmall.png");
        Icon tenOfSpades = new ImageIcon("lib\\CardImgs\\10SpadesSmall.png");
        Icon aceOfSpades = new ImageIcon("lib\\CardImgs\\ASpadesSmall.png");

        Icon twoOfHearts = new ImageIcon("lib\\CardImgs\\2HeartsSmall.png");
        Icon threeOfHearts = new ImageIcon("lib\\CardImgs\\3HeartsSmall.png");
        Icon fourOfHearts = new ImageIcon("lib\\CardImgs\\4HeartsSmall.png");
        Icon fiveOfHearts = new ImageIcon("lib\\CardImgs\\5HeartsSmall.png");
        Icon sixOfHearts = new ImageIcon("lib\\CardImgs\\6HeartsSmall.png");
        Icon sevenOfHearts = new ImageIcon("lib\\CardImgs\\7HeartsSmall.png");
        Icon eightOfHearts = new ImageIcon("lib\\CardImgs\\8HeartsSmall.png");
        Icon nineOfHearts = new ImageIcon("lib\\CardImgs\\9HeartsSmall.png");
        Icon tenOfHearts = new ImageIcon("lib\\CardImgs\\10HeartsSmall.png");
        Icon aceOfHearts = new ImageIcon("lib\\CardImgs\\AHeartsSmall.png");

        Icon newHandButtonIcon = new ImageIcon("lib\\CardImgs\\newHandButtonBrown.png");

        File bgImgFile = new File("lib\\CardImgs\\Background with patterns.png");

        BufferedImage bgImg = new BufferedImage(800, 800, BufferedImage.TYPE_INT_ARGB);
        try {
            bgImg = ImageIO.read(bgImgFile);
        } catch (IOException e) {
        }

        // Frame that gets thing put into it
        frame = new JFrame();

        // create frame for when you need to split
        frameSplit = new JFrame();

        // Create a buttons for my hand
        // 2
        myHand1 = new JButton(twoOfSpades);
        myHand1.addActionListener(this);
        myHand1.setSize(75, 125);
        myHand1.setLocation(10, 40);

        myHand2 = new JButton(threeOfSpades);
        myHand2.addActionListener(this);
        myHand2.setSize(75, 125);
        myHand2.setLocation(90, 40);

        myHand3 = new JButton(fourOfSpades);
        myHand3.addActionListener(this);
        myHand3.setSize(75, 125);
        myHand3.setLocation(170, 40);

        myHand4 = new JButton(fiveOfSpades);
        myHand4.addActionListener(this);
        myHand4.setSize(75, 125);
        myHand4.setLocation(250, 40);

        myHand5 = new JButton(sixOfSpades);
        myHand5.addActionListener(this);
        myHand5.setSize(75, 125);
        myHand5.setLocation(330, 40);

        myHand6 = new JButton(sevenOfSpades);
        myHand6.addActionListener(this);
        myHand6.setSize(75, 125);
        myHand6.setLocation(410, 40);

        myHand7 = new JButton(eightOfSpades);
        myHand7.addActionListener(this);
        myHand7.setSize(75, 125);
        myHand7.setLocation(490, 40);

        myHand8 = new JButton(nineOfSpades);
        myHand8.addActionListener(this);
        myHand8.setSize(75, 125);
        myHand8.setLocation(570, 40);

        myHand9 = new JButton(tenOfSpades);
        myHand9.addActionListener(this);
        myHand9.setSize(75, 125);
        myHand9.setLocation(650, 40);

        myHand10 = new JButton(aceOfSpades);
        myHand10.addActionListener(this);
        myHand10.setSize(75, 125);
        myHand10.setLocation(730, 40);

        // buttons for dealers hand
        DealerHand1 = new JButton(twoOfHearts);
        DealerHand1.addActionListener(this);
        DealerHand1.setSize(75, 125);
        DealerHand1.setLocation(10, 190);

        DealerHand2 = new JButton(threeOfHearts);
        DealerHand2.addActionListener(this);
        DealerHand2.setSize(75, 125);
        DealerHand2.setLocation(90, 190);

        DealerHand3 = new JButton(fourOfHearts);
        DealerHand3.addActionListener(this);
        DealerHand3.setSize(75, 125);
        DealerHand3.setLocation(170, 190);

        DealerHand4 = new JButton(fiveOfHearts);
        DealerHand4.addActionListener(this);
        DealerHand4.setSize(75, 125);
        DealerHand4.setLocation(250, 190);

        DealerHand5 = new JButton(sixOfHearts);
        DealerHand5.addActionListener(this);
        DealerHand5.setSize(75, 125);
        DealerHand5.setLocation(330, 190);

        DealerHand6 = new JButton(sevenOfHearts);
        DealerHand6.addActionListener(this);
        DealerHand6.setSize(75, 125);
        DealerHand6.setLocation(410, 190);

        DealerHand7 = new JButton(eightOfHearts);
        DealerHand7.addActionListener(this);
        DealerHand7.setSize(75, 125);
        DealerHand7.setLocation(490, 190);

        DealerHand8 = new JButton(nineOfHearts);
        DealerHand8.addActionListener(this);
        DealerHand8.setSize(75, 125);
        DealerHand8.setLocation(570, 190);

        DealerHand9 = new JButton(tenOfHearts);
        DealerHand9.addActionListener(this);
        DealerHand9.setSize(75, 125);
        DealerHand9.setLocation(650, 190);

        DealerHand10 = new JButton(aceOfHearts);
        DealerHand10.addActionListener(this);
        DealerHand10.setSize(75, 125);
        DealerHand10.setLocation(730, 190);

        // buttons for other cards on table
        card1 = new JButton(twoOfSpades);
        card1.addActionListener(this);
        card1.setSize(75, 125);
        card1.setLocation(10, 340);

        card2 = new JButton(threeOfHearts);
        card2.addActionListener(this);
        card2.setSize(75, 125);
        card2.setLocation(90, 340);

        card3 = new JButton(fourOfSpades);
        card3.addActionListener(this);
        card3.setSize(75, 125);
        card3.setLocation(170, 340);

        card4 = new JButton(fiveOfHearts);
        card4.addActionListener(this);
        card4.setSize(75, 125);
        card4.setLocation(250, 340);

        card5 = new JButton(sixOfSpades);
        card5.addActionListener(this);
        card5.setSize(75, 125);
        card5.setLocation(330, 340);

        card6 = new JButton(sevenOfHearts);
        card6.addActionListener(this);
        card6.setSize(75, 125);
        card6.setLocation(410, 340);

        card7 = new JButton(eightOfSpades);
        card7.addActionListener(this);
        card7.setSize(75, 125);
        card7.setLocation(490, 340);

        card8 = new JButton(nineOfHearts);
        card8.addActionListener(this);
        card8.setSize(75, 125);
        card8.setLocation(570, 340);

        card9 = new JButton(tenOfSpades);
        card9.addActionListener(this);
        card9.setSize(75, 125);
        card9.setLocation(650, 340);

        card10 = new JButton(aceOfHearts);
        card10.addActionListener(this);
        card10.setSize(75, 125);
        card10.setLocation(730, 340);

        // button that makes a new hand
        newHandButton = new JButton(newHandButtonIcon);
        newHandButton.addActionListener(this);
        newHandButton.setSize(100, 100);
        newHandButton.setLocation(350, 500);
        newHandButton.setBorder(BorderFactory.createEmptyBorder());

        // text feild for entering deck
        deckIn = new JTextField(10);
        deckIn.setSize(50, 30);
        deckIn.setLocation(100, 650);

        // text feilds for split in, maybe change to buttons if you really hate yourself
        myHandSplit1In = new JTextField(10);
        myHandSplit1In.setSize(50, 30);
        myHandSplit1In.setLocation(50, 100);

        myHandSplit2In = new JTextField(10);
        myHandSplit2In.setSize(50, 30);
        myHandSplit2In.setLocation(250, 100);

        // crate split label
        myHandSplit1 = new JLabel("Your Hand 1: 0");
        myHandSplit1.setSize(100, 100);
        myHandSplit1.setLocation(10, 0);

        myHandSplit2 = new JLabel("Your Hand 2: 0");
        myHandSplit2.setSize(100, 100);
        myHandSplit2.setLocation(250, 0);

        splitRect1 = new JLabel("What you should do");
        splitRect1.setSize(100, 100);
        splitRect1.setLocation(50, 200);

        splitRect2 = new JLabel("What you should do");
        splitRect2.setSize(100, 100);
        splitRect2.setLocation(250, 200);

        // create label
        myHandTitle = new JLabel("Your Hand: 0");
        myHandTitle.setSize(400, 400);
        myHandTitle.setLocation(350, -175);
        myHandTitle.setForeground(Color.white);

        dealerHandTitle = new JLabel("Dealer Hand: 0");
        dealerHandTitle.setSize(400, 400);
        dealerHandTitle.setLocation(350, -25);
        dealerHandTitle.setForeground(Color.white);

        runningCount = new JLabel("Running count: 0");
        runningCount.setSize(300, 300);
        runningCount.setLocation(600, 400);
        runningCount.setForeground(Color.white);

        trueCount = new JLabel("True count: 0.0");
        trueCount.setSize(300, 300);
        trueCount.setLocation(600, 450);
        trueCount.setForeground(Color.white);

        mesc = new JLabel("There are 0 cards used in a deck of 0.");
        mesc.setSize(600, 300);
        mesc.setLocation(100, 560);
        mesc.setForeground(Color.white);

        JLabel title = new JLabel("Cards on Table:");
        title.setSize(400, 400);
        title.setLocation(350, 125);
        title.setForeground(Color.white);

        JLabel deckSet = new JLabel("Set Number of Decks");
        deckSet.setSize(400, 400);
        deckSet.setLocation(70, 435);
        deckSet.setForeground(Color.white);

        recomendation = new JLabel("Recomendation");
        recomendation.setSize(200, 300);
        recomendation.setLocation(90, 395);
        recomendation.setForeground(Color.white);

        // create new split pop up panel
        panelSplit = new JPanel();
        panelSplit.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panelSplit.setLayout(new GroupLayout(panelSplit));

        // Panel holds things in frame
        panel = new ImagePanel(bgImg);
        // create border for panel
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));

        // create panel layout (rows, colums)
        // panel.setLayout(new GridLayout(4, 6));

        // group layout
        panel.setLayout(new GroupLayout(panel));

        // add button to panel
        panel.add(myHand1);
        panel.add(myHand2);
        panel.add(myHand3);
        panel.add(myHand4);
        panel.add(myHand5);
        panel.add(myHand6);
        panel.add(myHand7);
        panel.add(myHand8);
        panel.add(myHand9);
        panel.add(myHand10);

        panel.add(DealerHand1);
        panel.add(DealerHand2);
        panel.add(DealerHand3);
        panel.add(DealerHand4);
        panel.add(DealerHand5);
        panel.add(DealerHand6);
        panel.add(DealerHand7);
        panel.add(DealerHand8);
        panel.add(DealerHand9);
        panel.add(DealerHand10);

        panel.add(card1);
        panel.add(card2);
        panel.add(card3);
        panel.add(card4);
        panel.add(card5);
        panel.add(card6);
        panel.add(card7);
        panel.add(card8);
        panel.add(card9);
        panel.add(card10);

        // add label
        // panel.add(label);
        panel.add(myHandTitle);
        panel.add(dealerHandTitle);
        panel.add(title);
        panel.add(recomendation);
        panel.add(runningCount);
        panel.add(trueCount);
        panel.add(mesc);
        panel.add(deckSet);

        // add label to panel split and text feilds
        panelSplit.add(myHandSplit1);
        panelSplit.add(myHandSplit2);
        panelSplit.add(myHandSplit1In);
        panelSplit.add(myHandSplit2In);
        panelSplit.add(splitRect1);
        panelSplit.add(splitRect2);

        myHandSplit1In.addActionListener(this);
        myHandSplit2In.addActionListener(this);

        // new Hand button
        panel.add(newHandButton);

        // text feild
        panel.add(deckIn);
        deckIn.addActionListener(this);

        // ---All is very standard set up for one frame
        // add frame with constrants
        frame.add(panel, BorderLayout.CENTER);
        // set what happens when you clase window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set Title
        frame.setTitle("BlackJack Wizard");
        // make window fit prefured size
        frame.setSize(830, 800);
        // set panel color
        // panel.setBackground(Color.red);
        // make window visable
        frame.setVisible(true);

        // set background to img

        // add frame with constrants
        frameSplit.add(panelSplit, BorderLayout.CENTER);
        // don't close all windows on close
        frameSplit.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // set Title
        frameSplit.setTitle("Split Pop-up");
        // make window fit prefured size
        frameSplit.setSize(400, 400);
        // make window visable
        frameSplit.setVisible(isSplit);

        // setup counters for split
        sp1 = new Counter();
        sp2 = new Counter();

    }

    /** Enter the counter object to be refranced by the GUI */
    public static void enterDeck(Counter c1) {
        c = c1;
    }

    /** Run this to update GUI values */
    public static void updateWindow() {

        // reset most labels and values back to 0
        myHandTitle.setText("Your Hand: " + c.getYourHand());
        dealerHandTitle.setText("Dealer Hand: " + c.getTheirHand());
        runningCount.setText("Running count: " + c.getRunningCount());
        trueCount.setText("True count: " + c.getTrueCount());
        mesc.setText("There are " + c.getCurrentCardCount() + " cards used in a deck of " + c.getCardNum() + ". "
                + c.HowAmIDoing());

        // reports basic stratagy + divations
        if (c.illust18().equals("")) {
            recomendation.setText(c.basicStrat(c.getYourHand(), c.getTheirHand()));
        } else {
            System.out.println(c.illust18());
            recomendation.setText(c.illust18());
        }

        // basic strat for both spit hands, runs two seperate counters to find what to
        // do
        if (c.basicStrat(c.getYourHand(), c.getTheirHand()).equals("Split") && c.getCardsUsed() > 2) {
            // create new window if it says to split
            isSplit = true;
            if (runSplitOnce == false) {
                // code that is run once
                if (c.getYourHand() == 12) {
                    splitHandCount1 = 11;
                    splitHandCount2 = 11;
                    sp1.setAceFlag(true);
                    sp2.setAceFlag(true);
                    sp1.addCard("am");
                    sp2.addCard("am");
                } else {
                    splitHandCount1 = c.getYourHand() / 2;
                    splitHandCount2 = c.getYourHand() / 2;
                    sp1.setAceFlag(false);
                    sp2.setAceFlag(false);
                    sp1.addCard(c.getYourHand() / 2 + "m");
                    sp2.addCard(c.getYourHand() / 2 + "m");
                }
                sp1.addCard(c.getTheirHand() + "d");
                sp2.addCard(c.getTheirHand() + "d");

            }
            myHandSplit1.setText("Your Hand 1: " + splitHandCount1);
            myHandSplit2.setText("Your Hand 2: " + splitHandCount2);

            runSplitOnce = true;
        } else {
            isSplit = false;
        }

        frameSplit.setVisible(isSplit);

        myHandSplit1.setText("Your Hand 1: " + splitHandCount1);
        myHandSplit2.setText("Your Hand 2: " + splitHandCount2);
        System.out.println("Split: " + splitHandCount1 + " " + splitHandCount2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // this is what each button will do
        if (e.getSource() == myHand1) {
            c.addCard("2m");
            myHandTitle.setText("Your Hand: " + c.getYourHand());
        } else if (e.getSource() == myHand2) {
            c.addCard("3m");
            myHandTitle.setText("Your Hand: " + c.getYourHand());
        } else if (e.getSource() == myHand3) {
            c.addCard("4m");
            myHandTitle.setText("Your Hand: " + c.getYourHand());
        } else if (e.getSource() == myHand4) {
            c.addCard("5m");
            myHandTitle.setText("Your Hand: " + c.getYourHand());
        } else if (e.getSource() == myHand5) {
            c.addCard("6m");
            myHandTitle.setText("Your Hand: " + c.getYourHand());
        } else if (e.getSource() == myHand6) {
            c.addCard("7m");
            myHandTitle.setText("Your Hand: " + c.getYourHand());
        } else if (e.getSource() == myHand7) {
            c.addCard("8m");
            myHandTitle.setText("Your Hand: " + c.getYourHand());
        } else if (e.getSource() == myHand8) {
            c.addCard("9m");
            myHandTitle.setText("Your Hand: " + c.getYourHand());
        } else if (e.getSource() == myHand9) {
            c.addCard("10m");
            myHandTitle.setText("Your Hand: " + c.getYourHand());
        } else if (e.getSource() == myHand10) {
            c.addCard("am");
            myHandTitle.setText("Your Hand: " + c.getYourHand());
        } else if (e.getSource() == DealerHand1) {
            c.addCard("2d");
            dealerHandTitle.setText("Dealer Hand: " + c.getTheirHand());
        } else if (e.getSource() == DealerHand2) {
            c.addCard("3d");
            dealerHandTitle.setText("Dealer Hand: " + c.getTheirHand());
        } else if (e.getSource() == DealerHand3) {
            c.addCard("4d");
            dealerHandTitle.setText("Dealer Hand: " + c.getTheirHand());
        } else if (e.getSource() == DealerHand4) {
            c.addCard("5d");
            dealerHandTitle.setText("Dealer Hand: " + c.getTheirHand());
        } else if (e.getSource() == DealerHand5) {
            c.addCard("6d");
            dealerHandTitle.setText("Dealer Hand: " + c.getTheirHand());
        } else if (e.getSource() == DealerHand6) {
            c.addCard("7d");
            dealerHandTitle.setText("Dealer Hand: " + c.getTheirHand());
        } else if (e.getSource() == DealerHand7) {
            c.addCard("8d");
            dealerHandTitle.setText("Dealer Hand: " + c.getTheirHand());
        } else if (e.getSource() == DealerHand8) {
            c.addCard("9d");
            dealerHandTitle.setText("Dealer Hand: " + c.getTheirHand());
        } else if (e.getSource() == DealerHand9) {
            c.addCard("10d");
            dealerHandTitle.setText("Dealer Hand: " + c.getTheirHand());
        } else if (e.getSource() == DealerHand10) {
            c.addCard("ad");
            dealerHandTitle.setText("Dealer Hand: " + c.getTheirHand());
        } else if (e.getSource() == card1) {
            c.addCard("2");
        } else if (e.getSource() == card2) {
            c.addCard("3");
        } else if (e.getSource() == card3) {
            c.addCard("4");
        } else if (e.getSource() == card4) {
            c.addCard("5");
        } else if (e.getSource() == card6) {
            c.addCard("7");
        } else if (e.getSource() == card7) {
            c.addCard("8");
        } else if (e.getSource() == card8) {
            c.addCard("9");
        } else if (e.getSource() == card9) {
            c.addCard("10");
        } else if (e.getSource() == card10) {
            c.addCard("a");
        } else if (e.getSource() == deckIn) {
            c.setDeck(deckIn.getText());
            System.out.println(deckIn.getText());
        } else if (e.getSource() == newHandButton) {
            c.newHand();
            sp1.newHand();
            sp2.newHand();

            runSplitOnce = false;
        } else if (e.getSource() == myHandSplit1In) {

            // print what comes in + add card
            // System.out.println(myHandSplit1In.getText());
            c.addCard(myHandSplit1In.getText());
            sp1.addCard(myHandSplit1In.getText() + "m");

            splitHandCount1 += StringToInt.toInt(myHandSplit1In.getText());

            myHandSplit1.setText("Your Hand 1: " + splitHandCount1);

            // set split suggestion text
            System.out.println(sp1.getYourHand() + " " + sp1.getTheirHand());
            splitRect1.setText(sp1.basicStrat(sp1.getYourHand(), sp1.getTheirHand()));

        } else if (e.getSource() == myHandSplit2In) {
            // print what comes in + add card
            // System.out.println(myHandSplit2In.getText());
            c.addCard(myHandSplit2In.getText());
            sp2.addCard(myHandSplit2In.getText() + "m");

            splitHandCount2 += StringToInt.toInt(myHandSplit2In.getText());

            myHandSplit2.setText("Your Hand 2: " + splitHandCount2);

            // set split suggestion text
            // System.out.println("2 " + sp2.getYourHand() + " " + sp2.getTheirHand());
            splitRect2.setText(sp2.basicStrat(sp2.getYourHand(), sp2.getTheirHand()));

            /*
             * Just deleate and reenter the numbers if you have to split again.
             */
        }

        // update everything on the GUI
        updateWindow();

    }

}
