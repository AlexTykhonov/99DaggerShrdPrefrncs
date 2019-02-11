package com.tae.a99daggershrdprefrncs.Network;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tae.a99daggershrdprefrncs.R;

import java.util.ArrayList;
import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder>
{

    private List<Result> posts;
    Context context;
    public PostsAdapter(Context context) {
        this.posts = new ArrayList<Result>();
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Result post = posts.get(position);

            holder.post.setText(post.getHref());
        holder.site.setText(post.getTitle());
//        Glide.with(context)
//                .load(post.getUrlToImage())
//                .into(holder.imageview);

    }

    @Override
    public int getItemCount() {
        if (posts == null)
            return 0;
        return posts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView post;
        TextView site;
        ImageView imageview;

        public ViewHolder(View itemView) {
            super(itemView);
            post = (TextView) itemView.findViewById(R.id.postitem_post);
            site = (TextView) itemView.findViewById(R.id.postitem_site);
            imageview = (ImageView) itemView.findViewById(R.id.image_p);

        }
    }

    public void setData(PojoNbu pojoNbu) {
        this.posts.addAll(pojoNbu.getResults());
        notifyDataSetChanged();
    }

}
