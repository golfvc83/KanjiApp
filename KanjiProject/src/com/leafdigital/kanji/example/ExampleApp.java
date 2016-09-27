/*
This file is part of leafdigital kanjirecog.

kanjirecog is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

kanjirecog is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with kanjirecog.  If not, see <http://www.gnu.org/licenses/>.

Copyright 2011 Samuel Marshall.
*/
package com.leafdigital.kanji.example;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.*;
import java.lang.reflect.InvocationTargetException;

import javax.swing.*;

/**
 * Frame for testing the kanji recogniser as an application.
 */
public class ExampleApp extends JFrame
{
	/**
	 * Constructor
	 * @throws FontFormatException 
	 */
	public ExampleApp(String s) throws FontFormatException
	{
		super("Kanji recognition test");
		try
		{
			    
			    Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("data/KanjiStrokeOrders_v4.000.ttf")).deriveFont(12f);
			    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			    //register the font
			    ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("data/KanjiStrokeOrders_v4.000.ttf")));
			    getContentPane().setLayout(new BorderLayout());
			    getContentPane().add(new ExamplePanel(
				new FileInputStream("data/strokes-20100823.xml"), getLayeredPane(), null, s, customFont));
		}
		catch(IOException e)
		{
			throw new Error(e);
		}
		
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	/**
	 * @param args No parameters
	 * @throws InterruptedException Invoke error
	 * @throws InvocationTargetException Invoke error
	 */
	public static void main(String[] args) throws InterruptedException, InvocationTargetException
	{
		SwingUtilities.invokeAndWait(new Runnable() 
		{
			@Override
			public void run()
			{
				try {
					new ExampleApp("test");
				} catch (FontFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
}
