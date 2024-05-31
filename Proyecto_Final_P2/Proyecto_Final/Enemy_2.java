import greenfoot.*;

public class Enemy_2 extends Actor {
    private int speed = 2;
    private int shootingInterval = 50;
    private int shootingTimer = 0;

    public Enemy_2() {
        setImage("Enemy_2.png"); // Asegúrate de tener una imagen llamada "enemy_2.png" en la carpeta de imágenes.
    }

    public void act() {
        moveDown();
        shoot();
        checkCollision();
    }

    private void moveDown() {
        if (getWorld() != null) { // Verificar si el actor sigue en el mundo
            setLocation(getX(), getY() + speed);
            if (getY() >= getWorld().getHeight() - 1) {
                World world = getWorld();
                if (world != null) {
                    world.removeObject(this);
                }
            }
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
        if (getWorld() == null) return; // Verificar si el actor sigue en el mundo

        Player player = (Player) getOneIntersectingObject(Player.class);
        if (player != null) {
            GalagaWorld world = (GalagaWorld) getWorld();
            if (world != null) {
                world.removeObject(player);
                world.gameOver();
            }
            // Eliminar el enemigo, no la bala
            if (getWorld() != null) {
                getWorld().removeObject(this);
            }
        }
    }
}
