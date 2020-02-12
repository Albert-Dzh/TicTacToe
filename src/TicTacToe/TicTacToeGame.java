package TicTacToe;

class TicTacToeGame {

    private char[][] field =
            {
                    {'-', '-', '-', '-', '-', '-', '-', '-', '-'},
                    {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                    {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                    {'|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
                    {'-', '-', '-', '-', '-', '-', '-', '-', '-'}
            };
    private String status = "Fucked";
    private int TicOrTac = 1;


    String getStatus() {
        return status;
    }

    private void setStatus(String status) {
        this.status = status;
    }

    private char TicOrTac(int TicOrTac) {
        return TicOrTac % 2 == 1 ? 'X' : 'O';
    }

    void input (char x, char y) {
        int col = Character.getNumericValue(x) * 2;
        int row = 52 - y;
        if (field[row][col] == ' ') {
            field[row][col] = TicOrTac(TicOrTac++);
        }
        else {
            System.out.println("This cell is occupied! Choose another one!");
        }
    }

    boolean analyze() {
        int sum = 0;
        int j = 2;

        //проверка количества Х и О, если их 9 - у нас предварительная ничья.
        for (int i = 1; i < 4; i++) {
            for (int k = 2; k < 7; k += 2) {
                sum += field[i][k] == 'O' || field[i][k] == 'X' ? 1 : 0;
                if (sum == 9) {
                    setStatus("Draw");
                }
            }
        }
        //проверка по вертикали горизонтали и диагонали, проходка по трём элементам.
        for (int i = 1; i < 4; i++) {
            if (field[i][j] == 'X' && isWon(field[i][j], i, j)) {
                setStatus("X wins");
            }
            else if (field[i][j] == 'O' && isWon(field[i][j], i, j)) {
                setStatus("O wins");
            }
            j += 2;
        }
        return !"Fucked".equals(status);
    }

    private boolean isWon(char currentMove, int i, int j) {
        return field[i][2] == field[i][4] && field[i][4] == field[i][6]
                || field[1][j] == field[2][j] && field[2][j] == field[3][j]
                || field[1][2] == field[i][j] && field[2][4] == field[i][j] && field[3][6] == currentMove
                || field[1][6] == field[2][4] && field[2][4] == field[3][2] && field[3][2] == currentMove;
    }

    void printField() {
        for (char[] chars : field) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }
}