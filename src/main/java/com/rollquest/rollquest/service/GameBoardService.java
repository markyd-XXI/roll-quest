package com.rollquest.rollquest.service;

import com.rollquest.rollquest.GameBoard;

import java.util.HashMap;

public class GameBoardService {
    public GameBoard generateGameBoard(){
        GameBoard gameBoard = new GameBoard();
            gameBoard.addNode("Spot 1");
            gameBoard.addNode("Spot 2");
            gameBoard.addNode("Spot 3");
            gameBoard.addNode("Spot 4");
            gameBoard.addNode("Spot 5");
            gameBoard.addEdge("Spot 1", "Spot 2");
            gameBoard.addEdge("Spot 1", "Spot 3");
            gameBoard.addEdge("Spot 2", "Spot 4");
            gameBoard.addEdge("Spot 3", "Spot 5");
            gameBoard.addEdge("Spot 4", "Spot 5");
            gameBoard.addEdge("Spot 5", "Spot 1");
            return gameBoard;
    }
}
