import java.util.LinkedList;
import java.util.Random;
/**
 * A deck of cards
 */
public class Deck
{
    private LinkedList<Card> m_cards;
    private int m_deckSize;

    public Deck()
    {
        m_deckSize = 52; //Default deck size is 52 cards
        m_cards = new LinkedList<Card>(); 
        for(Card.Rank i : Card.Rank.values())
        {
            for(Card.Suit j : Card.Suit.values())
            {
                m_cards.add(new Card(i, j));
            }
        }
    }

    //No overloaded constructor needed

    //Copy constructor to duplicate deck because what if 2 people want to play the same game?

    /**
     * Removes a card from the deck
     * @return the removed card (To be collected by a player)
     */
    public Card dealCard()
    {
        if(m_deckSize <= 0)
        {
            //Throw an exception :O
        }
        Random r = new Random(System.currentTimeMillis()); //Seed random based on time
        int randNum = r.nextInt(m_deckSize);
        //Remove a random card from the linkedList and return it
        Card cardToReturn = m_cards.get(randNum);
        m_cards.remove(randNum);
        --m_deckSize;
        return cardToReturn;
    }

    /**
     * Adds a card to the deck
     * @param someCard the card being added
     */
    public void collectCard(Card someCard)
    {
        m_cards.add(someCard);
    }

    /**
     * Accessor for m_deckSize
     * @return size of the deck
     */
    public int getSize()
    {
        return m_deckSize;
    }

}