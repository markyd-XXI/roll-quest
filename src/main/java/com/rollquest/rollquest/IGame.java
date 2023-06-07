package com.rollquest.rollquest;

import java.util.List;

public interface IGame {
    public void initializeCharacters(List<ICharacter> characters);
    public List<ICharacter> getCharacters();
}
