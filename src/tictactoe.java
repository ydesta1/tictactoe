import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class tictactoe {
    public void tictactoe(){
    }
    public static void main(String[] args){
        gameboard();

    }
    public static void gameboard(){

        ArrayList <String> positions = new ArrayList<String>();
        for (int i = 0; i < 10; i++){
            positions.add("   ");
        }
        System.out.println(

                positions.get(0) + "|" + positions.get(1) + "|" + positions.get(2)+ "\n" + "---+---+---" + "\n" + positions.get(3) + "|" + positions.get(4) + "|" + positions.get(5)+ "\n" + "---+---+---" + "\n" + positions.get(6) + "|" + positions.get(7) + "|" + positions.get(8)
        );
        while (true){
            if (play(positions)){
                break;
            };
        }
    }
    public static boolean play(ArrayList<String> ALstr){
        boolean gameover = false;
        String playermark = " X ";
        String cpumark = " O ";

        //player goes
        System.out.println("Enter your position (0-8)");
        Scanner scan = new Scanner(System.in);
        int playerpos = scan.nextInt();
        while (ALstr.get(playerpos).equals(cpumark) || ALstr.get(playerpos).equals(playermark)){
            System.out.println("Position is already taken!");
            scan = new Scanner(System.in);
            playerpos = scan.nextInt();
        }
        ALstr.set(playerpos, " X ");
        updateGameBoard(ALstr);
        if (checkWinner(ALstr)){
            gameover = true;
            return gameover;
        };

        //cpu goes
        Random rand = new Random();
        int cpupos = rand.nextInt(8);
        while (ALstr.get(cpupos).equals(playermark)|| ALstr.get(cpupos).equals(cpumark)){
            cpupos = rand.nextInt(8);
        }
        ALstr.set(cpupos, " O ");

        updateGameBoard(ALstr);
        if (checkWinner(ALstr)){
            gameover = true;
            return gameover;
        };
        return gameover;
    }

    public static boolean checkWinner(ArrayList<String> ALstr){
        String playermark = " X ";
        String cpumark = " O ";
        boolean winnerfound = false;

        if ((ALstr.get(0) == playermark && ALstr.get(1) == playermark && ALstr.get(2) == playermark) ||
            (ALstr.get(3) == playermark && ALstr.get(4) == playermark && ALstr.get(5) == playermark) ||
            (ALstr.get(6) == playermark && ALstr.get(7) == playermark && ALstr.get(8) == playermark) ||
            (ALstr.get(0) == playermark && ALstr.get(4) == playermark && ALstr.get(8) == playermark) ||
            (ALstr.get(6) == playermark && ALstr.get(4) == playermark && ALstr.get(2) == playermark) ||
            (ALstr.get(0) == playermark && ALstr.get(3) == playermark && ALstr.get(6) == playermark) ||
            (ALstr.get(1) == playermark && ALstr.get(4) == playermark && ALstr.get(7) == playermark) ||
            (ALstr.get(2) == playermark && ALstr.get(5) == playermark && ALstr.get(8) == playermark)
        ){
            System.out.println("Congrats you won!");
            winnerfound = true;
        }else if ((ALstr.get(0) == cpumark && ALstr.get(1) == cpumark && ALstr.get(2) == cpumark) ||
                (ALstr.get(3) == cpumark && ALstr.get(4) == cpumark && ALstr.get(5) == cpumark) ||
                (ALstr.get(6) == cpumark && ALstr.get(7) == cpumark && ALstr.get(8) == cpumark) ||
                (ALstr.get(0) == cpumark && ALstr.get(4) == cpumark && ALstr.get(8) == cpumark) ||
                (ALstr.get(6) == cpumark && ALstr.get(4) == cpumark && ALstr.get(2) == cpumark) ||
                (ALstr.get(0) == cpumark && ALstr.get(3) == cpumark && ALstr.get(6) == cpumark) ||
                (ALstr.get(1) == cpumark && ALstr.get(4) == cpumark && ALstr.get(7) == cpumark) ||
                (ALstr.get(2) == cpumark && ALstr.get(5) == cpumark && ALstr.get(8) == cpumark)){
            System.out.println("You lost :( better luck next time!");
            winnerfound = true;
        }
        return winnerfound;
    }

    public static void updateGameBoard(ArrayList<String> positions){
       ClearConsole();
        System.out.println(

                positions.get(0) + "|" + positions.get(1) + "|" + positions.get(2)+ "\n" + "---+---+---" + "\n" + positions.get(3) + "|" + positions.get(4) + "|" + positions.get(5)+ "\n" + "---+---+---" + "\n" + positions.get(6) + "|" + positions.get(7) + "|" + positions.get(8)
        );
    }

    public static void ClearConsole(){
        try {
            ProcessBuilder pb = new ProcessBuilder("clear");
            Process startProcess = pb.inheritIO().start();

            startProcess.waitFor();
        }catch (Exception e){
            System.out.println("ERROR " + e);
        }

    }
}
