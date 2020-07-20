package me.ogruendel.ziegenproblem;

import java.util.concurrent.ThreadLocalRandom;

public class Game {

    private final int gates;
    private final Host host;
    private final AbstractPlayer player;

    public Game(int gates, Host host, AbstractPlayer player) {
        this.gates = gates;
        this.host = host;
        this.player = player;
    }

    /**
     * Runs one instance of a game: player chooses initial gate, host opens one of the other gates,
     * player chooses final gate.
     *
     * @return {@code true} if player wins, {@code false} otherwise.
     */
    public boolean runGame() {
        int winningGate = ThreadLocalRandom.current().nextInt(gates);

        player.chooseInitialGate();
        int initialGate = player.getInitialGate();

        host.openGate(winningGate, initialGate);
        int openedGate = host.getOpenedGate();

        player.chooseFinalGate(openedGate);
        return player.getFinalGate() == winningGate;
    }

    /*
    public static void main(String[] args) {
        Game game = new Game(4);
        for (int i = 0; i < 10000; i++) {
            game.runGame();
            System.out.println("Runs, wins: " + game.runs + ", " + game.playerWins);
        }
    }

     */
}
