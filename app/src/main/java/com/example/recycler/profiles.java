package com.example.recycler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class profiles extends AppCompatActivity {
    bookdetails[] bookdetails,bookdetails2;
    int position;
    private TextView fname,lname,genre,bookname;
    ImageView profileimage;
     Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profiles);

        Bundle extra=getIntent().getExtras();

        if(extra!=null)
        {
            bookdetails=(bookdetails[])extra.getSerializable("obj");
            position=extra.getInt("pos");
        }

        fname=findViewById(R.id.real_name);
        lname=findViewById(R.id.textView);
        genre=findViewById(R.id.tv_realgenre);
        bookname=findViewById(R.id.tv_realbookname);
        profileimage=findViewById(R.id.iv_profile);
        back=findViewById(R.id.back);

        fname.setText(bookdetails[position].firstName);
        lname.setText(bookdetails[position].lastName);
        genre.setText(bookdetails[position].Genre);
        bookname.setText(bookdetails[position].bookName);
        int resID=getResources().getIdentifier(bookdetails[position].imageName,"mipmap",getPackageName());
        profileimage.setImageBitmap(BitmapFactory.decodeResource(getResources(),resID));

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(profiles.this,book.class);
                i.putExtra("obj",bookdetails);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);  //to clear simply written details in frofiles page
                i.putExtra("EXIT",true);
                startActivity(i);
                finish();

            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.editdetails,menu);  //to create the editdetails 3 dots
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId()==R.id.ed)
        {
            Intent i=new Intent(profiles.this,EditDet.class);
            i.putExtra("obj",bookdetails).putExtra("position",position); //go to next page after clicking editdetails
            startActivity(i);
            finish();
        }
        return super.onOptionsItemSelected(item);

    }

}
