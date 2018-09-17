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
	private void giveTwoCardsToDealer() {
		System.out.println("Dealer Card 1: " + "\u003F" + " \u003F" + " \uD83C\uDCA0" + " \u003F" + " \u003F");
		System.out.println("Dealer Card 2: " + dealerCards.get(1));			
		}
		
	// 4. Give the other 2 cards to the player, then print the value
	//	of both cards to the console
	private void giveTwoCardstoPlayer() {
		System.out.println("*********************************");
		System.out.println("Player Card 1: " + playerCards.get(0));
		System.out.println("Player Card 2: " + playerCards.get(1));					
	}
		
	// 5. The user is prompted an option to HIT or STAY
	private void hitOrStay() {
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
					processStay();
					break;
				default: System.out.println("Invalid Input!");
					hitOrStay();
			}
			sc.close();		
	}
		
	// 6. When the user selects HIT, a card will be dealt from the deck
	private void processHit() {
		Card newCard = deck.dealCard();
		System.out.println("Player added: " + newCard);
		playerCards.add(newCard);
	}
		
	// 7. When the user selects STAY, calculate the final value of player's cards.
	// if final value exceeds 21, player BUSTS! else, dealer has to open secret card.
	int playerFinalValue = 0;
	private void processStay() {
		for (Card card : playerCards) {
			playerFinalValue += card.getValue();
		}
		if (playerFinalValue > 21) {
			System.out.println("Your final score is: " + playerFinalValue );
			System.out.println("YOU BUST!!!" );
			System.out.println("DEALER WINS!!!");
		}
		else {
			System.out.println("Your final score is: " + playerFinalValue);
			System.out.println("The dealer's secret card is " + dealerCards.get(0));
			processDealerTurn();
		}
	}
		
	// 8. Dealer draw card(s) from the deck once player selects STAY until
	// dealer's final value reaches 17 or more. 
	private void processDealerTurn() {
		Card newCard = deck.dealCard();
		System.out.println("Dealer added: " + newCard);
		dealerCards.add(newCard);
		if (exceedThreshold()) {
			System.out.println("Exceeded Threshold!");
			System.out.println("Calculating Final Scores.");
			compareValue();
		}
		else {
			processDealerTurn();
		}
	}

	// Setting dealer's threshold to 17
	int dealerFinalValue = 0;
	private boolean exceedThreshold() {
		for (Card card : dealerCards) {
			dealerFinalValue += card.getValue();	
				
		}
		if (dealerFinalValue > 17) {
			return true;
		}
		else {
			return false;
		}
	}
		
	// Check if dealer's final score is more than 21, then dealer lose
	private void compareValue() {
		System.out.println("Player's final score: " + playerFinalValue);
		System.out.println("Dealer's final value: " + dealerFinalValue);
		if (dealerFinalValue <= 21 && dealerFinalValue > playerFinalValue) {
			System.out.println("DEALER WINS!!!");
		}
		else {
			System.out.println("DEALER BUSTS!");
			System.out.println("PLAYER WINS!!!");
		}
	}
	
}		
