public class Score {
    private String playername;
    private String playerscore;
    public Score(String a, String b){
        playername=a;
        playerscore=b;
    }
    public String getPlayername(){ return playername;}
    public String getPlayerscore(){ return playerscore.trim();}
    public void printScore(){
        System.out.println(this.getPlayername()+ " "+ this.getPlayerscore());
    }
}