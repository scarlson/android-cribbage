package us.scarlson.cribbage;

public class Pips {
  int p;

  Pips(int i) { 
	  p = i; 
  }
  
  public String toString() {
    if (p > 1 && p < 11)
      return String.valueOf(p);
    else if (p == 1)
      return "Ace";
    else if (p == 11)
      return "Jack";
    else if (p == 12)
      return "Queen";
    else if (p == 13)
      return "King";
    else if (p == 14)
      return "Ace";
    else return "error";
  }

  public int getValue() { 
	  return p; 
  }
}
