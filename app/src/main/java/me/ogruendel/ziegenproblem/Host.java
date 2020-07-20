package me.ogruendel.ziegenproblem;

import java.util.concurrent.ThreadLocalRandom;

public class Host {

    private final int gates;

    private int openedGate;

    public Host(int gates) {
        this.gates = gates;
    }

    public void openGate(int winningGate, int chosenGate) {
        while (true) {
            openedGate = ThreadLocalRandom.current().nextInt(gates);
            if (openedGate != winningGate && openedGate != chosenGate){
                break;
            }
        }
    }

    public int getOpenedGate() {
        return openedGate;
    }
}
