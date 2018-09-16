package com.skilldistillery.cards.blackjack;


import java.util.List;


import com.skilldistillery.cards.common.*;

public abstract class Hand {
	private List<Card> cards;
			
	public Hand() {
		
	}
	
	public int getHandValue() {
		return 0;
			
		}	
	
	
	public void addCard (Card card) {
		this.cards.add(card);
	}
	
	public void clearHand() {
		
	}
	
	public String toString() {
		return null;
		
	}

}
