package GuessGame.models;

import lombok.Data;

@Data
public class GameSession {
    private final int targetNumber;
    private int attempts;

    public GameSession() {
        this.targetNumber = (int) (Math.random() * 100) + 1;
        this.attempts = 0;
    }

    public void incrementAttempts() {
        this.attempts++;
    }
}
