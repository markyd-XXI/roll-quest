package com.rollquest.rollquest;

import java.util.List;

public interface ICharacter {
    public List<Integer> rollDice(IDice dice, int numberOfDice);
    public String getName();
    public String getRace();
}
