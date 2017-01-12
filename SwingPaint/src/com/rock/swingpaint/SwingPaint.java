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
		//make menu bar
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("File");

		JMenuItem menuItem = new JMenuItem("New File");
		menu.add(menuItem);
		menuItem = new JMenuItem("Open");
		menuItem.setMnemonic(KeyEvent.VK_S);
		menu.add(menuItem);
		menuItem = new JMenuItem("Save");
		
		menu.add(menuItem);
		menu.addSeparator();
		menuItem = new JMenuItem("Exit");
		menuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		menu.add(menuItem); 
		menuBar.add(menu);
		
		menu = new JMenu("Edit");
		menuItem = new JMenuItem("Undo");
		menu.add(menuItem);
		menuItem = new JMenuItem("Clear All");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_DELETE, ActionEvent.ALT_MASK));
		menuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				drawShape.clear();
			}
		});
		menu.add(menuItem);
		
		//make subMenu
		JMenu subMenu = new JMenu("Color");
		menuItem = new JMenuItem("Black");
		menuItem.addActionListener(colorHandler(Color.black));
		subMenu.add(menuItem);
		menuItem = new JMenuItem("LightGrey");
		menuItem.addActionListener(colorHandler(Color.lightGray));
		subMenu.add(menuItem);
		menuItem = new JMenuItem("White");
		menuItem.addActionListener(colorHandler(Color.white));
		subMenu.add(menuItem);
		menuItem = new JMenuItem("Blue");
		menuItem.addActionListener(colorHandler(Color.blue));
		subMenu.add(menuItem);
		menuItem = new JMenuItem("Yellow");
		menuItem.addActionListener(colorHandler(Color.yellow));
		subMenu.add(menuItem);
		menuItem = new JMenuItem("Red");
		menuItem.addActionListener(colorHandler(Color.red));	
		subMenu.add(menuItem);
		subMenu.addSeparator();
		menuItem = new JMenuItem("Choose...");
		subMenu.add(menuItem);
		//add sub menu to main menu
		menu.add(subMenu);
		
		subMenu = new JMenu("Insert");
		menuItem = new JMenuItem("Text");
		subMenu.add(menuItem);
		menuItem = new JMenuItem("Picture");
		subMenu.add(menuItem);
		menu.add(subMenu);
		menuBar.add(menu);
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
	
	public ActionListener colorHandler(final Color c)
	{
		return new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				drawShape.setColor(c);
			}
		};
	}
	
	public static void main(String[] args)
	{
		new SwingPaint().show();
	}
}
