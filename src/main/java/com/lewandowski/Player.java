package com.lewandowski;

import java.util.ArrayList;

/**
 * Player
 */
public class Player {
  private ArrayList<Ship> ships;
  private String name;

  public Player(ArrayList<Ship> ships, String name) {
    this.ships = ships;

    this.name = name;
  }

  public boolean defend(int[] coords) {
    int x = coords[0];
    int y = coords[1];

    for (Ship ship : this.ships) {
      if (ship.isHit(x, y)) {
        ship.setIsDestroyed(true);
        this.ships.remove(ship);
        return true;
      }
    }
    return false;
  }

  public String getName() {
    return this.name;
  }

  public int getShipsAmount() {
    return this.ships.size();
  }

  @Override
  public String toString() {
    StringBuilder str = new StringBuilder(String.format("%s\n", this.name));
    for (int i = 0; i < ships.size(); i++) {
      String s = String.format("%d (x, y) - (%d %d)\n", i, ships.get(i).getX(), ships.get(i).getY());
      str.append(s);
    }
    return str.toString();
  }

}
