package com.alanson.books;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.alanson.books.Model.Books;
import com.alanson.books.adapter.BookAdapter;
import com.alanson.books.adapter.BookCallBack;
import com.alanson.books.adapter.CustomItemAnimator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BookCallBack {
    //variable
    private RecyclerView rvBooks;
    private BookAdapter bookAdapter;
    private List<Books> booksList ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //methods
        initViews();
        initBooksListBooks();
        setupBookAdapter();
    }

    private void setupBookAdapter() {

        bookAdapter = new BookAdapter(booksList,this);
        rvBooks.setAdapter(bookAdapter);

    }

    private void initBooksListBooks() {

        booksList = new ArrayList<>();

        booksList.add(new Books("Agile","By Aptech",R.drawable.b1));
        booksList.add(new Books("Android Application\nDevelopment","By Aptech",R.drawable.b2));
        booksList.add(new Books("Android Application Testing","By Aptech",R.drawable.b3));
        booksList.add(new Books("Android Apprentice 3rd edition\nBeginning Android Development\n with Kotlin","By Darryl Bayliss,Namrata Bandekar, \nTom Blankenship,Fuad Kamal",R.drawable.b4));
        booksList.add(new Books("Android Programming \nThe Big Nerd Ranch Guide ","By Bill Phillips, Chris Stewart, \nKristin Marsicano",R.drawable.b5));
        booksList.add(new Books("Developing Application Using \nJava Web Framework","By Aptech",R.drawable.b6));
        booksList.add(new Books("Elementary Programming \nwith C","By Aptech",R.drawable.b7));
        booksList.add(new Books("eProject-Java \nProgrammer Guide","By Aptech",R.drawable.b8));
        booksList.add(new Books("eProject Guide-HTML5","By Aptech",R.drawable.b9));
        booksList.add(new Books("eProject Guide-Building App \nfor Android Device","By Aptech",R.drawable.b10));
        booksList.add(new Books("Essentials of Red Hat L\ninux","By Aptech",R.drawable.b11));
        booksList.add(new Books("Fundamentals Programming \nin Java ","By Aptech",R.drawable.b12));
        booksList.add(new Books("Fundamentals of Java \nEnterprise Components","By Aptech",R.drawable.b13));
        booksList.add(new Books("HTML5-NexTGen \nWeb - INTL","By Aptech",R.drawable.b14));
        booksList.add(new Books("Kotlin Programming \nThe Big Nerd Ranch Guide","By Josh Skeen, David Greenhalgh",R.drawable.b15));
        booksList.add(new Books("Modern Markup for\nData Interchange","By Aptech",R.drawable.b16));
        booksList.add(new Books("Object-Oriented \nProgramming Concepts","By Aptech",R.drawable.b17));
        booksList.add(new Books("Object-Oriented \nProgramming With C++","By Aptech",R.drawable.b18));
        booksList.add(new Books("Online Advertising \nUsing Google AdWords","By Aptech",R.drawable.b19));
        booksList.add(new Books("Professional Programming \nin Java","By Aptech",R.drawable.b20));
        booksList.add(new Books("Programming Practices \nand Techniques","By Aptech",R.drawable.b21));
        booksList.add(new Books("SEO Made Easy","By Aptech",R.drawable.b22));
        booksList.add(new Books("SQL Server Inside Out","By Aptech",R.drawable.b23));
        booksList.add(new Books("Web Component Development \nUsing Java","By Aptech",R.drawable.b24));
        booksList.add(new Books("A Guide to Web \nProductivity Tools","By Aptech",R.drawable.b25));
        booksList.add(new Books("UI and UX \nfor Responsive Web Design-IT","By Aptech",R.drawable.b26));
    }

    private void initViews() {
        rvBooks = findViewById(R.id.rv_book);
        rvBooks.setLayoutManager(new LinearLayoutManager(this));
        rvBooks.setHasFixedSize(true);

        // we need first to setupe the custom item animator that we just create
        rvBooks.setItemAnimator(new CustomItemAnimator());
    }


    @Override
    public void onBookItemClick(int pos, ImageView imgContainer,
                                ImageView imgBook, TextView title,
                                TextView authorName, TextView nbpages,
                                TextView score, RatingBar ratingBar) {


        // create intent and send book object to Details activity

        Intent intent = new Intent(this,BookDetails.class);
        intent.putExtra("bookObject",booksList.get(pos));

        // shared Animation setup
        // let's import the Pair class
        Pair<View,String> p1 = Pair.create((View)imgContainer,"containerTN"); // second arg is the tansition string Name
        Pair<View,String> p2 = Pair.create((View)imgBook,"bookTN"); // second arg is the tansition string Name
        Pair<View,String> p3 = Pair.create((View)title,"booktitleTN"); // second arg is the tansition string Name
        Pair<View,String> p4 = Pair.create((View)authorName,"authorTN"); // second arg is the tansition string Name
        Pair<View,String> p5 = Pair.create((View)nbpages,"bookpagesTN"); // second arg is the tansition string Name
        Pair<View,String> p6 = Pair.create((View)score,"scoreTN"); // second arg is the tansition string Name
        Pair<View,String> p7 = Pair.create((View)ratingBar,"rateTN"); // second arg is the tansition string Name


        ActivityOptionsCompat optionsCompat =
                ActivityOptionsCompat.makeSceneTransitionAnimation(this,p1,p2,p3,p4,p5,p6,p7);


        // start the activity with scene transition

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            startActivity(intent,optionsCompat.toBundle());
        }
        else
            startActivity(intent);


    }
}