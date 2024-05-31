import greenfoot.*;

public class Enemy extends Actor {
    private int speed = 2;
    
    public Enemy() {
        setImage("enemy.png"); // Asegúrate de tener una imagen llamada "enemy.png" en la carpeta de imágenes.
    }
    
    public void act() {
        setLocation(getX(), getY() + speed);
        if (getY() == getWorld().getHeight() - 1) {
            endGame();
        }
        checkCollision();
    }
    
    private void checkCollision() {
        Player player = (Player) getOneIntersectingObject(Player.class);
        if (player != null) {
            endGame();
        }
    }
    
    private void endGame() {
        GalagaWorld world = (GalagaWorld) getWorld();
        world.gameOver();
    }
}
