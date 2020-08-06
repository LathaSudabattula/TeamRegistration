package com.svecw.projectregistration;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomRecyclerViewHolder>{

    List<String> mItems;

    private  ClickListener clicklistener = null;

    Context mContext;

    public CustomAdapter(Context context, List<String> items){
        mContext = context;
        mItems = items;
    }

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
                    if(clicklistener !=null){
                        clicklistener.itemClicked(view,getAdapterPosition());
                    }
                }
            });
        }
    }
    public void setClickListener(ClickListener clickListener){
        this.clicklistener = clickListener;
    }
    public CustomRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(mContext)
                .inflate(R.layout.custom_recyclerview_layout, parent, false);
        //set the margin if any, will be discussed in next blog
        return new CustomRecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final CustomRecyclerViewHolder holder, final int position) {
        holder.mAvatarView.setImageResource(R.drawable.images);
        holder.mMsg1.setText(mItems.get(position).toString());

        Log.v("p", mItems.get(position));




    }
    @Override
    public int getItemCount() {
        return mItems.size();
    }
}