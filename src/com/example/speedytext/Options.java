package com.example.speedytext;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;

public class Options extends ActionBarActivity {
private  Switch ding;
private Switch countdown;
public  boolean isDingChecked;
public  boolean isCountdownChecked;
public static final String PREFS = "examplePrefs";
public static final String PREFS2 = "examplePrefs2";
public Button bluebutton;
//public SharedPreferences examplePrefs;
public Editor editor;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_options);
    ding = (Switch) findViewById(R.id.switch1);
    countdown = (Switch)findViewById(R.id.switch2);
    bluebutton = (Button)findViewById(R.id.bluebutton);
    //grab prefs first
    final SharedPreferences examplePrefs = getSharedPreferences(PREFS,0);
    final SharedPreferences examplePrefs2 = getSharedPreferences(PREFS2,0);
    
    final Editor editor = examplePrefs.edit();
    final Editor editor2 = examplePrefs2.edit();
    
    ding.setChecked(examplePrefs.getBoolean("your_key", false)); //false default 
    countdown.setChecked(examplePrefs2.getBoolean("your_key2",false));

    ding.setOnCheckedChangeListener(new OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            //commit prefs on change
            editor.putBoolean("your_key", isChecked);
            editor.commit();

            System.out.println(isDingChecked + " is ding checked");
        }
    });  
    
    countdown.setOnCheckedChangeListener(new OnCheckedChangeListener() {
		
		@Override
		public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			// TODO Auto-generated method stub
			editor2.putBoolean("your_key2", isChecked);
            editor2.commit();

            System.out.println(isCountdownChecked + " is countdown checked");
		}
	});
    
    bluebutton.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			try {
				Class ourClass = Class.forName("com.example.speedytext.Menu");
				Intent ourIntent = new Intent(Options.this, ourClass);
				startActivity(ourIntent);
				}
				catch(ClassNotFoundException e)
				{
					e.printStackTrace();
				}
			
		}
	});
}
}