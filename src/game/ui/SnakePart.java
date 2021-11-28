package game.ui;

import java.awt.*;

import game.window.Panel;

public class SnakePart extends GameObject {
  public SnakePart(int x, int y) {
    super(x, y);
  }

  private void fill(Graphics g) {
    g.fillRect(
      this.x*Panel.BLOCK_SIZE+2,
      this.y*Panel.BLOCK_SIZE+2,
      Panel.BLOCK_SIZE-4,
      Panel.BLOCK_SIZE-4
    );
  }

  public void drawHead(Graphics g) {
    g.setColor(Color.gray);
    fill(g);
  }

  @Override
  public void draw(Graphics g) {
    g.setColor(Color.blue);
    fill(g);
  }
}
