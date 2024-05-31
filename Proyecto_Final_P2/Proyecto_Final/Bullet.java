import greenfoot.*;

public class Bullet extends Actor {
    private int speed = 10;
    
    public Bullet() {
        setImage("bullet.png"); // Asegúrate de tener una imagen llamada "bullet.png" en la carpeta de imágenes.
    }
    
    public void act() {
        setLocation(getX(), getY() - speed);
        if (getY() == 0) {
            getWorld().removeObject(this);
        } else {
            checkCollision();
        }
    }
    
    private void checkCollision() {
        Actor enemy = getOneIntersectingObject(Enemy.class);
        if (enemy != null) {
            getWorld().removeObject(enemy);
            getWorld().removeObject(this);
        }
        else {
            Actor enemy_2 = getOneIntersectingObject(Enemy_2.class);
            if (enemy_2 != null) {
                getWorld().removeObject(enemy_2);
                getWorld().removeObject(this);
        }
        }
    }
}
