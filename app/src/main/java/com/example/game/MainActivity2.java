package com.example.game;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
private EditText Playerone,Playertwo;
private Button  Gamestart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        Playerone = findViewById(R.id.Playerone);
        Playertwo = findViewById(R.id.playertwo);
        Gamestart =findViewById(R.id.Gamestart);
        Gamestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String GetPlayerOneName = Playerone.getText().toString();
                final String GetPlayerTwoName = Playertwo.getText().toString();
                Log.i("MainActivity2", "PlayerOneName: " + GetPlayerOneName);
                Log.i("MainActivity2", "PlayerTwoName: " + GetPlayerTwoName);
                if(GetPlayerOneName.isEmpty() || GetPlayerTwoName.isEmpty()){
                    Toast.makeText(MainActivity2.this, "Please Enter Players Name", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(MainActivity2.this,MainActivity3.class);
                    intent.putExtra("PlayerOneName",GetPlayerOneName);
                    intent.putExtra("PlayerTwoName",GetPlayerTwoName);
                    startActivity(intent);
                }
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}