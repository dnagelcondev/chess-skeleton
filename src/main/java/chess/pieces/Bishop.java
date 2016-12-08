package chess.pieces;

import chess.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * The 'Bishop' class
 */
public class Bishop extends Piece {
    public Bishop(Player owner) {
        super(owner);
    }

    @Override
    protected char getIdentifyingCharacter() {
        return 'b';
    }

    @Override
    public List<String> listAllPossibleMoves(chess.GameState gameState, Player player, String position) {
        List<String> moves = new ArrayList<>();


        return moves;
    }

    public String getName(){ return "Bishop"; }
}
