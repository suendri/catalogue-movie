package com.suendri.project.suecataloguemovie12;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.suendri.project.suecataloguemovie12.model.ResultsItem;

import java.util.List;

public class MovieAdapter extends BaseAdapter {

    private List<ResultsItem> movies;
    private Context context;
    private LayoutInflater mInflater;

    public MovieAdapter(Context context) {
        this.context = context;
        mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setData(List<ResultsItem> items) {
        movies = items;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return (movies == null) ? 0 : movies.size();
    }

    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View itemView, ViewGroup parent) {

        viewHolder holder;

        if (itemView == null){
            itemView = mInflater.inflate(R.layout.movie_items, null);
            holder = new viewHolder(itemView);

            itemView.setTag(holder);

        } else {
            holder = (viewHolder) itemView.getTag();
        }

        holder.judul.setText(movies.get(position).getTitle());
        holder.deskripsi.setText(movies.get(position).getOverview());
        holder.tanggal.setText(movies.get(position).getReleaseDate());

        // untuk konversi ke String karena sebelumnya bertype int
        holder.voting.setText(String.valueOf(movies.get(position).getVoteCount()));

        Picasso.get().load("http://image.tmdb.org/t/p/w185" + movies.get(position).getPosterPath()).into(holder.photo);

        // Sue Untuk detail
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);

                intent.putExtra(DetailActivity.EXTRA_IMAGE_MOVIE, movies.get(position).getPosterPath());
                intent.putExtra(DetailActivity.EXTRA_TITLE, movies.get(position).getTitle());
                intent.putExtra(DetailActivity.EXTRA_VOTE, movies.get(position).getVoteCount());
                intent.putExtra(DetailActivity.EXTRA_RATING, movies.get(position).getPopularity());
                intent.putExtra(DetailActivity.EXTRA_DATE_RELEASE, movies.get(position).getReleaseDate());
                intent.putExtra(DetailActivity.EXTRA_OVERVIEW, movies.get(position).getOverview());

                context.startActivity(intent);
            }
        });

        return itemView;

    }

    static final class viewHolder {

        TextView judul;
        TextView deskripsi;
        TextView tanggal;
        TextView voting;
        ImageView photo;

        viewHolder(View view) {
            judul = view.findViewById(R.id.t_judul);
            deskripsi = view.findViewById(R.id.t_deskripsi);
            tanggal = view.findViewById(R.id.t_tanggal);
            voting = view.findViewById(R.id.t_voting);
            photo = view.findViewById(R.id.t_photo);
        }
    }
}
