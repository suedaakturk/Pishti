import java.util.Scanner;

public class GamePlaying {
    public static void main(String[] args) {
        System.out.println("Welcome to my Pishti Game...");
        Scanner sc = new Scanner(System.in);
		System.out.println("Enter your name...");
        Area game = new Area();
        game.gamePlaying();

    }
}