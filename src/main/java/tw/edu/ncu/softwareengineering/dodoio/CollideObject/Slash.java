package tw.edu.ncu.softwareengineering.dodoio.CollideObject;

import tw.edu.ncu.softwareengineering.dodoio.Collide.RectangleCollider;

public class Slash extends AttackObject {
    int height;
    int width;
    int FPS = 20;// set for no error. this is not real
    double slashTime = 0.5;

    /**
     * move the slash region out of swordman's body
     *
     * @param inputID
     * @param image
     * @param setPosition
     * @param setPlayer
     */
    public Slash(int setID, CollideObjectManager cOManager, int className, Character setPlayer) {
        super(setID, cOManager, className, setPlayer);
        this.position = player.getPosition();
        player = setPlayer;
        width = (int) (player.getRadius()*2);
        height = player.getRadius();
        collider = new RectangleCollider(position, width, height);
        isInvincible = true;
        Position.projection(player.getRadius(), position);
        move(position);
        damage = (int) player.damagePoint;
        priority =2;
    }

    @Override
    public void move(Position nextPosition) {
        position = nextPosition;
        collider.update(nextPosition);
    }

    ;

    /**
     * update it slash time, let it dead when run out of slashTime
     */
    @Override
    public void update() {
        long newTime = date.getTime();
        long updateTime = oldTime - newTime;
        while (updateTime >= 0) {
            if (!isDead() && slashTime > 0) {
                slashTime -= 1000 / FPS;
            } else {
                dead();
                break;
            }
            updateTime -= 1000 / FPS;
        }
    }
}
