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

    public static void main(String[] args){
        System.out.println("Weolcome to Game Pisti :)...");
		Cards[] deck= new Cards[52];
        createCards(deck);


    }
}