package com.rollquest.rollquest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


@RestController
public class GameController {
    @GetMapping("/test-game")
    public String testGame()
    {
        IGame rollQuestGame = new RollQuest();
        List<ICharacter> gameCharacters = new ArrayList<>();

        gameCharacters.add(new Player("Legolas Tobias", "Elf"));
        gameCharacters.add(new Player("Abraxas", "Rabid Hydra"));
        gameCharacters.add(new Player("Aeronwen Amina", "Chasm Giants"));

        rollQuestGame.initializeCharacters(gameCharacters);
        IDice dice = new Dice(6);

        final StringBuffer rtn = new StringBuffer();
        rollQuestGame.getCharacters().stream().forEach((character)->{
            rtn.append(String.format("%s rolled a ", character.getName()));
            character.rollDice(dice, 3).stream().forEach(roll-> rtn.append(String.format("[%s] ", roll)));
            rtn.append("<br>");
        });

        return rtn.toString();
    }
}
