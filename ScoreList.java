import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.nio.file.Paths;
import java.util.Formatter;


public class ScoreList {
    private Score[] scoreList;

    public ScoreList(String playername, String playerscore) {
        Scanner reader = null;

        scoreList = new Score[11];
        try {
            reader = new Scanner(Paths.get("ScoreList.txt"));
            for (int i = 0; i < scoreList.length - 1; i++) {
                String[] info = reader.nextLine().split(" ");
                scoreList[i] = new Score(info[1], info[2]);
            }
            scoreList[10] = new Score(playername, playerscore);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }
        public void sort() {
            int num;
            int num2;
            for (int i = 0; i < scoreList.length; i++) {
                for (int k = i + 1; k < scoreList.length; k++) {
                    num = Integer.parseInt(scoreList[i].getPlayerscore());
                    num2 = Integer.parseInt(scoreList[k].getPlayerscore());
                    Score temp;
                    if (num < num2) {
                        temp = scoreList[i];
                        scoreList[i] = scoreList[k];
                        scoreList[k] = temp;
                    }
                }
            }
        }
        public void clear() {
            try {
                PrintWriter pw = new PrintWriter("ScoreList.txt");
                pw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        public void append() {
            String[] nums = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
            Formatter f = null;
            FileWriter fw = null;
            for (int i = 0; i < scoreList.length - 1; i++) {
                try {
                    fw = new FileWriter("ScoreList.txt", true);
                    f = new Formatter(fw);
                    f.format("%s %s %s\n", nums[i], scoreList[i].getPlayername(), scoreList[i].getPlayerscore());
                    fw.close();
                } catch (Exception ex) {
                    System.err.println("Something gives an error.");
                } finally {
                    if (f != null) {
                        f.close();
                    }
                }
            }
        }
        public void print() {
            for (int i = 0; i < scoreList.length - 1; i++) {
                scoreList[i].printScore();
            }
        }
    }
