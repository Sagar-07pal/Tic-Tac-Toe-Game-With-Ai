package com.example.gametictactoe;

import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

    public class MainActivity extends AppCompatActivity implements com.example.tictactoe.MainActivity {
// ALL BUTTONS
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btncurr,turn_x,turn_o,play_again,btn_ok;

    String b1, b2, b5, b3, b6, b8, b9, b4, b7;
    TextView winner_text;
    Dialog winning_dialog;
    int flag = 0, count = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
        turn_x.setBackgroundResource(R.drawable.turn_btn);
        play_again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playagain();
            }
       });
    }

//     WHEN BUTTON IS CLICKED
    public void click(View view) {
        btncurr = (Button) view;  // CURRENT BUTTON REFERENCE
        flag++;

        //Printing the values
        if (btncurr.getText().toString().isEmpty()) {
            if (count == 0) {
                btncurr.setText("X");
                turn_o.setBackgroundResource(R.drawable.turn_btn);
                turn_x.setBackgroundResource(R.drawable.turnoff);
                count = 1;
            } else {
                btncurr.setText("O");
                turn_x.setBackgroundResource(R.drawable.turn_btn);
                turn_o.setBackgroundResource(R.drawable.turnoff);
                count = 0;
            }
        }
        if(flag>4){
            value();
//            1
            if (b1.equals(b2) && b2.equals(b3) && !b1.isEmpty() )  {
                dialog_show(b1);
            }
//            2
          else if (b4.equals(b5) && b5.equals(b6) && !b4.isEmpty() )  {
                dialog_show(b4);
            }
//            3
           else if (b7.equals(b8) && b8.equals(b9) && !b7.isEmpty() )  {
                dialog_show(b7);
            }
//            4  DIAGONAL
            else if (b1.equals(b5) && b5.equals(b9) && !b5.isEmpty() )  {
                dialog_show(b5);
            }
//            5 DIAGONAL
            else if (b3.equals(b5) && b5.equals(b7) && !b3.isEmpty() )  {
                dialog_show(b3);
            }
//            6
            else if (b1.equals(b4) && b4.equals(b7) && !b4.isEmpty() )  {
                dialog_show(b1);
            }
//            7
            else if (b2.equals(b5) && b5.equals(b8) && !b8.isEmpty() )  {
                dialog_show(b2);
            }
//            8
            else if (b3.equals(b6) && b6.equals(b9) && !b9.isEmpty() )  {
                dialog_show(b6);
            }
//            9
            else if(flag==9) {
                dialog_show("Draw, play again!!");
            }
        }
    }

        private void value() {
            b1=btn1.getText().toString();
            b2=btn2.getText().toString();
            b3=btn3.getText().toString();
            b4=btn4.getText().toString();
            b5=btn5.getText().toString();
            b6=btn6.getText().toString();
            b7=btn7.getText().toString();
            b8=btn8.getText().toString();
            b9=btn9.getText().toString();
        }

        //    //Ids are found
    private void init() {
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        turn_x=findViewById(R.id.btn_x);
        turn_o=findViewById(R.id.btn_o);
        play_again=findViewById(R.id.btnagain);
    }

    private void dialog_show(String text){
        winning_dialog=new Dialog(this);
        winning_dialog.setContentView(R.layout.winning_dialog_box);
        winning_dialog.setCancelable(false);
        btn_ok=winning_dialog.findViewById(R.id.btn_ok);
        winner_text=winning_dialog.findViewById(R.id.winner);
        winner_text.setText(text);
        winning_dialog.show();
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playagain();
                winning_dialog.dismiss();
            }
        });
    }

        public void playagain(){
            count=0;
            flag=0;
            btn1.setText("");
            btn2.setText("");
            btn3.setText("");
            btn4.setText("");
            btn5.setText("");
            btn6.setText("");
            btn7.setText("");
            btn8.setText("");
            btn9.setText("");
            turn_x.setBackgroundResource(R.drawable.turn_btn);
            turn_o.setBackgroundResource(R.drawable.turnoff);
        }
}