package com.dam.intenciones;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;

public class Principal extends Activity implements OnClickListener, OnCheckedChangeListener, android.widget.CompoundButton.OnCheckedChangeListener, OnEditorActionListener{
	private static final int REQUEST_TEXT = 0;
	EditText e1, e2;
	RadioGroup rG;
	RadioButton rM, rF;
	Switch sW1;
	RatingBar rB;
	Button enDa;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//Elementos del Layout que hay que obtener info o añadir listener
		setContentView(R.layout.activity_principal);
		e1=(EditText)findViewById(R.id.editText1);
		e2=(EditText)findViewById(R.id.editText2);
		
		rG=(RadioGroup)findViewById(R.id.radioGroup1);
		rM=(RadioButton)findViewById(R.id.radio0);
		rM=(RadioButton)findViewById(R.id.radio1);
		
		sW1=(Switch)findViewById(R.id.switch1);
		rB=(RatingBar)findViewById(R.id.ratingBar1);
		
		enDa=(Button)findViewById(R.id.button1);
		e1.setOnEditorActionListener(this);
		e2.setOnClickListener(this);
		
		rG.setOnClickListener(this);
		rG.setOnCheckedChangeListener(this);
		
		sW1.setOnCheckedChangeListener(this);
		sW1.setOnClickListener(this);
		
		enDa.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.principal, menu);
		return true;
	}

	/*@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}*/

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		//codigo usado en la version que comprueba al hacer clich sobre editext 2 comprobando la longitud del texto de editext 1 para recibir foco en caso de ser mayor que 0
	/*	case R.id.editText2 :
			if(e1.getText().length()<=0){
				Toast.makeText(getApplicationContext(),"introduce primero el nombre", Toast.LENGTH_SHORT).show();
			}
			else{
				e2.setFocusableInTouchMode(true);
			}	
			break;*/
		case R.id.radioGroup1 :
			if(e1.getText().length()<=0||e2.getText().length()<=0){
				//en caso de no estar rellenos los editext no deja continuar
				Toast.makeText(getApplicationContext(),"Completa los campos anteriores", Toast.LENGTH_SHORT).show();
			}
			
			
			break;
		case R.id.switch1 :
			if(e1.getText().length()<=0||e2.getText().length()<=0){
				//en caso de no estar rellenos los editext no deja continuar
				Toast.makeText(getApplicationContext(),"Completa los campos anteriores", Toast.LENGTH_SHORT).show();
			}	
			break;
		case R.id.button1 :
			if(e1.getText().length()<=0||e2.getText().length()<=0){
				//en caso de no estar rellenos los editext no deja continuar
				Toast.makeText(getApplicationContext(),"Completa los campos anteriores", Toast.LENGTH_SHORT).show();
			}
			else{
				//si estan los editext con datos lanza la segunda actividad con los resultados
				Intent i = new Intent(Principal.this , Resultados.class);
				i.putExtra("nombre", e1.getText().toString());
				i.putExtra("telefono", e2.getText().toString());
				i.putExtra("sexo", rG.getCheckedRadioButtonId());
				i.putExtra("carnet", sW1.isChecked());
				i.putExtra("punts", rB.getProgress());
				Principal.this.startActivity(i);
				//Codigo utilizado en la version que cierra todo al finalizar en la segunda activity
				//Principal.this.startActivityForResult(i,REQUEST_TEXT);
				
			}
			break;
		
		}		
	}
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		//cambia de mayusculas a minusculas
		if(checkedId == R.id.radio0){
			e1.setText(e1.getText().toString().toLowerCase());
		}
		else{
			e1.setText(e1.getText().toString().toUpperCase());
		}
		
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		// Setea el valor del rating o numero de estrellas
		if(isChecked){
			rB.setRating(3.0f);
		}else{
			rB.setRating(0.0f);
		}
		
	}

	@Override
	public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
		// TODO Auto-generated method stub
		e2.setFocusableInTouchMode(true);
		return true;
	}
	//Codigo utilizado en la version que cierra todo al finalizar en la segunda activity
	@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
         if ( requestCode == REQUEST_TEXT ){
              if ( resultCode == Activity.RESULT_OK ){
                   Principal.this.finish();
              }
         }


}
	}
