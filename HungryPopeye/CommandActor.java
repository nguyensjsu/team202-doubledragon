import greenfoot.*;

/**
 * Write a description of class CommandActor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CommandActor extends Actor
{
    
    Trampoline p;
    GameInvoker myGameInvoker;
    ICommand startGame; 
    ICommand exitGame;
    IGameReceiver startGameRecevier,exitGameReceiver;
    boolean start = false;
    boolean exit = false;
    
    
    public void act() 
    {
              
        if (Greenfoot.isKeyDown("space")){    
            start = true;            
            callInvoker();
        }
        
        if (Greenfoot.isKeyDown("escape")){
            exit = true;
            callInvoker();
        }
    }    
    
    public CommandActor(Trampoline trampoline)
    {
        p = trampoline;
        myGameInvoker = new GameInvoker();
        startGameRecevier= new StartGameReceiver();
        exitGameReceiver= new ExitGameReceiver();
        startGame = new StartGameCommand(startGameRecevier, p);
        exitGame = new ExitGameCommand(exitGameReceiver, p);               
    }
    
    public void callInvoker(){
        
        if (p.havePopeye() && start){
             myGameInvoker.executeGame(startGame); 
        }
        
        if (exit){
            myGameInvoker.executeGame(exitGame); 
        }
    }
    
}