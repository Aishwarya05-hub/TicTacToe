package co.in.nextgencoder.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class StartActivity extends AppCompatActivity {

    private TextInputEditText player1NameET, player2NameET;
    private RadioButton sideOneRB, sideTwoRB;
    private Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        player1NameET = findViewById( R.id.player1Name);
        player2NameET = findViewById( R.id.player2Name);
        sideOneRB = findViewById( R.id.oneSide);
        sideTwoRB = findViewById( R.id.twoSide);

        startButton = findViewById( R.id.startBtn);

        startButton.setOnClickListener(this::startGame);
    }

    private void startGame( View view) {
        String player1Name = player1NameET.getText().toString().trim();
        String player2Name = player2NameET.getText().toString().trim();
        
        if( player1Name.equals( "") || player2Name.equals( "")) {
            Toast.makeText(this, "Please enter name to continue", Toast.LENGTH_SHORT).show();
        } else {
            if( sideOneRB.isChecked()) {

                Intent intent = new Intent( this, OneSidedActivity.class);
                intent.putExtra( "player1Name", player1Name);
                intent.putExtra( "player2Name", player2Name);
                startActivity( intent);

            } else {

                Intent intent = new Intent( this, TwoSidedActivity.class);
                intent.putExtra( "player1Name", player1Name);
                intent.putExtra( "player2Name", player2Name);
                startActivity( intent);

            }
        }
    }
}


















