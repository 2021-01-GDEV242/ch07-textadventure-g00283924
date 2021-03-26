/**
 * Write a description of class Player here.
 *
 * @author  Joan Amaury rosario
 * @version 2020.03.20
 */
public class Player
{
    // instance variables - replace the example below with your own
    private String playerName;
    private static int MAXWEIGHT = 50;
    private double playerWeight;
    private Room currentRoom;

    /**
     * Constructor for objects of class Player
     */
    public Player(String name)
    {
        this.playerName = playerName;
        
        playerWeight = 10;
    }

     /**
     *A method to return the players name
     */
    public String getPlayerName()
    {
        return playerName;
    }
 
    /**
    * A method to return the weight of the player 
    */
    public double getPlayerWeight()
    {
        return playerWeight;
    }
    
    /**
     * returns the max weight a player can hold
     */
    public int getMAXWEIGHT()
    {
        return MAXWEIGHT;
    }
    
}

