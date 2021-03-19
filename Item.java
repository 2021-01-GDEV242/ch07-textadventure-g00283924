import java.util.ArrayList;
/**
 * Create ingame Items for each room
 *
 * @author  Joan Amaury rosario
 * @version 2020.03.10
 */
   public class Item 
   {
   private String description;
   private int weight;
   private String name;
   private ArrayList<Item> items;
  
    /**
    * Constructor for the Class Items
    */
    public Item(String description,int weight, String name)
    {
    this.description = description;
    this.weight = weight;
    this.name = name;
    ArrayList items = new ArrayList (20);
   }
   
    /**
     * Item description
     * (defined in constructor)
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * @return The weight of the item
     * (the one that was defined in the constructor).
     */
    public int getWeight()
    {
        return weight;
    }
    
    /**
     * @return The name of the item
     * (the one that was defined in the constructor).
     */
    public String getName()
    {
        return name;
    }
    
}
