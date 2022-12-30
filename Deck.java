public class Deck {
    private Card[] deck;
    private int numOfCards=52;
    private int currentCard=-1;
    private Card[] myDeck=new Card[numOfCards];

    public Deck() {
        String[] suit = {"♠", "♣","♥", "♦" };
        String[] rank = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        for (int i = 0; i < myDeck.length; i++) {
            myDeck[i] = new Card(suit[i / 13], rank[i % 13]);
        }
        shuffleDeck();
        cutDeck();
    }

       public void shuffleDeck(){
        Card[] temp = new Card[myDeck.length];
        for (int i = 0; i < myDeck.length; i++) {
            int index = (int) (Math.random() * myDeck.length);
            temp[i] = myDeck[i];
            myDeck[i] = myDeck[index];
            myDeck[index] = temp[i];
        }
    }
    public void cutDeck(){

        Card[] temp1= new Card[myDeck.length];
        for (int i=0; i< myDeck.length/2; i++){
            temp1[i]=myDeck[26+i];
            myDeck[26+i]=myDeck[i];
            myDeck[i]=temp1[i];
        }
    }
    public void printDeck(){
        for(int i=0;i<myDeck.length;i++){
            System.out.println(myDeck[i]);
        }
    }
    public Card returnCard(){
        currentCard++;
        return myDeck[currentCard];

    }

}
