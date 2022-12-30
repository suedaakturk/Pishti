import java.sql.SQLOutput;
import java.util.Scanner;

public class GamePlaying {
    public static void main(String[] args) {
        //System.out.println("Welcome to my Pishti Game...");
        Scanner sc= new Scanner(System.in);
        Area game= new Area();
        game.gamePlaying();
        

        //System.out.println("The End...");

       /* Scanner sc= new Scanner(System.in);
        Deck deck= new Deck();
        Board gameboard= new Board();
        deck.shuffleDeck();
        deck.cutDeck();
        //deck.printDeck();
        Hand playerhand= new Hand("sueda");
        Hand cp=new Hand("Computer");
        Board cppile=new Board();
        Board playerpile= new Board();

        //kartları dağıtma kısmı.
        playerhand.addCard(deck.returnCard());
        playerhand.addCard(deck.returnCard());
        playerhand.addCard(deck.returnCard());
        playerhand.addCard(deck.returnCard());
        gameboard.addCardToBoard(deck.returnCard());
        gameboard.addCardToBoard(deck.returnCard());
        gameboard.addCardToBoard(deck.returnCard());
        gameboard.addCardToBoard(deck.returnCard());
        cp.addCard(deck.returnCard());
        cp.addCard(deck.returnCard());
        cp.addCard(deck.returnCard());
        cp.addCard(deck.returnCard());

        System.out.println("board:"); //board ilk gösterim.
        gameboard.printBoard();
        System.out.println(" ");
        System.out.println("----");

        System.out.println("My hand:");// oyuncu ilk gösterim
        playerhand.printHand();
        System.out.println(" ");
        System.out.println("----");

        System.out.println("pc hand:"); //pc hand ilk gösterim
        cp.printHand();
        System.out.println(" ");


        gameboard.addCardToBoard(playerhand.returnCardToBoard());// 1 kart oynadıktan sonra oyuncu eli.
        playerhand.removeCardFromHand();
        System.out.println("oyuncunun yeni eli:");
        playerhand.printHand();
        gameboard.winCardPlayer();
        System.out.println(" ");


        System.out.println("new board:"); //boardun 1 el oynandıktan sonraki hali
        gameboard.printBoard();
        System.out.println(" ");
        System.out.println("----");
        ****gameboard.addCardToBoard(cp.choseCardPc(gameboard.returnCard()));
        cp.removeCardFromPcHand(gameboard.returnCard());
        gameboard.winCardPc();


        System.out.println("pc new hand:");
        cp.printHand();
        System.out.println(" ");



        System.out.println("new board:"); //pc de oynadıktan sonra board
        gameboard.printBoard();
        System.out.println(" ");


        System.out.println("oyuncunun kazandıkları:");
        gameboard.printPlayerPile();
        System.out.println(" ");
        System.out.println("-----");

        System.out.println("pcnin kazandıkları");
        gameboard.printPcPile();
        System.out.println(" ");

        System.out.println("boardun son hali");
        gameboard.printBoard();
        System.out.println(" ");}*/

    }
}

