package advertising;

import java.util.Scanner;
import java.math.BigDecimal;

/** The graphic style of an advert. */
enum Graphic
{
    NONE(0),
    SMALL(1907),
    MEDIUM(2476),
    LARGE(2933);

    private final int cost;

    private Graphic(int cost)
    {
        this.cost = cost;
    }

    /** Returns the cost in cents. */
    public int getCost()
    {
        return cost;
    }
}

/** The link payment plan for an advert. */
enum LinkPlan
{
    NONE(0),
    PREPAID(1495), // 1 month
    POSTPAID(1495 * 3 - (1495 * 3) / 10); // 10% discount for 3 months up-front

    private final int cost;

    private LinkPlan(int cost)
    {
        this.cost = cost;
    }

    /** Returns the cost in cents. */
    public int getCost()
    {
        return cost;
    }
}

class Advertisement
{
    private final int wordCount;
    private final LinkPlan linkPlan;
    private final Graphic graphic;

    public Advertisement(int wordCount, LinkPlan linkPlan, Graphic graphic)
    {
        this.wordCount = wordCount;
        this.linkPlan = linkPlan;
        this.graphic = graphic;
    }

    /**
     * Returns the fee for the words in the advert, in cents.
     * 
     * For up to 25 words, there's a flat fee of 40c per word and a base fee
     * of $3.00.
     * 
     * For 26-35 words inclusive, the fee for the first 25 words is as before,
     * but the per-word fee goes down to 35c for words 26-35.
     * 
     * For more than 35 words, there's a flat fee of 32c per word, and no
     * base fee.     
     */
    public int getWordCost()
    {
        if (wordCount > 35)
        {
            return 32 * wordCount;
        }
        // Apply flat fee always, then up to 25 words at 40 cents,
        // then the rest at 35 cents.
        return 300 + Math.min(wordCount, 25) * 40
                   + Math.min(wordCount - 25, 0) * 35;        
    }

    /**
     * Displays the costs associated with this advert.
     */
    public void printAllCosts()
    {
        System.out.printf("\t\t%-16s %11s\n", "Category", "Cost");
        printCost("Text", getWordCost());
        printCost("Link", linkPlan.getCost());
        printCost("Graphic", graphic.getCost());
        int total = getWordCost() + linkPlan.getCost() + graphic.getCost();
        printCost("Total", total);
        int gst = total / 20;
        printCost("GST", gst);
        printCost("Total with GST", total + gst);
    }

    private void printCost(String category, int cents)
    {
        BigDecimal dollars = new BigDecimal(cents).scaleByPowerOfTen(-2);
        System.out.printf("\t\t%-16s %11.2f\n", category, dollars);
    }
}

/**
 * The entry point for the program - takes user input, builds an 
 * Advertisement, and displays its cost.
 */
public class EntryPoint
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome!");
        int wordCount = readWordCount(scanner);
        LinkPlan linkPlan = readLinkPlan(scanner);
        Graphic graphic = readGraphic(scanner);

        Advertisement advert = new Advertisement(wordCount, linkPlan, graphic);
        advert.printAllCosts();
    }

    private static int readWordCount(Scanner scanner)
    {
        System.out.print("Enter the number of words in your ad: ");
        // Could add validation code in here
        return scanner.nextInt();
    }

    private static LinkPlan readLinkPlan(Scanner scanner)
    {
        System.out.print("Would you like to add a link (y = yes or n = no)? ");
        char addLink = readSingleCharacter(scanner, "yn");
        LinkPlan linkPlan;
        if (addLink == 'n')
        {
            return LinkPlan.NONE;
        }
        System.out.print("Would you like to pay 3 months in advance " +
                         "(y = yes or n = no)? ");
        char advancePay = readSingleCharacter(scanner, "yn");
        return advancePay == 'y' ? LinkPlan.PREPAID : LinkPlan.POSTPAID;
    }

    private static Graphic readGraphic(Scanner scanner)
    {
        System.out.print("Would you like to add graphics/pictures? " +
            "(s = small, m = medium, l = large or n = None)? ");
        char graphic = readSingleCharacter(scanner, "smln");
        switch (graphic)
        {
            case 's': return Graphic.SMALL;
            case 'm': return Graphic.MEDIUM;
            case 'l': return Graphic.LARGE;
            case 'n': return Graphic.NONE;
            default:
                throw new IllegalStateException("Unexpected state; graphic=" +
                                                graphic);
        }
    }

    private static char readSingleCharacter(Scanner scanner,
                                            String validOptions)
    {
        while(true)
        {
            String input = scanner.next();
            if (input.length() != 1 || !validOptions.contains(input))
            {
                System.out.print("Invalid value. Please try again: ");
                continue;
            }
            return input.charAt(0);
        }
    }
}