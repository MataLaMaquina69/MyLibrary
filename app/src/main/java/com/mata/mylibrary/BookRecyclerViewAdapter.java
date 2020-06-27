package com.mata.mylibrary;

import android.content.Context;
import android.content.Intent;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class BookRecyclerViewAdapter extends RecyclerView.Adapter<BookRecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "BookRecyclerViewAdapter";
    private ArrayList<Book> books = new ArrayList<>();
    private Context myContext;

    public BookRecyclerViewAdapter(Context myContext) {
        this.myContext = myContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_book,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBingViewHolder: Called");
        holder.txtBookName.setText(books.get(position).getName());

        Glide.with(myContext).asBitmap()
                .load(books.get(position)
                .getImageUrl())
                .into(holder.imgBook);


        holder.cardParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myContext.startActivity(new Intent(myContext,BookActivity.class));
            }
        });

        holder.txtAuthor.setText(books.get(position).getAuthor());
        holder.txtDescription.setText(books.get(position).getShortDesc());
        if (books.get(position).isExpanded()){
            TransitionManager.beginDelayedTransition(holder.cardParent);
            holder.expandedRelLayout.setVisibility(View.VISIBLE);
            holder.imgArrowDown.setVisibility(View.GONE);
        } else {
            TransitionManager.beginDelayedTransition(holder.cardParent);
            holder.expandedRelLayout.setVisibility(View.GONE);
            holder.imgArrowDown.setVisibility(View.VISIBLE);

        }
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private MaterialCardView cardParent;
        private TextView txtBookName;
        private TextView txtAuthor;
        private TextView txtDescription;

        private ImageView imgBook;
        private ImageView imgArrowDown;
        private ImageView imgArrowUp;

        private RelativeLayout expandedRelLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardParent = itemView.findViewById(R.id.itemBook);
            imgBook = itemView.findViewById(R.id.imgBook);
            txtBookName = itemView.findViewById(R.id.txt1);

            txtAuthor = itemView.findViewById(R.id.txtAuthorText);
            txtDescription = itemView.findViewById(R.id.txtShortDescription);

            imgArrowDown  = itemView.findViewById(R.id.btnDownArrow);
            imgArrowUp = itemView.findViewById(R.id.btnUpArrow);
            expandedRelLayout = itemView.findViewById(R.id.expandedRelativeLayout);

            imgArrowDown.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                     Book book = books.get(getAdapterPosition());
                     book.setExpanded(!book.isExpanded());
                     notifyItemChanged(getAdapterPosition());
                }
            });

            imgArrowUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Book book = books.get(getAdapterPosition());
                    book.setExpanded(!book.isExpanded());
                    notifyItemChanged(getAdapterPosition());

                }
            });

        }
    }
}
