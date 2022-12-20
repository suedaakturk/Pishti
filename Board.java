public class Board {

    private int boardnumcards=0;

    private int boardcurrentnum=1;

    private int boardcarddesk;
    private Card[] board;

    private Card[] playerwin;
    private Card[] pcwin;

    public Board(){
        board=new Card[boardcurrentnum];

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
    public void printBoard(){
        for (int i=0; i<board.length;i++){
            System.out.print(board[i]+" ");
        }

    }
    public Card returnCard(){
        return board[0];

    }
    public void resetBoard(Card a) {
        boolean match = false;
        Card[] temp = new Card[boardnumcards];
        while (!match) {
            if ((board[0].getRank() == board[1].getRank()) || board[0].getRank()=="J") {
                temp[boardcarddesk]=board[boardcarddesk];
                match=true;
            }
        }
    }
}