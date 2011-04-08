package us.scarlson.cribbage;

public class Card {
  Suit suit;   
  Pips pip; 
  
  Card() {}  
  
  Card(Suit s, Pips p) { suit = s; pip = p;}
  
  Card(Card c) { suit = c.suit; pip = c.pip;}

  public  String toString() {
    return pip.toString() +" of " 
        +  suit.toString()+ " ";  
  }   

  public Suit getSuit() { return suit; }
  public Pips getPip() { return pip; }
}
