import greenfoot.*;
import java.util.List;

public class GalagaWorld extends World {

    private boolean gameOver = false;

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
        showText("Game Over", getWidth() / 2, getHeight() / 2);
        
        // Eliminar todos los enemigos y balas
        List<Actor> actors = getObjects(Actor.class);
        for (Actor actor : actors) {
            if (!(actor instanceof Player)) {
                removeObject(actor);
            }
        }

        Greenfoot.stop();
    }
}
