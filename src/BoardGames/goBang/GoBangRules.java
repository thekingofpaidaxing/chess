package BoardGames.goBang;

import BoardGames.template.Player;

public class GoBangRules implements GoBangConfig {


    //初始化
    public GoBangRules() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = 0;
            }
        }
        CURRENT_PLAYER = true;
        GameOver = false;
        chessCount = 0;
    }

    public int[][] GetBegin() {
        Begin = new int[ROWS][COLS];

        return Begin;
    }

    //下棋过程
    public void Process(Player player1, Player player2, GoBangChessPieces chess, GoBangRules gameStatus) {
        if (CURRENT_PLAYER) {
            player1.play(chess, gameStatus);
        } else {
            player2.play(chess, gameStatus);
        }
    }

    public Boolean End() {

        return true;
    }

    //判赢
    public boolean win(int x, int y, boolean start) {
        int i, count = 1;
        int BOARD_SIZE = ROWS;
        int f = 0;
        if (start) {
            f = 1;
        } else {
            f = 2;
        }
        boolean up, down, right, left, rup, lup, rdown, ldown;
        up = down = right = left = rup = lup = rdown = ldown = true;
        /**
         *
         * 上下
         *
         */
        for (i = 1; i < 5; ++i) {
            if ((y + i) < BOARD_SIZE) {
                if (board[x][y + i] == f && down)
                    count++;
                else
                    down = false;
            }
            if ((y - i) >= 0) {
                if (board[x][y - i] == f && up)
                    count++;
                else
                    up = false;
            }
        }
        if (count >= 5) {
            return true;
        }
        count = 1;
        /**
         *
         * 左右
         *
         */
        for (i = 1; i < 5; ++i) {
            if ((x + i) < BOARD_SIZE) {
                if (board[x + i][y] == f && right)
                    count++;
                else
                    right = false;
            }
            if ((x - i) >= 0) {
                if (board[x - i][y] == f && left)
                    count++;
                else
                    left = false;
            }
        }
        if (count >= 5) {
            return true;
        }
        count = 1;
        /**
         *
         * 左上右下
         *
         */
        for (i = 1; i < 5; ++i) {
            if ((x + i) < BOARD_SIZE && (y + i) < BOARD_SIZE) {
                if (board[x + i][y + i] == f && rdown)
                    count++;
                else
                    rdown = false;
            }
            if ((x - i) >= 0 && (y - i) >= 0) {
                if (board[x - i][y - i] == f && lup)
                    count++;
                else
                    lup = false;
            }
        }
        if (count >= 5) {
            return true;
        }
        count = 1;
        /**
         *
         * 右上左下
         *
         */
        for (i = 1; i < 5; ++i) {
            if ((x + i) < BOARD_SIZE && (y - i) >= 0) {
                if (board[x + i][y - i] == f && rup)
                    count++;
                else
                    rup = false;
            }
            if ((x - i) >= 0 && (y + i) < BOARD_SIZE) {
                if (board[x - i][y + i] == f && ldown)
                    count++;
                else
                    ldown = false;
            }
        }
        if (count >= 5) {
            return true;
        }
        return false;//默认没有赢局
    }

    //查找所在位置是否有棋子
    public boolean findChess(int position_X, int position_Y) {
        for (GoBangChessPieces c : chessArray) {
            if (c != null && c.getX_coordinate() == position_X && c.getY_coordinate() == position_Y)
                return true;
        }
        return false;

    }

    //重新开始
    public void RestartGame() {
        for (int i = 0; i < chessArray.length; i++)//设置为初始状态
            chessArray[i] = null;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = 0;
            }
        }
        CURRENT_PLAYER = true;
        GameOver = false;
        chessCount = 0;
    }

    //悔棋
    public void GoBack() {
        if (chessCount == 0) {
            return;
        }
        if (chessCount > 0) {
            int x_index = chessArray[chessCount - 1].getX_coordinate();
            int y_index = chessArray[chessCount - 1].getY_coordinate();
            board[x_index][y_index] = 0;
        }
        chessArray[chessCount - 1] = null;
        chessCount--;
        GameOver = false;
        CURRENT_PLAYER = !CURRENT_PLAYER;
    }
}
