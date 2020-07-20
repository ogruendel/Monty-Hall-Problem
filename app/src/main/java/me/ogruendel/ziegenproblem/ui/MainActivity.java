package me.ogruendel.ziegenproblem.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

import me.ogruendel.ziegenproblem.AbstractPlayer;
import me.ogruendel.ziegenproblem.Game;
import me.ogruendel.ziegenproblem.Host;
import me.ogruendel.ziegenproblem.PlayerChangeGate;
import me.ogruendel.ziegenproblem.PlayerKeepGate;
import me.ogruendel.ziegenproblem.R;

public class MainActivity extends AppCompatActivity {

    private class PlayerOnClickListener implements View.OnClickListener {

        private final EditText etGames;
        private final EditText etGates;
        private final AbstractPlayer player;

        private PlayerOnClickListener(EditText etGames, EditText etGates, AbstractPlayer player) {
            this.etGames = etGames;
            this.etGates = etGates;
            this.player = player;
        }

        @Override
        public void onClick(View v) {
            if (!etGames.equals("") && !etGates.equals("")) {
                String gamesS = etGames.getText().toString();
                String gatesS = etGates.getText().toString();

                final int games = Integer.parseInt(gamesS);
                final int gates = Integer.parseInt(gatesS);

                Host host = new Host(gates);
                player.setGates(gates);
                Game game = new Game(gates, host, player);
                int playerWins = 0;
                for (int i = 0; i < games; i++) {
                    if (game.runGame()) {
                        playerWins++;
                    }
                }
                DecimalFormat df = new DecimalFormat("0.0");
                Toast toast = Toast.makeText(getApplicationContext(), "Gewonnen: " + playerWins + "\nGewinn Wahrscheinlichkeit: " + (df.format((playerWins / (double) games) * 100)) + "%", Toast.LENGTH_SHORT);
                toast.show();
            }else{
                Toast toast = Toast.makeText(getApplicationContext(), "Bitte geben sie Tore und Spiele an!", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonKeep = findViewById(R.id.btnKeepGate);
        Button buttonChange = findViewById(R.id.btnChangeGate);

        final EditText etGames = findViewById(R.id.etNumberOfGames);
        final EditText etGates = findViewById(R.id.etNumberOfGates);

        buttonKeep.setOnClickListener(new PlayerOnClickListener(etGames, etGates, new PlayerKeepGate()));
        buttonChange.setOnClickListener(new PlayerOnClickListener(etGames, etGates, new PlayerChangeGate()));
    }
}
