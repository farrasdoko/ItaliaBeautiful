package com.gmail.farasabiyyu12.italiabeautiful.Recyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gmail.farasabiyyu12.italiabeautiful.R;
import com.gmail.farasabiyyu12.italiabeautiful.ScrollingActivity;
import com.gmail.farasabiyyu12.italiabeautiful.WisataActivity;

import java.util.List;

/**
 *
 * Created by farasabiyyuhandoko on 24/04/18.
 *
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<FarViewHolder> {

    public List<ItemObject> itemLists;
    public Context context;

    public RecyclerViewAdapter(List<ItemObject> itemLists, Context context) {
        this.itemLists = itemLists;
        this.context = context;
    }

    @Override
    public FarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.cardview_list, null);
        return new FarViewHolder(v);
    }

    @Override
    public void onBindViewHolder(FarViewHolder holder, final int position) {
        holder.photo.setImageResource(itemLists.get(position).getPhoto());
        holder.name.setText(itemLists.get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (itemLists.get(position).getName()){
                    case "Negara Italia":
                        context.startActivity(new Intent(context, ScrollingActivity.class)
                                .putExtra("namas", "Negara Italia")
                                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                        break;
                    case "Tempat Wisata":
                        context.startActivity(new Intent(context, WisataActivity.class)
                                .putExtra("namaw", "Tempat Wisata")
                                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                        break;
                    case "Orang Ternama":
                        context.startActivity(new Intent(context, WisataActivity.class)
                                .putExtra("namaw", "Orang Ternama")
                                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                        break;
                    case "Tentang":
                        context.startActivity(new Intent(context, ScrollingActivity.class)
                                .putExtra("namas", "Tentang")
                                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.itemLists.size();
    }
}
