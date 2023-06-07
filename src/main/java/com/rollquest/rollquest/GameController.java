package com.rollquest.rollquest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


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

        String rtn = "";
        for(ICharacter character : rollQuestGame.getCharacters()) {
            List<Integer> rollResults = character.rollDice(dice, 3);
            rtn += String.format("%s rolled a ", character.getName());
            for (Integer roll : rollResults) {
                rtn += String.format("[%s] ", roll);
            }
            rtn += "<br>";
        }

        return rtn;
    }
}
