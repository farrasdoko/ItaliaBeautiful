package com.gmail.farasabiyyu12.italiabeautiful.Recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gmail.farasabiyyu12.italiabeautiful.R;

/**
 *
 * Created by farasabiyyuhandoko on 24/04/18.
 *
 */

class FarViewHolder extends RecyclerView.ViewHolder {

    public TextView name;
    public ImageView photo;

    public FarViewHolder(View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.name);
        photo = itemView.findViewById(R.id.photo);
    }
}
