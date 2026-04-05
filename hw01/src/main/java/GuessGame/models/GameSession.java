package GuessGame.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "game_sessions")
public class GameSession {

    @Id
    private String id;

    private int targetNumber;
    private int attempts;
    private boolean completed;

    public GameSession() {
        this.targetNumber = (int) (Math.random() * 100) + 1;
        this.attempts = 0;
        this.completed = false;
    }

    public void incrementAttempts() {
        this.attempts++;
    }
}
