package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.cards.common.*;

public class BlackJackApp {

	Deck deck = new Deck();	
	private List<Card> initialCards;
	private List<Card> playerCards = new ArrayList<>();
	private List<Card> dealerCards = new ArrayList<>();
	
	public static void main(String[] args) {
		BlackJackApp play = new BlackJackApp();
		play.shuffleCards();
		play.dealInitialCards();
		play.giveTwoCardsToDealer();
		play.giveTwoCardstoPlayer();
		play.hitOrStay();
		
	}

	// 1. Shuffle the deck of cards
	private void shuffleCards() {	
		deck.shuffle();				
	}

	// 2. Deal initial 4 cards from the deck
	private void dealInitialCards() {
		initialCards = deck.getInitialCards();
		dealerCards.add(initialCards.get(0));
		dealerCards.add(initialCards.get(1));
		playerCards.add(initialCards.get(2));
		playerCards.add(initialCards.get(3));
		
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
			System.out.println("*********************************");
			System.out.println("Player Card 1: " + initialCards.get(2));
			System.out.println("Player Card 2: " + initialCards.get(3));					
		}
		
	// 5. The user is prompted an option to HIT or STAY
		public void hitOrStay() {
			Scanner sc = new Scanner(System.in);
			System.out.println("*********************************");
			System.out.println("Do you want to HIT or STAY? (H/S)");
			switch (sc.nextLine()) {
				case "H":
				case "h":
				case "Hit":
				case "hit":
					processHit();
					hitOrStay();
					break;
				case "S":
				case "s":
				case "Stay":
				case "stay":
					break;
			}
			sc.close();		
		}
		
	// 6. When the user selects HIT, a card will be dealt from the deck
		public void processHit() {
			Card newCard = deck.dealCard();
			System.out.println("Player added: " + newCard);
			playerCards.add(newCard);
		}
		
	// 7. When the user selects STAY, calculate the final value of player's cards.
	// if final value exceeds 21, player BUSTS! else, dealer has to open secret card.
		int playerFinalValue = 0;
		public void processStay() {
			for (Card card : playerCards) {
				playerFinalValue += card.getValue();
			}
			if (playerFinalValue > 21) {
				System.out.println("Your final score is: " + playerFinalValue );
				System.out.println("YOU BUST!!!" );
			}
			else {
				System.out.println("Your final score is: " + playerFinalValue);
				System.out.println("The dealer's secret card is " + initialCards.get(0));
			}
		}

}
