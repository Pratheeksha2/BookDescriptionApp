package com.example.recycler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditDet extends AppCompatActivity {
    private EditText e0,e1,e2,e3;
    private bookdetails[] bookdetails;
    private Button update;
    private int position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_det);

        Bundle extra=getIntent().getExtras();
        if(extra!=null)
        {
            bookdetails=(bookdetails[])extra.getSerializable("obj");
            position=extra.getInt("position");
        }

        e0=findViewById(R.id.editText0);
        e1=findViewById(R.id.editText1);
        e2=findViewById(R.id.editText2);
        e3=findViewById(R.id.editText3);
        update=findViewById(R.id.button);

        e0.setText(bookdetails[position].firstName);
        e1.setText(bookdetails[position].lastName);
        e2.setText(bookdetails[position].Genre);
        e3.setText(bookdetails[position].bookName);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookdetails[position].firstName=e0.getText().toString();
                bookdetails[position].lastName=e1.getText().toString();
                bookdetails[position].Genre=e2.getText().toString();
                bookdetails[position].bookName=e3.getText().toString();

                Intent i=new Intent(EditDet.this,profiles.class);
                i.putExtra("obj",bookdetails).putExtra("pos",position);
                startActivity(i);
                finish();


            }
        });
    }
}
