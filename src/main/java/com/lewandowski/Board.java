package com.lewandowski;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Board
 */
public class Board {
  private boolean[][] fields;
  private int shipsPerPlayer;

  public Board() {
    Config config = new Config();
    int maxBoardRows = Integer.parseInt(config.getProperty("boardRows"));
    int maxBoardCols = Integer.parseInt(config.getProperty("boardCols"));
    this.shipsPerPlayer = Integer.parseInt(config.getProperty("shipsPerPlayer"));

    this.fields = new boolean[maxBoardRows][maxBoardCols];
  }

  public void setField(int x, int y) {
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

  public Ship[] generateShipsForPlayer(int minRow, int maxRow) {
    Ship[] ships = new Ship[3];
    for (int i = 0; i < ships.length; i++) {
      ships[i] = generateShip(minRow, maxRow);
    }
    return ships;
  }

}
