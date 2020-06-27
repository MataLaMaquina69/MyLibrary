package com.mata.mylibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class AllBookActivity extends AppCompatActivity {
    private RecyclerView bookReView;
    private BookRecyclerViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_book);

        bookReView = findViewById(R.id.booksRecyclerView);
        adapter = new BookRecyclerViewAdapter(this);

        bookReView.setAdapter(adapter);
        bookReView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book(1,"Me before you", "Jojo mo",230,"https://www.sanborns.com.mx/imagenes-sanborns-ii/1200/602547920089.jpg",
                "This is a very worthy movie to watch","Long"));
        books.add(new Book(2,"La mecanica del corazón", "Alguien",222,"https://kbimages1-a.akamaihd.net/10274baa-539b-47fc-aa7a-6293212d04c1/353/569/90/False/la-mecanica-del-corazon-1.jpg",
                "This is a very worthy movie to watch","Long"));

        adapter.setBooks(books);


    }
}
