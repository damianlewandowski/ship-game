package com.lewandowski;

public final class App {

  public static void main(String[] args) {
    Config config = new Config();
    int maxBoardRows = Integer.parseInt(config.getProperty("boardRows"));
    int maxBoardCols = Integer.parseInt(config.getProperty("boardCols"));
    int shipsPerPlayer = Integer.parseInt(config.getProperty("shipsPerPlayer"));

    Game game = new Game(maxBoardRows, maxBoardCols, shipsPerPlayer);

    game.run();
  }
}
