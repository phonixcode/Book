package com.alanson.books;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.alanson.books.Model.Books;
import com.bumptech.glide.Glide;

import java.util.Objects;

public class BookDetails extends AppCompatActivity {
    //variable
    ImageView imgBook;
    TextView bookTitle, bookAuthor;
    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);

        //ini view
        imgBook = findViewById(R.id.item_book_img);
        ratingBar = findViewById(R.id.item_book_ratingbar);
        bookAuthor = findViewById(R.id.item_book_author);
        bookTitle = findViewById(R.id.item_book_title);

        // we need to get book item object
        Books item = (Books) Objects.requireNonNull(getIntent().getExtras()).getSerializable("bookObject");

        assert item != null;
        loadBookData(item);
    }
    //loading book data
    private void loadBookData(Books item) {
        //ratingBar.setRating(item.getRating());
        bookTitle.setText(item.getTitle());
        bookAuthor.setText(item.getAuthor());

        // bind book data here for now i will only load the book cover image
        Glide.with(this).load(item.getDrawableResource()).into(imgBook);

    }
}