import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class Hand {
    Random rd = new Random();

    private int chosen;
    private int k;

    private String name;
    private int mycurrentNum = 0;
    private Card[] hand = new Card[1];

    private int numCards;

    public Hand(String a) {
        name = a;
    }

    public void addCard(Card mycard) {
        if (mycurrentNum < 4) {
            mycurrentNum++;
            Card[] temp = new Card[mycurrentNum];
            for (int i = 0; i < mycurrentNum; i++) {
                if (i == 0) {
                    temp[i] = mycard;
                } else {
                    temp[i] = hand[i - 1];
                }
            }
            hand = temp;
        }
    }

    public void invalid() {
        boolean invalid = false;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                chosen = sc.nextInt();
                invalid = true;
            } catch (java.util.InputMismatchException ex) {
                System.out.println("Which card you want to play?");
                invalid = false;
            }
        } while (!invalid);
    }

    public Card returnCardToBoard() {
        while (true) {
            invalid();
            if (chosen < 1 || chosen > hand.length + 1) {
                System.out.println("Please write an valid value!");
            }
            if (chosen > 0 && chosen < hand.length + 1) {
                break;
            }
        }
        return hand[chosen - 1];
    }


    public void removeCardFromHand() {

        Card[] temp = new Card[mycurrentNum - 1];
        for (int i = 0; i < mycurrentNum; i++) {
            if (i < chosen - 1) {
                temp[i] = hand[i];
            } else if (i > chosen - 1) {
                temp[i - 1] = hand[i];
            }
        }
        mycurrentNum--;
        hand = temp;
    }

    public void printHand() {
        for (int i = 0; i < hand.length; i++) {
            System.out.print(hand[i] + " ");
        }
    }

    public Card choseCardPc(Card a, int b) {
        if (hand.length == 1) {
            return hand[0];
        }
        for (int i = 0; i < 1; i++) {
             k = (int) (Math.random() * hand.length);
            if (hand[k].getRank() == "J") {
                i--;
            }
            for (int j = 0; j < hand.length; j++) {
                if (a.getRank() == hand[j].getRank()) {
                    return hand[j];
                } else if (hand[j].getRank() == "J") {
                    if (!(b == 0)) {
                        return hand[j];
                    }
                }
            }
        }
        return hand[k];
    }
        public void removeCardFromPcHand(Card a){
            Card temp2[] = new Card[mycurrentNum - 1];
            for (int k = 0; k < hand.length; k++) {
                if (hand[k] == a) {
                    for (int i = 0; i < mycurrentNum; i++) {
                        if (i < k) {
                            temp2[i] = hand[i];
                        } else if (i > k) {
                            temp2[i - 1] = hand[i];
                        }

                    }
                }

            }
            mycurrentNum--;
            hand = temp2;
        }
    public boolean emptyHand() {
            if (mycurrentNum == 0) {
                return true;
            }
            return false;
        }
        public String returnPlayerName() {
            return name;
        }

    }


