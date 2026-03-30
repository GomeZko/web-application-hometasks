package GuessGame.controllers;



import GuessGame.services.GameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public String startNewGame() {
        return gameService.startNewGame();
    }

    @GetMapping("/{gameId}/guess/{number}")
    public String makeGuess(@PathVariable String gameId, @PathVariable int number) {
        return gameService.makeGuess(gameId, number);
    }
}
