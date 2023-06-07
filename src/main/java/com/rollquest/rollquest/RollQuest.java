package com.rollquest.rollquest;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RollQuest implements IGame {

    private List<ICharacter> characters;
    public void initializeCharacters(List<ICharacter> characters)
    {
        this.characters = characters;
    }
}
