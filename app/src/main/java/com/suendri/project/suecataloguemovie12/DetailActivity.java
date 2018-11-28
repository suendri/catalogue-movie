package com.suendri.project.suecataloguemovie12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    public static String EXTRA_IMAGE_MOVIE = "extra_image_movie";
    public static String EXTRA_TITLE = "extra_title";
    public static String EXTRA_VOTE = "extra_vote";
    public static String EXTRA_RATING = "extra_rating";
    public static String EXTRA_DATE_RELEASE = "extra_date_release";
    public static String EXTRA_OVERVIEW = "extra_overview";

    ImageView detail_photo;
    TextView detail_judul;
    TextView detail_voting;
    TextView detail_rating;
    TextView detail_tanggal;
    TextView detail_deskripsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detail_photo = findViewById(R.id.d_photo);
        detail_judul = findViewById(R.id.d_judul);
        detail_voting = findViewById(R.id.d_voting);
        detail_rating = findViewById(R.id.d_rating);
        detail_tanggal = findViewById(R.id.d_tanggal);
        detail_deskripsi = findViewById(R.id.d_deskripsi);

        String s_photo = getIntent().getStringExtra(EXTRA_IMAGE_MOVIE);
        String s_judul = getIntent().getStringExtra(EXTRA_TITLE);
        String s_voting =String.valueOf(getIntent().getIntExtra(EXTRA_VOTE,0));
        String s_rating = String.valueOf(getIntent().getDoubleExtra(EXTRA_RATING,0));
        String s_tanggal = getIntent().getStringExtra(EXTRA_DATE_RELEASE);
        String s_deskripsi = getIntent().getStringExtra(EXTRA_OVERVIEW);

        Picasso.get().load("http://image.tmdb.org/t/p/w185" + s_photo).into(detail_photo);

        detail_judul.setText(s_judul);
        detail_voting.setText(s_voting);
        detail_rating.setText(s_rating);
        detail_tanggal.setText(s_tanggal);
        detail_deskripsi.setText(s_deskripsi);

    }
}
