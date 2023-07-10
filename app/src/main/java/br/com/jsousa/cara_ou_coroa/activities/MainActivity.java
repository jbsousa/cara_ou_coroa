package br.com.jsousa.cara_ou_coroa.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import br.com.jsousa.cara_ou_coroa.R;

public class MainActivity extends AppCompatActivity {

    private Button buttonPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttonPlay = findViewById(R.id.buttonPlay);


        buttonPlay.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
            startActivity(intent);
        });

    }
}