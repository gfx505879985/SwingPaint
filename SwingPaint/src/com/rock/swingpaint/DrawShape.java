package com.rock.swingpaint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JComponent;

public class DrawShape extends JComponent
{
	//object used to draw on
	private Graphics2D g2;
	//buffered image we draw
	private Image image;
	//coords
	private int x,y,x_old,y_old;
	
	public DrawShape()
	{
		setDoubleBuffered(false);
		
		//set old coords when mouse is pressed
		addMouseListener(new MouseAdapter()
		{
			public void mousePressed(MouseEvent e)
			{
				x_old=e.getX();
				y_old=e.getY();
			}
			
		});
		
		addMouseMotionListener(new MouseMotionAdapter()
		{
			public void mouseDragged(MouseEvent e) 
			{
				//when mouse dragged, record current x,y coord
				x = e.getX();
				y = e.getY();
					
				if(g2 != null)
				{
					//if g2 is not null, draw line
					g2.drawLine(x_old,y_old,x,y);
					//refresh and update coords for next draw line
					repaint();
					x_old=x;
					y_old=y;
				}
			}
		});
		
	}
	
	protected void paintComponent(Graphics g)
	{
		if(image == null)
		{
			//we create
			image = createImage(getSize().width,getSize().height);
			
			g2 = (Graphics2D) image.getGraphics();
			//turn on antialiasing
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			clear();
		}
		
		g.drawImage(image,0,0,null);
		
	}
	
	public void clear()
	{
		g2.setPaint(Color.white);
		g2.fillRect(0, 0, getWidth(), getHeight());
		g2.setPaint(Color.black);
		repaint();
	}
	
	public void setColor(Color c)
	{
		g2.setPaint(c);
		repaint();
	}
	//public void set paint
	
}
