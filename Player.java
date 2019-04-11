import java.util.LinkedList;
/**
 * A player in a game of Blackjack
 */
public class Player
{
    private LinkedList<Card> m_hand;
    private boolean m_hasBusted;

    public Player()
    {
        m_hand = new LinkedList<Card>();
    }

    /**
     * Adds a card to the player's hand
     * @param someCard the card to add
     */
    public void collect(Card someCard)
    {
        m_hand.add(someCard);
    }

    /**
     * Flips a card from the players hand
     * @return the card flipped
     */
    public Card flip()
    {
        return m_hand.pop();
    }

    /**
     * Accessor for hand size
     * @return hand size
     */
    public int getHandSize()
    {
        return m_hand.size();
    }

    /**
     * Accessor for hand
     * @return hand
     */
    public LinkedList<Card> getHand()
    {
        return m_hand;
    }

    /**
     * Calculates score according to rules of blackjack
     * @return total score
     */
    public int getScore()
    {
        int totalScore = 0;
        int numAces = 0;
        for(Card c : m_hand)
        {
            if (c.getRank() <= 10) //If the number is numeric, add its face value to total score
            {
                totalScore += c.getRank();
            }
            else if (c.getRank() != 14) //If the card isn't numeric but isn't an ace, add 10
            {
                totalScore += 10;
            }
            else //Keep track of the number of aces played to subtract 10 as needed
            {
                totalScore += 11;
                ++numAces;
            }
        }
        while(totalScore > 21 && numAces > 0) //If they're 'busted', but they have an ace, count it as 1 instead of 11
        {
            totalScore -= 10;
            --numAces;
        }
        return totalScore;
    }

    /**
     * Acessor for has busted
     * @return whether or not the player has busted
     */
    public boolean getHasBusted()
    {
        return m_hasBusted;
    }

    /**
     * Mutator for has busted
     * @param hasBusted whether or not the player has busted
     */
    public void setHasBusted(boolean hasBusted)
    {
        m_hasBusted = hasBusted;
    }

}