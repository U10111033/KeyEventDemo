/**U10111033, Computer science 4, Hsueh_Hsin Lu*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class KeyEventDemo extends JFrame {
	private MessagePane keyboardPanel = new MessagePane();
	
	/** Initialize UI */
	public KeyEventDemo() {
		// Add the keyboard panel to accept and display user input
		add(keyboardPanel);

		// Set focus
		keyboardPanel.setFocusable(true);
	}

	/** Main method */
	public static void main(String[] args) {
		KeyEventDemo frame = new KeyEventDemo();
		frame.setTitle("KeyEventDemo");
		frame.setSize(300, 100);
		frame.setLocationRelativeTo(null); // Center the frame   
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	// Inner class: MessagePane for receiving key input
	static class MessagePane extends JPanel {
		private int x = 10;
		private int y = 35;
		private char keyChar = 'A'; // Default key
		private StringBuffer buf = new StringBuffer();

		public MessagePane() {
			addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e){
					if(e.getKeyCode() == KeyEvent.VK_ENTER){
						//clean the StringBuffer if press ENTER key
						buf.delete(0, buf.length());
					}else{
						//get the char, and append the char to the StringBuffer
						keyChar = e.getKeyChar();
						buf.append(keyChar);
					}
					
					//repaint
					repaint();
				}
			});
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			//draw it begin frme 10,35
			g.drawString(buf.toString() , x, y);
		}
	}
}