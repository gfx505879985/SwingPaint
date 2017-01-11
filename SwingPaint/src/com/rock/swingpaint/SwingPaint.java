package com.rock.swingpaint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingPaint
{
	JButton clearBtn,pickBtn;
	DrawShape drawShape;
	
	
	public void show()
	{
		//make frame
		JFrame frame = new JFrame("Swing Paint");
		//make container for layout
		//Container content = frame.getContentPane();
		drawShape = new DrawShape();
		JPanel panel = new JPanel();
		frame.add(panel);
		panel.setLayout(new BorderLayout());
		//create event lister and perform for clear button
		clearBtn = new JButton("Clear");
		clearBtn.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					if(e.getSource()==clearBtn)
					{
						drawShape.clear();
					}
				}
			});
		
		panel.add(clearBtn,BorderLayout.NORTH);
		panel.add(drawShape, BorderLayout.CENTER);
		//set size, set visible
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	
	public static void main(String[] args)
	{
		new SwingPaint().show();
	}
}
