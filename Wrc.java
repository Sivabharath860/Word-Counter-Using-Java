package com.wordcount;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;


public class Wrc extends JFrame implements ActionListener  {
	JLabel w;
	JLabel ch;
	JTextArea ta;
	JLabel ta1;
	JButton s;
	JButton p;
	JButton tf;
	Image img = null;
	JLabel background;
	Wrc() {
		super("JAVA WORD COUNTER");
		w = new JLabel("WORDS:");
		ch = new JLabel("CHARACTERS:");
		ta = new JTextArea();
		ta1 = new JLabel("ENTER YOUR TEXT HERE");
		s = new JButton("SUBMIT");
		p = new JButton("PAD COL");
		tf = new JButton("TEXT COL");
		
		
		try {
			String impath = "D:\\wordcounter.jpg";
			URL imgurl = getClass().getResource(impath);
			if (imgurl == null) {
				
			}
			else {
				img = ImageIO.read(imgurl);
			}
		}catch(IOException ex) {
			JOptionPane.showMessageDialog(this,"Back ground image not found."); 
		}
		catch(NullPointerException exc) {
			System.out.println(exc);
		}
		
		
		ch.setBounds(50,50,120,20);
		w.setBounds(50,80,120,20);
		ta1.setBounds(50,120,140,20);
		ta.setBounds(50,140,300,200);
		s.setBounds(50,460,100,20);
		s.addActionListener(this);
		p.setBounds(160,460,100,20);
		p.addActionListener(this);
		tf.setBounds(270,460,100,20);
		tf.addActionListener(this);
		try {
		BufferedImage img = ImageIO.read(new File("D:\\wordcounter"));
		background = new JLabel(new ImageIcon(img));
		}
		catch(IOException ex) {
			System.out.println(ex);
		}catch(NullPointerException exc) {
			System.out.println(exc);
		}
		background = new JLabel(new ImageIcon(img));
		background.setBounds(0,0,400,400);
		add(background);
		add(w);add(ch);add(ta);add(ta1);add(s);add(p);add(tf);
		setSize(400,400);
		
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == s) {
			String text = ta.getText();
			String[] words = text.split("\\s");
			int chars = text.length();
			ch.setText("CHARACTERS:"+chars);
			w.setText("WORDS:"+words.length);
		}else if(e.getSource() == p) {
			Color c = JColorChooser.showDialog(ta, "choose color", Color.WHITE);
			ta.setBackground(c);
		}
		else if(e.getSource() == tf) {
			Color c = JColorChooser.showDialog(tf, "choose color", Color.blue);
			ta.setForeground(c);
		}
	}
	public static void main(String args[]) {
		new Wrc();
	}

}
