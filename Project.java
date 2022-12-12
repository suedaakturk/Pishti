import java.util.Scanner;
public class Project{
 public static void createCards(Cards[] deck){
        Scanner sc= new Scanner(System.in);

        String[] suits={"♠","♣","♥","♦"};
        String[] ranks={"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
      
		Cards[] temp= new Cards[52];
        System.out.println("Cards are dealing...");

        for(int i=0; i< deck.length;i++){
            deck[i]= new Cards(suits[i/13], ranks[i%13]);
        }
		for (int i=0; i<deck.length;i++) {
                System.out.println(deck[i].getSuit()+deck[i].getRank());

        }System.out.println("--------");
				
 
 
        for (int i=0; i<deck.length;i++) {
            int index = (int) (Math.random() * deck.length);
            temp[i] = deck[i];
            deck[i] = deck[index];
            deck[index] = temp[i];
		}
		
		
		for (int i=0; i<deck.length;i++) {
                System.out.println(deck[i].getSuit()+deck[i].getRank());
				
		}
        System.out.println("--------");
        Cards[] temp1= new Cards[deck.length];
        for (int i=0; i<deck.length/2;i++) {
            temp1[i]= deck[26+i];
            deck[26+i] = deck[i];
            deck[i] = temp1[i];
            }
        for (int i=0; i<deck.length;i++){
            System.out.println(deck[i].getSuit()+ deck[i].getRank());

        }

        System.out.println("-------");
 }
 
        public static void dealingCards(Cards[] playerhand, Cards[] deck,Cards[]oppenanthand,
         Cards[]board) {
        int tur=13;
        System.out.println("your cards");
        for (int i = 0; i < playerhand.length; i++) {
            playerhand[i] = deck[i];
            System.out.println(playerhand[i].getSuit() + playerhand[i].getRank());
        }
        System.out.println("opp cards");
        for (int i = 0; i < oppenanthand.length; i++) {
            oppenanthand[i] = deck[4+i];
            System.out.println(oppenanthand[i].getSuit() + oppenanthand[i].getRank());
        }
        System.out.println("board cards");
        for (int i = 0; i < board.length; i++) {
            board[i] = deck[8+i];
            System.out.println( board[i].getSuit() + board[i].getRank());
        }
		
		public static void playingCards(Cards[] playerhand, Cards[]board){
        Cards[] temp= new Cards[board.length+1];
        Cards[] tempforboard= new Cards[1];
        Scanner sc= new Scanner(System.in);
        System.out.println("Which card you want to play?");
        int chosen= sc.nextInt();
       for(int i=0; i< temp.length;i++){
           if(i==0){
           temp[i]=playerhand[chosen-1];

           }if (i!=0 && playerhand[chosen-1]!=board[0]){
               temp[i]=board[i-1];
           }else{
               tempforboard[0]=new Cards(" "," ");
               for (int k=0; k<= temp.length;k++){

                   board[k]= tempforboard[0]; //kaldığım yer
               }
           }
           System.out.println("board cards:");
           System.out.println( temp[i].getSuit() + temp[i].getRank());
        }


    }
	

    public static void main(String[] args){
        System.out.println("Weolcome to Game Pisti :)...");
		Cards[] deck= new Cards[52];
        createCards(deck);
		dealingCards(playerhand,deck,opponenthand,board);
        playingCards(playerhand,board);


    }
}