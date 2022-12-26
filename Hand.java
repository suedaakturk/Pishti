import java.util.Scanner;
import java.util.Random;

public class Hand {
    Scanner sc = new Scanner(System.in);
    Random rd = new Random();

    private int chosen;
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
            Card[] temp= new Card[mycurrentNum];
			for(int i=0; i<mycurrentNum; i++){
				if(i==0){
					temp[i]=mycard;
				}else{
					temp[i]= hand[i-1];
				}
			}hand=temp;
        }
    }

    public Card returnCardToBoard() {
        System.out.println("Which card you want to play?");
        chosen = sc.nextInt();
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

    public Card choseCardPc(Card a) {
        for (int i = 0; i < hand.length; i++) {
            if (a.getRank() == hand[i].getRank()) {
                return hand[i];
            } else if (hand[i].getRank() == "J") {
                return hand[i];

            }
        }
        return hand[0];
    }

    public void removeCardFromPcHand(Card a) {
        Card temp2[] = new Card[mycurrentNum-1];
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
	 public boolean emptyHand(){
        if (mycurrentNum==0){
            return true;
        }
        return false;
    }

}