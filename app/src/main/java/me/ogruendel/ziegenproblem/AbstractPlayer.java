package me.ogruendel.ziegenproblem;

import java.util.concurrent.ThreadLocalRandom;

public abstract class AbstractPlayer {

    protected int gates;

    private int initialGate;

    public void setGates(int gates) {
        this.gates = gates;
    }

    public void chooseInitialGate() {
        initialGate = ThreadLocalRandom.current().nextInt(gates);
    }

    public int getInitialGate() {
        return initialGate;
    }

    public abstract void chooseFinalGate(int openedGate);

    public abstract int getFinalGate();
}
