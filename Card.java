public class Card {
   private String Suit;
   private String Rank;

    public Card(String Suit, String Rank){
        this.Suit=Suit;
        this.Rank=Rank;
    }


    public String toString() {
        return this.Suit.toString() + this.Rank.toString();
    }

    public String getRank() {
        return this.Rank;
    }

    public String getSuit(){
        return this.Suit;
    }
}
