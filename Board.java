public class Board {
    private boolean turnOfPlayer=true;
    private boolean boardisempty;
    private boolean stupid;

    private int boardnumcards = 0;
    private int playerwoncards = 0;
    private int pcwoncards = 0;

    private int boardcurrentnum = 1;
    private int sum=0;
    private int sum2=0;
    private int playerpishtinum=0;
    private int pcpishtinum=0;

    private int boardcarddesk;
    private Card[] board;

    private Card[] playerpile = new Card[1];
    private Card[] pcpile = new Card[1];

    public Board() {
        board = new Card[boardcurrentnum];
        playerpile[0] = new Card(" "," ");
        pcpile[0] = new Card(" ", " ");

    }

    public void addCardToBoard(Card a) {
        if (boardnumcards == 0) {
            board[0] = a;
            boardnumcards++;
        } else {
            Card tempboard[] = new Card[board.length + 1];
            for (int i = 0; i < board.length + 1; i++) {
                if (i == 0) {
                    tempboard[i] = a;
                    boardnumcards++;
                } else {
                    tempboard[i] = board[i - 1];
                }
            }
            board = tempboard;
        }
    }

    public void empty() {
        Card[] temp = new Card[1];
        temp[0] = new Card(" ", " ");
        board = temp;
        boardnumcards = 0;

    }

    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            System.out.print(board[i] + " ");
        }
    }

    public void printPlayerPile() {
        for (int i = 0; i < playerpile.length; i++) {
            System.out.print(playerpile[i] + " ");
        }
    }

    public void printPcPile() {
        for (int i = 0; i < pcpile.length; i++) {
            System.out.print(pcpile[i] + " ");
        }
    }

    public Card returnCard() {
        return board[0];

    }

    public void winCardPlayer(boolean a) {
        if (boardnumcards==2){
            if (board[0].getRank()==board[1].getRank()){
                playerpishtinum++;
            }
        }
        if (boardnumcards > 1) {
            if ((board[0].getRank() == board[1].getRank()) || board[0].getRank() == "J" || a) {
                if(playerwoncards == 0) {
                    Card[] temp = new Card[board.length];
                    for (int k = 0; k < temp.length; k++) {
                        temp[k] = board[k];
                        playerwoncards++;
                    }
                    playerpile = temp;
                } else {
                    Card[] temp = new Card[board.length + playerpile.length];
                    for (int i = 0; i < temp.length; i++) {
                        if (i < board.length) {
                            temp[i] = board[i];
                            playerwoncards++;
                        } else {
                            temp[i] = playerpile[i - board.length];
                        }
                    }
                    playerpile = temp;
                }
                empty();
                turnOfPlayer=true;
            }

        }else {turnOfPlayer=false;}
    }

    public void winCardPc(boolean a) {

            if (boardnumcards == 2) {
                if (board[0].getRank() == board[1].getRank()) {
                    pcpishtinum++;
                }
            }
            if (boardnumcards > 1) {
                if ((board[0].getRank() == board[1].getRank()) || board[0].getRank() == "J" || a) {
                    if (pcwoncards == 0) {
                        Card[] temp = new Card[board.length];
                        for (int k = 0; k < temp.length; k++) {
                            temp[k] = board[k];
                            pcwoncards++;
                        }
                        pcpile = temp;
                    } else {
                        Card[] temp = new Card[board.length + pcpile.length];
                        for (int i = 0; i < temp.length; i++) {
                            if (i < board.length) {
                                temp[i] = board[i];
                                playerwoncards++;
                            } else {
                                temp[i] = pcpile[i - board.length];
                            }
                        }
                        pcpile = temp;
                    }
                    empty();
                    turnOfPlayer = false;
                }

            } else {
                turnOfPlayer = true;
            }
        }

    public void playerPileCalculater(){
        for (int i=0; i<playerpile.length; i++){
        if (playerpile[i].getRank()=="2" && playerpile[i].getSuit()== "♣"){
                sum=sum+2;
            }else if (playerpile[i].getRank()=="10" && playerpile[i].getSuit()=="♦"){
                sum=sum+3;
            }else{sum=sum+1;}
        }if (playerpishtinum>0){
            sum=sum+ (playerpishtinum*10);
        }if (playerpile.length>pcpile.length){
            sum=sum+3;
        }
    }

    public void pcPileCalculater(){
        for (int i=0; i< pcpile.length; i++){
            if (pcpile[i].getRank()=="2" && pcpile[i].getSuit()== "♣"){
                sum2=sum2+2;
            }else if (pcpile[i].getRank()=="10" && pcpile[i].getSuit()== "♦"){
                sum2=sum2+3;
            }else{sum2=sum2+1;}
            }
        if (pcpishtinum>0){
            sum2=sum2+(pcpishtinum*10);
        }
        if (playerpile.length<pcpile.length){
            sum2+=3;
        }
    }
    public void printPlayerCardValue(String k){
        System.out.println(k + "'s score is ");
        System.out.print(" "+ sum);


    }
    public void printPcCardValue(){
        System.out.println("Pc's score is:");
        System.out.println(" "+ sum2);
    }

    public void printResultScore(){
        if (sum>sum2){
            System.out.println("Player won!!!! :)");
        }else{
            System.out.println("Pc won!!!! :(");
        }
    }
    public boolean returnTurn(){
        return turnOfPlayer;
    }
    public boolean isemptyBoard(){
        if(boardnumcards==0){
            return true;
        }
        return false;
    }
    public void printpishtinumcards(){
        System.out.println(playerpishtinum);
        System.out.println(pcpishtinum);
    }
    public int returnPlayerScore(){
        return sum;
    }
    public int returnBoradNumCards(){
        return boardnumcards;
    }
}




