package com.dam.intenciones;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

@SuppressWarnings("unused")
public class Resultados extends Activity implements OnClickListener {
	TextView t1, t2, t3, t4;
	Button b1;
	ImageView img;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_resultados);
		b1 = (Button) findViewById(R.id.button1);
		b1.setOnClickListener(this);
		t1 = (TextView) findViewById(R.id.textView2);
		t2 = (TextView) findViewById(R.id.textView4);
		t3 = (TextView) findViewById(R.id.textView6);
		t4 = (TextView) findViewById(R.id.textView8);
		img = (ImageView) findViewById(R.id.imageView1);
		t1.setText(getIntent().getExtras().getString("nombre").toString());
		t2.setText(getIntent().getExtras().getString("telefono").toString());
		t4.setText(getIntent().getExtras().getFloat("punts") + "");
		if (getIntent().getExtras().getInt("sexo") == R.id.radio0) {
			img.setImageResource(R.drawable.mascle);
		} else {
			img.setImageResource(R.drawable.femella);
		}

		if (getIntent().getBooleanExtra("carnet", true)) {
			t3.setText("SI");
		} else {
			t3.setText("NO");
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.resultados, menu);
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
			Resultados.this.finish();
		}

	}
	// Codigo utilizado en la version que cierra todo al finalizar en la segunda activity
	/*
	 * @Override public void onClick(View v) { 
	 * stub if (v.getId() == R.id.button1) { Intent i = new
	 * Intent(Resultados.this, Principal.class); setResult(Activity.RESULT_OK,
	 * i); Resultados.this.finish(); }
	 * 
	 * }
	 */
}
