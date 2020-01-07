package com.lewandowski;

public final class App {
  public static void main(String[] args) {
    Board board = new Board();

    Ship[] player1Ships = board.generateShipsForPlayer(0, 3);
    Ship[] computerShips = board.generateShipsForPlayer(4, 7);

    Player player1 = new Player(player1Ships, "Player 1");
    Player computer = new Player(computerShips, "Computer");

    System.out.println(player1);
    System.out.println(computer);
  }
}
