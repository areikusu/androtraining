package com.example.notificasino;

import java.util.ArrayList;
import java.util.Collections;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class Primera extends Activity implements OnItemSelectedListener, OnItemClickListener, OnClickListener, OnItemLongClickListener {
	EditText ed1;
	Button b1;
	Spinner s1;
	ListView l1;
	ArrayList<String> datos = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_primera);
		ed1 = (EditText)findViewById(R.id.editText1);
		b1 =(Button)findViewById(R.id.button1);
		s1 = (Spinner)findViewById(R.id.spinner1);
		l1 = (ListView)findViewById(R.id.listView1);
		l1.setOnItemLongClickListener(this);
		b1.setOnClickListener(this);
		s1.setOnItemSelectedListener(this);


		String[] comidas = getResources().getStringArray(R.array.Comidas);

		for(String s : comidas){
			datos.add(s);
		}
		Collections.sort(datos);
		ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,datos);
		adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);	


		//final String[] datos = new String[]{"Lunes","Martes","Miercoles","Jueves","Viernes"};
		 
		//String[] empresas = getResources().getStringArray(R.array.Empresas);
		ArrayAdapter<String> adaptador2 = new ArrayAdapter<String>(this, android.R.layout.simple_selectable_list_item, datos);
		s1.setAdapter(adaptador);
		l1.setAdapter(adaptador2);
		
		//l1.setOnItemClickListener(this);

	}


	public void onSaveInstanceState(Bundle b) {
		b.putStringArrayList("data", datos);

	}
	@Override
	public void onRestoreInstanceState(Bundle b) {


		this.datos = b.getStringArrayList("data");
		ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,datos);
		ArrayAdapter<String> adaptador2 = new ArrayAdapter<String>(this, android.R.layout.simple_selectable_list_item, datos);
		adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		s1.setAdapter(adaptador);
		l1.setAdapter(adaptador2);


	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.primera, menu);
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
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		Toast.makeText(getApplicationContext(),"Has seleccionado la posicion "+position, Toast.LENGTH_SHORT).show();

	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		Toast.makeText(getApplicationContext(),"Has seleccionado el ", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onClick(View v) {
		if (v.getId()== R.id.button1){
			if(ed1.getText().toString().isEmpty()){
				Toast.makeText(getApplicationContext(),"No has introducido nada", Toast.LENGTH_SHORT).show();
			}
			else if (datos.contains(ed1.getText().toString())){
				Toast.makeText(getApplicationContext(),"Ya existe.", Toast.LENGTH_SHORT).show();
			}
			else{
				datos.add(ed1.getText().toString());
				Collections.sort(datos);
				ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,datos);
				adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				s1.setAdapter(adaptador);
			}





		}
		// TODO Auto-generated method stub

	}


	@Override
	public boolean onItemLongClick(AdapterView<?> parent, View view,
			int position, long id) {
		// TODO Auto-generated method stub
		datos.remove(position);
		
		ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,datos);
		adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);	
		ArrayAdapter<String> adaptador2 = new ArrayAdapter<String>(this, android.R.layout.simple_selectable_list_item, datos);
		s1.setAdapter(adaptador);
		l1.setAdapter(adaptador2);
		return true;
	}
}
