package com.gmail.farasabiyyu12.italiabeautiful.Recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gmail.farasabiyyu12.italiabeautiful.R;

import java.util.List;

/**
 *
 * Created by farasabiyyuhandoko on 24/04/18.
 *
 */

public class CardViewAdapter extends RecyclerView.Adapter<FarViewHolder> {

    public List<ItemObject> itemLists;
    public Context context;

    public CardViewAdapter(List<ItemObject> itemLists, Context context) {
        this.itemLists = itemLists;
        this.context = context;
    }

    @Override
    public FarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View vi = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_real, parent, false);
        FarViewHolder fhb = new FarViewHolder(vi);
        return fhb;
    }

    @Override
    public void onBindViewHolder(FarViewHolder holder, int position) {
        holder.photo.setImageResource(itemLists.get(position).getPhoto());
        holder.name.setText(itemLists.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return this.itemLists.size();
    }
}
