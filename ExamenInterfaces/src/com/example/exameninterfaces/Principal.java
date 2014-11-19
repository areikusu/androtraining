package com.example.exameninterfaces;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
/**
 * 
 * @author Aleix Casanova @areikusu aleix.casanova@gmail.com
 *
 */
public class Principal extends Activity implements OnClickListener {
	ArrayList<CheckBox> checkList;
	TextView txt1,txt2;
	CheckBox ch1;
	CheckBox ch2;
	CheckBox ch3;
	CheckBox ch4;
	CheckBox ch5;
	CheckBox ch6;
	CheckBox ch7;
	CheckBox ch8;
	CheckBox ch9;
	CheckBox ch10;
	CheckBox ch11;
	CheckBox ch12;
	Button b1;
	Button b2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_principal);
		ch1 = (CheckBox)findViewById(R.id.checkBox1);
		ch2 = (CheckBox)findViewById(R.id.checkBox2);
		ch3 = (CheckBox)findViewById(R.id.checkBox3);
		ch4 = (CheckBox)findViewById(R.id.checkBox4);
		ch5 = (CheckBox)findViewById(R.id.checkBox5);
		ch6 = (CheckBox)findViewById(R.id.checkBox6);
		ch7 = (CheckBox)findViewById(R.id.checkBox7);
		ch8 = (CheckBox)findViewById(R.id.checkBox8);
		ch9 = (CheckBox)findViewById(R.id.checkBox9);
		ch10 = (CheckBox)findViewById(R.id.checkBox10);
		ch11 = (CheckBox)findViewById(R.id.checkBox11);
		ch12 = (CheckBox)findViewById(R.id.checkBox12);

		txt1 = (TextView)findViewById(R.id.textView1);
		txt2 = (TextView)findViewById(R.id.textView2);

		checkList = new ArrayList<CheckBox>();
		checkList.add(ch1);
		checkList.add(ch2);
		checkList.add(ch3);
		checkList.add(ch4);
		checkList.add(ch5);
		checkList.add(ch6);
		checkList.add(ch7);
		checkList.add(ch8);
		checkList.add(ch9);
		checkList.add(ch10);
		checkList.add(ch11);
		checkList.add(ch12);

		b1 = (Button)findViewById(R.id.button1);
		b1.setOnClickListener(this);
		b2 = (Button)findViewById(R.id.button2);
		b2.setOnClickListener(this);

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
		int conta = 0;
		if (v.getId() == R.id.button1){

			for(CheckBox ck : checkList){
				if(ck.isChecked()){
					conta++;
				} 
			}
			if (conta == 0){
				txt2.setText("");
			}
			else if (conta == 1){
				txt2.setText("Has marcado 1 mes");
			}
			else if (conta > 1){
				txt2.setText("Has marcado "+conta+" meses.");
			}

		}
		if(v.getId()==R.id.button2){
			for(CheckBox ck : checkList){
				ck.setChecked(false);
				txt2.setText("");
				} 
		}

	}
}
