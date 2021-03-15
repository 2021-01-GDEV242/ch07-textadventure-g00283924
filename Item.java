/**
 * Create ingame Items for each room
 *
 * @author  Joan Amaury rosario
 * @version 2020.03.10
 */
public class Item {
    
  private String itemDescription;
  private int itemWeight;

    /**
     * Item description
     * @param (description of the item, weight of the item)
     */
    public Item()
    {
     itemDescription = " " ;
     itemWeight = 0;
    }
    
    /**
     * Creates an item for a room
     * @param (description of the item, weight of the item)
     */
    public Item(String description, int weight)
    {
     itemDescription = description;
     itemWeight = weight;
    }

    /**
     * gets the description of an item
     * @return itemInfo and the weight as a string
     */
    public String getItemDescription()
    {
        String itemInfo ="Item name: "+ this.itemDescription + "Weight: " + this.itemWeight;
        return itemInfo;
    }
}
