package com.example.root.yiplproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ImageView contrator,complain,forum,aboutus;
    TextView glossary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contrator=(ImageView) findViewById(R.id.contractor);
        complain=(ImageView)findViewById(R.id.complain);
        forum=(ImageView)findViewById(R.id.forum);
        aboutus=(ImageView)findViewById(R.id.aboutus);
        glossary=(TextView)findViewById(R.id.glossary);

        contrator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListofContractor.class);
                intent.putExtra("rumi","rumi");
                startActivity(intent);
            }
        });

        complain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Login.class);
                startActivity(intent);

            }
        });

        forum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ForumActivity.class);
                startActivity(intent);


            }
        });

        aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,AboutUs.class);
                startActivity(intent);

            }
        });
        glossary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Glossary.class);
                startActivity(intent);

            }
        });
    }
}

