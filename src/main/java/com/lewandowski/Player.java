package com.lewandowski;

/**
 * Player
 */
public class Player {
  private Ship[] ships;
  private String name;

  public Player(Ship[] ships, String name) {
    this.ships = ships;
    this.name = name;
  }

  @Override
  public String toString() {
    StringBuilder str = new StringBuilder(String.format("%s\n", this.name));
    for (int i = 0; i < ships.length; i++) {
      String s = String.format("%d (x, y) - (%d %d)\n", i, ships[i].getX(), ships[i].getY());
      str.append(s);
    }
    return str.toString();
  }

}
