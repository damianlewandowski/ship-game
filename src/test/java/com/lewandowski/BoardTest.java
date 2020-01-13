package com.lewandowski;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

/**
 * Unit test for simple App.
 */
public class BoardTest {
  /**
   * Create ship
   */
  @Test
  public void testShipGeneration() {
    int cols = 5;
    int rows = 5;
    // Create board 5x5, 3 ships for each player
    Board board = new Board(cols, rows, 3);
    Ship ship = board.generateShip(0, 2);

    assertNotNull(ship);
  }

  /**
   * Make sure ship's row is proper
   */
  @Test
  public void testShipGenerationY() {
    int cols = 5;
    int rows = 5;
    // Create board 5x5, 3 ships for each player
    Board board = new Board(cols, rows, 3);
    Ship ship = board.generateShip(0, 2);

    assertTrue(ship.getY() <= 2);
  }

  /**
   * Make sure ship's column is proper
   */
  @Test
  public void testShipGenerationX() {
    // Create board 5x5, 3 ships for each player
    Board board = new Board(5, 5, 3);
    Ship ship = board.generateShip(0, 2);

    assertTrue(ship.getX() <= 5);
  }

  /**
   * Multiple ships
   */
  @Test
  public void testShipsGeneration() {
    int cols = 5;
    int rows = 5;
    int shipsPerPlayer = 5;
    // Create board 5x5, 5 ships for each player
    Board board = new Board(cols, rows, shipsPerPlayer);
    ArrayList<Ship> ships = board.generateShipsForPlayer(0, 3);

    assertNotNull(ships);
  }
}
