import java.util.Scanner;

public class Othello {
    public static void main(String[] args) {
        char[][] board = new char[9][9];
        board[0][0] = ' ';
        board[0][1] = board[1][0] = '1';
        for(int i = 2 , j = 1 ;i < 9; i++ , j++) {
            board[0][i] = board[i][0] = (char) (board[0][1] + j);
        }
        for(int i = 1 ; i < 9; i++) {
            for(int j = 1; j < 9; j++) {
                board[i][j] = '.';
            }
        }
        board[4][4] = board[5][5] = 'I';
        board[5][4] = board[4][5] = 'O';
        print(board);
        boolean isO = true;
        Scanner in = new Scanner(System.in);
        for(int q = 0; q < 60 ; q++){
            int r = 0 , x , y;
            x = in.nextInt();
            y = in.nextInt();
            if(isO && reverse(x,y,board,isO) && board[x][y] == '.') {
                board[x][y] = 'O';
                isO = false;
                print(board);
            }
            else if (!isO && reverse(x,y,board,isO) && board[x][y] == '.') {
                board[x][y] = 'I';
                isO = true;
                print(board);
            }
            else {
                System.out.println("INVALID !");
                q--;
                continue;
            }
        }
        int IC = 0 , OC = 0;
        for(int i = 1 ; i < 9; i++) {
            for(int j = 1; j < 9; j++) {
                if(board[i][j] == 'I')
                    IC++;
                else
                    OC++;
            }
        }
        if(OC>IC)
            System.out.println("O wins !");
        else if(IC>OC)
            System.out.println("I wins !");
        else
            System.out.println("Draw !");
    }
    static void print(char[][] a) {
        for(int i = 0 ; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
    static boolean reverse (int x , int y , char[][] b , boolean o) {
        boolean rev = false, isOpp = false;
        if (o) {
            for (int i = x + 1; i < 9; i++) {
                if (b[i][y] == 'I') {
                    isOpp = true;
                }
                else if (b[i][y] == 'O' && isOpp) {
                    for(int j = i; j>x ; j--) {
                        b[j][y] = 'O';
                    }
                    rev = true;
                    break;
                }
                else {
                    isOpp = false;
                    break;
                }
            }
            for (int i = x - 1; i > 0; i--) {
                if (b[i][y] == 'I') {
                    isOpp = true;
                }
                else if (b[i][y] == 'O' && isOpp) {
                    for(int j = i; j < x ; j++) {
                        b[j][y] = 'O';
                    }
                    rev = true;
                    break;
                }
                else {
                    isOpp = false;
                    break;
                }
            }
            for (int i = y + 1; i < 9; i++) {
                if (b[x][i] == 'I') {
                    isOpp = true;
                }
                else if (b[x][i] == 'O' && isOpp) {
                    for(int j = i; j > y ; j--) {
                        b[x][j] = 'O';
                    }
                    rev = true;
                    break;
                }
                else {
                    isOpp = false;
                    break;
                }
            }
            for (int i = y - 1; i > 0; i--) {
                if (b[x][i] == 'I') {
                    isOpp = true;
                }
                else if (b[x][i] == 'O' && isOpp) {
                    for(int j = i; j < y ; j++) {
                        b[x][j] = 'O';
                    }
                    rev = true;
                    break;
                }
                else {
                    isOpp = false;
                    break;
                }
            }
            for (int i = x + 1 , j = y + 1; i < 9 && j < 9; j++, i++) {
                if (b[i][j] == 'I') {
                    isOpp = true;
                }
                else if (b[i][j] == 'O' && isOpp) {
                    for(int k = i , t = j ; k > x && t > y ; k-- , t--) {
                        b[k][t] = 'O';
                    }
                    rev = true;
                    break;
                }
                else {
                    isOpp = false;
                    break;
                }
            }
            for (int i = x - 1 , j = y - 1; i > 0 && j > 0; j--, i--) {
                if (b[i][j] == 'I') {
                    isOpp = true;
                }
                else if (b[i][j] == 'O' && isOpp) {
                    for(int k = i , t = j ; k < x && t < y ; k++ , t++) {
                        b[k][t] = 'O';
                    }
                    rev = true;
                    break;
                }
                else {
                    isOpp = false;
                    break;
                }
            }
            for (int i = x + 1 , j = y - 1; i < 9 && j > 0; j--, i++) {
                if (b[i][j] == 'I') {
                    isOpp = true;
                }
                else if (b[i][j] == 'O' && isOpp) {
                    for(int k = i , t = j ; k > x && t < y ; k-- , t++) {
                        b[k][t] = 'O';
                    }
                    rev = true;
                    break;
                }
                else {
                    isOpp = false;
                    break;
                }
            }
            for (int i = x - 1 , j = y + 1; i > 0 && j < 9; j++, i--) {
                if (b[i][j] == 'I') {
                    isOpp = true;
                }
                else if (b[i][j] == 'O' && isOpp) {
                    for(int k = i , t = j ; k < x && t > y ; k++ , t--) {
                        b[k][t] = 'O';
                    }
                    rev = true;
                    break;
                }
                else {
                    isOpp = false;
                    break;
                }
            }
        }
        else {
            for (int i = x + 1; i < 9; i++) {
                if (b[i][y] == 'O') {
                    isOpp = true;
                }
                else if (b[i][y] == 'I' && isOpp) {
                    for(int j = i; j>x ; j--) {
                        b[j][y] = 'I';
                    }
                    rev = true;
                    break;
                }
                else {
                    isOpp = false;
                    break;
                }
            }
            for (int i = x - 1; i > 0; i--) {
                if (b[i][y] == 'O') {
                    isOpp = true;
                }
                else if (b[i][y] == 'I' && isOpp) {
                    for(int j = i; j < x ; j++) {
                        b[j][y] = 'I';
                    }
                    rev = true;
                    break;
                }
                else {
                    isOpp = false;
                    break;
                }
            }
            for (int i = y + 1; i < 9; i++) {
                if (b[x][i] == 'O') {
                    isOpp = true;
                }
                else if (b[x][i] == 'I' && isOpp) {
                    for(int j = i; j > y ; j--) {
                        b[x][j] = 'I';
                    }
                    rev = true;
                    break;
                }
                else {
                    isOpp = false;
                    break;
                }
            }
            for (int i = y - 1; i > 0; i--) {
                if (b[x][i] == 'O') {
                    isOpp = true;
                }
                else if (b[x][i] == 'I' && isOpp) {
                    for(int j = i; j < y ; j++) {
                        b[x][j] = 'I';
                    }
                    rev = true;
                    break;
                }
                else {
                    isOpp = false;
                    break;
                }
            }
            for (int i = x + 1 , j = y + 1; i < 9 && j < 9; j++, i++) {
                if (b[i][j] == 'O') {
                    isOpp = true;
                }
                else if (b[i][j] == 'I' && isOpp) {
                    for(int k = i , t = j ; k > x && t > y ; k-- , t--) {
                        b[k][t] = 'I';
                    }
                    rev = true;
                    break;
                }
                else {
                    isOpp = false;
                    break;
                }
            }
            for (int i = x - 1 , j = y - 1; i > 0 && j > 0; j--, i--) {
                if (b[i][j] == 'O') {
                    isOpp = true;
                }
                else if (b[i][j] == 'I' && isOpp) {
                    for(int k = i , t = j ; k < x && t < y ; k++ , t++) {
                        b[k][t] = 'I';
                    }
                    rev = true;
                    break;
                }
                else {
                    isOpp = false;
                    break;
                }
            }
            for (int i = x + 1 , j = y - 1; i < 9 && j > 0; j--, i++) {
                if (b[i][j] == 'O') {
                    isOpp = true;
                }
                else if (b[i][j] == 'I' && isOpp) {
                    for(int k = i , t = j ; k > x && t < y ; k-- , t++) {
                        b[k][t] = 'I';
                    }
                    rev = true;
                    break;
                }
                else {
                    isOpp = false;
                    break;
                }
            }
            for (int i = x - 1 , j = y + 1; i > 0 && j < 9; j++, i--) {
                if (b[i][j] == 'O') {
                    isOpp = true;
                }
                else if (b[i][j] == 'I' && isOpp) {
                    for(int k = i , t = j ; k < x && t > y ; k++ , t--) {
                        b[k][t] = 'I';
                    }
                    rev = true;
                    break;
                }
                else {
                    isOpp = false;
                    break;
                }
            }
        }
        return rev;
    }
}
