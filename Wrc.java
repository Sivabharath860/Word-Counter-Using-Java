package com.wordcount;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;


public class Wrc extends JFrame implements ActionListener  {
	JLabel w;
	JLabel ch;
	JTextArea ta;
	JLabel ta1;
	JButton s;
	JButton p;
	JButton tf;
	JButton rs;
	
	Wrc() {
		super("JAVA WORD COUNTER");
		w = new JLabel("WORDS:");
		ch = new JLabel("CHARACTERS:");
		ta = new JTextArea();
		ta1 = new JLabel("ENTER YOUR TEXT HERE");
		s = new JButton("SUBMIT");
		p = new JButton("PAD COL");
		tf = new JButton("TEXT COL");
		rs = new JButton("RESET");
		
		
		
		
		ch.setBounds(50,50,120,20);
		w.setBounds(50,80,120,20);
		ta1.setBounds(50,120,140,20);
		ta.setBounds(50,140,320,300);
		s.setBounds(50,460,100,20);
		s.addActionListener(this);
		s.setBackground(Color.lightGray);
		s.setContentAreaFilled(false);
		s.setOpaque(true);
		p.setBounds(160,460,100,20);
		p.addActionListener(this);
		p.setBackground(Color.lightGray);
		p.setContentAreaFilled(false);
		p.setOpaque(true);
		tf.setBounds(270,460,100,20);
		tf.addActionListener(this);
		tf.setBackground(Color.lightGray);
		tf.setContentAreaFilled(false);
		tf.setOpaque(true);
		rs.setBounds(50,480,100,20);
		rs.addActionListener(this);
		rs.setBackground(Color.lightGray);
		rs.setContentAreaFilled(false);
		rs.setOpaque(true);
		
		
		add(w);add(ch);add(ta);add(ta1);add(s);add(p);add(tf);add(rs);
		setSize(400,400);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == s) {
			String text = ta.getText();
			String[] words = text.split("\\s");
			int chars = text.length();
			ch.setText("CHARACTERS:"+chars);
			if(text.equals("")) {
				w.setText("WORDS:"+0);
			}
			else {
				w.setText("WORDS:"+words.length);
			}
		}else if(e.getSource() == p) {
			Color c = JColorChooser.showDialog(ta, "choose color", Color.WHITE);
			ta.setBackground(c);
		}
		else if(e.getSource() == tf) {
			Color c = JColorChooser.showDialog(tf, "choose color", Color.blue);
			ta.setForeground(c);
		}
		else if(e.getSource() == rs) {
			ta.setText("");
		}
	}
	public static void main(String args[]) {
		new Wrc();
	}

}
