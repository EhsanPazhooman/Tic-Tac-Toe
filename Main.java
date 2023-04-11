import java.util.*;

public class Main {

    static String[] cells = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16"};

    static Scanner input = new Scanner(System.in);

    /*********************************************************************************************/
    public static void main(String[] args) {
        startmenu();
        keymenu();
    }
    /********************************************************************************************/
    static void maincaller()
    {
        main(null);
    }
    /********************************************************************************************/
    public static void startmenu(){
        System.out.printf("%s%s%n%n%s%n%n%s%n", """

                                                                                                                        \s
                                                                                                                        \s
                    ___                                 ___                                    ___                      \s
                  ,--.'|_   ,--,                      ,--.'|_                                ,--.'|_                    \s
                  |  | :,',--.'|                      |  | :,'                               |  | :,'   ,---.           \s
                  :  : ' :|  |,                       :  : ' :                               :  : ' :  '   ,'\\          \s
                .;__,'  / `--'_      ,---.          .;__,'  /   ,--.--.     ,---.          .;__,'  /  /   /   |  ,---.  \s
                |  |   |  ,' ,'|    /     \\         |  |   |   /       \\   /     \\         |  |   |  .   ; ,. : /     \\ \s
                :__,'| :  '  | |   /    / '         :__,'| :  .--.  .-. | /    / '         :__,'| :  '   | |: :/    /  |\s
                  '  : |__|  | :  .    ' /            '  : |__ \\__\\/: . ..    ' /            '  : |__'   | .; .    ' / |\s
                  |  | '.''  : |__'   ; :__           |  | '.'|," .--.; |'   ; :__           |  | '.'|   :    '   ;   /|\s
                  ;  :    |  | '.''   | '.'|          ;  :    /  /  ,.  |'   | '.'|          ;  :    ;\\   \\  /'   |  / |\s
                  |  ,   /;  :    |   :    :          |  ,   ;  :   .'   |   :    :          |  ,   /  `----' |   :    |\s
                   ---`-' |  ,   / \\   \\  /            ---`-'|  ,     .-./\\   \\  /            ---`-'           \\   \\  / \s
                           ---`-'   `----'                    `--`---'     `----'                               `----'  \s
                                                                                                                        \s
                """, "1.Play with the computer", "2.Play with your friend", "3.Exit");
    }
    /****************This method is used for choosing your opponent(or leave the game)***************/
    public static void keymenu(){
        int key = input.nextInt();

        switch (key){
            case 1:
                blockcells();
                playwithcomputer();
            case 2:
                blockcells();
                playwithfriend();
            case 3:
                System.exit(0);
            default:
                System.out.println("▼ Please try again ▼");
                keymenu();
        }
    }
    /******************************This method is printing the gameboard***************************/
    public static void gameboard() {
        System.out.println(cells[0] + '\t' + cells[1] + '\t' + cells[2] + '\t' + cells[3]);
        System.out.println(cells[4] + '\t' + cells[5] + '\t' + cells[6] + '\t' + cells[7]);
        System.out.println(cells[8] + '\t' + cells[9] + '\t' + cells[10] + '\t' + cells[11]);
        System.out.println(cells[12] + '\t' + cells[13] + '\t' + cells[14] + '\t' + cells[15]);
    }

    /*****************************This method is using for blocking cells**************************/
    public static void blockcells() {
        Random rand = new Random();

        ArrayList<Integer> randomnumber = new ArrayList<Integer>();

        randomnumber.add(0,rand.nextInt(1,5));

        randomnumber.add(1,rand.nextInt(6,10));

        randomnumber.add(2,rand.nextInt(11,16));

        for (int i=0; i<3; i++) {
            cells[randomnumber.get(i)]="#";
        }
        gameboard();
    }
    /****************************This method is using for playing with computer********************/

    public static void playwithcomputer() {


        for(int i=1;i<=20;i++)
        {
            {
                if(xcheckwinnerdiagonal()||xcheckwinnerrow()||xcheckwinnercolumns())
                {
                    System.out.println("You Win");
                    playagain();
                }
                else if (ocheckwinnerdiagonal()||ocheckwinnerrow()||ocheckwinnercolumns())
                {
                    System.out.println("Computer Win");
                    playagain();
                }
                else if(checktoe())
                {
                    System.out.println("No one Win");
                    System.out.println("It's toe");
                    System.exit(0);
                }
                else
                {
                    if (i % 2 == 1)
                    {
                        xchoice();
                    }
                    if (i % 2 ==0){
                        computerchoice();
                    }
                }
            }
        }
    }
    /************************This method is using for playing with your friend*********************/
    public static void playwithfriend(){
        for(int i=1;i<=20;i++) {
             {
                if(xcheckwinnerdiagonal()||xcheckwinnerrow()||xcheckwinnercolumns())
                {
                    System.out.println("Player X Win");
                    playagain();
                }
                else if (ocheckwinnerdiagonal()||ocheckwinnerrow()||ocheckwinnercolumns())
                 {
                     System.out.println("Player O Win");
                     playagain();
                 }
                else if(checktoe())
                {
                    System.out.println("No one Win");
                    System.out.println("It's toe");
                    System.exit(0);
                }
                else
                {
                    if (i % 2 == 1)
                    {
                        xchoice();
                    }
                    if (i % 2 == 0)
                    {
                        ochoice();
                    }
                }
             }
        }
    }
    /*********************This method reset the gameboard if you want to play again****************/
    public static void resetgameboard(){
        cells[0]="1";
        cells[1]="2";
        cells[2]="3";
        cells[3]="4";
        cells[4]="5";
        cells[5]="6";
        cells[6]="7";
        cells[7]="8";
        cells[8]="9";
        cells[9]="10";
        cells[10]="11";
        cells[11]="12";
        cells[12]="13";
        cells[13]="14";
        cells[14]="15";
        cells[15]="16";
    }
    /********************This method is using for if you want to play again or not******************/
     public static void playagain(){
         System.out.println("You want to play Again?");
         System.out.println("1-Yes");
         System.out.println("2-No");

         int again = input.nextInt();

         switch (again){
             case 1:
                 resetgameboard();
                 maincaller();
                 break;
             case 2:
                 System.exit(0);
         }
     }
    /************************This method is for Computer turn**************************************/
    public static void computerchoice(){
        Random rand = new Random();

        ArrayList<Integer> randomcomputer = new ArrayList<Integer>();


        for(int i=0;i<16;i++){
            if(cells[i]!="X"&&cells[i]!="O"&&cells[i]!="#")
            {
                randomcomputer.add(i);
            }
        }

        int cmp = rand.nextInt(randomcomputer.size());

        cells[randomcomputer.get(cmp)]="O";

        System.out.println();

        gameboard();
    }

    /************************This method is for Player X turn*************************************/
    public static void xchoice() {
        System.out.println("Choose your cell:");

            int pos = input.nextInt();

            switch (pos) {
                case 1:
                    if(cells[0]=="X"||cells[0]=="#"||cells[0]=="O")
                    {
                        tryagainx();
                    }
                    else
                    {
                        cells[0] = "X";
                    }
                        break;
                case 2:
                    if(cells[1]=="X"||cells[1]=="#"||cells[1]=="O")
                    {
                        tryagainx();
                    }
                    else
                    {
                        cells[1] = "X";
                    }
                    break;
                case 3:
                    if(cells[2]=="X"||cells[2]=="#"||cells[2]=="O")
                    {
                        tryagainx();
                    }
                    else
                    {
                        cells[2] = "X";
                    }
                    break;
                case 4:
                    if(cells[3]=="X"||cells[3]=="#"||cells[3]=="O")
                    {
                        tryagainx();
                    }
                    else
                    {
                        cells[3] = "X";
                    }
                    break;
                case 5:
                    if(cells[4]=="X"||cells[4]=="#"||cells[4]=="O")
                    {
                        tryagainx();
                    }
                    else
                    {
                        cells[4] = "X";
                    }
                    break;
                case 6:
                    if(cells[5]=="X"||cells[5]=="#"||cells[5]=="O")
                    {
                        tryagainx();
                    }
                    else
                    {
                        cells[5] = "X";
                    }
                    break;
                case 7:
                    if(cells[6]=="X"||cells[6]=="#"||cells[6]=="O")
                    {
                        tryagainx();
                    }
                    else
                    {
                        cells[6] = "X";
                    }
                    break;
                case 8:
                    if(cells[7]=="X"||cells[7]=="#"||cells[7]=="O")
                    {
                        tryagainx();
                    }
                    else
                    {
                        cells[7] = "X";
                    }
                    break;
                case 9:
                    if(cells[8]=="X"||cells[8]=="#"||cells[8]=="O")
                    {
                        tryagainx();
                    }
                    else
                    {
                        cells[8] = "X";
                    }
                    break;
                case 10:
                    if(cells[9]=="X"||cells[9]=="#"||cells[9]=="O")
                    {
                        tryagainx();
                    }
                    else
                    {
                        cells[9] = "X";
                    }
                    break;
                case 11:
                    if(cells[10]=="X"||cells[10]=="#"||cells[10]=="O")
                    {
                        tryagainx();
                    }
                    else
                    {
                        cells[10] = "X";
                    }
                    break;
                case 12:
                    if(cells[11]=="X"||cells[11]=="#"||cells[11]=="O")
                    {
                        tryagainx();
                    }
                    else
                    {
                        cells[11] = "X";
                    }
                    break;
                case 13:
                    if(cells[12]=="X"||cells[12]=="#"||cells[12]=="O")
                    {
                        tryagainx();
                    }
                    else
                    {
                        cells[12] = "X";
                    }
                    break;
                case 14:
                    if(cells[13]=="X"||cells[13]=="#"||cells[13]=="O")
                    {
                        tryagainx();
                    }
                    else
                    {
                        cells[13] = "X";
                    }
                    break;
                case 15:
                    if(cells[14]=="X"||cells[14]=="#"||cells[14]=="O")
                    {
                        tryagainx();
                    }
                    else
                    {
                        cells[14] = "X";
                    }
                    break;
                case 16:
                    if(cells[15]=="X"||cells[15]=="#"||cells[15]=="O")
                    {
                        tryagainx();
                    }
                    else
                    {
                        cells[15] = "X";
                    }
                    break;
                default:
                    tryagainx();

            }
        gameboard();
    }

    /********************This method is using when Player X choose wrong cell***********************/
    public static void tryagainx() {

        System.out.println("▼ Please try again ▼");

        int pos = input.nextInt();

        switch (pos) {
            case 1:
                if(cells[0]=="X"||cells[0]=="#"||cells[0]=="O")
                {
                    tryagainx();
                }
                else
                {
                    cells[0] = "X";
                }
                break;
            case 2:
                if(cells[1]=="X"||cells[1]=="#"||cells[1]=="O")
                {
                    tryagainx();
                }
                else
                {
                    cells[1] = "X";
                }
                break;
            case 3:
                if(cells[2]=="X"||cells[2]=="#"||cells[2]=="O")
                {
                    tryagainx();
                }
                else
                {
                    cells[2] = "X";
                }
                break;
            case 4:
                if(cells[3]=="X"||cells[3]=="#"||cells[3]=="O")
                {
                    tryagainx();
                }
                else
                {
                    cells[3] = "X";
                }
                break;
            case 5:
                if(cells[4]=="X"||cells[4]=="#"||cells[4]=="O")
                {
                    tryagainx();
                }
                else
                {
                    cells[4] = "X";
                }
                break;
            case 6:
                if(cells[5]=="X"||cells[5]=="#"||cells[5]=="O")
                {
                    tryagainx();
                }
                else
                {
                    cells[5] = "X";
                }
                break;
            case 7:
                if(cells[6]=="X"||cells[6]=="#"||cells[6]=="O")
                {
                    tryagainx();
                }
                else
                {
                    cells[6] = "X";
                }
                break;
            case 8:
                if(cells[7]=="X"||cells[7]=="#"||cells[7]=="O")
                {
                    tryagainx();
                }
                else
                {
                    cells[7] = "X";
                }
                break;
            case 9:
                if(cells[8]=="X"||cells[8]=="#"||cells[8]=="O")
                {
                    tryagainx();
                }
                else
                {
                    cells[8] = "X";
                }
                break;
            case 10:
                if(cells[9]=="X"||cells[9]=="#"||cells[9]=="O")
                {
                    tryagainx();
                }
                else
                {
                    cells[9] = "X";
                }
                break;
            case 11:
                if(cells[10]=="X"||cells[10]=="#"||cells[10]=="O")
                {
                    tryagainx();
                }
                else
                {
                    cells[10] = "X";
                }
                break;
            case 12:
                if(cells[11]=="X"||cells[11]=="#"||cells[11]=="O")
                {
                    tryagainx();
                }
                else
                {
                    cells[11] = "X";
                }
                break;
            case 13:
                if(cells[12]=="X"||cells[12]=="#"||cells[12]=="O")
                {
                    tryagainx();
                }
                else
                {
                    cells[12] = "X";
                }
                break;
            case 14:
                if(cells[13]=="X"||cells[13]=="#"||cells[13]=="O")
                {
                    tryagainx();
                }
                else
                {
                    cells[13] = "X";
                }
                break;
            case 15:
                if(cells[14]=="X"||cells[14]=="#"||cells[14]=="O")
                {
                    tryagainx();
                }
                else
                {
                    cells[14] = "X";
                }
                break;
            case 16:
                if(cells[15]=="X"||cells[15]=="#"||cells[15]=="O")
                {
                    tryagainx();
                }
                else
                {
                    cells[15] = "X";
                }
                break;
            default:
                tryagainx();
        }

    }

    /****************************This method is for Player O turn*********************************/
    public static void ochoice() {
        System.out.println("Choose your cell:");

        int pos = input.nextInt();

        switch (pos) {
            case 1:
                if(cells[0]=="X"||cells[0]=="#"||cells[0]=="O")
                {
                    tryagaino();
                }
                else
                {
                    cells[0] = "O";
                }
                break;
            case 2:
                if(cells[1]=="X"||cells[1]=="#"||cells[1]=="O")
                {
                    tryagaino();
                }
                else
                {
                    cells[1] = "O";
                }
                break;
            case 3:
                if(cells[2]=="X"||cells[2]=="#"||cells[2]=="O")
                {
                    tryagaino();
                }
                else
                {
                    cells[2] = "O";
                }
                break;
            case 4:
                if(cells[3]=="X"||cells[3]=="#"||cells[3]=="O")
                {
                    tryagaino();
                }
                else
                {
                    cells[3] = "O";
                }
                break;
            case 5:
                if(cells[4]=="X"||cells[4]=="#"||cells[4]=="O")
                {
                    tryagaino();
                }
                else
                {
                    cells[4] = "O";
                }
                break;
            case 6:
                if(cells[5]=="X"||cells[5]=="#"||cells[5]=="O")
                {
                    tryagaino();
                }
                else
                {
                    cells[5] = "O";
                }
                break;
            case 7:
                if(cells[6]=="X"||cells[6]=="#"||cells[6]=="O")
                {
                    tryagaino();
                }
                else
                {
                    cells[6] = "O";
                }
                break;
            case 8:
                if(cells[7]=="X"||cells[7]=="#"||cells[7]=="O")
                {
                    tryagaino();
                }
                else
                {
                    cells[7] = "O";
                }
                break;
            case 9:
                if(cells[8]=="X"||cells[8]=="#"||cells[8]=="O")
                {
                    tryagaino();
                }
                else
                {
                    cells[8] = "O";
                }
                break;
            case 10:
                if(cells[9]=="X"||cells[9]=="#"||cells[9]=="O")
                {
                    tryagaino();
                }
                else
                {
                    cells[9] = "O";
                }
                break;
            case 11:
                if(cells[10]=="X"||cells[10]=="#"||cells[10]=="O")
                {
                    tryagaino();
                }
                else
                {
                    cells[10] = "O";
                }
                break;
            case 12:
                if(cells[11]=="X"||cells[11]=="#"||cells[11]=="O")
                {
                    tryagaino();
                }
                else
                {
                    cells[11] = "O";
                }
                break;
            case 13:
                if(cells[12]=="X"||cells[12]=="#"||cells[12]=="O")
                {
                    tryagaino();
                }
                else
                {
                    cells[12] = "O";
                }
                break;
            case 14:
                if(cells[13]=="X"||cells[13]=="#"||cells[13]=="O")
                {
                    tryagaino();
                }
                else
                {
                    cells[13] = "O";
                }
                break;
            case 15:
                if(cells[14]=="X"||cells[14]=="#"||cells[14]=="O")
                {
                    tryagaino();
                }
                else
                {
                    cells[14] = "O";
                }
                break;
            case 16:
                if(cells[15]=="X"||cells[15]=="#"||cells[15]=="O")
                {
                    tryagaino();
                }
                else
                {
                    cells[15] = "O";
                }
                break;
            default:
                tryagaino();
        }
        gameboard();
    }
    /**********************This method is using when Player O choose wrong cell*********************/
    public static void tryagaino() {

        System.out.println("▼ Please try again ▼");

        int pos = input.nextInt();

        switch (pos) {
            case 1:
                if(cells[0]=="X"||cells[0]=="#"||cells[0]=="O")
                {
                    tryagaino();
                }
                else
                {
                    cells[0] = "O";
                }
                break;
            case 2:
                if(cells[1]=="X"||cells[1]=="#"||cells[1]=="O")
                {
                    tryagaino();
                }
                else
                {
                    cells[1] = "O";
                }
                break;
            case 3:
                if(cells[2]=="X"||cells[2]=="#"||cells[2]=="O")
                {
                    tryagaino();
                }
                else
                {
                    cells[2] = "O";
                }
                break;
            case 4:
                if(cells[3]=="X"||cells[3]=="#"||cells[3]=="O")
                {
                    tryagaino();
                }
                else
                {
                    cells[3] = "O";
                }
                break;
            case 5:
                if(cells[4]=="X"||cells[4]=="#"||cells[4]=="O")
                {
                    tryagaino();
                }
                else
                {
                    cells[4] = "O";
                }
                break;
            case 6:
                if(cells[5]=="X"||cells[5]=="#"||cells[5]=="O")
                {
                    tryagaino();
                }
                else
                {
                    cells[5] = "O";
                }
                break;
            case 7:
                if(cells[6]=="X"||cells[6]=="#"||cells[6]=="O")
                {
                    tryagaino();
                }
                else
                {
                    cells[6] = "O";
                }
                break;
            case 8:
                if(cells[7]=="X"||cells[7]=="#"||cells[7]=="O")
                {
                    tryagaino();
                }
                else
                {
                    cells[7] = "O";
                }
                break;
            case 9:
                if(cells[8]=="X"||cells[8]=="#"||cells[8]=="O")
                {
                    tryagaino();
                }
                else
                {
                    cells[8] = "O";
                }
                break;
            case 10:
                if(cells[9]=="X"||cells[9]=="#"||cells[9]=="O")
                {
                    tryagaino();
                }
                else
                {
                    cells[9] = "O";
                }
                break;
            case 11:
                if(cells[10]=="X"||cells[10]=="#"||cells[10]=="O")
                {
                    tryagaino();
                }
                else
                {
                    cells[10] = "O";
                }
                break;
            case 12:
                if(cells[11]=="X"||cells[11]=="#"||cells[11]=="O")
                {
                    tryagaino();
                }
                else
                {
                    cells[11] = "O";
                }
                break;
            case 13:
                if(cells[12]=="X"||cells[12]=="#"||cells[12]=="O")
                {
                    tryagaino();
                }
                else
                {
                    cells[12] = "O";
                }
                break;
            case 14:
                if(cells[13]=="X"||cells[13]=="#"||cells[13]=="O")
                {
                    tryagaino();
                }
                else
                {
                    cells[13] = "O";
                }
                break;
            case 15:
                if(cells[14]=="X"||cells[14]=="#"||cells[14]=="O")
                {
                    tryagaino();
                }
                else
                {
                    cells[14] = "O";
                }
                break;
            case 16:
                if(cells[15]=="X"||cells[15]=="#"||cells[15]=="O")
                {
                    tryagaino();
                }
                else
                {
                    cells[15] = "O";
                }
            default:
                tryagaino();
        }
    }


    /**************This method is checking the winner in row condition for player X ****************/
    public static boolean xcheckwinnerrow(){
        if((cells[0]=="X"&&cells[1]=="X"&&cells[2]=="X")||(cells[1]=="X"&&cells[2]=="X"&&cells[3]=="X")||
                (cells[4]=="X"&&cells[5]=="X"&&cells[6]=="X")||(cells[5]=="X"&&cells[6]=="X"&&cells[7]=="X")||
                (cells[8]=="X"&&cells[9]=="X"&&cells[10]=="X")||(cells[9]=="X"&&cells[10]=="X"&&cells[11]=="X")||
                (cells[12]=="X"&&cells[13]=="X"&&cells[14]=="X")||(cells[13]=="X"&&cells[14]=="X"&&cells[15]=="X"))
        {
            return true;
        }
            return false;
    }
/******************This method is checking the winner in column condition for player X *************/
    public static boolean xcheckwinnercolumns(){
        if((cells[0]=="X"&&cells[4]=="X"&&cells[8]=="X")||(cells[4]=="X"&&cells[8]=="X"&&cells[12]=="X")||
            (cells[1]=="X"&&cells[5]=="X"&&cells[9]=="X")||(cells[5]=="X"&&cells[9]=="X"&&cells[13]=="X")||
            (cells[2]=="X"&&cells[6]=="X"&&cells[10]=="X")||(cells[6]=="X"&&cells[10]=="X"&&cells[14]=="X")||
            (cells[3]=="X"&&cells[7]=="X"&&cells[11]=="X")||(cells[7]=="X"&&cells[11]=="X"&&cells[15]=="X"))
    {
            return true;
    }
            return false;
}
/****************This method is checking the winner in diagonal condition for player X ***************/
    public static boolean xcheckwinnerdiagonal(){
        if((cells[0]=="X"&&cells[10]=="X"&&cells[5]=="X")||(cells[1]=="X"&&cells[6]=="X"&&cells[11]=="X")||
            (cells[2]=="X"&&cells[5]=="X"&&cells[8]=="X")||(cells[3]=="X"&&cells[6]=="X"&&cells[9]=="X")||
            (cells[4]=="X"&&cells[9]=="X"&&cells[14]=="X")||(cells[5]=="X"&&cells[10]=="X"&&cells[15]=="X")||
            (cells[6]=="X"&&cells[9]=="X"&&cells[12]=="X")||(cells[7]=="X"&&cells[10]=="X"&&cells[13]=="X"))
    {
            return true;
    }
            return false;
}

    /*************This method is checking the winner in row condition for player O **********************/
    public static boolean ocheckwinnerrow(){
    if((cells[0]=="O"&&cells[1]=="X"&&cells[2]=="O")||(cells[1]=="O"&&cells[2]=="O"&&cells[3]=="O")||
            (cells[4]=="O"&&cells[5]=="O"&&cells[6]=="O")||(cells[5]=="O"&&cells[6]=="O"&&cells[7]=="O")||
            (cells[8]=="O"&&cells[9]=="O"&&cells[10]=="O")||(cells[9]=="O"&&cells[10]=="O"&&cells[11]=="O")||
            (cells[12]=="O"&&cells[13]=="O"&&cells[14]=="O")||(cells[13]=="O"&&cells[14]=="O"&&cells[15]=="O"))
    {
        return true;
    }
    return false;
}
    /****************This method is checking the winner in column condition for player O *****************/
    public static boolean ocheckwinnercolumns(){
        if((cells[0]=="O"&&cells[4]=="O"&&cells[8]=="O")||(cells[4]=="O"&&cells[8]=="O"&&cells[12]=="O")||
                (cells[1]=="O"&&cells[5]=="O"&&cells[9]=="O")||(cells[5]=="O"&&cells[9]=="O"&&cells[13]=="O")||
                (cells[2]=="O"&&cells[6]=="O"&&cells[10]=="O")||(cells[6]=="O"&&cells[10]=="O"&&cells[14]=="O")||
                (cells[3]=="O"&&cells[7]=="O"&&cells[11]=="O")||(cells[7]=="O"&&cells[11]=="O"&&cells[15]=="O"))
        {
            return true;
        }
        return false;
    }
    /*****************This method is checking the winner in diagonal condition for player O ***************/
    public static boolean ocheckwinnerdiagonal(){
    if((cells[0]=="O"&&cells[5]=="X"&&cells[10]=="O")||(cells[1]=="O"&&cells[6]=="O"&&cells[11]=="O")||
            (cells[2]=="O"&&cells[5]=="O"&&cells[8]=="O")||(cells[3]=="O"&&cells[6]=="O"&&cells[9]=="O")||
            (cells[4]=="O"&&cells[9]=="O"&&cells[14]=="O")||(cells[5]=="O"&&cells[10]=="O"&&cells[15]=="O")||
            (cells[6]=="O"&&cells[9]=="O"&&cells[12]=="O")||(cells[7]=="O"&&cells[10]=="O"&&cells[13]=="O"))
    {
        return true;
    }
    return false;
    }
    /****************This method is checking for Toe(draw) Condition ************************************/

    public static boolean checktoe(){
        if(cells[0]!="1"&&cells[1]!="2"&&cells[2]!="3"&&cells[3]!="4"&&cells[4]!="5"&&cells[5]!="6"&&
                cells[6]!="7"&&cells[7]!="8"&&cells[8]!="9"&&cells[9]!="10"&&cells[10]!="11"&&cells[11]!="12"&&
                cells[12]!="13"&&cells[13]!="14"&&cells[14]!="15"&&cells[15]!="16")
        {
            return true;
        }
            return false;
    }
}

