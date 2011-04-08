package us.scarlson.cribbage;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
//import android.widget.TextView;
import android.widget.Button;
import android.widget.TextView;
import android.util.DisplayMetrics;
import android.view.View;

public class Cribbage extends Activity {
    /** Called when the activity is first created. */
	final static int hand_size = 6;
	private static Hand hand = new Hand(hand_size);
	private static Hand comp = new Hand(hand_size);
	private static Hand crib = new Hand(4);
	private static Deck deck = new Deck();
	private static int blue_score = 0;
	private static int red_score = 0;
	DisplayMetrics metrics = new DisplayMetrics();
	Button button1,button2,button3,button4,button5,button6,newgame,exit;
    TextView lv,rv;
	public boolean CPU = true;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    	getWindowManager().getDefaultDisplay().getMetrics(metrics);
    	setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        lv = (TextView) findViewById(R.id.leftview);
        rv = (TextView) findViewById(R.id.rightview);
        exit = (Button) findViewById(R.id.Exit);
        newgame = (Button) findViewById(R.id.New);
        
        button1 = (Button) findViewById(R.id.Card1);
        button2 = (Button) findViewById(R.id.Card2);
        button3 = (Button) findViewById(R.id.Card3);
        button4 = (Button) findViewById(R.id.Card4);
        button5 = (Button) findViewById(R.id.Card5);
        button6 = (Button) findViewById(R.id.Card6);
        
        button1.setWidth(metrics.widthPixels/6);
        button2.setWidth(metrics.widthPixels/6);
        button3.setWidth(metrics.widthPixels/6);
        button4.setWidth(metrics.widthPixels/6);
        button5.setWidth(metrics.widthPixels/6);
        button6.setWidth(metrics.widthPixels/6);
        
        rv.setVisibility(8);
        button1.setVisibility(8);
        button2.setVisibility(8);
        button3.setVisibility(8);
        button4.setVisibility(8);
        button5.setVisibility(8);
        button6.setVisibility(8);
        
        newgame.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	newgame.setVisibility(8);
                exit.setVisibility(8);
                button1.setVisibility(0);
                button2.setVisibility(0);
                button3.setVisibility(0);
                button4.setVisibility(0);
                button5.setVisibility(0);
                button6.setVisibility(0);
                rv.setVisibility(0);
            	deal();
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	toCrib(1);
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	toCrib(1);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	toCrib(2);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	toCrib(3);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	toCrib(4);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	toCrib(5);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	toCrib(6);
            }
        });
        
    }

    public void toCrib(int btn){
    	crib.setCard(0, hand.cards[btn]);
    }
    
    public void deal(){
		//Shuffle deck and deal the hand
    //while(chips > 0){
    	String x = "";
    	button1.setVisibility(1);
        button2.setVisibility(1);
        button3.setVisibility(1);
        button4.setVisibility(1);
        button5.setVisibility(1);
        button6.setVisibility(1);
        
		deck.shuffle();
            	for (int i = 0; i<hand_size; i++){
                    	hand.setCard(i, deck.dealCard());
                    	comp.setCard(i, deck.dealCard());
            	}
            	
		//Print players hand in leftview, comps hand in rightview
		x = "Player\nYour Hand Is:\n\n";
		lv.setText(x + hand.toString());
		x = "Computer\nHand Is:\n\n";
		rv.setText(x + comp.toString());
		
		//Display hand value
		//x = "\n\n" + hand.getScore() + "!\n";
		//tv.append(x);
		//red_score += hand.getScore();
		//blue_score += comp.getScore();
		
		
		// request player to discard to crib
		x = "\n\nPlease pick 2 cards to discard";
		lv.append(x);
		
		//Display scores
		x = "\nRed: " + red_score;
		lv.append(x);
		x = "\nBlue: " + blue_score;
		rv.append(x);
	//}
    }
}
