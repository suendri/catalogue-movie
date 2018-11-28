package com.suendri.project.suecataloguemovie12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.suendri.project.suecataloguemovie12.model.Items;
import com.suendri.project.suecataloguemovie12.model.ResultsItem;
import com.suendri.project.suecataloguemovie12.rest.ApiClient;
import com.suendri.project.suecataloguemovie12.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


// Asli buatan sendiri om, dibantu mentor dan teman-teman :)

public class MainActivity extends AppCompatActivity {

    TextView edit_judul;
    Button btn_cari;
    ListView list_movie;

    MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_judul = findViewById(R.id.i_judul);
        btn_cari = findViewById(R.id.i_cari);
        list_movie = findViewById(R.id.i_list);

        adapter = new MovieAdapter(this);
        adapter.notifyDataSetChanged();

        list_movie.setAdapter(adapter);

        // Sue ketika di click button cari
        btn_cari.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                ApiInterface apiServices = ApiClient.getClient().create(ApiInterface.class);

                Call<Items> call = apiServices.getItemSearch(edit_judul.getText().toString());

                call.enqueue(new Callback<Items>() {

                    @Override
                    public void onResponse(Call<Items> call, Response<Items> response) {

                        if (response.isSuccessful()) {

                            List<ResultsItem> resultsItems = response.body().getResults();
                            adapter.setData(resultsItems);

                        } else {

                        }

                    }

                    @Override
                    public void onFailure(Call<Items> call, Throwable t) {

                    }
                });
            }
        });

    }

}
