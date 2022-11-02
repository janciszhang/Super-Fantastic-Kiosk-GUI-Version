package assignment1;

import java.util.ArrayList;

/**
 * This class Item is the all products of Kiosk.
 * Store information in ArrayList which include items' id, items' name, items' price.
 * Can print all items information.
 *
 * @author  Zhang
 * @version 1.8.0   28 March 2020
 */
public class Item
{
    /**
     * Field:
     * ids: items' ID store in ArrayList
     * names: items' names store in ArrayList
     * prices: items' prices store in ArrayList
     */
    private ArrayList<Integer> ids;
    private ArrayList<String> names;
    private ArrayList<Integer> prices;

    /**
     * Constructor for object of class Item
     * Default Constructor (no parameter)
     * All initial values are from Kiosk Item Table
     */
    public Item()
    {
        ids = new ArrayList<>();
        names = new ArrayList<>();
        prices = new ArrayList<>();
        names.add("PEN");
        names.add("BOOK");
        names.add("DVD");
        names.add("MOUSE");
        names.add("KEYBOARD");
        for (int i = 0; i < names.size(); i++)
        {
            ids.add(i + 1);
            prices.add((i + 1) * 10);
        }
    }

    /**
     * Accessor (getter) to get ids ArrayList
     *
     * @return ArrayList ids
     */
    public ArrayList getIds()
    {
        return ids;
    }

    /**
     * Accessor (getter) to get names ArrayList
     *
     * @return ArrayList names
     */
    public ArrayList getNames()
    {
        return names;
    }

    /**
     * Accessor (getter) to get prices ArrayList
     *
     * @return ArrayList prices
     */
    public ArrayList getPrices()
    {
        return prices;
    }

    /**
     * Mutator (setter) to set ids ArrayList
     *
     * @param id an int input to set ids ArrayList
     */
    public void setIds(int id)
    {
        ids.add(id);
    }

    /**
     * Mutator (setter) to set names ArrayList
     *
     * @param name a String input to set names ArrayList
     */
    public void setNames(String name)
    {
        names.add(name);
    }

    /**
     * Mutator (setter) to set prices array
     *
     * @param price an int input to set prices array
     */
    public void setPrices(int price)
    {
        prices.add(price);
    }

    /**
     * Show all items information (for loop)
     * Print format example: (1) PEN, worth $10
     */
    public void showItems()
    {
        for (int i = 0; i < ids.size(); i++)
            System.out.println("(" + ids.get(i) + ") " + names.get(i) + ", worth " + "$" + prices.get(i));
    }

    /**
     * =========================== Test ===========================
     */
    public static void main(String[] args)
    {
        Item items = new Item();
        items.setNames("Air");
        items.setIds(6);
        items.setPrices(6666);
        items.showItems();
    }

}
