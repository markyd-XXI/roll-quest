package com.rollquest.rollquest;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Player implements ICharacter{

    private String name;
    private String race;

    public Player(String name, String race)
    {
        this.name = name;
        this.race = race;
    }
    public List<Integer> rollDice(IDice dice, int numberOfDice)
    {
        return dice.roll(numberOfDice);
    }

}
