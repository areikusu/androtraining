package com.example.ej3;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Principal extends Activity implements OnClickListener {
	Button bA,bB;
	private int contadorA,contadorB;
	TextView txt1,txt2,txt3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_principal);
		this.contadorA = 0;
		this.contadorB = 0;
		this.txt1 = (TextView)findViewById(R.id.textView1);
		this.txt2 = (TextView)findViewById(R.id.textView2);
		this.txt3 = (TextView)findViewById(R.id.textView3);
		this.bA = (Button)findViewById(R.id.button1);
		this.bB = (Button)findViewById(R.id.button2);
		bA.setOnClickListener(this);
		bB.setOnClickListener(this);
		
	}
	public void onSaveInstanceState(Bundle b) {
		b.putInt("contadorA", this.contadorA);
		b.putInt("contadorB", this.contadorB);
		b.putString("texto",this.txt1.getText().toString());
		b.putString("last",this.txt2.getText().toString());
		b.putString("total", this.txt3.getText().toString());
		
		
		}
	public void onRestoreInstanceState(Bundle b) {
		super.onRestoreInstanceState(b);
		this.contadorA = b.getInt("contadorA");
		this.contadorB = b.getInt("contadorB");
		this.txt1.setText(b.getString("texto"));
		this.txt2.setText(b.getString("last"));
		this.txt3.setText(b.getString("total"));
		
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
		int id = v.getId();
		switch(id){
		case R.id.button1:
			contadorA++;
			txt1.setText("Llevas "+contadorA+" pulsaciones arriba.");
			txt2.setText("ARRIBA");
			txt3.setText("TOTAL: "+(contadorA+contadorB)+" pulsaciones.");
			break;
			
		case R.id.button2:
			contadorB++;
			txt1.setText("Llevas "+contadorB+" pulsaciones abajo.");
			txt2.setText("ABAJO");
			txt3.setText("TOTAL: "+(contadorA+contadorB)+" pulsaciones.");
			break;
		
		}
		
	}
}
