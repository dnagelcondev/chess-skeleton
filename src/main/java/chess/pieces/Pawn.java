package chess.pieces;

import chess.Player;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;
import java.util.List;

/**
 * The Pawn
 */
public class Pawn extends Piece {
    public Pawn(Player owner) {
        super(owner);
    }

    @Override
    protected char getIdentifyingCharacter() {
        return 'p';
    }

    @Override
    public List<String> listAllPossibleMoves(chess.GameState gameState, Player player, String position) {
        List<String> moves = new ArrayList<>();

        if (player.equals(getOwner())) {
            String[] postionInfo = position.split("");
            int row = Integer.parseInt(postionInfo[1]);
            String col = postionInfo[0];

            List<String> availablePositions = getAvailablePositions(player, row, col);
            List<String> availableDiagonalPositions = getAvailableDiagonalPositions(player, row, col);

            moves.addAll(getValidMoves(gameState, player, availablePositions, false));
            moves.addAll(getValidMoves(gameState, player, availablePositions, true));
        }

        return moves;
    }



    private List getAvailablePositions(Player player, int row, String col) {
        List<String> availablePositions = new ArrayList<>();

        int targetRow = -1;
        int extraRow = -1;

        if (player == Player.White) {
            targetRow = row + 1;

            if (row == 2) {
                extraRow = targetRow + 1;
            }
        } else {
            targetRow = row - 1;
            if (row == 7) {
                extraRow = targetRow - 1;
            }
        }

        if (targetRow > 0 && targetRow < 9) {
            availablePositions.add(col + targetRow);
        }

        if (extraRow > 0 && extraRow < 9) {
            availablePositions.add(col + extraRow);
        }

        return availablePositions;
    }

    private List getAvailableDiagonalPositions(Player player, int row, String col) {
        List<String> diagonalPositions = getDiagonalPositions(col);

        List<String> availableDiagonalPositions = new ArrayList<>();
        for (int i = 0; i < diagonalPositions.size(); i++) {
            availableDiagonalPositions.addAll(getAvailablePositions(player, row, diagonalPositions.get(i)));
        }

        return availableDiagonalPositions;
    }

    public String getName(){ return "Pawn"; }
}
