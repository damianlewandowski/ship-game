package com.lewandowski;

import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Game
 */
public class Game {
  int maxBoardRows;
  int maxBoardCols;
  int shipsPerPlayer;
  Scanner scanner = new Scanner(System.in);

  public Game(int maxBoardRows, int maxBoardCols, int shipsPerPlayer) {
    this.maxBoardCols = maxBoardCols;
    this.maxBoardRows = maxBoardRows;
    this.shipsPerPlayer = shipsPerPlayer;
  }

  private int[] getRandCoords() {
    int x = ThreadLocalRandom.current().nextInt(0, maxBoardCols);
    int y = ThreadLocalRandom.current().nextInt(0, maxBoardRows);

    return new int[] { x, y };
  }

  private void playRound(int[] coords, Player playerOrComputer) {
    boolean isHit = playerOrComputer.defend(coords);
    if (isHit) {
      System.out
          .println(String.format("%s's ship on coordinates: (x, y) - (%d, %d) has been sunk.\n%s has %d ships left",
              playerOrComputer.getName(), coords[0], coords[1], playerOrComputer.getName(),
              playerOrComputer.getShipsAmount()));
    }
  }

  private void playComputerRound(Player player) {
    int[] compAttack = getRandCoords();
    System.out.println(String.format("Computer attacks (x, y) - (%d, %d)", compAttack[0], compAttack[1]));
    this.playRound(compAttack, player);
  }

  private void playPlayerRound(Player computer) {
    System.out.println("Enter x coordinate");
    int x = scanner.nextInt();
    System.out.println("Enter y coordinate");
    int y = scanner.nextInt();
    int[] attack = { x, y };
    this.playRound(attack, computer);
  }

  private boolean checkWin(Player player, Player computer) {
    if (player.getShipsAmount() <= 0) {
      System.out.println(String.format("%s won!", computer.getName()));
      return true;
    }

    if (computer.getShipsAmount() <= 0) {
      System.out.println(String.format("%s won!", player.getName()));
      return true;
    }

    return false;
  }

  public void run() {
    Board board = new Board(maxBoardCols, maxBoardRows, shipsPerPlayer);

    ArrayList<Ship> player1Ships = board.generateShipsForPlayer(0, 3);
    ArrayList<Ship> computerShips = board.generateShipsForPlayer(4, 7);

    Player player1 = new Player(player1Ships, "Player 1");
    Player computer = new Player(computerShips, "Computer");

    System.out.println(player1);
    System.out.println(computer);

    while (true) {
      this.playComputerRound(player1);
      this.playPlayerRound(computer);

      boolean isGameOver = this.checkWin(player1, computer);
      if (isGameOver) {
        break;
      }
    }
  }

}
