import greenfoot.*;

public class EnemyBullet extends Actor {
    private int speed = 5;

    public EnemyBullet() {
        setImage("bullet.png"); 
    }

    public void act() {
        moveDown();
        checkCollision();
    }

    private void moveDown() {
        if (getWorld() != null) { 
            setLocation(getX(), getY() + speed);
            if (getY() >= getWorld().getHeight() - 1) {
                World world = getWorld();
                if (world != null) {
                    world.removeObject(this);
                }
            }
        }
    }

    private void checkCollision() {
        if (getWorld() == null) return;

        Player player = (Player) getOneIntersectingObject(Player.class);
        if (player != null) {
            GalagaWorld world = (GalagaWorld) getWorld();
            if (world != null) {
                world.removeObject(player);
                world.gameOver();
            }
            if (getWorld() != null) {
                getWorld().removeObject(this);
            }
        }
    }
}
