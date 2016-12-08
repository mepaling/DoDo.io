package tw.edu.ncu.softwareengineering.dodoio.CollideObject;

import java.awt.image.BufferedImage;

import tw.edu.ncu.softwareengineering.dodoio.Collide.ICollider;

public abstract class CollideObject {
	protected Position position;
	public BufferedImage appearance;
	public final int ID;
	public final int collideDamage = 30;
	protected boolean isInvincible;
	protected int healthPoint;
	protected ICollider collider;
	private boolean isDead;
	
	/**set data of the object
	 * 
	 * @param inputID
	 * @param image
	 * @param setPosition
	 */
	protected CollideObject(int inputID, BufferedImage image, Position setPosition) {
		ID = inputID;
		appearance = image;
		position = setPosition;
		healthPoint = 1000;
		isInvincible = false;
		isDead = false;
	}
	
	/**Method to complete
	 * 
	 * @param whichObjectCollideThis
	 */
	public void onCollide(CollideObject whichObjectCollideThis){
		this.beHarmed(collideDamage);
	}
	
	public boolean isInvincible() {
		return isInvincible;
	}
	
	/**when player are attacked, check if it is invincible and change the healthPoint
	 * 
	 * @param damage
	 */
	protected void beHarmed(int damage) {
		if(this.isInvincible()) return;
		
		if(damage >= this.healthPoint) {
			this.dead();
		}
		else
			this.healthPoint-=damage;
	}
	
	protected void dead() {
		isDead = true;
	}
	
	public int getHP(){
		return healthPoint;
	}
	
	public Position getPosition(){
		return position;
	}
	
	public ICollider getCollider() {
		return collider;
	}
	
	public void move(Position nextPosition){
		position = nextPosition;
	}
	/**To get "if the object is dead?"
	 * 
	 * @return
	 */
	public boolean isDead() {
		return isDead;
	}
	
}
