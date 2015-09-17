package com.example.speedytext;

import java.util.Random;

import android.support.v7.app.ActionBarActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnHoverListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;

public class Menu extends ActionBarActivity {
	public static final String PREFS = "examplePrefs";
	public MediaPlayer mpMenu;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menutry);
		Button playButton = (Button) findViewById(R.id.playrenewed);
		Random randMenu = new Random();
		int randomNum = randMenu.nextInt(8) + 1;
		if(randomNum == 1)
		{
			mpMenu = MediaPlayer.create(Menu.this, R.raw.animals);
			mpMenu.start();
		}
		if(randomNum == 2)
		{
			mpMenu = MediaPlayer.create(Menu.this, R.raw.blue);
			mpMenu.start();
		}
		if(randomNum == 3)
		{
			mpMenu = MediaPlayer.create(Menu.this, R.raw.idontlikechiefkeef);
			mpMenu.start();
		}
		if(randomNum == 4)
		{
			mpMenu = MediaPlayer.create(Menu.this, R.raw.lights);
			mpMenu.start();
		}
		if(randomNum == 5)
		{
			mpMenu = MediaPlayer.create(Menu.this, R.raw.nowyouregone);
			mpMenu.start();
		}
		if(randomNum == 6)
		{
			mpMenu = MediaPlayer.create(Menu.this, R.raw.oftenweeknd);
			mpMenu.start();
		}
		if(randomNum == 7)
		{
			mpMenu = MediaPlayer.create(Menu.this, R.raw.tko);
			mpMenu.start();
		}
		Button settingsButton = (Button) findViewById(R.id.optionsrenewed);
		Button songButton = (Button) findViewById(R.id.changerenewed);
		Button aboutButton = (Button) findViewById(R.id.aboutrenewed);
		final RelativeLayout menulayout = (RelativeLayout)findViewById(R.id.layoutmenu);
		
		playButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {
					Class ourClass = Class.forName("com.example.speedytext.MainActivity");
					Intent ourIntent = new Intent(Menu.this, ourClass);
					startActivity(ourIntent);
					}
					catch(ClassNotFoundException e)
					{
						e.printStackTrace();
					}
			}
		});
		aboutButton.setOnClickListener(new OnClickListener() {
		
	public void onClick(View v) {
		// TODO Auto-generated method stub
		try {
			Class ourClass = Class.forName("com.example.speedytext.AboutDeveloper");
			Intent ourIntent = new Intent(Menu.this, ourClass);
			startActivity(ourIntent);
			}
			catch(ClassNotFoundException e)
			{
				e.printStackTrace();
			}
	}
});
		settingsButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {
					Class ourClass = Class.forName("com.example.speedytext.Options");
					Intent ourIntent = new Intent(Menu.this, ourClass);
					startActivity(ourIntent);
					}
					catch(ClassNotFoundException e)
					{
						e.printStackTrace();
					}
			}
		});
		
		songButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {
					Class ourClass = Class.forName("com.example.speedytext.SongButton");
					Intent ourIntent = new Intent(Menu.this, ourClass);
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
