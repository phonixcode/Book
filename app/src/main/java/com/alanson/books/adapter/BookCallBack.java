package com.alanson.books.adapter;

import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public interface BookCallBack {
    void onBookItemClick(int pos,
                         ImageView imgContainer,
                         ImageView imgBook,
                         TextView title,
                         TextView authorName,
                         TextView nbpages,
                         TextView score,
                         RatingBar ratingBar);
}
