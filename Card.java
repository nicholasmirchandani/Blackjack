/**
 * A card from a standard 52-card deck
 */
public class Card
{

    public enum Rank
    {
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        JACK,
        QUEEN,
        KING,
        ACE
    }

    public enum Suit
    {
        HEARTS,
        SPADES,
        CLUBS,
        DIAMONDS
    }

    private Rank m_rank;
    private Suit m_suit;

    public Card() //Default Constructor
    {
        //If you're calling the default constructor, you'll get an ace of spades
        m_rank = Rank.ACE;
        m_suit = Suit.SPADES;
    }

    public Card(Rank rank, Suit suit) //Overloaded Constructor for rank and suit
    {
        m_rank = rank;
        m_suit = suit;
    }

    public Card(Card someCard) //Copy Constructor
    {
        m_rank = someCard.m_rank;
        m_suit = someCard.m_suit;
    }

    /**
     * @return integer representing the rank (To be used for easy comparisons of card values)
     */
    public int getRank() //returns an int representing the rank
    {
        switch(m_rank)
        {
            case TWO:
                return 2;
            case THREE:
                return 3;
            case FOUR:
                return 4;
            case FIVE:
                return 5;
            case SIX:
                return 6;
            case SEVEN:
                return 7;
            case EIGHT:
                return 8;
            case NINE:
                return 9;
            case TEN:
                return 10;
            case JACK:
                return 11;
            case QUEEN:
                return 12;
            case KING:
                return 13;
            case ACE:
                return 14;
            default:
                return 0;
        }
    }

    public String toString()
    {
        String rank;
        String suit;
        
        switch(m_rank)
        {
            case TWO:
                rank = "2";
                break;
            case THREE:
                rank = "3";
                break;
            case FOUR:
                rank = "4";
                break;
            case FIVE:
                rank = "5";
                break;
            case SIX:
                rank = "6";
                break;
            case SEVEN:
                rank = "7";
                break;
            case EIGHT:
                rank = "8";
                break;
            case NINE:
                rank = "9";
                break;
            case TEN:
                rank= "10";
                break;
            case JACK:
                rank = "Jack";
                break;
            case QUEEN:
                rank = "Queen";
                break;
            case KING:
                rank = "King";
                break;
            case ACE:
                rank = "Ace";
                break;
            default:
                rank = "?";
        }

        switch (m_suit)
        {
            case HEARTS:
                suit = "Hearts";
                break;
            case SPADES:
                suit = "Spades";
                break;
            case CLUBS:
                suit = "Clubs";
                break;
            case DIAMONDS:
                suit = "Diamonds";
                break;
            default:
                suit = "?";
        }
        return rank + " of " + suit;
    }

}