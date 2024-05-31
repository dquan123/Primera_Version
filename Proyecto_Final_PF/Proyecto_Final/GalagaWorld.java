import greenfoot.*;
import java.util.List;

public class GalagaWorld extends World {

    private boolean gameOver = false;
    private int score = 0;

    public GalagaWorld() {    
        super(600, 800, 1);
        addObject(new Player(), getWidth() / 2, getHeight() - 50);
        spawnEnemies();
    }

    public void act() {
        if (!gameOver) {
            if (Greenfoot.getRandomNumber(100) < 2) {
                spawnEnemies();
            }
        }
    }

    private void spawnEnemies() {
        int x = Greenfoot.getRandomNumber(getWidth());
        if (Greenfoot.getRandomNumber(2) == 0) {
            addObject(new Enemy(), x, 0);
        } else {
            addObject(new Enemy_2(), x, 0);
        }
    }

    public void gameOver() {
        gameOver = true;
        showText("Game Over\nScore: " + score, getWidth() / 2, getHeight() / 2);
        Greenfoot.stop();
    }

    public void incrementScore(int points) {
        score += points;
    }
}
