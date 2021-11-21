package game.process;

import java.awt.*;
import java.util.Random;
import java.util.ArrayList;

import game.window.Panel;
import game.window.Keyboard;

import game.ui.Apple;
import game.ui.SnakePart;

public class GameProcess {
  private Panel gamePanel;
  private Keyboard keyboard;

  private Apple apple;
  private Random random;
  private ArrayList<SnakePart> snake;

  public GameProcess(Keyboard keyboard, Panel gamePanel) {
    this.keyboard = keyboard;
    this.gamePanel = gamePanel;

    this.random = new Random();
    this.apple = new Apple(
      getRandom(0, Panel.WIDTH-1),
      getRandom(0, Panel.HEIGHT-1)
    );

    this.snake = new ArrayList<SnakePart>();
    this.snake.add(new SnakePart(3, 1));
    this.snake.add(new SnakePart(2, 1));
    this.snake.add(new SnakePart(1, 1));
  }

  public void update() {
    if (this.snake.size() < 1) return;

    SnakePart head = this.snake.get(0);
    SnakePart tail = this.snake.get(this.snake.size() - 1);
    int x = head.getX();
    int y = head.getY();
    int newX = tail.getX();
    int newY = tail.getY();

    for (int i = this.snake.size() - 1; i >= 1; i--) {
      SnakePart current = this.snake.get(i);
      SnakePart next = this.snake.get(i-1);

      if (current.getX() == head.getX() && current.getY() == head.getY()) {
        this.gamePanel.setRunning(false);
        return;
      }

      current.setX(next.getX());
      current.setY(next.getY());
    }

    if (this.apple.getX() == x && this.apple.getY() == y) {
      this.snake.add(new SnakePart(newX, newY));
      this.apple.update(
        getRandom(0, Panel.WIDTH-1),
        getRandom(0, Panel.HEIGHT-1)
      );
    }

    if (keyboard.up()) {
      head.setY(y > 0 ? y-1 : Panel.HEIGHT-1);
    } else if (keyboard.down()) {
      head.setY((y+1) % Panel.HEIGHT);
    } else if (keyboard.left()) {
      head.setX(x > 0 ? x-1 : Panel.WIDTH-1);
    } else if (keyboard.right()) {
      head.setX((x+1) % Panel.WIDTH);
    }
  }

  public void repaint(Graphics g) {
    for (SnakePart part : this.snake) {
      part.draw(g);
    }
    this.apple.draw(g);
    this.snake.get(0).drawHead(g);

    g.setColor(Color.white);
    g.drawString("Score: " + this.snake.size(), 0, g.getFont().getSize());
  }

  private int getRandom(int min, int max) {
    Random random = new Random();
    return random.ints(min, max)
      .findFirst()
      .getAsInt();
  }
}
