package com.example.ej4;

import android.R.color;
import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Principal extends Activity implements OnClickListener {
	Button b1, b2;
	TextView tx1, tx2, tx3, tx4, tx5, tx6, tx7, tx8, tx9, tx10;
	EditText ed1;
	String label1 = "Tu color favorito es:";
	String label = "Tu número favorito es:";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_principal);

		tx1 = (TextView) findViewById(R.id.textView1);
		tx2 = (TextView) findViewById(R.id.textView3);
		ed1 = (EditText) findViewById(R.id.editText1);
		tx3 = (TextView) findViewById(R.id.textView4);
		tx4 = (TextView) findViewById(R.id.textView5);
		tx5 = (TextView) findViewById(R.id.textView6);
		tx6 = (TextView) findViewById(R.id.textView7);
		tx7 = (TextView) findViewById(R.id.textView8);
		tx8 = (TextView) findViewById(R.id.textView9);
		tx9 = (TextView) findViewById(R.id.textView10);
		tx10 = (TextView) findViewById(R.id.textView12);
		b1 = (Button) findViewById(R.id.button1);
		b2 = (Button) findViewById(R.id.button2);

		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		tx3.setOnClickListener(this);
		tx4.setOnClickListener(this);
		tx5.setOnClickListener(this);
		tx6.setOnClickListener(this);
		tx7.setOnClickListener(this);
		tx8.setOnClickListener(this);
		tx9.setOnClickListener(this);
		SharedPreferences preferences = getPreferences(0);
		tx1.setText(preferences.getString("fav", ""));
		tx2.setText(preferences.getString("numero", ""));
		tx10.setBackgroundColor(preferences.getInt("color", color.white));

	}

	protected void onSaveInstanceState(Bundle b) {
		super.onSaveInstanceState(b);
		b.putString("numero", tx2.getText().toString());
		b.putString("fav", tx1.getText().toString());
		b.putInt("color", dameColor(tx10));

	}

	public void onRestoreInstanceState(Bundle b) {
		// Always call the superclass so it can restore the view hierarchy
		super.onRestoreInstanceState(b);
		tx1.setText(b.getString("fav"));
		tx2.setText(b.getString("numero"));
		tx10.setBackgroundColor(b.getInt("color"));

	}

	protected void onStop() {
		super.onStop();
		SharedPreferences sharedPref = getPreferences(0);
		SharedPreferences.Editor editor = sharedPref.edit();
		editor.putString("fav", tx1.getText().toString());
		editor.putString("numero", tx2.getText().toString());
		editor.putInt("color", dameColor(tx10));
		editor.commit();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.principal, menu);
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

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v.getId() == b1.getId()) {
			tx1.setText(label+ ed1.getText().toString());

		} else if (v.getId() == b2.getId()) {
			this.finish();

		} else if (v.getId() == tx3.getId()) {

			tx2.setText(label1);
			tx10.setBackgroundColor(dameColor(v));
		} else if (v.getId() == tx4.getId()) {
			tx2.setText(label1);
			tx10.setBackgroundColor(dameColor(v));
		} else if (v.getId() == tx5.getId()) {
			tx2.setText(label1);
			tx10.setBackgroundColor(dameColor(v));
		} else if (v.getId() == tx6.getId()) {
			tx2.setText(label1);
			tx10.setBackgroundColor(dameColor(v));
		} else if (v.getId() == tx7.getId()) {
			tx2.setText(label1);
			tx10.setBackgroundColor(dameColor(v));
		} else if (v.getId() == tx8.getId()) {
			tx2.setText(label1);
			tx10.setBackgroundColor(dameColor(v));
		} else if (v.getId() == tx9.getId()) {
			tx2.setText(label1);
			tx10.setBackgroundColor(dameColor(v));
		}

	}

	 int dameColor(View v) {

		ColorDrawable col = (ColorDrawable) v.getBackground();
		int c = col.getColor();
		return c;
	}

}
