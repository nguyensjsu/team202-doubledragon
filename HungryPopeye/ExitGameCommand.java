import greenfoot.*;

/**
 * Write a description of class ExitGameCommand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ExitGameCommand extends Actor implements ICommand
{
    private IGameReceiver changeGame;
    private Trampoline trampoline;
        
    public void act() 
    {
        // Add your action code here.
    } 

    /**
     * Constructor for objects of class exitGame
     */
    public ExitGameCommand(IGameReceiver newGame, Trampoline p)
    {
        this.changeGame=newGame;
        this.trampoline = p;
    }
    
    public void execute()
    {
        changeGame.doAction(trampoline);
    }       
}