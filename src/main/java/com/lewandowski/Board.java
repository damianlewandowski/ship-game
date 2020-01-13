package com.lewandowski;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Board
 */
public class Board {
  private boolean[][] fields;
  private int shipsPerPlayer;

  public Board(int maxCols, int maxRows, int shipsPerPlayer) {
    this.fields = new boolean[maxRows][maxCols];
    this.shipsPerPlayer = shipsPerPlayer;
  }

  public void setField(int x, int y) {
    if (x < 0) {
      throw new Error("x too small");
    }

    if (y < 0) {
      throw new Error("y too small");
    }

    if (x >= this.fields[0].length) {
      System.out.println(x);
      throw new Error("x too big");
    }

    if (y >= this.fields.length) {
      throw new Error("y too big");
    }

    this.fields[y][x] = true;
  }

  public boolean getField(int x, int y) {
    return this.fields[y][x];
  }

  public void clearBoard() {
    for (int i = 0; i < fields.length; i++) {
      for (int j = 0; j < fields[i].length; j++) {
        this.fields[i][j] = false;
      }
    }
  }

  public Ship generateShip(int minRow, int maxRow) {
    while (true) {
      int randCol = ThreadLocalRandom.current().nextInt(0, this.fields[0].length);
      int randRow = ThreadLocalRandom.current().nextInt(minRow, maxRow);

      boolean isFieldtaken = this.fields[randRow][randCol];
      if (!isFieldtaken) {
        setField(randCol, randRow);
        return new Ship(randCol, randRow);
      }
    }
  }

  public ArrayList<Ship> generateShipsForPlayer(int minRow, int maxRow) {
    ArrayList<Ship> ships = new ArrayList<Ship>();
    for (int i = 0; i < this.shipsPerPlayer; i++) {
      ships.add(generateShip(minRow, maxRow));
    }
    return ships;
  }

}
