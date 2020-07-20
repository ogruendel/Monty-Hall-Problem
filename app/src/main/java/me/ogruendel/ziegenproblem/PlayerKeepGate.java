package me.ogruendel.ziegenproblem;

public class PlayerKeepGate extends AbstractPlayer {

    private int finalGate;

    @Override
    public void chooseFinalGate(int openedGate) {
        finalGate = getInitialGate();
    }

    @Override
    public int getFinalGate() {
        return finalGate;
    }
}
