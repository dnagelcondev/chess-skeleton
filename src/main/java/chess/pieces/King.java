package chess.pieces;

import chess.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * The King class
 */
public class King extends Piece {
    public King(Player owner) {
        super(owner);
    }

    @Override
    protected char getIdentifyingCharacter() {
        return 'k';
    }

    @Override
    public List<String> listAllPossibleMoves(chess.GameState gameState, Player player, String position) {
        List<String> moves = new ArrayList<>();


        return moves;
    }

    public String getName(){ return "King"; }
}
