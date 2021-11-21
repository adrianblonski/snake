package game.ui;

import java.awt.*;

public abstract class GameObject {
  protected int x;
  protected int y;

  protected GameObject(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public void update(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public void setX(int value) {
    this.x = value;
  }

  public void setY(int value) {
    this.y = value;
  }

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }

  public abstract void draw(Graphics g);
}
