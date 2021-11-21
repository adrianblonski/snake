package game.window;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import game.process.GameProcess;

public class Panel extends JPanel implements ActionListener {
  public static final int WIDTH = 20;
  public static final int HEIGHT = 15;
  public static final int BLOCK_SIZE = 32;

  private Timer timer;
  private boolean running;
  private Keyboard keyboard;
  private GameProcess process;

  public Panel() {
    this.running = true;
    this.keyboard = new Keyboard();
    this.timer = new Timer(75, this);
    this.process = new GameProcess(this.keyboard, this);

    this.setFocusable(true);
    this.setBackground(Color.black);
    this.addKeyListener(this.keyboard);
    this.setPreferredSize(new Dimension(WIDTH*BLOCK_SIZE, HEIGHT*BLOCK_SIZE));

    timer.start();
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    this.process.repaint(g);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (running) {
      this.process.update();
      this.keyboard.update();
    }

    repaint();
  }

  public void setRunning(boolean value) {
    this.running = value;
  }
}
