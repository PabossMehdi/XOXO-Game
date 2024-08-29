package com.example.game;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {
private final List<int[]> combinationsList = new ArrayList<>();
private static int[] boxPositions = {0,0,0,0,0,0,0,0,0};
private static int PlayerTurn = 1;
private static int totalSelectboxes = 1;
private LinearLayout PlayerOneLayout,PlayerTwoLayout;
private TextView Player1, Player2;
private static ImageView image1;
    private static ImageView image2;
    private static ImageView image3;
    private static ImageView image4;
    private static ImageView image5;
    private static ImageView image6;
    private static ImageView image7;
    private static ImageView image8;
    private static ImageView image9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        Player1 = findViewById(R.id.Player1);
        Player2 = findViewById(R.id.Player2);

        PlayerOneLayout = findViewById(R.id.PlayerOneLayout);
        PlayerTwoLayout = findViewById(R.id.PlayerTwoLayout);

        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);
        image5 = findViewById(R.id.image5);
        image6 = findViewById(R.id.image6);
        image7 = findViewById(R.id.image7);
        image8 = findViewById(R.id.image8);
        image9 = findViewById(R.id.image9);
        combinationsList.add(new int[]{0, 1, 2});
        combinationsList.add(new int[]{3 ,4, 5});
        combinationsList.add(new int[]{6 ,7, 8});
        combinationsList.add(new int[]{0 ,3, 6});
        combinationsList.add(new int[]{1 ,4, 7});
        combinationsList.add(new int[]{2 ,5, 8});
        combinationsList.add(new int[]{0 ,4, 8});
        combinationsList.add(new int[]{2 ,4, 6});

        final String getPlayerOneName = getIntent().getStringExtra("PlayerOneName");
        final String getPlayerTwoName = getIntent().getStringExtra("PlayerTwoName");
        Player1.setText(getPlayerOneName);
        Player2.setText(getPlayerTwoName);
        
        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(isboxselectable(0)){
                   performAction((ImageView)view,0);
               }
            }
        });
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isboxselectable(1)){
                    performAction((ImageView)view,1);
                }
            }
        });
        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isboxselectable(2)){
                    performAction((ImageView)view,2);
                }
            }
        });
        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isboxselectable(3)){
                    performAction((ImageView)view,3);
                }
            }
        });
        image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isboxselectable(4)){
                    performAction((ImageView)view,4);
                }
            }
        });
        image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isboxselectable(5)){
                    performAction((ImageView)view,5);
                }
            }
        });
        image7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isboxselectable(6)){
                    performAction((ImageView)view,6);
                }
            }
        });
        image8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isboxselectable(7)){
                    performAction((ImageView)view,7);
                }
            }
        });
        image9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isboxselectable(8)){
                    performAction((ImageView)view,8);
                }
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void performAction(ImageView imageView, int Selectedboxpositions){
        boxPositions[Selectedboxpositions] = PlayerTurn;
        if(PlayerTurn == 1){
            imageView.setImageResource(R.drawable.cross);
            if(checkPlayerWin()){

                WinDialog  winDialog = new WinDialog (MainActivity3.this, Player1.getText().toString()+" has Won the match",MainActivity3.this);
                winDialog.setCancelable(false);
                winDialog.show();
            } else if (totalSelectboxes == 9) {
                WinDialog  winDialog = new WinDialog (MainActivity3.this, "Game Draw",MainActivity3.this);
                winDialog.setCancelable(false);
                winDialog.show();
            }
            else {
                changePlayerTurn(2);
                totalSelectboxes++;
            }
        }
        else {
            imageView.setImageResource(R.drawable.tick);

            if(checkPlayerWin()){
                WinDialog  winDialog = new WinDialog (MainActivity3.this, Player2.getText().toString()+" has Won the match",MainActivity3.this);
                winDialog.setCancelable(false);
                winDialog.show();
            }
            else if(totalSelectboxes == 9){
                WinDialog  winDialog = new WinDialog (MainActivity3.this, "Game Draw",MainActivity3.this);
                winDialog.setCancelable(false);
                winDialog.show();
            }
            else {
                changePlayerTurn(1);
                totalSelectboxes++;
            }


        }
    }

    private void changePlayerTurn(int currentPlayerTurn){
        PlayerTurn = currentPlayerTurn;
        if(PlayerTurn == 1){
            PlayerOneLayout.setBackgroundResource(R.drawable.douted_line);
            PlayerTwoLayout.setBackgroundResource(R.drawable.back_dark_blue);
        }
        else {
            PlayerOneLayout.setBackgroundResource(R.drawable.back_dark_blue);
            PlayerTwoLayout.setBackgroundResource(R.drawable.douted_line);

        }
    }
    private boolean checkPlayerWin(){
        boolean responce = false;
        for(int i=0;i<combinationsList.size();i++){
            final int [] combination = combinationsList.get(i);
            if(boxPositions[combination[0]] == PlayerTurn && boxPositions[combination[1]] == PlayerTurn && boxPositions[combination[2]]==PlayerTurn){
                responce = true;

            }
        }
    return  responce;
    }

    protected boolean isboxselectable(int boxPosition){

        boolean responce = false;

        if(boxPositions[boxPosition] == 0){
            responce = true;
        }
        return responce;
    }
    public static void restartMatch(){
        boxPositions = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        PlayerTurn =1;

        totalSelectboxes = 1;
        image1.setImageResource(R.drawable.th);
        image2.setImageResource(R.drawable.th);
        image3.setImageResource(R.drawable.th);
        image4.setImageResource(R.drawable.th);
        image5.setImageResource(R.drawable.th);
        image6.setImageResource(R.drawable.th);
        image7.setImageResource(R.drawable.th);
        image8.setImageResource(R.drawable.th);
        image9.setImageResource(R.drawable.th);
    }

}