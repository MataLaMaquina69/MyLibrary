package com.mata.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.function.ToDoubleBiFunction;

public class BookActivity extends AppCompatActivity {
    private TextView txtBookName;
    private TextView txtAuthor;
    private TextView txtPages;
    private TextView txtLongDescription;

    private Button btnAddToWantToRead;
    private Button btnAddToAlreadyRead;
    private Button btnAddToCurrentlyReading;
    private Button btnAddToFavourite;

    private ImageView imgBook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        initViews();

        //TODO: Get the data from recycler view in here
        Book book = new Book(1,"Me before you", "Jojo mo",230,"https://www.sanborns.com.mx/imagenes-sanborns-ii/1200/602547920089.jpg",
                "This is a very worthy movie to watch","Long");

        setData(book);


    }
    private void setData(Book book){
        txtBookName.setText(book.getName());
        txtAuthor.setText(book.getAuthor());
        txtPages.setText(String.valueOf(book.getPages())) ;
        txtLongDescription.setText(book.getLongDesc());
        Glide.with(this)
                .asBitmap()
                .load(book.getImageUrl())
                .into(imgBook);



    }

    private void initViews(){
        txtBookName = findViewById(R.id.txtBookName);
        txtAuthor = findViewById(R.id.txtAuthor);
        txtPages  = findViewById(R.id.txtPages);
        txtLongDescription  = findViewById(R.id.txtLongDescription);

        btnAddToWantToRead  = findViewById(R.id.btnAddToWantToRead);
        btnAddToAlreadyRead  = findViewById(R.id.btnAddToAlreadyRead);
        btnAddToCurrentlyReading  = findViewById(R.id.btnAddCurrentlyReading);
        btnAddToFavourite  = findViewById(R.id.btnAddToFavourites);

        imgBook  = findViewById(R.id.imgCurrentlyBook);
    }
}
