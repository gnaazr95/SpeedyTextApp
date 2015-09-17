package com.example.speedytext;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class SongButton extends Activity{
	ListView listView;
	MediaPlayer medialist;
	MediaPlayer medialist1;
	MediaPlayer medialist2;
	MediaPlayer medialist3;
	MediaPlayer medialist4;
	MediaPlayer medialist5;
	MediaPlayer medialist6;
	MediaPlayer medialistmenu;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.songselection);
		Menu menuActivity = new Menu();
		medialistmenu = menuActivity.mpMenu;
		listView = (ListView) findViewById(R.id.list);
		medialist = MediaPlayer.create(SongButton.this, R.raw.blue);
		medialist1 = MediaPlayer.create(SongButton.this, R.raw.tko);
		medialist2 = MediaPlayer.create(SongButton.this, R.raw.lights);
		medialist3 = MediaPlayer.create(SongButton.this, R.raw.idontlikechiefkeef);
		medialist4 = MediaPlayer.create(SongButton.this, R.raw.animals);
		medialist5 = MediaPlayer.create(SongButton.this, R.raw.oftenweeknd);
		medialist6 = MediaPlayer.create(SongButton.this, R.raw.nowyouregone);
		String[] values = new String[] { "Eiffel 65 - Blue", 
                "Justin Timberlake - TKO",
                "Ellie Goulding - Lights",
                "Chief Keef - I Don't Like", 
                "Martin Garrix - Animals", 
                "The Weeknd - Often (Kygo Remix)",
                "Basshunter - Now You're Gone"
               };
		  ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
	              android.R.layout.simple_list_item_1, android.R.id.text1, values);
		  listView.setAdapter(adapter); 
		  listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				  int itemPosition     = position;
				  int counter = 0;
                  // ListView Clicked item value
                  String  itemValue    = (String) listView.getItemAtPosition(position);
                     
                  if(itemPosition == 0)
                  {
                	  medialistmenu.stop();
                	  if(medialist1.isPlaying())
                	  {
                		  medialist1.stop();
                	  }
                	  if(medialist2.isPlaying())
                	  {
                		  medialist2.stop();
                	  }
                	  if(medialist3.isPlaying())
                	  {
                		  medialist3.stop();
                	  }
                	  if(medialist4.isPlaying())
                	  {
                		  medialist4.stop();
                	  }
                	  if(medialist5.isPlaying())
                	  {
                		  medialist5.stop();
                	  }
                	  if(medialist6.isPlaying())
                	  {
                		  medialist6.stop();
                	  }
                	  medialist.start();
                  }
                  if(itemPosition == 1)
                  {
                	  medialistmenu.stop();
                	  if(medialist.isPlaying())
                	  {
                		  medialist.stop();
                	  }
                	  if(medialist2.isPlaying())
                	  {
                		  medialist2.stop();
                	  }
                	  if(medialist3.isPlaying())
                	  {
                		  medialist3.stop();
                	  }
                	  if(medialist4.isPlaying())
                	  {
                		  medialist4.stop();
                	  }
                	  if(medialist5.isPlaying())
                	  {
                		  medialist5.stop();
                	  }
                	  if(medialist6.isPlaying())
                	  {
                		  medialist6.stop();
                	  }
                	  medialist1.start();
                  }
                  if(itemPosition == 2)
                  {       
                	  medialistmenu.stop();
                	  if(medialist1.isPlaying())
                	  {
                		  medialist1.stop();
                	  }
                	  if(medialist.isPlaying())
                	  {
                		  medialist.stop();
                	  }
                	  if(medialist3.isPlaying())
                	  {
                		  medialist3.stop();
                	  }
                	  if(medialist4.isPlaying())
                	  {
                		  medialist4.stop();
                	  }
                	  if(medialist5.isPlaying())
                	  {
                		  medialist5.stop();
                	  }
                	  if(medialist6.isPlaying())
                	  {
                		  medialist6.stop();
                	  }
                	  medialist2.start();
                  }
                  if(itemPosition == 3)
                  {
                	  medialistmenu.stop();
                	  if(medialist1.isPlaying())
                	  {
                		  medialist1.stop();
                	  }
                	  if(medialist2.isPlaying())
                	  {
                		  medialist2.stop();
                	  }
                	  if(medialist.isPlaying())
                	  {
                		  medialist.stop();
                	  }
                	  if(medialist4.isPlaying())
                	  {
                		  medialist4.stop();
                	  }
                	  if(medialist5.isPlaying())
                	  {
                		  medialist5.stop();
                	  }
                	  if(medialist6.isPlaying())
                	  {
                		  medialist6.stop();
                	  }
                	  medialist3.start();
                  }
                  if(itemPosition == 4)
                  { 
                	  medialistmenu.stop();
                	  if(medialist1.isPlaying())
                	  {
                		  medialist1.stop();
                	  }
                	  if(medialist2.isPlaying())
                	  {
                		  medialist2.stop();
                	  }
                	  if(medialist3.isPlaying())
                	  {
                		  medialist3.stop();
                	  }
                	  if(medialist.isPlaying())
                	  {
                		  medialist.stop();
                	  }
                	  if(medialist5.isPlaying())
                	  {
                		  medialist5.stop();
                	  }
                	  if(medialist6.isPlaying())
                	  {
                		  medialist6.stop();
                	  }
                	  medialist4.start();
                  }
                  if(itemPosition == 5)
                  {    
                	  medialistmenu.stop();
                	  if(medialist1.isPlaying())
                	  {
                		  medialist1.stop();
                	  }
                	  if(medialist2.isPlaying())
                	  {
                		  medialist2.stop();
                	  }
                	  if(medialist3.isPlaying())
                	  {
                		  medialist3.stop();
                	  }
                	  if(medialist4.isPlaying())
                	  {
                		  medialist4.stop();
                	  }
                	  if(medialist.isPlaying())
                	  {
                		  medialist.stop();
                	  }
                	  if(medialist6.isPlaying())
                	  {
                		  medialist6.stop();
                	  }
                	  medialist5.start();
                  }
                  if(itemPosition == 6)
                  {   
                	  medialistmenu.stop();
                	  if(medialist1.isPlaying())
                	  {
                		  medialist1.stop();
                	  }
                	  if(medialist2.isPlaying())
                	  {
                		  medialist2.stop();
                	  }
                	  if(medialist3.isPlaying())
                	  {
                		  medialist3.stop();
                	  }
                	  if(medialist4.isPlaying())
                	  {
                		  medialist4.stop();
                	  }
                	  if(medialist5.isPlaying())
                	  {
                		  medialist5.stop();
                	  }
                	  if(medialist.isPlaying())
                	  {
                		  medialist.stop();
                	  }
                	  medialist6.start();
                  }
			}

            
	});
	}

}
