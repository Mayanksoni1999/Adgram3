package com.xyz.adgram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Insert;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.xyz.adgram.DataModel.Authetication;
import com.xyz.adgram.DataModel.MyAppDatabase;

import java.util.List;
import java.util.Timer;

public class LoginAcitivity extends AppCompatActivity {

    private String tempid;
    private String tempps;
    private Button insta;
    private Button idpas;
    private Button signupbtn;
    private Authetication authetication;
    private Authetication tempauthetication;

    public static MyAppDatabase myAppdatabase;


    Thread t2= new Thread(new Runnable() {
        @Override
        public void run() {
            myAppdatabase.myDao2().addUser(tempauthetication);
        }
    });

    Thread t = new Thread(new Runnable() {
        @Override
        public void run() {
            List<Authetication> users=null;
            users=myAppdatabase.myDao2().check(tempid);
            int f=0;
            if(users.equals(null) || users==null || users.isEmpty()){
                f=1;
            }

            autheticaterespos(f);
        }
    });


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        myAppdatabase= Room.databaseBuilder(getApplicationContext(),MyAppDatabase.class,"UserDb").build();
    }

    @Override
    protected void onResume() {
        super.onResume();
        insta=findViewById(R.id.instabtnid);
        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //instagram login
                Toast.makeText(LoginAcitivity.this,"Unable to Login now",Toast.LENGTH_SHORT).show();
            }
        });

        idpas=findViewById(R.id.lginbtn);
        idpas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView id = findViewById(R.id.idtvid);
                TextView ps = findViewById(R.id.pstvid);
                String sid = id.getText().toString();
                String sps = ps.getText().toString();
                if(sid.equals("abc") && sps.equals("1234")){
                    Intent i = new Intent(LoginAcitivity.this,HomeActivity.class);
                    startActivity(i);
                }
                else{
                    tempid=sid;
                    tempps=sps;
                    t.start();

                }

            }
        });

        signupbtn=findViewById(R.id.signupbtnid);
        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginAcitivity.this,RegisterinfActivity.class);
                startActivity(i);
            }
        });


    }


    public void autheticaterespos(int f){
        if(f==1){
            View parentLayout = findViewById(android.R.id.content);
            Snackbar.make(parentLayout,"Invalid id or password!",Snackbar.LENGTH_SHORT).show();
            return;
        }
        else{
            Intent i = new Intent(LoginAcitivity.this,HomeActivity.class);
            startActivity(i);
        }
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
