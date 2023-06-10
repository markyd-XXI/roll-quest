package com.rollquest.rollquest.service;

import com.rollquest.rollquest.GameBoard;
import com.rollquest.rollquest.Node;

import java.util.*;

public class GameBoardService {

    private final GameBoard gameboard = new GameBoard();
    public GameBoard generateGameBoard(int minNodes, int maxNodes, int minEdges, int maxEdges){
        generateNodes(minNodes, maxNodes);
        generateEdges(minEdges, maxEdges);
        return this.gameboard;
    }

    public void generateNodes(int minNodes, int maxNodes)
    {
        Random random = new Random();
        int numberOfNodes = random.nextInt((maxNodes - minNodes +1) + 1);
        for(int n = 1; n <= numberOfNodes; n++)
        {
            this.gameboard.addNode("Space " + n);
        }
    }

    public void generateEdges(int minEdges, int maxEdges)
    {
        Random random = new Random();
        List<Integer> adjNodes = new ArrayList<>();


        for(int i = 1; i <= gameboard.getNodes().size(); i++)
        {
            adjNodes.add(i);
        }

        Map<Node, List<Node>> nodes = this.gameboard.getNodes();
        Set<Map.Entry<Node, List<Node>>>  nodeSet = nodes.entrySet();


        nodeSet.forEach(nodeListEntry -> {
            List<Integer> thisAdjNodes = new ArrayList<>(adjNodes);
            Collections.shuffle(thisAdjNodes);
            int numberOfEdges = random.nextInt((maxEdges - minEdges + 1) + 1);
            String label = nodeListEntry.getKey().getLabel();
            for(int e = 1; e <= numberOfEdges; e++)
            {
                int adjacentNode = thisAdjNodes.get(0);
                this.gameboard.addEdge(label, "Space " + adjacentNode);
                thisAdjNodes.remove(0);
            }
        });
    }
}
