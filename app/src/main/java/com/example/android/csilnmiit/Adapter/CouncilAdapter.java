package com.example.android.csilnmiit.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.android.csilnmiit.Model.Member;
import com.example.android.csilnmiit.R;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by NIMISH GUPTA on 11-Feb-18.
 */

public class CouncilAdapter extends RecyclerView.Adapter<CouncilAdapter.MyViewHolder> {
    final private CouncilAdapter.ListItemClickListener mOnClickListener;
    private Context mContext;


    private ArrayList<Member> albumList;
    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex) throws IOException;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView name;
        public TextView post;
        public ImageView thumbnail;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            post = (TextView) view.findViewById(R.id.post);

            thumbnail = (ImageView) view.findViewById(R.id.coverphoto);
            thumbnail.setOnClickListener(this);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();

        }
    }


    public CouncilAdapter(Context mContext, ArrayList<Member> albumList, CouncilAdapter.ListItemClickListener listener) {
        Log.v("SIZE",albumList.size()+"");
        if (mContext == null) {
            throw new IllegalArgumentException("Context must not be null.");
        }
        if (albumList == null) {
            throw new IllegalArgumentException("List of tasks must not be null.");
        }
        this.mContext = mContext;
        this.albumList = albumList;
        mOnClickListener=listener;
    }

    @Override
    public CouncilAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_council_members, parent, false);

        return new CouncilAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final CouncilAdapter.MyViewHolder holder, int position) {
        Member album = albumList.get(position);
        holder.name.setText(album.getName());
        holder.post.setText(album.getPost());


        Glide.with(mContext).load(album.getImgUrl()).placeholder(R.drawable.bird).dontAnimate().into(holder.thumbnail);

    }
    @Override
    public int getItemCount() {
        return albumList.size();
    }
}
