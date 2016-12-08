package chess.pieces;

import chess.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * A base class for chess pieces
 */
public abstract class Piece {
    private final Player owner;

    protected Piece(Player owner) {
        this.owner = owner;
    }

    public char getIdentifier() {
        char id = getIdentifyingCharacter();
        if (owner.equals(Player.White)) {
            return Character.toLowerCase(id);
        } else {
            return Character.toUpperCase(id);
        }
    }

    public Player getOwner() {
        return owner;
    }

    abstract public List<String> listAllPossibleMoves(chess.GameState gameState, Player player, String position);
    abstract public String getName();

    protected abstract char getIdentifyingCharacter();

    protected List getDiagonalPositions(String col) {
        List<String> cols = new ArrayList<>();

        switch (col) {
            case "a": {
                cols.add("b");
                break;
            }
            case "b": {
                cols.add("a");
                cols.add("c");
                break;
            }
            case "c": {
                cols.add("b");
                cols.add("d");
                break;
            }
            case "d": {
                cols.add("c");
                cols.add("e");
                break;
            }
            case "e": {
                cols.add("d");
                cols.add("f");
                break;
            }
            case "f": {
                cols.add("e");
                cols.add("g");
                break;
            }
            case "g": {
                cols.add("f");
                cols.add("h");
                break;
            }
            case "h": {
                cols.add("g");
                break;
            }
        }

        return cols;
    }

    protected List<String> getValidMoves(chess.GameState gameState, Player player, List<String> availablePositions, boolean isDiagonal) {
        List<String> validMoves = new ArrayList<>();


        for (int i = 0; i < availablePositions.size(); i++) {
            String move = availablePositions.get(i);

            chess.pieces.Piece piece = gameState.getPieceAt(move);

            if (isDiagonal) {
                if (piece != null && piece.getOwner() != player) {
                    validMoves.add(move);
                }
            } else {
                if (piece == null || piece.getOwner() != player) {
                    validMoves.add(move);
                }
            }
        }

        return validMoves;
    }
}
