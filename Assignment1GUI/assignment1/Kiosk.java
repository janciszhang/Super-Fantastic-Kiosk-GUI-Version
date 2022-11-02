package assignment1;

import java.util.ArrayList;

/**
 * This class Kiosk is to simulate the whole purchase process
 * Show Menu include welcome and all options
 * Customer choose an option of Menu
 * Switch to each option according to option that customer choose
 * While customer choose 7, end whole purchase process and clear information
 *
 * @author  Zhang
 * @version 1.8.0   18 April 2020
 */
public class Kiosk
{
    /**
     * Field:
     * credit: int, credit balance, customer can charge it and use it to buy
     * customer1: Customer, one customer object which belong to Customer class
     * items: Item, one items object which belong to Item class
     * luckyNumber: int, when customer choose that will generate a random number of items' id
     */
    private int credit;
    private Customer customer1;
    private Item items;
    private int luckyNumber;

    /**
     * Constructor for object of class Kiosk
     * Default Constructor (no parameter)
     * Set all the initial value as default value (int: 0, String: "")
     * For luckyNumber, is after the number of items' number
     */
    public Kiosk()
    {
        credit = 0;
        customer1 = new Customer();
        items = new Item();
        luckyNumber = items.getIds().size() + 1;
    }

    /**
     * Constructor for object of class Kiosk
     * Constructor with parameters
     * Set the initial value of customer's name and credit from input parameter
     * For luckyNumber, is after the number of items' number
     *
     * @param credit an int input to set the initial value of credit
     * @param name   a String input to set the initial value of name
     */
    public Kiosk(String name, int credit)
    {
        this.credit = credit;
        customer1 = new Customer(name);
        items = new Item();
        luckyNumber = items.getIds().size() + 1;
    }

    /**
     * Simulate the whole purchase process (do while loop)
     * Customer choose an option of Menu
     * Switch to each option according to option that customer choose
     * While customer choose 7, end whole purchase process
     */
    public void buyWholeProcess()
    {
        System.out.print("\u000C"); // BlueJ clear the screen
        int option = 0;
        do
        {
            System.out.println("Customer Name: " + customer1.getName());
            System.out.println("Credit Balance: $" + credit);
            printMenuOption();
            System.out.print("Choose an option: ");
            option = Input.inputInt();
            System.out.print("\u000C");
            optionSwitch(option);
            System.out.println("");
        } while (option != 7);
    }

    /**
     * Option 5: Collect My Order
     * Indicates the customer has finished with his order and wishes to collect the items purchased.
     * Clear the current order, in preparation for the next order.
     */
    public void collectOrder()
    {
        printOrder();
        System.out.println("Thank you for shopping with us. Please collect your goods (and your " +
                "balance) at the front desk.");
        customer1.setItemsPurchased();
        customer1.setTotalCost();
    }

    /**
     * Accessor (getter) to get credit
     *
     * @return int credit
     */
    public int getCredit()
    {
        return credit;
    }

    /**
     * Accessor (getter) to get luckyNumber
     *
     * @return int luckyNumber
     */
    public int getLuckyNumber()
    {
        return luckyNumber;
    }

    /**
     * Option 7: Leave Kiosk
     * exits the program.
     * Clear all customer/order statistics
     */
    public void leaveClear()
    {
        customer1.setName("");
        customer1.setItemsPurchased();
        customer1.setTotalCost();
        setCredit();
    }

    /**
     * Start point
     */
    public static void main(String[] args)
    {
        Kiosk kiosk = new Kiosk();
        kiosk.buyWholeProcess();
    }

    /**
     * Menu Option Switch 1-7
     * When customer choose an option of menu, switch to each option
     * Must have customer name first, and then can enter other option
     * Combine option 1 and 2 for easy use
     * When input option out of 1-7, print error
     *
     * @param option an int input which is customer choose
     */
    public void optionSwitch(int option)
    {
        if (customer1.getName().equals("") && option != 1 && option != 7)
            System.out.println("Please enter 1 and Create A New Order first!");
        else
            switch (option)
            {
                case 1:
                    System.out.print("Enter your name please: ");
                    String name = Input.inputString();
                    customer1.setName(name);
                    setCredit(); // initialise this credit of new order as 0
                    // break; // combine with option 2
                case 2:
                    System.out.print("Buy some credits please: $");
                    setCredit(Input.inputInt());
                    while (credit == 0)
                    {
                        System.out.print("Buy some credits more than 0 please: $");
                        setCredit(Input.inputInt());
                    }
                    break;
                case 3:
                    purchase();
                    break;
                case 4:
                    printOrder();
                    break;
                case 5:
                    collectOrder();
                    break;
                case 6:
                    printHelp();
                    break;
                case 7:
                    System.out.println("Thank you for your shopping!");
                    leaveClear();
                    break;
                default:
                    System.out.println("Error: your choice must be between 1-7");
                    break;
            }
    }

    /**
     * Option 6: Display Help
     * Displays some brief instructions regarding how to use the program
     * Inform the customer of the rules of item selection
     */
    public void printHelp()
    {
        int size = items.getIds().size();
        System.out.println("There " + size + " products you can buy.");
        System.out.println("If you pick Item #" + luckyNumber + ", the computer will generates \na " +
                "random number between 1 and " + size + ".");
        System.out.println("and then use that number to pick one of the " + size + "\navailable " +
                "items for you.");
    }

    /**
     * Menu
     * Print welcome and all option of menu
     */
    public void printMenuOption()
    {
        System.out.println("Welcome to Super Fantastic Kiosk");
        System.out.println("================================");
        System.out.println("(1) Create A New Order");
        System.out.println("(2) Buy More Credit");
        System.out.println("(3) Purchase An Item");
        System.out.println("(4) What Have I Order So Far?");
        System.out.println("(5) Collect My Order");
        System.out.println("(6) Display Help");
        System.out.println("(7) Leave Kiosk");
    }

    /**
     * Option 4: What Have I Ordered So Far?
     * Displays some statistics about the customer's current order
     */
    public void printOrder()
    {
        System.out.println("Customer " + customer1.getName() + " has " + "purchased these items:");
        System.out.println(customer1.getItemsPurchased());
        System.out.println("worth a total of $" + customer1.getTotalCost());
        System.out.println("Credit balance: $" + credit);
    }

    /**
     * Show items list
     */
    public void printProductList()
    {
        System.out.println("These are the items available for sale today:");
        System.out.println("---------------------------------------------");
        items.showItems();
        System.out.println("(" + luckyNumber + ") Let ME pick a random item for you!!!");
        System.out.println("");
    }

    /**
     * Option 3: Purchase An Item
     * Print items list first
     * Pick a item's id (if is luckyNumber, generate a random number)
     * Check credit balance if is enough buy this item
     * Enough: pay the money and get this item
     * Not enough: tell customer information about that
     */
    public void purchase()
    {
        printProductList();
        System.out.print("Pick a number between 1-" + luckyNumber + ": ");
        int buyProductID = Input.inputInt();
        if (buyProductID < 1 || buyProductID > luckyNumber)
            System.out.println("Error: your choice must be between 1-" + luckyNumber);
        else
        {
            if (buyProductID == luckyNumber)
                buyProductID = LuckyDipGenerator.generateNumber(1, items.getIds().size());
            int index = buyProductID - 1;
            int cost = (int) items.getPrices().get(index);
            String prodName = (String) items.getNames().get(index);
            if (credit >= cost)
            {
                credit -= cost;
                customer1.setTotalCost(cost);
                customer1.setItemsPurchased(prodName);
                System.out.println("You have bought a " + prodName + ", worth $" + cost);
                System.out.println("Your new credit balance is now: $" + credit);
            }
            else
            {
                System.out.println("Sorry, you do not have enough credit to purchase " + prodName +
                        "!");
                System.out.println("Credit Balance: $" + credit + ", Item Price: $" + cost);
            }
        }
    }

    /**
     * Mutator (setter) to set credit (no parameter)
     * initialise credit as 0
     */
    public void setCredit()
    {
        credit = 0;
    }

    /**
     * Option 2: Buy More Credit
     * Mutator (setter) to set credit (if input credit smaller than 0, set as 0)
     *
     * @param credit an int input to set credit
     */
    public void setCredit(int credit)
    {
        if (credit < 0)
        {
            System.out.println("INVALID ENTRY! Please enter a positive number!");
            credit = 0;
        }
        this.credit += credit;
    }

    /**
     * Mutator (setter) to set luckyNumber
     *
     * @param luckyNumber an int input to set credit
     */
    public void setLuckyNumber(int luckyNumber)
    {
        this.luckyNumber = luckyNumber;
    }

}

