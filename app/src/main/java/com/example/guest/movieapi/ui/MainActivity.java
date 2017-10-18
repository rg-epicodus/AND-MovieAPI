package com.example.guest.movieapi.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.guest.movieapi.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.showByMoviesButton) Button mShowByMoviesButton;
    @Bind(R.id.movieTitleEditText) EditText mMovieTitleEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mShowByMoviesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String movieTitle = mMovieTitleEditText.getText().toString();
                Intent intent = new Intent(MainActivity.this, MovieListActivity.class);
                intent.putExtra("movieTitle", movieTitle);
                startActivity(intent);
            }
        });
    }
}
