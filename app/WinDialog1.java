import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import com.example.game.R;

public class WinDialog1 extends Dialog1 {
    private  final String message;
    private  final MainActivity3 mainActivity3;
    public WinDialog(Context context, String message, MainActivity3 mainActivity3) {
        super(context);
        this.message = message;
        this.mainActivity3 = mainActivity3;
    }
    @Override
    protected void onCrete(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.win_dialog_layout);
        final TextView textmessage = findViewById(R.id.textmessage);
        final Button Startgamebtn = findViewById(R.id.Startgamebtn);
        textmessage.setText(message);
        Startgamebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
