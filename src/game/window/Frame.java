package game.window;

import javax.swing.JFrame;

public class Frame extends JFrame {
  public Frame(String title) {
    this.add(new Panel());
    this.setTitle(title);
    this.setVisible(true);
    this.setResizable(false);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    this.pack();
  }
}

