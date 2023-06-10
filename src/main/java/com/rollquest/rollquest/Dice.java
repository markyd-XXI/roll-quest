package com.rollquest.rollquest;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@Setter
public class Dice implements IDice
{
    private int sides;

    public Dice(int sides)
    {
        this.sides = sides;
    }

    public List<Integer> roll(int numberOfDie)
    {
        List<Integer> rollResults = new ArrayList<>();

        for(int i = 1; i <= numberOfDie; i++)
        {
            Random random = new Random();

            rollResults.add(random.nextInt((this.sides - 1) + 1) + 1);
        }

        return rollResults;
    }
}
