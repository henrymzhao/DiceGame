package com.learn.henry.dicegame;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView rollResult;
    private int score;
    private Button rollButton;
    private Random rand;

    private int die1;
    private int die2;
    private int die3;

    private TextView highScore;

//    arraylist to hold dice numbers
    private ArrayList<Integer> dices;
//    arraylist to hold dice images
    private ArrayList<ImageView> dicePics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        score = 0;
        rollResult = (TextView) findViewById(R.id.rollResult);
        rollButton = (Button) findViewById(R.id.rollButton);
//        creating a toast
        Toast.makeText(getApplicationContext(), "Welcome to DiceGame", Toast.LENGTH_SHORT).show();

//        creating a new random class
        rand = new Random();

        dices = new ArrayList<Integer>();

        ImageView die1Image = (ImageView) findViewById(R.id.die1Image);
        ImageView die2Image = (ImageView) findViewById(R.id.die2Image);
        ImageView die3Image = (ImageView) findViewById(R.id.die3Image);
        dicePics = new ArrayList<ImageView>();
        dicePics.add(die1Image);
        dicePics.add(die2Image);
        dicePics.add(die3Image);

        highScore = (TextView) findViewById(R.id.highScore);
    }

    public void rollDice(View v)
    {
        rollResult.setText("rolled");

//        roll dice
        die1 = rand.nextInt(6)+1;
        die2 = rand.nextInt(6)+1;
        die3 = rand.nextInt(6)+1;

        dices.clear();
        dices.add(die1);
        dices.add(die2);
        dices.add(die3);

        for (int i = 0; i < 3; i++)
        {
            String imageName = "die_" + dices.get(i) + ".png";

            try
            {
                InputStream stream = getAssets().open(imageName);
                Drawable d = Drawable.createFromStream(stream, null);
                dicePics.get(i).setImageDrawable(d);
            }catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        rollResult.setText("You rolled a " + die1 + ", and a " + die2 + ", and " + die3);

        String msg;

        if (die1 == die2 && die1 == die3)
        {
//            triples
            int scoreDelta = die1*100;
            msg = "You rolled a triple " + die1 + "! You scored " + scoreDelta + " points.";
        }
        else if (die1 == die2 || die1 == die3 || die2 == die3)
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
