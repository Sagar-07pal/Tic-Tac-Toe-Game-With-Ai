package com.example.gametictactoe;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

    public class MainActivity extends AppCompatActivity implements com.example.tictactoe.MainActivity {
// ALL BUTTONS
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btncurr, btnre;

    String b1, b2, b5, b3, b6, b8, b9, b4, b7;
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
    }
//     WHEN BUTTON IS CLICKED
    public void click(View view) {
        btncurr = (Button) view;  // CURRENT BUTTON REFERENCE
        flag++;

        //Printing the values
        if (btncurr.getText().toString().isEmpty()) {
            if (count == 0) {
                btncurr.setText("X");
                count = 1;
            } else {
                btncurr.setText("O");
                count = 0;
            }
        }
    }

    //    //Ids are found
    public void init() {
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnre = findViewById(R.id.btnre);
    }
}