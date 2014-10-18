package com.logipop;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity implements OnClickListener , OnLongClickListener   {
	Button b1;
	TextView t;
	int counter=0;
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.button1);
        b1.setOnClickListener(this);
        b1.setOnLongClickListener(this);
        t=(TextView)findViewById(R.id.textView1);
    }
    public void onSaveInstanceState(Bundle b) {
		super.onSaveInstanceState(b);
		b.putInt("cont",this.counter);
		
		}
	public void onRestoreInstanceState(Bundle b) {
		super.onRestoreInstanceState(b);
		this.counter = b.getInt("cont");
		t.setText(counter+"");
		
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
 		if(v.getId()==R.id.button1){
 			counter++;
 			t.setText(counter+"");
 		}	
	}
	@Override
	public boolean onLongClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId()==R.id.button1){
			counter=0;
 			t.setText(counter+"");
 		}
		
		return true;
	}}
