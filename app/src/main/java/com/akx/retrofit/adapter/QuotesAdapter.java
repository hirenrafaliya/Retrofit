package com.akx.retrofit.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.akx.retrofit.R;
import com.akx.retrofit.model.Quotes;

import java.util.List;

public class QuotesAdapter extends RecyclerView.Adapter<QuotesAdapter.ViewHolder> {

    List<String> quotesList;

    public QuotesAdapter(List<String> quotesList){
        this.quotesList=quotesList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_quote,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtQuotes.setText(quotesList.get(position));
    }

    @Override
    public int getItemCount() {
        return quotesList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtQuotes;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtQuotes=itemView.findViewById(R.id.txtQuotes);
        }
    }
}
