package game.window;

import java.awt.event.*;

public class Keyboard extends KeyAdapter {
  private char newDir;
  private char dir;

  public Keyboard() {
    this.dir = 'r';
    this.newDir = this.dir;
  }

  public boolean up() {
    return this.dir == 'u';
  }

  public boolean down() {
    return this.dir == 'd';
  }

  public boolean right() {
    return this.dir == 'r';
  }

  public boolean left() {
    return this.dir == 'l';
  }

  public void update() {
    this.dir = this.newDir;
  }

  @Override
  public void keyPressed(KeyEvent e) {
    char curr = this.dir;
    switch(e.getKeyCode()) {
      case KeyEvent.VK_UP:
        curr = 'u';
        break;
      case KeyEvent.VK_DOWN:
        curr = 'd';
        break;
      case KeyEvent.VK_RIGHT:
        curr = 'r';
        break;
      case KeyEvent.VK_LEFT:
        curr = 'l';
        break;
    }

    // exclude impossible turns
    if (
      (this.dir == 'u' && curr == 'd') ||
      (this.dir == 'd' && curr == 'u') ||
      (this.dir == 'l' && curr == 'r') ||
      (this.dir == 'r' && curr == 'l')
    ){
      return;
    }

    this.newDir = curr;
  }
}
