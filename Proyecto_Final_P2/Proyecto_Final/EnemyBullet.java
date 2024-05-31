import greenfoot.*;

public class EnemyBullet extends Actor {
    private int speed = 5;

    public EnemyBullet() {
        setImage("bullet.png"); // Asegúrate de tener una imagen llamada "enemy_bullet.png" en la carpeta de imágenes.
    }

    public void act() {
        moveDown();
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

    private void checkCollision() {
        if (getWorld() == null) return; // Verificar si el actor sigue en el mundo

        Player player = (Player) getOneIntersectingObject(Player.class);
        if (player != null) {
            GalagaWorld world = (GalagaWorld) getWorld();
            if (world != null) {
                world.removeObject(player);
                world.gameOver();
            }
            // Verificar que el actor no haya sido eliminado antes de intentar eliminarlo de nuevo
            if (getWorld() != null) {
                getWorld().removeObject(this);
            }
        }
    }
}
