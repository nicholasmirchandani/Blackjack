import java.util.Scanner;

public class Blackjack
{
    public static void main(String[] args)
    {
        Deck deck = new Deck();
        Player p1 = new Player();
        Player p2 = new Player();
        Scanner sin = new Scanner(System.in);
        boolean playAgain = true;
        while(playAgain)
        {
            //Deal 2 cards to each player to begin
            p1.collect(deck.dealCard());
            p1.collect(deck.dealCard());
            p2.collect(deck.dealCard());
            p2.collect(deck.dealCard());

            //P1 is player, P2 is computer

            //P1 turn
            while(true)
            {
                System.out.println("\nYOUR CARDS:");
                for(Card c : p1.getHand())
                {
                    System.out.println(c.toString());
                }
                System.out.println("Current score: " + p1.getScore());
                System.out.println("\nHit or Pass? (h/p)"); //Everything except "h" is pass
                if(sin.nextLine().equals("h"))
                {
                    Card cardToDraw = deck.dealCard();
                    p1.collect(cardToDraw);
                    System.out.println("You drew a " + cardToDraw.toString());
                }
                else
                {
                    break;
                }
                if(p1.getScore() > 21)
                {
                    System.out.println("You busted :(");
                    p1.setHasBusted(true);
                    break;
                }
            }

            System.out.println(); //Formatting

            //AI Turn
            while(p2.getScore() < 17 && !p1.getHasBusted()) //If the player has busted, the house will not take another card
            {
                System.out.println("The house draws a card.");
                p2.collect(deck.dealCard());
            }

            if(p2.getScore() > 21)
            {
                System.out.println("\nThe house has busted with the following: ");
                for(Card c : p2.getHand())
                {
                    System.out.println(c.toString());
                }
                p2.setHasBusted(true);
            }
            else
            {
                System.out.println("The house passes."); //To get to this line, the house must have just passed to exit the loop
            }
 
            System.out.println("\nPlayer 1 Score: " + p1.getScore());
            System.out.println("House Score: " + p2.getScore());
            if(p1.getScore() > p2.getScore() && !p1.getHasBusted() || p2.getHasBusted())
            {
                System.out.println("\nPlayer 1 wins!");
            }
            else if(p2.getScore() > p1.getScore() && !p2.getHasBusted() || p1.getHasBusted())
            {
                System.out.println("\nHouse wins");
            }
            else
            {
                System.out.println("\nNobody wins :(");
            }
            System.out.println("\nPlay again? (y/n)");
            String input = sin.nextLine();
            if(input.equals("y"))
            {
                //Put cards back into deck
                while(p1.getHandSize() > 0)
                {
                    deck.collectCard(p1.flip());
                }

                while(p2.getHandSize() > 0)
                {
                    deck.collectCard(p2.flip());
                }

                continue;
            }
            else
            {
                break;
            }
            
        }
        System.out.println("\nHave a nice day!");
        sin.close();
    }
}