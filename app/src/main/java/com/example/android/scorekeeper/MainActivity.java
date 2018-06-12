package com.example.android.scorekeeper;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int scoreA = 0, scoreB = 0;


    private Button plusThreeA;
    private Button plusTwoA;
    private Button freeShotA;
    private Button plusThreeB;
    private Button plusTwoB;
    private Button freeShotB;
    private Button reset;
    private Button start;
    private TextView mTextField;
    private MediaPlayer mMediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        plusThreeA = findViewById(R.id.plus_three_A);
        plusThreeA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scoreA+=3;
                display_score_team_A(scoreA);
            }
        });
        plusTwoA = findViewById(R.id.plus_two_A);
        plusTwoA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scoreA+=2;
                display_score_team_A(scoreA);
            }
        });
        freeShotA = findViewById(R.id.free_shot_A);
        freeShotA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scoreA+=1;
                display_score_team_A(scoreA);
            }
        });
        plusThreeB = findViewById(R.id.plus_three_B);
        plusThreeB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scoreB+=3;
                display_score_team_B(scoreB);
            }
        });
        plusTwoB = findViewById(R.id.plus_two_B);
        plusTwoB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scoreB+=2;
                display_score_team_B(scoreB);
            }
        });
        freeShotB = findViewById(R.id.free_shot_B);
        freeShotB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scoreB+=1;
                display_score_team_B(scoreB);
            }
        });
        reset = findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scoreA=0;
                scoreB=0;
                display_score_team_A(scoreA);
                display_score_team_B(scoreB);
                mMediaPlayer.pause();


            }
        });
        start = findViewById(R.id.start);
        mMediaPlayer=MediaPlayer.create(this,R.raw.mysong);
        mMediaPlayer.setLooping(true);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mMediaPlayer.start();
            }
        });
    }
      @Override
    protected void onStop() {
        super.onStop();
        mMediaPlayer.release();
    }
    // Display methods for showing scores foe two teams
    public void display_score_team_A(int score){
        TextView Team_A= (TextView)findViewById(R.id.scoreA);
        Team_A.setText(score+" ");
    }
    public  void display_score_team_B(int score){
        TextView Team_B=(TextView)findViewById(R.id.scoreB);
        Team_B.setText(score+" ");
    }

}
