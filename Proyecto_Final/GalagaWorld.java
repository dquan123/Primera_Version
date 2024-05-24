import greenfoot.*;

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
        addObject(new Enemy(), x, 0);
    }
    
    public void gameOver() {
        gameOver = true;
        showText("Game Over", getWidth() / 2, getHeight() / 2);
        Greenfoot.stop();
    }
}
