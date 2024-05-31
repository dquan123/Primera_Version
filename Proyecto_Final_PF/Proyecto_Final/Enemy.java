import greenfoot.*;

public class Enemy extends Actor {
    private int speed = 2;
    private boolean gameEnded = false;
    
    public Enemy() {
        setImage("enemy.png"); 
    }
    
    public void act() {
        setLocation(getX(), getY() + speed);
        if (!gameEnded && getY() >= getWorld().getHeight() - 1) {
            endGame();
        }
        checkCollision();
    }
    
    private void checkCollision() {
        if (!gameEnded) {
            Player player = (Player) getOneIntersectingObject(Player.class);
            if (player != null) {
                endGame();
            }
        }
    }
    
    private void endGame() {
        gameEnded = true;
        GalagaWorld world = (GalagaWorld) getWorld();
        world.gameOver();
    }
}
