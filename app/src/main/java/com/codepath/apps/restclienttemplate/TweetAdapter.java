package com.codepath.apps.restclienttemplate;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.models.Tweet;

import java.util.List;

public class TweetAdapter extends RecyclerView.Adapter<TweetAdapter.ViewHolder>{

private Context context;
private List<Tweet> tweets;

    public TweetAdapter(Context context, List<Tweet> tweets) {
        this.context = context;
        this.tweets = tweets;
    }
// pass int the context and list of tweets

    //for ech row inflate the layout
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View view = LayoutInflater.from( context ).inflate( R.layout.item_tweet, viewGroup, false);
        return new ViewHolder( view );
    }

    //Bind values based on the position of the element
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        Tweet tweet = tweets.get( position );
        viewHolder.tvBody.setText( tweet.body );
        viewHolder.tvScreenName.setText( tweet.user.screenName );
        Glide.with( context ).load( tweet.user.profileImageUrl ).into(viewHolder.ivProfileImage);
        viewHolder.tvTime.setText( tweet.createdAt );


    }

    //Define how many items are in a data source
    @Override
    public int getItemCount() {
        return tweets.size();
    }


    public void clear(){
        tweets.clear();
        notifyDataSetChanged();
    }

    public void addTweet(List<Tweet> tweetList){
        tweets.addAll( tweetList );
        notifyDataSetChanged();
    }

    //Define the viewHolder
    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView ivProfileImage;
        public TextView tvScreenName;
        public TextView tvBody;
        public TextView tvTime;

        public ViewHolder(@NonNull View itemView) {
            super( itemView );

            ivProfileImage = itemView.findViewById( R.id.ivProfileImage );
            tvScreenName = itemView.findViewById( R.id.tvScreenName );
            tvBody = itemView.findViewById( R.id.tvBody );
            tvTime = itemView.findViewById( R.id.tvTime );
        }
    }

}
