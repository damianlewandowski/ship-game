package com.lewandowski;

/**
 * Ship
 */
public class Ship {

  private int x;
  private int y;
  private boolean isDestroyed;
  private int maxBoardRows;
  private int maxBoardCols;

  public Ship(int x, int y) {
    this.x = x;
    this.y = y;

    Config config = new Config();
    this.maxBoardRows = Integer.parseInt(config.getProperty("boardRows"));
    this.maxBoardCols = Integer.parseInt(config.getProperty("boardCols"));
  }

  public int getX() {
    return this.x;
  }

  public void setX(int x) {
    if (x >= this.maxBoardCols) {
      throw new Error("Ship's \"x\" field cannot be bigger than boardSize");
    }
    this.x = x;
  }

  public int getY() {
    return this.y;
  }

  public void setY(int y) {
    if (y >= this.maxBoardRows) {
      throw new Error("Ship's \"y\" field cannot be bigger than boardSize");
    }
    this.y = y;
  }

  public boolean isDestroyed() {
    return this.isDestroyed;
  }

  public boolean getIsDestroyed() {
    return this.isDestroyed;
  }

  public void setIsDestroyed(boolean isDestroyed) {
    this.isDestroyed = isDestroyed;
  }
}
