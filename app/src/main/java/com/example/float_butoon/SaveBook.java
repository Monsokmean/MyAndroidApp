package com.example.float_butoon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class SaveBook extends AppCompatActivity {


    private EditText title, author, page;
    private Button btn_save;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_book);

    title = (EditText) findViewById(R.id.titlebook_editText);
    author = (EditText) findViewById(R.id.bookAuthor_editText);
    page  = (EditText) findViewById(R.id.page_editText);



    btn_save = (Button) findViewById(R.id.btn_save);
    btn_save.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
//            //DBHelper myDB = new DBHelper(SaveBook.this);
//           // myDB.addbook(title.getText().toString().trim(),
//                    author.getText().toString().trim(),
//                    Integer.valueOf(page.getText().toString().trim())
//                    );

        }
    });


    }
}