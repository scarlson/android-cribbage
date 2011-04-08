package us.scarlson.cribbage;

import java.util.ArrayList;
import java.util.List;
//import java.util.Arrays;


public class Hand {
	Card[] cards;
	Card cut;
	
	public int length(){
		return cards.length;
	}
	
	public Hand(){
		cards = new Card[6];
	}
	
	public Hand(int c){
		cards = new Card[c];
	}

	public void setCard(int i, Card c){
		cards[i] = c;
	}

	public void setCut(Card c){
		cut = c;
	}
	
	public String toString(){
		String str = "";
		
		for(Card card : cards){
			str += "\t";
			str += card.toString();
			str += "\n";
		}

		return str;
	}

	public Hand findBestHand() {
		List<Hand> hands = findPokerHands();
		int value = 0;
		Hand highest = new Hand();
		for (Hand hand : hands) {
			int temp = hand.getScore();
			if (temp > value) {
				value = temp;
				highest = hand;
			}
		}
		return highest;
	}
	
	public List<Hand> findPokerHands(){
		List<Hand> hands = new ArrayList<Hand>();

		for (int i = 0; i < cards.length; i++) {
			for (int j = 0; j < i; j++) {
				Hand hand = new Hand();
				int index = 0;
				for (int k = 0; k < cards.length; k++) {
					if (k != i && k != j) {
						hand.setCard(index, cards[k]);
						index++;
					}
				}
				hands.add(hand);
			}
		}
		return hands;
	}	
	
	public int getScore(){
		int value = 0;
		if(isNobs())
			value++;
		value += find15s();
		value += findStraights();
		return value;
	}
	

	public boolean isNobs(){
		for(Card c : cards)
			if (c.suit.suitValue == cut.suit.suitValue)
				return true;
		return false;
	}

	public int find15s(){
		int total = 0;
		return total;
	}
	
	public int findStraights(){
		int total = 0;
		for(Card c : cards)
			return c.hashCode();
		return total;
	}
	
	public boolean isFlush(){
		int suit = cards[0].suit.suitValue;
		for(Card c : cards)
			if(c.suit.suitValue != suit)
				return false;
		return true;
	}
	
}
