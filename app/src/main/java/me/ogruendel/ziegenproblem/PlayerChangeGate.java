package me.ogruendel.ziegenproblem;

import java.util.concurrent.ThreadLocalRandom;

public class PlayerChangeGate extends AbstractPlayer {

    private int finalGate;

    @Override
    public void chooseFinalGate(int openedGate) {

        while (true) {
            finalGate = ThreadLocalRandom.current().nextInt(gates);
            if (finalGate != getInitialGate() && finalGate != openedGate){
                break;
            }
        }
    }

    @Override
    public int getFinalGate() {
        return finalGate;
    }
}
