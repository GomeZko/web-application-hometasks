# Guess the Number Game

A REST API game built with Spring Boot. The server picks a random number between 1 and 100, and the player tries to guess it via HTTP requests.

## Running

```bash
./gradlew bootRun
```

The server starts at `http://localhost:8080`.

## How to Play

### 1. Start a new game

```
GET /game
```

Returns a unique `gameId` for your session.

**Example:**
```
GET http://localhost:8080/game
→ "550e8400-e29b-41d4-a716-446655440000"
```

### 2. Make a guess

```
GET /game/{gameId}/guess/{number}
```

**Possible responses:**
- `Number is bigger!` — the target number is higher than your guess
- `Number is smaller!` — the target number is lower than your guess
- `Correct! It took you N times!` — you guessed it in N attempts

**Example:**
```
GET http://localhost:8080/game/550e8400-.../guess/50
→ "Number is bigger!"

GET http://localhost:8080/game/550e8400-.../guess/75
→ "Number is smaller!"

GET http://localhost:8080/game/550e8400-.../guess/62
→ "Correct! It took you 3 times!"
```

## Tech Stack

- Java + Spring Boot
- REST API (Spring Web)
- Gradle
- Lombok