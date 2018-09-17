## Blackjack Project

#### Week 3 Skill Distillery Weekend Homework

#### How the program was created:

* Following the UML Diagram provided, I imported the following classes:
1. Card.java
2. Deck.java
3. Rank.java
4. Suit.java

* Then I created the BlackJackApp where I can test and run the program.
* Each method in the BlackJackApp has an explanation of what they're suppose to do.

#### How the program works:

1. The initial 3 cards are displayed in the console (one dealer card is hidden as per blackjack rules).

2. The player is then prompted an option to either HIT (add more cards) or STAY (stop adding cards and calculate final card values)

3. After STAY is selected, the dealer(Computer) will then reveal the hidden card.

4. If the value of the hidden card plus the initial card shown at the beginning is less than 17, then dealer will have to draw another card until total card value reaches or exceeds 17. 

5. If it reaches or exceeds 17, then the dealer calculates final card value and compare with the player. 

6. Whoever has the higher score (BUT NOT EXCEEDING 21) wins the round.

7. 21 is the limit. Whoever exceeds this score BUSTS and automatically lose the round.

#### Additional Notes:

* I focused too much on the functionality of the program rather than following the UML Diagram. If I have more time and energy, I would have Refactored my code to reflect the UML diagram. 


#### Tools and Techniques used:

* Some of the tools/techniques I used are as follows:

- List - for the decks and cards
- ArrayList - to split the List<Card> for the player's card and dealer's cards
- Scanner - prompts the user
- Switch statements - process user's choice