package com.example.game;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class WinDialog extends Dialog {
    private  final String message;
    private  final MainActivity3 mainActivity3;
    public WinDialog(@NonNull Context context, String message, MainActivity3 mainActivity3) {
        super(context);
        this.message = message;
        this.mainActivity3 = mainActivity3;
    }
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.win_dialog_layout);
        final TextView textmessage = findViewById(R.id.textmessage);
        final Button Startgamebtn = findViewById(R.id.Startgamebtn);
        textmessage.setText(message);
        Startgamebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity3.restartMatch();
                dismiss();

            }
        });
    }
}
