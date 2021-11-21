package game.ui;

import java.awt.*;

import game.window.Panel;

public class Apple extends GameObject {
  public Apple(int x, int y) {
    super(x, y);
  }

  @Override
  public void draw(Graphics g) {
    g.setColor(Color.green);
    g.fillRect(
      this.x*Panel.BLOCK_SIZE+Panel.BLOCK_SIZE/2,
      this.y*Panel.BLOCK_SIZE+Panel.BLOCK_SIZE/2,
      Panel.BLOCK_SIZE/4,
      Panel.BLOCK_SIZE/4
    );
    g.setColor(Color.red);
    g.fillOval(
      this.x*Panel.BLOCK_SIZE+Panel.BLOCK_SIZE/4,
      this.y*Panel.BLOCK_SIZE+Panel.BLOCK_SIZE/4,
      Panel.BLOCK_SIZE/2,
      Panel.BLOCK_SIZE/2
    );
  }
}
