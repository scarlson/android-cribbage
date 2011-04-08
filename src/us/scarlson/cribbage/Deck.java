package us.scarlson.cribbage;

public class Deck {
  Card[] deck;
  private int cardsUsed;
  
public Deck() {
    deck = new Card[52];    
    for (int i = 0; i < deck.length; i++)
      deck[i] = new Card(new Suit(i / 13 + 1),
                         new Pips(i % 13 + 1));
   cardsUsed = 0;                   
  }


public void shuffle() {   
    for (int i = 0; i < deck.length; i++){
      int k = (int)(Math.random() * 52);
      Card t = deck[i];
      deck[i] = deck[k];
      deck[k] = t;    
    } 

  cardsUsed = 0; 
  } 

public int cardsLeft() {
        return 52 - cardsUsed;
}
    
public Card dealCard() {
        if (cardsUsed == 52)
           shuffle();
        cardsUsed++;
        return deck[cardsUsed - 1];
    }
  
  public  String toString()  { 
    String t = ""; 
    for (int i = 0; i < 52; i++)
      if ( (i + 1) % 5 == 0)
          t = t  + deck[i] + "\n";
      else     
          t = t + deck[i];
      return t;
  }

}
