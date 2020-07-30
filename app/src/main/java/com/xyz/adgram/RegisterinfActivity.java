package com.xyz.adgram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.xyz.adgram.DataModel.Authetication;
import com.xyz.adgram.DataModel.MyAppDatabase;

public class RegisterinfActivity extends AppCompatActivity {

    private Button signupbnt;
    private EditText pid;
    private EditText pass;

    private Authetication tempauthetication;
    private Authetication authetication;

    public static MyAppDatabase myAppdatabase;


    Thread t2= new Thread(new Runnable() {
        @Override
        public void run() {
            myAppdatabase.myDao2().addUser(tempauthetication);
        }
    });


    protected void onCreate(Bundle savedInstanceState) {
        this.myAppdatabase=LoginAcitivity.myAppdatabase;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerinf);

        pid=(EditText)findViewById(R.id.editid);
        pass=(EditText)findViewById(R.id.editpass);
        signupbnt=(Button)findViewById(R.id.register);
        signupbnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sid = pid.getText().toString();
                String sps = pass.getText().toString();

                authetication = new Authetication();
                authetication.setId(sid);
                authetication.setPass(sps);

                tempauthetication=authetication;
                t2.start();
                onBackPressed();
            }
        });

    }


}
