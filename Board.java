public class Board {

    private int boardnumcards=0;
	private int playerwoncards=0;
	private int pcwoncards=0;
    private int boardcurrentnum=1;
	private sum=0;
	private int sum2=0;
	private int playerpishtinum=0;
	private pcpishtinum=0;
	private int boarddesk;
	

    private Card[] board;

    private Card[] playerpile=new Card[1];
    private Card[] pcpile= new Card[1];

    public Board(){
        board=new Card[boardcurrentnum];
		 playerpile[0] = new Card(" "," ");
        pcpile[0] = new Card(" ", " ");
    }
	
    public void addCardToBoard(Card a){
        if (boardnumcards==0){
            board[0]=a;
            boardnumcards++;
        }else {
            Card tempboard[]= new Card[board.length+1];
            for (int i=0; i<board.length+1; i++){
                if(i==0){
                    tempboard[i]=a;
                    boardnumcards++;
                }else{
                    tempboard[i]=board[i-1];
                }

            }
            board=tempboard;
        }
    }
	
	 public void empty() {
        Card[] temp = new Card[1];
        temp[0] = new Card(" ", " ");
        board = temp;
        boardnumcards = 0;
    }
	
    public void printBoard(){
        for (int i=0; i<board.length;i++){
            System.out.print(board[i]+" ");
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
	
    public Card returnCard(){
        return board[0];

    }
   
    public void winCardPlayer() {
        if (boardnumcards==2){
            if (board[0].getRank()==board[1].getRank()){
                playerpishtinum++;
            }
        }
        if (boardnumcards > 1) {
            if ((board[0].getRank() == board[1].getRank()) || board[0].getRank() == "J") {
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
            }

        }
    }

    public void winCardPc() {
        if (boardnumcards==2){
            if (board[0].getRank()==board[1].getRank()){
                pcpishtinum++;
            }
        }
        if (boardnumcards > 1) {
            if (board[0].getRank() == board[1].getRank() || board[0].getRank() == "J") {
                if (pcwoncards == 0) {
                    Card[] temp = new Card[board.length];
                    for (int k = 0; k < temp.length; k++) {
                        temp[k] = board[k];
                        playerwoncards++;
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
            }

        }
    }
    public void playerPileCalculater(){
        for (int i=0; i<playerpile.length; i++){
            if (playerpile[i].getRank()=="2" && playerpile[i].getSuit()== "♣"){
                sum=sum+2;
            }if (playerpile[i].getRank()=="10" && playerpile[i].getSuit()=="♦"){
                sum=sum+3;
            }else{
                for (int k=0; k<playerpile.length; k++){
                    sum=sum+1;
                }
            }
        }if (playerpishtinum>0){
            sum+=playerpishtinum*10;
        }
    }

    public void pcPileCalculater(Card card){
        for (int i=0; i< pcpile.length; i++){
            if (pcpile[i].getRank()=="2" && pcpile[i].getSuit()== "♣"){
                sum2=sum2+2;
            }if (pcpile[i].getRank()=="10" && pcpile[i].getSuit()== "♦"){
                sum2=sum2+3;
            }else{sum2=sum2+1;}
            }
        if (pcpishtinum>0){
            sum2+=pcpishtinum*10;
        }
    }
    public void printPlayerCardValue(){
        System.out.println("Player score is:");
        System.out.println(" "+ sum);


    }
    public void printPcCardValue(){
        System.out.println("Pc score is:");
        System.out.println(" "+ sum2);
    }

    public void printResultScore(){
        if (sum>sum2){
            System.out.println("Player won!!!! :)");
        }else{
            System.out.println("Pc won!!!! :(");
        }
    }
}

