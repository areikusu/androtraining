package dam.pmdm.rotacioii;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.EditText;
import android.widget.NumberPicker;

public class Inici extends Activity {

	//meter objeto numberpicker y editext variables
		NumberPicker npR, npG;
		EditText edt;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_inici);
		
		Log.d("hola","Executant el onCreate");
		
		edt=(EditText) findViewById(R.id.et_Nom);
		npG=(NumberPicker)findViewById(R.id.np_TG);
		npG.setMinValue(0);
		npG.setMaxValue(2);
		
		npR=(NumberPicker)findViewById(R.id.np_TR); 
		npR.setMinValue(0);
		npR.setMaxValue(1);
	}
	public void onSaveInstanceState(Bundle outState) {
		outState.putInt("roja",npR.getValue());
		outState.putInt("amarilla",npG.getValue());
		
		}
	public void onRestoreInstanceState(Bundle b) {
		super.onRestoreInstanceState(b);
		npR.setValue(b.getInt("roja"));
		npG.setValue(b.getInt("amarilla"));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.inici, menu);
		return true;
	}

}
