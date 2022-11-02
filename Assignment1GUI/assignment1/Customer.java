package assignment1;

/**
 * This class Customer is all information about customer.
 * Include: customer's name, all items customer bought and the total cost.
 *
 * @author  Zhang
 * @version 1.8.0   28 March 2020
 */
public class Customer
{
    /***
     * Field:
     * itemsPurchased: String, all items customer bought
     * name: String, customer's name
     * totalCost: int, customer total cost for all items he bought
     */
    private String itemsPurchased;
    private String name;
    private int totalCost;

    /**
     * Constructor for object of class Customer
     * Default Constructor (no parameter)
     * All initial values are default value (int: 0, String: "")
     */

        public Customer()
    {
        itemsPurchased = "";
        name = "";
        totalCost = 0;
    }

    /**
     * Constructor for object of class Customer
     * Constructor with parameter
     * Only name from parameters, others are default value (int: 0, String: "")
     *
     * @param name an String input to set name
     */
    public Customer(String name)
    {
        itemsPurchased = "";
        this.name = name;
        totalCost = 0;
    }


        /**
     * Accessor (getter) to get itemsPurchased
     *
     * @return String itemsPurchased
     */
    public String getItemsPurchased()
    {
        return itemsPurchased;
    }

    /**
     * Accessor (getter) to get name
     *
     * @return String name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Accessor (getter) to get totalCost
     *
     * @return int totalCost
     */
    public int getTotalCost()
    {
        return totalCost;
    }

    /**
     * Mutator (setter) to set itemsPurchased (no parameter)
     * initialise itemsPurchased as ""
     */
    public void setItemsPurchased()
    {
        itemsPurchased = "";
    }

    /**
     * Mutator (setter) to set itemsPurchased
     *
     * @param itemsPurchased an String input to set itemsPurchased
     */
    public void setItemsPurchased(String itemsPurchased)
    {
        this.itemsPurchased += (itemsPurchased + " ");
    }

    /**
     * Mutator (setter) to set name
     *
     * @param name an String input to set name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Mutator (setter) to set totalCost (no parameter)
     * initialise totalCost as 0
     */
    public void setTotalCost()
    {
        totalCost = 0;
    }

    /**
     * Mutator (setter) to set totalCost
     *
     * @param cost an int input to set totalCost
     */
    public void setTotalCost(int cost)
    {
        totalCost += cost;
    }

}
