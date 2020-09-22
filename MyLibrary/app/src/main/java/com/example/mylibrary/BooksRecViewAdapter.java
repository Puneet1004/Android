package com.example.mylibrary;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import java.util.ArrayList;

public class BooksRecViewAdapter extends RecyclerView.Adapter<BooksRecViewAdapter.ViewHolder>{
    private static final String TAG = "BooksRecViewAdapter";

    private ArrayList<Book> books = new ArrayList<>();
    private Context context;
    private Util util;
    private String type = "";

    BooksRecViewAdapter(Context context) {
        this.context = context;
        util = new Util();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_book_rec_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called");
        holder.bookName.setText(books.get(position).getName());
        holder.bookCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, BookActivity.class);
                intent.putExtra("bookId",books.get(position).getId());
                context.startActivity(intent);
                /*Toast.makeText(context, books.get(position).getName() + " Selected", Toast.LENGTH_SHORT).show();*/
            }
        });
        holder.bookCard.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                final Book book = books.get(position);
                AlertDialog.Builder builder = new AlertDialog.Builder(context)
                        .setTitle("Deleting "+book.getName())
                        .setMessage("Are you sure to delete "+book.getName()+" ?")
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                switch (type){
                    case "Currently Reading":
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                util.removeCurrentlyReadingBook(book);
                                notifyDataSetChanged();
                                Toast.makeText(context, book.getName()+" is Removed Successfully", Toast.LENGTH_SHORT).show();
                            }
                        }).create().show();
                        break;
                    case "Already Read":
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                util.removeAlreadyReadBook(book);
                                notifyDataSetChanged();
                                Toast.makeText(context, book.getName()+" is Removed Successfully", Toast.LENGTH_SHORT).show();
                            }
                        }).create().show();
                        break;
                    case "Want To Read":
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                util.removeWantToReadBook(book);
                                notifyDataSetChanged();
                                Toast.makeText(context, book.getName()+" is Removed Successfully", Toast.LENGTH_SHORT).show();
                            }
                        }).create().show();
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
        Glide.with(context)
                .asBitmap()
                .load(books.get(position).getImageUrl())
                .into(holder.bookImage);
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private CardView bookCard;
        private ImageView bookImage;
        private TextView bookName;

        private ViewHolder(View itemView) {
            super(itemView);
            bookImage = (ImageView) itemView.findViewById(R.id.bookImage);
            bookName = (TextView) itemView.findViewById(R.id.bookName);
            bookCard = (CardView) itemView.findViewById(R.id.bookCard);
        }
    }
        void setBooks(ArrayList<Book> books){
            this.books =books;
            notifyDataSetChanged();
        }

    public void setType(String type) {
        this.type = type;
    }
}