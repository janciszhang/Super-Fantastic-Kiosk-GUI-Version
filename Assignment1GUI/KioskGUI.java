package Assignment1GUI;

import assignment1.Kiosk;
import other.study.gui.lesson04.DialogDemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class KioskGUI
{

    private static void windowClose(Frame frame)
    {
        frame.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args)
    {
        //Frame
        Frame frame = new Frame("Kiosk");

        frame.setVisible(true);
        frame.setBounds(200, 200, 500, 600);
        frame.setBackground(new Color(41, 100, 239));
        windowClose(frame);

        //Panel
        Panel panel1 = new Panel();
        Panel panel2 = new Panel();
        Panel panel3 = new Panel();
        Panel panel4 = new Panel();
        panel1.setBounds(50, 50, 400, 35);
        panel2.setBounds(50, 110, 400, 210);
        panel3.setBounds(50, 350, 400, 50);
        panel4.setBounds(50, 410, 400, 50);
        panel1.setBackground(Color.magenta);
        panel2.setBackground(Color.PINK);
        panel3.setBackground(Color.GREEN);
        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);
        frame.add(panel4);

        //Label
        Label label1 = new Label("Welcome to Super Fantastic Kiosk");
        panel1.add(label1);

        Button button1 = new Button("(1) Create A New Order");
        Button button2 = new Button("(2) Buy More Credit");
        Button button3 = new Button("(3) Purchase An Item");
        Button button4 = new Button("(4) What Have I Order So Far?");
        Button button5 = new Button("(5) Collect My Order");
        Button button6 = new Button("(6) Display Help");
        Button button7 = new Button("(7) Leave Kiosk");

        panel2.setLayout(new GridLayout(7, 1));
        panel2.add(button1);
        panel2.add(button2);
        panel2.add(button3);
        panel2.add(button4);
        panel2.add(button5);
        panel2.add(button6);
        panel2.add(button7);

        panel3.setLayout(new GridLayout(2,1));
        Label label2 = new Label("Choose an option: ");
        TextField textField = new TextField(30);
        panel3.add(label2);
        panel3.add(textField);


        MyMenuMonitor myMenuMonitor = new MyMenuMonitor();
        button1.addActionListener(myMenuMonitor);
        button2.addActionListener(myMenuMonitor);
        button3.addActionListener(myMenuMonitor);
        button4.addActionListener(myMenuMonitor);
        button5.addActionListener(myMenuMonitor);
        button6.addActionListener(myMenuMonitor);
        button7.addActionListener(myMenuMonitor);

        button1.setActionCommand("1");
        button2.setActionCommand("2");
        button3.setActionCommand("3");
        button4.setActionCommand("4");
        button5.setActionCommand("5");
        button6.setActionCommand("6");
        button7.setActionCommand("7");

        button3.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new MyDialog3();
            }
        });

        button6.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new MyDialog6();
            }
        });



    }
}

class MyMenuMonitor implements ActionListener
{

    @Override
    public void actionPerformed(ActionEvent e)
    {
        System.out.println("Your choose is: " + e.getActionCommand());
        int option = Integer.parseInt(e.getActionCommand());
        Kiosk kiosk = new Kiosk();
        kiosk.optionSwitch(option);


    }
}

class MyDialog3 extends JDialog{
    public MyDialog3(){
        this.setVisible(true);
        this.setBounds(100,100,500,600);
        //this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//弹窗默认自带关闭功能，添加会报错！！！

        Container container = this.getContentPane();
        container.setBackground(new Color(73, 135, 234));

        //Panel
        Panel panel1 = new Panel();
        Panel panel2 = new Panel();
        Panel panel3 = new Panel();
        Panel panel4 = new Panel();
        panel1.setBounds(50, 50, 400, 35);
        panel2.setBounds(50, 110, 400, 210);
        panel3.setBounds(50, 350, 400, 50);
        panel4.setBounds(50, 410, 400, 50);
        panel1.setBackground(Color.magenta);
        panel2.setBackground(Color.PINK);
        panel3.setBackground(Color.GREEN);
        //panel4.setBackground(Color.PINK);
        container.add(panel1);
        container.add(panel2);
        container.add(panel3);
        container.add(panel4);


        Label label1 = new Label("These are the items available for sale today:");
        Label label2 = new Label("Pick a number between 1-6: ");
        TextField textField = new TextField(30);
        Button button1 = new Button("(1) PEN, worth $10");
        Button button2 = new Button("(2) BOOK, worth $20");
        Button button3 = new Button("(3) DVD, worth $30");
        Button button4 = new Button("(4) MOUSE, worth $40");
        Button button5 = new Button("(5) KEYBOARD, worth $50");
        Button button6 = new Button("(6) Let ME pick a random item for you!!!");

        button1.setActionCommand("1");
        button2.setActionCommand("2");
        button3.setActionCommand("3");
        button4.setActionCommand("4");
        button5.setActionCommand("5");
        button6.setActionCommand("6");

        panel1.add(label1);

        panel2.setLayout(new GridLayout(6, 1));
        panel2.add(button1);
        panel2.add(button2);
        panel2.add(button3);
        panel2.add(button4);
        panel2.add(button5);
        panel2.add(button6);

        panel3.setLayout(new GridLayout(2,1));
        panel3.add(label2);
        panel3.add(textField);

    }
}

class MyDialog6 extends  JDialog{
    public MyDialog6(){
        setVisible(true);
        setBounds(100,100,265,160);

        Container container = getContentPane();
        container.setBackground(Color.YELLOW);

        Panel panel = new Panel();
        panel.setBounds(10,10, 230,100);
        panel.setBackground(Color.PINK);

        Label label1 = new Label("There 5 products you can buy. If you     ");
        Label label2 = new Label("pick Item #6, the computer will generates");
        Label label3 = new Label("a random number between 1 and 5.         ");
        Label label4 = new Label("And then use that number to pick one     ");
        Label label5 = new Label("of the 5 available items for you.        ");

        panel.setLayout(new GridLayout(5,1));
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        panel.add(label5);

        container.setLayout(null);
        container.add(panel);


    }
}

