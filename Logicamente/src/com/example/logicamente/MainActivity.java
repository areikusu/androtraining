package com.example.logicamente;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener,
		OnLongClickListener {
	Button b1;
	TextView t;
	int counter = 0;

	@Override
	protected void onCreate(Bundle b) {
		super.onCreate(b);
		if(getIntent()!=null){
			counter = getIntent().getIntExtra("puntos", 0);
		}
		setContentView(R.layout.activity_main);
		b1 = (Button) findViewById(R.id.button1);
		b1.setOnClickListener(this);
		b1.setOnLongClickListener(this);
		t = (TextView) findViewById(R.id.textView1);
		t.setText(counter + "");
	}

	public void onSaveInstanceState(Bundle b) {
		super.onSaveInstanceState(b);
		b.putInt("cont", this.counter);

	}

	public void onRestoreInstanceState(Bundle b) {
		super.onRestoreInstanceState(b);
		this.counter = b.getInt("cont");
		t.setText(counter + "");

	}

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

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.button1) {

			counter++;
			t.setText(counter + "");

			if (counter % 3 == 0) {
				NotificationCompat.Builder mBuild = new NotificationCompat.Builder(
						getApplicationContext());
				NotificationManager nMmgr = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
				Intent reseteo = new Intent(this, MainActivity.class);
				reseteo.putExtra("puntos", counter);
				PendingIntent pi1 = PendingIntent.getActivity(this, 0, reseteo, PendingIntent.FLAG_UPDATE_CURRENT);
				mBuild.setContentTitle("3 más.");
				mBuild.setContentText("Llevas " + counter + " lógicamentes.");
				mBuild.setSmallIcon(R.drawable.ic_launcher);
				mBuild.setContentIntent(pi1);
				mBuild.setAutoCancel(true);				
				nMmgr.notify(1, mBuild.build());
				finish();
			}
		}
	}

	@Override
	public boolean onLongClick(View v) {
		// TODO Auto-generated method stub
		if (v.getId() == R.id.button1) {
			counter = 0;
			t.setText(counter + "");
		}

		return true;
	}

}