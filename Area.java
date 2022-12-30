import java.util.Scanner;

public class Area {
    private int tournum = 1;
    private boolean boardlast=false;
    Scanner sc = new Scanner(System.in);
    String k;


    Deck deck = new Deck();
    Board gameboard = new Board();
    Hand playerhand = new Hand(k);

    Hand cp = new Hand("Computer");

    public void display() {
        System.out.println("BOARD");
        gameboard.printBoard();
        System.out.println();
        System.out.println("------------");
        System.out.println(k);
        playerhand.printHand();
        System.out.println();
        System.out.println("------------");
        System.out.println("Computer");
        cp.printHand();
        System.out.println();
        System.out.println("------------");

    }

    public void dealer() {
        if (tournum == 1) {
            for (int k = 0; k < 4; k++) {
                playerhand.addCard(deck.returnCard());
                gameboard.addCardToBoard(deck.returnCard());
                cp.addCard(deck.returnCard());

            }
        } else {
            for (int i = 0; i < 4; i++) {
                playerhand.addCard(deck.returnCard());
                cp.addCard(deck.returnCard());

            }
        }
        tournum++;


    }

    public void gamePlaying() {
        System.out.println("Enter your name...");
        k = sc.next();
        for (int i = 0; i < 6; i++) {// oyun 6 tur döneceği için i<6.
            dealer();
            display();
            playingOrder();
            emptyHandController();

        }
        lastTourController();

        System.out.println("Player won cards:");
        gameboard.playerPileCalculater();
        gameboard.printPlayerPile();
        System.out.println(" ");
        gameboard.printPlayerCardValue(k);
        System.out.println(" ");
        System.out.println("Computer won cards:");
        gameboard.pcPileCalculater();
        gameboard.printPcPile();
        System.out.println(" ");
        gameboard.printPcCardValue();
        System.out.println(" ");
        gameboard.printResultScore();
       // gameboard.printpishtinumcards();
        String str= Integer.toString(gameboard.returnPlayerScore());
        ScoreList scr= new ScoreList(k,str);
        scr.sort();
        scr.clear();
        scr.append();
        scr.print();
    }
    public void playingOrder() {
        for (int i = 0; i < 4; i++) {
            gameboard.addCardToBoard(playerhand.returnCardToBoard());
            playerhand.removeCardFromHand();
            gameboard.winCardPlayer(boardlast);
            gameboard.addCardToBoard(cp.choseCardPc(gameboard.returnCard(), gameboard.returnBoradNumCards()));
            cp.removeCardFromPcHand(gameboard.returnCard());
            gameboard.winCardPc(boardlast);
            display();

        }
    }

    public void emptyHandController() {//yeni denemem.
        while (!playerhand.emptyHand() && cp.emptyHand()) {
            dealer();
            playingOrder();
        }

    }

    public void lastTourController() {
        if (playerhand.emptyHand() && cp.emptyHand() && !gameboard.isemptyBoard()) {
            boardlast=true;
            if (gameboard.returnTurn()) {
                gameboard.winCardPlayer(boardlast);
            }
            if (!gameboard.returnTurn()) {
                gameboard.winCardPc(boardlast);
            }
        }
    }
}





