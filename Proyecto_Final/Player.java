import greenfoot.*;

public class Player extends Actor {
    private int speed = 5;
    private boolean canShoot = true;
    
    public Player() {
        setImage("player.png"); // Asegúrate de tener una imagen llamada "player.png" en la carpeta de imágenes.
    }
    
    public void act() {
        move();
        shoot();
    }
    
    private void move() {
        if (Greenfoot.isKeyDown("left")) {
            setLocation(getX() - speed, getY());
        }
        if (Greenfoot.isKeyDown("right")) {
            setLocation(getX() + speed, getY());
        }
        if (Greenfoot.isKeyDown("up")) {
            setLocation(getX(), getY() - speed);
        }
        if (Greenfoot.isKeyDown("down")) {
            setLocation(getX(), getY() + speed);
        }
    }
    
    private void shoot() {
        if (Greenfoot.isKeyDown("space")) {
            if (canShoot) {
                getWorld().addObject(new Bullet(), getX(), getY() - 30);
                canShoot = false; // Desactivar el disparo hasta que se libere la tecla
            }
        } else {
            canShoot = true; // Permitir disparar nuevamente cuando la tecla se libera
        }
    }
}
