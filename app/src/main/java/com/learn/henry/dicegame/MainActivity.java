package com.learn.henry.dicegame;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView rollResult;
    private int score;
    private Button rollButton;
    private Random rand;

    private int dieOne;
    private int dieTwo;
    private int dieThree;

    private ArrayList<Integer> dices;

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

    }

    public void rollDice(View v)
    {
        rollResult.setText("rolled");

//        roll dice
        dieOne = rand.nextInt(6)+1;
        dieTwo = rand.nextInt(6)+1;
        dieThree = rand.nextInt(6)+1;

        dices.clear();
        dices.add(dieOne);
        dices.add(dieTwo);
        dices.add(dieThree);


        rollResult.setText("You rolled a " + dieOne + ", and a " + dieTwo + ", and " + dieThree);
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
