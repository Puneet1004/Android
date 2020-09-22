package com.example.mylibrary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {
    private static final String TAG = "BookActivity";
    private TextView bookName, authorName , bookDescription,pageNumber;
    private ImageView bookImage;
    private Button btnCurReading , btnWantToRead,btnAlreadyRead;
    private Book incomingBook;
    private Util util = new Util();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        overridePendingTransition(R.anim.in,R.anim.out);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initWidgets();
        Intent intent =  getIntent();
        int id = intent.getIntExtra("bookId",0);
        ArrayList<Book> books = util.getAllBooks();
        for(Book b: books){
            if(b.getId() == id){
                incomingBook = b;
                bookName.setText(b.getName());
                authorName.setText(b.getAuthor());
                bookDescription.setText(b.getDescription());
                String pages = "Pages -> "+b.getPages();
                pageNumber.setText(pages);
                Glide.with(this)
                        .asBitmap()
                        .load(b.getImageUrl())
                        .into(bookImage);

            }
        }
        btnCurReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnCurReadingTapped();
            }
        });
        btnAlreadyRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnAlreadyReadTapped();
            }
        });
        btnWantToRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnWantToReadTapped();
            }
        });
    }

    private void btnWantToReadTapped(){
        Log.d(TAG, "btnWantToReadTapped: Started");

        ArrayList<Book> wantToBooks = util.getWantToReadBooks();

        if(wantToBooks.contains(incomingBook)){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("You already added This book to your Want To Read list");
            builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            builder.setCancelable(false);
            builder.create().show();
        }
        else {
            ArrayList<Book> alreadyReadBooks = util.getAlreadyReadBooks();
            if(alreadyReadBooks.contains(incomingBook)){
                AlertDialog.Builder builder =new AlertDialog.Builder(this);
                builder.setMessage("You already read this book");
                builder.setTitle("Error");
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.create().show();
            }else{
                ArrayList<Book> currentlyReadingBook = util.getCurrentlyReadingBooks();
                if(currentlyReadingBook.contains(incomingBook)){
                    AlertDialog.Builder builder =new AlertDialog.Builder(this);
                    builder.setMessage("You are Currently reading this book");
                    builder.setTitle("Error");
                    builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    builder.create().show();
                }
                else{
                    util.addWantToReadBook(incomingBook);
                    Toast.makeText(this,"The Book "+ incomingBook.getName()+" added to your Want To Read Shelf.",Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    private void btnCurReadingTapped(){
        Log.d(TAG, "btnCurReadingTapped: started");
        ArrayList<Book> currentlyReadingBooks = util.getCurrentlyReadingBooks();

        if(currentlyReadingBooks.contains(incomingBook)){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("You already added This book to your currently reading list");
            builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            builder.setCancelable(false);
            builder.create().show();
        }
        else {
            ArrayList<Book> alreadyReadBook = util.getAlreadyReadBooks();
            if(alreadyReadBook.contains(incomingBook)){
                AlertDialog.Builder builder =new AlertDialog.Builder(this);
                builder.setMessage("You have already read this book!!! \n Are you reading it again ?");
                builder.setTitle("!!??");
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        util.removeAlreadyReadBook(incomingBook);
                        util.addCurrentlyReadingBook(incomingBook);
                        Toast.makeText(BookActivity.this,"The Book "+ incomingBook.getName()+" added to your Currently Reading Shelf and removed from Already Read book shelf",Toast.LENGTH_LONG).show();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.create().show();
            }else{
                ArrayList<Book> wantToReadBooks = util.getWantToReadBooks();
                if(wantToReadBooks.contains(incomingBook)){
                    util.removeWantToReadBook(incomingBook);
                    util.addCurrentlyReadingBook(incomingBook);
                    Toast.makeText(this,"The Book "+ incomingBook.getName()+" added to your Currently Reading Shelf and removed from Want To Read book shelf",Toast.LENGTH_LONG).show();
                }
                else{
                    util.addCurrentlyReadingBook(incomingBook);
                    Toast.makeText(this,"The Book "+ incomingBook.getName()+" added to your Currently Reading Shelf.",Toast.LENGTH_LONG).show();
                }
            }
        }
    }
    private void btnAlreadyReadTapped(){
        Log.d(TAG, "btnAlreadyReadTapped: started");
        ArrayList<Book> alreadyReadBooks = util.getAlreadyReadBooks();
        if(alreadyReadBooks.contains(incomingBook)){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("You already added This book to your Already Read list");
            builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            builder.setCancelable(false);
            builder.create().show();
        }
        else {
            ArrayList<Book> wantToReadBook = util.getWantToReadBooks();
            if(wantToReadBook.contains(incomingBook)){
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Have You Finished Already?");
                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        util.removeWantToReadBook(incomingBook);
                        util.addAlreadyReadBook(incomingBook);
                        Toast.makeText(BookActivity.this,"The Book "+ incomingBook.getName()+" added to your Already Read Shelf and removed from Want To Read Book shelf.",Toast.LENGTH_LONG).show();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                builder.setCancelable(false);
                builder.create().show();
            }
            else{
                ArrayList<Book> currentlyReadingBook = util.getCurrentlyReadingBooks();
                if(currentlyReadingBook.contains(incomingBook)){
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage("Are You Finish Reading?");
                    builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            util.removeCurrentlyReadingBook(incomingBook);
                            util.addAlreadyReadBook(incomingBook);
                            Toast.makeText(BookActivity.this,"The Book "+ incomingBook.getName()+" added to your Already Read Shelf and removed from Currently Reading Book shelf.",Toast.LENGTH_LONG).show();
                        }
                    });
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    builder.setCancelable(false);
                    builder.create().show();
                }
                else{
                    util.addAlreadyReadBook(incomingBook);
                    Toast.makeText(this,"The Book "+ incomingBook.getName()+" added to your Already Read Shelf.",Toast.LENGTH_LONG).show();
                }
            }
        }
    }
    private void initWidgets() {
        bookName = (TextView) findViewById(R.id.bookName);
        authorName = (TextView) findViewById(R.id.authorName);
        bookDescription = (TextView) findViewById(R.id.bookDescription);
        pageNumber = (TextView)findViewById(R.id.pageNumber);
        bookImage = (ImageView) findViewById(R.id.bookImage);
        btnCurReading = (Button) findViewById(R.id.btnCurReading);
        btnWantToRead = (Button) findViewById(R.id.btnWantToRead);
        btnAlreadyRead = (Button) findViewById(R.id.btnAlreadyRead);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                super.onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.in,R.anim.out);
    }
}
