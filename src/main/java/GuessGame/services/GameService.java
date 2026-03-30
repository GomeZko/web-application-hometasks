package GuessGame.services;

import GuessGame.models.GameSession;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class GameService {

    private final ConcurrentHashMap<String, GameSession> games = new ConcurrentHashMap<>();

    // For generating game token

    public String startNewGame() {
        String gameId = UUID.randomUUID().toString();
        games.put(gameId,new GameSession());
        return gameId;
    }

    public String makeGuess(String gameId, int number) {
        GameSession session = games.get(gameId);

        if (session == null) {
            return "Game not found! Start a new game at /game path.";
        }

        session.incrementAttempts();
        int target = session.getTargetNumber();

        if (number > target) {
            return "Number is smaller!";
        } else if (number < target) {
            return "Number is bigger!";
        } else {
            int totalAttemps = session.getAttempts();
            games.remove(gameId);
            return "Correct! It took you: " + totalAttemps + " times!";
        }
    }
}
