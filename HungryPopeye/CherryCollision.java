import greenfoot.*;

/**
 * Write a description of class CherryCol here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CherryCollision extends Actor implements CollisionHandler
{
     private CollisionHandler successor = null;
    public void handleCollision(String objectName, Popeye objPopeye, int brickLocationX) {
        if(objectName.equals("olive")){
            //System.out.println("Entered into brick check");
            int deltaY = -1 * objPopeye.getDeltaY();
            objPopeye.setDeltaY(deltaY);
            int offset = objPopeye.getX() - brickLocationX;
            int deltaX = objPopeye.getDeltaX() + (offset/10);
            if (deltaX > 7) {
                objPopeye.setDeltaX(7);
            }
            if (deltaX < -7) {
                objPopeye.setDeltaX(-7);
            }
            //((Board)getWorld()).removeObject(brick);
            //((Board)getWorld()).incrementScore();
            //Greenfoot.playSound("Baspinach.mp3");
        }
        else {
            if(successor != null) {
                successor.handleCollision(objectName, objPopeye, brickLocationX);
            }    
        }
    }
    public void setSuccessor(CollisionHandler next) {
        this.successor = next;
    }

}
