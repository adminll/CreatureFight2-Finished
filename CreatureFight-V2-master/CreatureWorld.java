/**
 * TODO (75): Add an assignment comment block below...
 * Class: Software development
 * Name: Kaden Spletzer
 * Due: Monday 11/26/18
 * Last edited: 11/23/18
 */
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.util.List;

//TODO (1): Import the javax.swing.JOptionPane library
import javax.swing.JOptionPane;

/**
 * Write a description of class CreatureWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CreatureWorld extends World
{
    private Creature playerOneCreature;
    private Creature playerTwoCreature;
    
    //TODO (2): Declare an integer instance variable called turnNumber
    int turnNumber;
    
    //TODO (3): Declare a Menu instance variable called oneFightMenu
    Menu oneFightMenu;
    
    //TODO (4): Declare a Menu instance variable called oneSwitchMenu
    Menu oneSwitchMenu;
    
    //TODO (5): Declare a Menu instance variable called twoFightMenu
    Menu twoFightMenu;
    
    //TODO (6): Declare a Menu instance variable called twoSwitchMenu
    Menu twoSwitchMenu;
    
    //TODO (7): Declare a String instance variable called playerOneName initialized to "1"
    String playerOneName = "1";
    
    //TODO (8): Declare a String instance variable called playerTwoName initialized to "2"
    String playerTwoName = "2";

    /**
     * Default constructor for objects of class CreatureWorld.
     * 
     * @param There are no parameters
     * @return an object of class CreatureWorld
     */
    public CreatureWorld()
    {    
        // Create a new world with 400x400 cells with a cell size of 1x1 pixels.
        super(400, 400, 1); 
        playerOneCreature = new Charmander(this);
        playerTwoCreature = new Pikachu(this);

        prepareCreatures();
        
        //TODO (9): Initialize the turnNumber variable to 0
        turnNumber = 0;

        Greenfoot.start();
    }
    
    /**
     * act will complete actions that the CreatureWorld object should
     * accomplish while the scenario is running
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void act()
    {
        List allObjects = getObjects(null);

        //TODO (10): If the turn number is equal to zero...
        
        if(turnNumber == 0)
        {
            playerOneName = JOptionPane.showInputDialog(null, "P1, enter your name", "P1's name: ", JOptionPane.QUESTION_MESSAGE);
            playerTwoName = JOptionPane.showInputDialog(null, "P2, enter your name", "P2's name: ",JOptionPane.QUESTION_MESSAGE);
            
            oneFightMenu = new Menu(" Fight ", " Scratch \n FlameThrower ",24,Color.BLACK,Color.WHITE,Color.BLACK,Color.WHITE,new FightCommands());
            oneSwitchMenu = new Menu(" Switch ", " Golem \n Ivysaur ",24,Color.BLACK,Color.WHITE,Color.BLACK,Color.WHITE, new SwitchCommands());
            addObject(oneFightMenu,173,getHeight()-100);
            addObject(oneSwitchMenu,241,getHeight()-100);
            twoFightMenu= new Menu(" Fight "," Tackel \n Thunderbolt ",24,Color.BLACK,Color.WHITE,Color.BLACK,Color.WHITE,new FightCommands());
            twoSwitchMenu= new Menu(" Switch "," Lapras \n Pidgeot ",24,Color.BLACK,Color.WHITE,Color.BLACK,Color.WHITE,new FightCommands());
            addObject(twoFightMenu,131,75);
            addObject(twoSwitchMenu,199,75);
            turnNumber = 1;
        }
        else if(turnNumber==1)
        {
            showText("Your turn player 1!",getWidth()/2,getHeight()/2);
        }
        else
        {
            showText("Your turn player 2!",getWidth()/2,getHeight()/2);
        }
            //TODO (73): Initialize the playerOneName variable by using a JOptionPane showInputDialog that uses null, a message to let the user know what to enter, a title for the input box, and JOptionPane.QUESTION_MESSAGE as parameters
            
            
            //TODO (74): Initialize the playerTwoName variable by using a JOptionPane showInputDialog that uses null, a message to let the user know what to enter, a title for the input box, and JOptionPane.QUESTION_MESSAGE as parameters
            

            //TODO (11): Initialize the oneFightMenu variable to a new Menu object with " Fight ", " Scratch \n Flamethrower ", 24, BLACK, WHITE, BLACK, WHITE, and a new FightCommands() object as parameters
            
            
            //TODO (12): Initialize the oneSwitchMenu variable to a new Menu object with " Switch ", " Golem \n Ivysaur ", 24, BLACK, WHITE, BLACK, WHITE, and a new SwitchCommands() object as parameters
            

            //TODO (13): Add the oneFightMenu at an x location of 173 and a y location of 100 pixels less than the height
            
            
            //TODO (14): Add the oneSwitchMenu at an x location of 241 and a y location of 100 pixels less than the height
            

            //TODO (15): Initialize the twoFightMenu variable to a new Menu object with " Fight ", " Tackle \n Thunderbolt ", 24, BLACK, WHITE, BLACK, WHITE, and a new FightCommands() object as parameters
            
            
            //TODO (16): Initialize the twoSwitchMenu variable to a new Menu object with " Switch ", " Lapras \n Pidgeot ", 24, BLACK, WHITE, BLACK, WHITE, and a new SwitchCommands() object as parameters
            

            //TODO (17): Add the twoFightMenu at an x location of 131 and a y location of 75
            
            
            //TODO (18): Add the twoSwitchMenu at an x location of 199 and a y location of 75
            

            //TODO (19): Set turnNumber to 1
            
        //TODO (20): Otherwise, if turnNumber is equal to 1...
        
            //TODO (21): Use the showText method to display player one's name and the fact that it is their turn in the middle of the world
            
        //TODO (22): Otherwise...
        
            //TODO (23): Use the showText method to display player two's name and the fact that it is their turn in the middle of the world
            

        if( playerOneCreature.getHealthBar().getCurrent() <= 0 )
        {
            removeObjects(allObjects);
            //TODO (24): Change this showText to display player two's name instead of "Player Two"
            showText("Player Two wins!!", getWidth()/2, getHeight()/2);
            Greenfoot.stop();
        }

        if( playerTwoCreature.getHealthBar().getCurrent() <= 0 )
        {
            removeObjects(allObjects);
            //TODO (25): Change this showText to display player one's name instead of "Player One"
            showText("Player One wins!!", getWidth()/2, getHeight()/2);
            Greenfoot.stop();
        }
    }

    /**
     * prepareCreatures adds the creatures for both players to the world
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    private void prepareCreatures()
    {
        addObject( playerOneCreature, playerOneCreature.getImage().getWidth()/2, getHeight() - playerOneCreature.getImage().getHeight()/2);
        addObject( playerTwoCreature, getWidth() - playerTwoCreature.getImage().getWidth()/2, playerTwoCreature.getImage().getHeight()/2);
    }
    
    /**
     * getPlayerOne returns player one's current creature for
     * use in other parts of the code or for the user's information
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public Creature getPlayerOne()
    {
        return playerOneCreature;
    }

    /**
     * getPlayerTwo returns player two's current creature for
     * use in other parts of the code or for the user's information
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public Creature getPlayerTwo()
    {
        return playerTwoCreature;
    }

    /**
     * @param no params
     * @return returns "turnNumber"
     */
    public int getTurnNumber()
    {
        return turnNumber;
    }

    /**
     * @param no params
     * @return returns "turnNumber"
     */
    public int setTurnNumber(int turn)
    {
        return turnNumber;
    }
}
