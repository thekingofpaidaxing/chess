package BoardGames.goBang;

import javax.swing.*;
import java.awt.*;

public class GoBangChessPieces {

    private int X_coordinate, Y_coordinate;

    private Image ChessImage;

    public Image getChessImage() {
        return ChessImage;
    }

    public void setChessImage(Image chessImage) {
        ChessImage = chessImage;
    }
    public GoBangChessPieces() {
        X_coordinate = -1;
        Y_coordinate = -1;
        ChessImage=null;
    }

    public GoBangChessPieces(int x_coordinate, int y_coordinate) {
        X_coordinate = x_coordinate;
        Y_coordinate = y_coordinate;
    }

    public int getX_coordinate() {
        return X_coordinate;
    }

    public void setX_coordinate(int x_coordinate) {
        X_coordinate = x_coordinate;
    }

    public int getY_coordinate() {
        return Y_coordinate;
    }

    public void setY_coordinate(int y_coordinate) {
        Y_coordinate = y_coordinate;
    }


}
