package com.example.speedytext;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ToggleButton;

public class Settings extends Activity{
	private ToggleButton first;
	private ToggleButton second;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.optionsactivity);
		first = (ToggleButton) findViewById(R.id.toggleButton1);
		second = (ToggleButton) findViewById(R.id.toggleButton2);
		first.setOnCheckedChangeListener((OnCheckedChangeListener) this);
		loadSavedPreferences();
	}
	private void loadSavedPreferences() {
		SharedPreferences sharedPreferences = PreferenceManager
				.getDefaultSharedPreferences(this);
		boolean checkIfTrue = sharedPreferences.getBoolean("Switch_Value", false);
		String name = sharedPreferences.getString("storedName", "YourName");
		if (checkIfTrue) {
			first.setChecked(true);
		} else {
			first.setChecked(false);
		}
	}
	private void savePreferences(String key, boolean value) {
		SharedPreferences sharedPreferences = PreferenceManager
				.getDefaultSharedPreferences(this);
		Editor editor = sharedPreferences.edit();
		editor.putBoolean(key, value);
		editor.commit();
	}

	private void savePreferences(String key, String value) {
		SharedPreferences sharedPreferences = PreferenceManager
				.getDefaultSharedPreferences(this);
		Editor editor = sharedPreferences.edit();
		editor.putString(key, value);
		editor.commit();
	}

	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
    	if(isChecked)
    	{
    		first.setChecked(true);
    	}
    }


}
