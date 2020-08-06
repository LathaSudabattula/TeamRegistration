package com.svecw.projectregistration;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CustomRecyclerViewHolder extends RecyclerView.ViewHolder{

    TextView mMsg1;
    ImageView mAvatarView;
    CardView cardView;
    public CustomRecyclerViewHolder(View itemView) {
        super(itemView);
        mMsg1 = (TextView)itemView.findViewById(R.id.text_view1);

        mAvatarView = (ImageView)itemView.findViewById(R.id.avatar_holder);


        cardView = (CardView)itemView.findViewById(R.id.card_holder);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}