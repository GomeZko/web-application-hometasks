package GuessGame.services;

import GuessGame.models.GameSession;
import GuessGame.repositories.GameSessionRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GameService {

    private final GameSessionRepository repository;

    public GameService(GameSessionRepository repository) {
        this.repository = repository;
    }

    public String startNewGame() {
        GameSession session = new GameSession();
        session.setId(UUID.randomUUID().toString());
        repository.save(session);
        return session.getId();
    }

    public String makeGuess(String gameId, int number) {
        GameSession session = repository.findById(gameId).orElse(null);

        if (session == null || session.isCompleted()) {
            return "Game not found! Start a new game at /game path.";
        }

        session.incrementAttempts();
        int target = session.getTargetNumber();

        if (number > target) {
            repository.save(session);
            return "Number is smaller!";
        } else if (number < target) {
            repository.save(session);
            return "Number is bigger!";
        } else {
            session.setCompleted(true);
            repository.save(session);
            return "Correct! It took you: " + session.getAttempts() + " times!";
        }
    }
}
