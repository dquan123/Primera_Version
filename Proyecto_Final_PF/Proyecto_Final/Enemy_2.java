import greenfoot.*;

public class Enemy_2 extends Actor {
    private int speed = 2;
    private int shootingInterval = 50;
    private int shootingTimer = 0;
    private boolean gameEnded = false;

    public Enemy_2() {
        setImage("Enemy_2.png");
    }

    public void act() {
        moveDown();
        shoot();
        checkCollision();
    }

    private void moveDown() {
        if (getWorld() != null) {
            setLocation(getX(), getY() + speed);
            if (getY() >= getWorld().getHeight() - 1) {
                endGame();
            }
        }
    }

    private void removeEnemy() {
        World world = getWorld();
        if (world != null) {
            world.removeObject(this);
        }
    }

    private void shoot() {
        if (shootingTimer == 0) {
            World world = getWorld();
            if (world != null) {
                world.addObject(new EnemyBullet(), getX(), getY() + 30);
                shootingTimer = shootingInterval;
            }
        } else {
            shootingTimer--;
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
            removeEnemy();
        }
    }
    
    private void endGame() {
        gameEnded = true;
        GalagaWorld world = (GalagaWorld) getWorld();
        world.gameOver();
    }
}
