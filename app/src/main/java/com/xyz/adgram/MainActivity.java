package com.xyz.adgram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button inf;
    private Button adv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        inf=findViewById(R.id.infubtn);
        inf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //influencer
                Intent i = new Intent(MainActivity.this,LoginAcitivity.class);
                startActivity(i);
            }
        });

        adv=findViewById(R.id.adverbtn);
        adv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //advertiser
                Intent i = new Intent(MainActivity.this,HomeActivity2.class);
                startActivity(i);
            }
        });



    }
}
