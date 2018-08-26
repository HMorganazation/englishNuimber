package com.example.softheart.englishnumbers;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.softheart.englishnumbers.adapter.CustomOnItemClick;
import com.example.softheart.englishnumbers.adapter.Song;
import com.example.softheart.englishnumbers.adapter.SongAdapter;
import com.example.softheart.englishnumbers.databinding.SongsActivityBinding;
import com.google.gson.Gson;

import java.util.ArrayList;

public class SongsActivity extends AppCompatActivity {
    SongsActivityBinding binding;
    ArrayList<Song> songs;
    SongAdapter songAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding=DataBindingUtil.setContentView(this,R.layout.songs_activity);
        songs = new ArrayList<>();
        songs.add(new Song("zero", R.raw._0sound, R.drawable._0));
        songs.add(new Song("one", R.raw._1sound, R.drawable._1));
        songs.add(new Song("two", R.raw._2sound, R.drawable._2));
        songs.add(new Song("three", R.raw._3sound, R.drawable._3));
        songs.add(new Song("four", R.raw._4sound, R.drawable._4));
        songs.add(new Song("five", R.raw._5sound, R.drawable._5));
        songs.add(new Song("six", R.raw._6sound, R.drawable._6));
        songs.add(new Song("seven", R.raw._7sound, R.drawable._7));
        songs.add(new Song("eight", R.raw._8sound, R.drawable._8));
        songs.add(new Song("nine", R.raw._9sound, R.drawable._9));

        songAdapter = new SongAdapter(songs, new CradView());
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(songAdapter);
        binding.recyclerView.setHasFixedSize(true);

    }

    class CradView implements CustomOnItemClick {
        private static final String TAG = "CradView";

        @Override
        public void onItemCick(View v, int position) {
            Log.i(TAG, "onItemCick: " + position);
            Intent intent = new Intent(getApplicationContext(), ControlerActivity.class);
            Gson gson = new Gson();
            intent.putExtra(ControlerActivity.SONG_OBJECT_KEY, gson.toJson(songs.get(position)));
            startActivity(intent);

        }
    }
}
