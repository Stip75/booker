package com.doranco.booker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import static com.doranco.booker.BookAdapter.ID_BOOK_EXTRA;

public class BookDetailActivity extends AppCompatActivity {

    private Book currentBook;
    private ImageView mImageView;
    private TextView titleTextView;
    private TextView pdTextView;
    private TextView isbnTextView;
    private TextView ldTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);
        mImageView = findViewById(R.id.book_item_image);
        titleTextView = findViewById(R.id.book_item_title);
        pdTextView = findViewById(R.id.book_item_pub_date);
        isbnTextView = findViewById(R.id.book_item_isbn);
        ldTextView = findViewById(R.id.book_item_long_description);
        Intent intent = getIntent();
        String isbn = intent.getStringExtra(ID_BOOK_EXTRA);
        if(isbn !=null){
            for(Book book: Utils.feedBooks(this)){
                if(isbn.equals(book.getIsbn())) {
                    currentBook = book;
                    break;
                }

            }
            Uri imageUri = Uri.parse(currentBook.getThumbnailUrl()).buildUpon().build();

            Glide.with(this).load(imageUri).into(mImageView);
            titleTextView.setText(currentBook.getTitle());
            pdTextView.setText(currentBook.getPublishedDate());
            isbnTextView.setText(currentBook.getIsbn());
            ldTextView.setText(currentBook.getLongDescription());

        }
    }
}
