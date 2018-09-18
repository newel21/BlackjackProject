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
	int playerFinalValue = 0;
	int dealerFinalValue = 0;
	
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
		this.deck.shuffle();				
	}

	// 2. Deal initial 4 cards from the deck
	private void dealInitialCards() {
		initialCards = deck.getInitialCards();
		dealerCards.add(deck.dealCard());
		dealerCards.add(deck.dealCard());
		playerCards.add(deck.dealCard());
		playerCards.add(deck.dealCard());
		
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
		System.out.println("************************************************");
		System.out.println("Player Card 1: " + playerCards.get(0));
		System.out.println("Player Card 2: " + playerCards.get(1));					
	}
		
	// 5. The user is prompted an option to HIT or STAY
	private void hitOrStay() {
		Scanner sc = new Scanner(System.in);
		System.out.println("************************************************");
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
					Scanner sc2 = new Scanner(System.in);
					System.out.println();
					System.out.println("Do you want to play again? (Y/N)");
						switch (sc2.nextLine()) {
						case "Y":
						case "y":
							playerCards.removeAll(playerCards);
							dealerCards.removeAll(dealerCards);
							playerFinalValue = 0;
							dealerFinalValue = 0;
							deck = new Deck();
							shuffleCards();
							dealInitialCards();
							giveTwoCardsToDealer();
							giveTwoCardstoPlayer();
							hitOrStay();
							break;
						case "N":
						case "n":
							System.out.println("Hope you had fun. Goodbye!");
							break;
						default: System.out.println("Invalid Input");
						}
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
		for (Card card : dealerCards) {
			dealerFinalValue += card.getValue();
		}
		if (dealerFinalValue >= 17) {
			System.out.println("Exceeded Threshold. Calculating Final Scores...");
			System.out.println("************************************************");
			compareValue();
		}
		else {
			Card newCard = deck.dealCard();
			System.out.println("Dealer added: " + newCard);
			dealerCards.add(newCard);
			dealerFinalValue = 0;
			processDealerTurn();
		}
	}
		
	// 9. Check if dealer's final score is more than 21, then dealer lose
	private void compareValue() {
		System.out.println("Player's final hand: " + playerCards);
		System.out.println("Player's final score: " + playerFinalValue);
		System.out.println("Dealer's final hand: " + dealerCards);
		System.out.println("Dealer's Final score: " + dealerFinalValue);
		if (dealerFinalValue <= 21 && dealerFinalValue > playerFinalValue) {
			System.out.println("DEALER WINS!!!");
		}
		else if ( dealerFinalValue == playerFinalValue ){
			System.out.println("IT's A DRAW!");
		}
		else if (dealerFinalValue > 21) {
			System.out.println("DEALER BUSTS!");
			System.out.println("PLAYER WINS!!!");
		}
		else {
			System.out.println("PLAYER WINS!");
		}
	}
	
}		
