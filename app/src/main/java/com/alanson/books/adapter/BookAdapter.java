package com.alanson.books.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alanson.books.Model.Books;
import com.alanson.books.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {
    List<Books> booksList;
    BookCallBack callback;

    public BookAdapter(List<Books> booksList , BookCallBack callback) {
        this.booksList = booksList;
        this.callback = callback ;
    }
    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_book,parent,false);

        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        //load book image using Glide
        Glide.with(holder.itemView.getContext())
                .load(booksList.get(position).getDrawableResource()) // set the img book Url
                .transforms(new CenterCrop(),new RoundedCorners(20)) // i know it's deprecated i will fix it later
                .into(holder.imgBook); // destination path

        holder.title.setText(booksList.get(position).getTitle());
        holder.author.setText(booksList.get(position).getAuthor());
        holder.ratingBar.setRating((float) 4.5);
    }

    @Override
    public int getItemCount() {
        return booksList.size();
    }

    public class BookViewHolder extends RecyclerView.ViewHolder {
        ImageView imgBook,imgContainer;
        TextView title,author,pages,rate;
        RatingBar ratingBar;
        public BookViewHolder(@NonNull View itemView) {
            super(itemView);

            imgBook = itemView.findViewById(R.id.item_book_img);
            imgContainer = itemView.findViewById(R.id.container);
            title = itemView.findViewById(R.id.item_book_title);
            author = itemView.findViewById(R.id.item_book_author);
            pages = itemView.findViewById(R.id.item_book_pagesrev);
            rate = itemView.findViewById(R.id.item_book_score);
            ratingBar = itemView.findViewById(R.id.item_book_ratingbar);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callback.onBookItemClick(getAdapterPosition(),
                            imgContainer,
                            imgBook,
                            title,
                            author,
                            pages,
                            rate,
                            ratingBar);
                }
            });
        }
    }
}
