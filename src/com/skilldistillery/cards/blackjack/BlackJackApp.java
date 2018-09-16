package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;
import java.util.List;


import com.skilldistillery.cards.common.*;

public class BlackJackApp {

	Deck deck = new Deck();	
	private List<Card> initialCards;
	
	public static void main(String[] args) {
		BlackJackApp play = new BlackJackApp();
		play.shuffleCards();
		play.dealInitialCards();
		play.giveTwoCardsToDealer();
		play.giveTwoCardstoPlayer();
		
	}

	// 1. Shuffle the deck of cards
	private void shuffleCards() {	
		deck.shuffle();				
	}

	// 2. Deal initial 4 cards from the deck
	private void dealInitialCards() {
		initialCards = deck.getInitialCards();
		Card dealerCard1 = initialCards.get(0);
		Card dealerCard2 = initialCards.get(1);
		Card playerCard1 = initialCards.get(2);
		Card playerCard2 = initialCards.get(3);
		
	}
	// 3. Give the first 2 cards to the dealer, then print ONLY the 
	//	  value of the second card to the console
		public void giveTwoCardsToDealer() {
		System.out.println("Dealer Card 1: " + "\u003F" + " \u003F" + " \uD83C\uDCA0" + " \u003F" + " \u003F");
		System.out.println("Dealer Card 2: " + initialCards.get(1));			
		}
		
	// 4. Give the other 2 cards to the player, then print the value
	//	of both cards to the console
		public void giveTwoCardstoPlayer() {
			System.out.println();
			System.out.println("Player Card 1: " + initialCards.get(2));
			System.out.println("Player Card 2: " + initialCards.get(3));					
		}

}
