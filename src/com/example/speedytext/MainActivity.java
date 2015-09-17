package com.example.speedytext;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
	 private int counter;
	 private int number;
	 private CountDownTimer hey;
	 private CountDownTimer hey2;
	 private TextView finaltally;
	 private int highest;
	 private TextView highscore;
	 private Button restart;
	 private int numero;
	 private int i;
	 private EditText answerText;
	 private Button someButton;
	 private int counterResume = 0;
	 private TextView text;
	 private TextView clockText;
	 private ArrayList updatedList;
	 private String wordFinal;
	 private int randomInt;
	 private Random rn;
	 public int mediatime;
	 private MediaPlayer mp;
	 private MediaPlayer countdown;
	 private boolean dingCheckedboolean;
	 private boolean countdownCheckedboolean;
	 public static final String PREFS = "examplePrefs";
	 public static final String PREFS2 = "examplePrefs2";
	 private Button pause;
	 private Button resume;
	 private Button backButton;
	 public boolean buttonPaused;
	 public long s1;
	 private int methodcounter = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mp = MediaPlayer.create(this, R.raw.dingsoundeffect);
		countdown = MediaPlayer.create(this, R.raw.newcountdown);
		answerText = (EditText) findViewById(R.id.answer);
		answerText.setEnabled(false);
		someButton = (Button) findViewById(R.id.buttontobegin);
		pause = (Button) findViewById(R.id.pause);
		pause.setVisibility(View.INVISIBLE);
		backButton = (Button) findViewById(R.id.backbutton);
		backButton.setVisibility(View.INVISIBLE);
		resume = (Button) findViewById(R.id.resume);
		resume.setVisibility(View.INVISIBLE);
		text = (TextView) findViewById(R.id.wordtoanswer);
		restart = (Button) findViewById(R.id.restart);
		restart.setVisibility(View.INVISIBLE);
		text.setVisibility(View.INVISIBLE);
		clockText = (TextView) findViewById(R.id.clock);
		finaltally = (TextView) findViewById(R.id.finaltally);
		clockText.setVisibility(View.INVISIBLE);
		highscore = (TextView) findViewById(R.id.highscore);
		SharedPreferences example = getSharedPreferences(PREFS,0);	
		SharedPreferences example2 = getSharedPreferences(PREFS2,0);	
		dingCheckedboolean = example.getBoolean("your_key", true);
		countdownCheckedboolean = example2.getBoolean("your_key2", true);
		System.out.println("Ding checked is " + dingCheckedboolean);
		System.out.println("Countdown checked is " + countdownCheckedboolean);
		someButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				restart.setVisibility(View.INVISIBLE);
				pause.setVisibility(View.VISIBLE);
				someButton.setVisibility(View.INVISIBLE);
				text.setVisibility(View.VISIBLE);
				someButton.setEnabled(false);
				clockText.setVisibility(View.VISIBLE);
				answerText.setEnabled(true);
				hey = new CountDownTimer(30000, 1000) {

				     public void onTick(long millisUntilFinished) {
				    	 clockText.setText("seconds remaining: " + millisUntilFinished / 1000);
				    	  s1=millisUntilFinished;
				    	  if(methodcounter == 0)
				    	  {
				    		  System.out.println("never called");
				    	 if(millisUntilFinished < 11000)
				    	 {
				    		 clockText.setTextColor(Color.RED);
				    		 if(countdownCheckedboolean)
				    		 {
				    		 countdown.start();
				    		 }
				    	 }
				    	  }
				     }

				     public void onFinish() {
				    	 if(methodcounter == 0)
				    	  {
				    		  System.out.println("never called");
				    	 clockText.setVisibility(View.INVISIBLE);  
				    	 pause.setVisibility(View.INVISIBLE);
				    	 backButton.setVisibility(View.VISIBLE);
				    	 restart.setVisibility(View.VISIBLE);
				    	 clockText.setText("Time is Up!");
				    	 clockText.setTextColor(Color.BLACK);
				    	 answerText.setEnabled(false);
				    	 if(counter>highest)
				    	 {
					    	 highest = counter;
				    	 }
				    	 highscore.setVisibility(View.VISIBLE);
				    	 finaltally.setVisibility(View.VISIBLE);
				    	 highscore.setText("Your high score is " + highest + ".");
	            		 finaltally.setText("You finished " + number + " words!");
				     }
				     }
				  }.start();
				
			}
		});	
		 updatedList = helperMethod();
		 int lengthOfList = updatedList.size();
		  rn = new Random();
		 randomInt = rn.nextInt(lengthOfList);
		 text.setText(updatedList.get(randomInt).toString());
		 wordFinal = updatedList.get(randomInt).toString();
		 counter = 0;
		 System.out.println(updatedList.size());
		answerText.addTextChangedListener(new TextWatcher() {
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                // TODO Auto-generated method stub
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                // TODO Auto-generated method stub
            }

            public void afterTextChanged(Editable s) {
            	int i = 0;
            	while(i < updatedList.size())
            	{	
            	String answer = s.toString();
            	if(answer.equals(updatedList.get(randomInt)))
            	{	
            		if(i == updatedList.size()-1)
            		{
            			answerText.setText("");
            			answerText.setEnabled(false);
            			number++;
            			text.setText("Congrats, you win!");
            			hey.cancel();
            			break;
            		}
            		else if(i<updatedList.size()-1)
            		{
            			if(dingCheckedboolean)
            			{
            			    mp.start();
            			}
            			counter++;
            			number++;
                    	randomInt = rn.nextInt(updatedList.size());
                    	text.setText(updatedList.get(randomInt).toString());
            		}
            		answerText.setText("");
            	}
            	i++;
            }
            }
        });
		restart.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//System.out.println(s1);
				answerText.setText("");
				hey.start();
				counter = 0;
				number = 0;
				answerText.setEnabled(true);
				restart.setVisibility(View.INVISIBLE);
				backButton.setVisibility(View.INVISIBLE);
				pause.setVisibility(View.VISIBLE);
				highscore.setVisibility(View.INVISIBLE);
				finaltally.setVisibility(View.INVISIBLE);
				numero = 0;
				i = 0;
			}
		});
		
		pause.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
					methodcounter++;
					System.out.println(s1 + " is s1");
					if(countdown.isPlaying())
					{
					countdown.pause();
					mediatime = countdown.getCurrentPosition();
					buttonPaused = true;
					}
					pause.setVisibility(View.INVISIBLE);
					if(counterResume == 0)
					{
					hey.cancel();
					}
					if(counterResume > 0)
					{
						hey2.cancel();
					}
					resume.setVisibility(View.VISIBLE);
					answerText.setEnabled(false);
				
			}
		});
		
		backButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {
					Class ourClass = Class.forName("com.example.speedytext.Menu");
					Intent ourIntent = new Intent(MainActivity.this, ourClass);
					startActivity(ourIntent);
					}
					catch(ClassNotFoundException e)
					{
						e.printStackTrace();
					}
				
			}
			
		});
		
		resume.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				counterResume++;
					if(buttonPaused)
					{
					 countdown.seekTo(mediatime - 1000);
					countdown.start();
					}
					pause.setVisibility(View.VISIBLE);
					hey2 = new CountDownTimer(s1, 1000) {

					     public void onTick(long millisUntilFinished) {
					    	 clockText.setText("seconds remaining: " + millisUntilFinished / 1000);
					    	  s1=millisUntilFinished;
					    	 if(millisUntilFinished < 11000)
					    	 {
					    		 clockText.setTextColor(Color.RED);
					    		 if(countdownCheckedboolean)
					    		 {
					    		 countdown.start();
					    		 }
					    	 }
					     }

					     public void onFinish() {
					    	 pause.setVisibility(View.INVISIBLE);
					    	 restart.setVisibility(View.VISIBLE);
					    	 clockText.setVisibility(View.INVISIBLE);  
					    	 clockText.setText("Time is Up!");
					    	 clockText.setTextColor(Color.BLACK);
					    	 answerText.setEnabled(false);
					    	 backButton.setVisibility(View.VISIBLE);
					    	 if(counter>highest)
					    	 {
						    	 highest = counter;
					    	 }
					    	 highscore.setVisibility(View.VISIBLE);
					    	 finaltally.setVisibility(View.VISIBLE);
					    	 highscore.setText("Your high score is " + highest + ".");
		            		 finaltally.setText("You finished " + number + " words!");
					     }
					  }.start();
					  resume.setVisibility(View.INVISIBLE);
						answerText.setEnabled(true);
				}
			
			});	
					
	}		
	
	//}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public ArrayList<String> helperMethod()
	{
		InputStream input;
		final ArrayList<String> listofStrings = new ArrayList<String>();
  		AssetManager assetManager = getAssets();
	    try 
	    {
	       input = assetManager.open("file.txt"); 
	       int size = input.available();
	       byte[] buffer = new byte[size];             
	       input.read(buffer);
	       input.close(); 
	       String textWords = new String(buffer);
	       String newString = "";
	       for(numero = 0 ; numero < textWords.length();numero++)
	    	{
	    		char a = textWords.charAt(numero);
	    		if((a!=' ')&&(numero!=textWords.length()-1))
	    		{
	    			newString = newString + a;
	    		}
	    		else if((a!=' ') && (numero == textWords.length()-1))
	    		{
	    			System.out.println("Im here");
	    			newString = newString + a;
	    			listofStrings.add(newString);
	    			break;
	    		}
	    		else if(numero != textWords.length()-1 && a==' ')
	    		{
	    			listofStrings.add(newString);
	    			newString = "";
	    		}
	    	}
	    	System.out.println(listofStrings);	    
	}
	    catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	    return listofStrings;
	}
	         	}

