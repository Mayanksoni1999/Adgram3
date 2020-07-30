package com.xyz.adgram;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class HomeActivity2 extends AppCompatActivity {


    private ListView listView;

    private int propic[]={R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image5,R.drawable.image6,R.drawable.image7,R.drawable.image8,R.drawable.image9,R.drawable.image10};
    private String[] profiles={"mehta_gudiya","nasa","warriors","nike","therock","mahi7781",
            "sachintendulkar","kapilsharma","youtube","marvel"};;
    private ArrayList<String> post;
    private ArrayList<String> followers;
    private ArrayList<String> massege;
    private ArrayList<String> likes;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        post= new ArrayList<String>();
        followers= new ArrayList<String>();
        massege= new ArrayList<String>();
        likes= new ArrayList<String>();

        for(int i=0;i<10;i++){
            post.add(String.valueOf(40*(i+1)));
            followers.add((90*(i+1))+"K");
            massege.add(String.valueOf(100*(i+1)));
            likes.add((50*(i+1))+"K");
        }

        listView=findViewById(R.id.profilesllist);
        MyAdapter myAdapter = new MyAdapter(this,profiles,propic,post,likes,massege,followers);
        listView.setAdapter(myAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.adrmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.item1:
                Intent i = new Intent(HomeActivity2.this,AdRegisterActivity.class);
                startActivity(i);
                break;
            case R.id.item2:
                Toast.makeText(this,"item2",Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    class MyAdapter extends ArrayAdapter<String> {
        Context context;

        private int propic[];
        private String[] profiles;
        private ArrayList<String> post;
        private ArrayList<String> followers;
        private ArrayList<String> massege;
        private ArrayList<String> likes;

        MyAdapter(Context c ,String[] profiles,int[] propic,ArrayList<String> post,ArrayList<String> likes,ArrayList<String> msg,ArrayList<String> folowers ){
            super(c,R.layout.profilerow,R.id.nameid,profiles);
            this.context=c;
            this.post=post;
            this.profiles=profiles;
            this.followers=folowers;
            this.massege=msg;
            this.propic=propic;
            this.likes=likes;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.profilerow,parent,false);
            ImageView imag=row.findViewById(R.id.rowprofimg);
            TextView lk = row.findViewById(R.id.likeid);
            TextView folo = row.findViewById(R.id.foloid);
            TextView msg = row.findViewById(R.id.msgid);
            TextView name = row.findViewById(R.id.nameid);
            TextView pst = row.findViewById(R.id.postid);


            //change
            imag.setImageResource(propic[position]);
            name.setText(profiles[position]);
            lk.setText(likes.get(position));
            msg.setText(massege.get(position));
            pst.setText(post.get(position));
            folo.setText(followers.get(position));


            return row;
        }
    }

}
