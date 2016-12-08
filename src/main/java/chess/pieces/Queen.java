package chess.pieces;

import chess.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * The Queen
 */
public class Queen extends Piece{
    public Queen(Player owner) {
        super(owner);
    }

    @Override
    protected char getIdentifyingCharacter() {
        return 'q';
    }

    @Override
    public List<String> listAllPossibleMoves(chess.GameState gameState, Player player, String position) {
        List<String> moves = new ArrayList<>();


        return moves;
    }

    public String getName(){ return "Queen"; }
}
