package com.example.recycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class book extends AppCompatActivity {
RecyclerView recyclerView;
LinearLayoutManager layoutManager;
PeopleAdapter peopleAdapter;
private Button back;

    bookdetails[] details={
            new bookdetails("Catherine","Ankslt","Comedy","Aren't you lucky","arntulucky","arntulucky"),
            new bookdetails("Peter","Melean","Horror","Priest of bones","bones","bones"),
            new bookdetails("Susan","Hill","Horror","Dolly","dollly","dollly"),
            new bookdetails("Joe","King","Comedy","Funny Stories","funnystories","funnystories"),
            new bookdetails("Mary","Downing","Horror","Girl in the locked room","girlinlockedroom","girlinlockedroom"),
            new bookdetails("John","Derilison","Kids","The Gruffalo","grufallo","grufallo"),
            new bookdetails("Ruskin","Bond","Horror","Horror omnibus","horror","horror"),
            new bookdetails("Darcy","Coates","Horror","House Next Door","housenextdoor","housenextdoor"),
            new bookdetails("James","Patterson","Comedy","I am funniest","iamfunniest","iamfunniest"),
            new bookdetails("James","Patterson","Comedy","I funny","ifunny","ifunny"),
            new bookdetails("Kristana","Bella","Comedy","Best Jokes","jokes","jokes"),
            new bookdetails("Brad","Meltzar","Kids","Rosa Parks Kids","rosaparkskids","rosaparkskids"),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),firstpage.class);//recycler is used as in onw recycler v can extract multiple book data automatically
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); //to get data from above mentioned detail sof books
                i.putExtra("EXIT",true);
                startActivity(i);
                finish();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//for edit details 3 dots in action bar
        Bundle extra=getIntent().getExtras();

        if(extra!=null)//object to get book deatails data
        {
            details=(bookdetails[])extra.getSerializable("obj");

        }

        recyclerView=findViewById(R.id.recview);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(recyclerView.getContext(),layoutManager.getOrientation());//for design of the layout
        recyclerView.addItemDecoration(dividerItemDecoration);//decoration is used only wen recycler view is used

        peopleAdapter=new PeopleAdapter(details);
        recyclerView.setAdapter(peopleAdapter);




    }
}
