package com.skilldistillery.cards.blackjack;

import java.util.List;


import com.skilldistillery.cards.common.*;

public class BlackJackApp {

	Deck deck = new Deck();	
	private List<Card> initialCards;
	
	
	public static void main(String[] args) {
		BlackJackApp play = new BlackJackApp();
		play.shuffleCards();
		play.dealInitialCards();
		
	}

	// 1. shuffle the deck of cards
	private void shuffleCards() {	
		deck.shuffle();				
	}

	// 2. deal initial 4 cards from the deck
	private void dealInitialCards() {
		initialCards = deck.getInitialCards();
		Card dealerCard1 = initialCards.get(0);
		Card dealerCard2 = initialCards.get(1);
		Card playerCard1 = initialCards.get(2);
		Card playerCard2 = initialCards.get(3);
		
		System.out.println("Dealer Card 1: ### HIDDEN ###");
		System.out.println("Dealer Card 2: " + dealerCard2);
		System.out.println("Player Card 1: " + playerCard1);
		System.out.println("Dealer Card 2: " + playerCard2);
	}
		

}
