package chess.pieces;

import chess.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * The Knight class
 */
public class Knight extends Piece {
    public Knight(Player owner) {
        super(owner);
    }

    @Override
    protected char getIdentifyingCharacter() {
        return 'n';
    }

    @Override
    public List<String> listAllPossibleMoves(chess.GameState gameState, Player player, String position) {
        List<String> moves = new ArrayList<>();

        if (player.equals(getOwner())) {
            String[] postionInfo = position.split("");
            int row = Integer.parseInt(postionInfo[1]);
            String col = postionInfo[0];

            List<String> availablePositions = getAvailablePositions(player, row, col);
            moves.addAll(getValidMoves(gameState, player, availablePositions, false));
        }

        return moves;
    }


    private List getAvailablePositions(Player player, int row, String col) {
        List<String> availablePositions = new ArrayList<>();

        int upmove1 = row + 1;
        int downmove1 = row - 1;

        int upmove2 = row + 2;
        int downmove2 = row - 2;

        List<String> diagonalPositions = getDiagonalPositions(col);


        for (int i = 0; i < diagonalPositions.size(); i++) {
            if (upmove1 > 0 && upmove1 < 9) {
                availablePositions.add(diagonalPositions.get(i) + upmove2);
            }

            if (downmove1 > 0 && downmove1 < 9) {
                availablePositions.add(diagonalPositions.get(i) + downmove1);
            }
        }

        return availablePositions;
    }


    public String getName() {
        return "Knight";
    }
}
