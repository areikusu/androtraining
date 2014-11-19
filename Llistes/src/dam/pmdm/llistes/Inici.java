package dam.pmdm.llistes;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Inici extends Activity {
	
	
	private ListView laLlista;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.llista);

		
		ArrayList<Element> dadesLlista = new ArrayList<Element>();
		dadesLlista.add(new Element(R.drawable.pumpkin_amazed, "Dilluns","Primer dia de la setmana"));
		dadesLlista.add(new Element(R.drawable.pumpkin_angry, "Dimarts","Segon dia de la setmana"));
		dadesLlista.add(new Element(R.drawable.pumpkin_in_love, "Dimecres","Tercer dia de la setmana"));
		dadesLlista.add(new Element(R.drawable.pumpkin_happy, "Dijous","Quart dia de la setmana"));

		laLlista= (ListView) findViewById(R.id.llista);
		
		
		laLlista.setAdapter(new AdaptadorLlista(this, R.layout.element, dadesLlista){
			
			public void onEntrada(Object entrada, View view) {
		        if (entrada != null) {
		            TextView text_sup_entrada = (TextView) view.findViewById(R.id.text_superior); 
		            if (text_sup_entrada != null) 
		            	text_sup_entrada.setText(((Element) entrada).getTextSuperior()); 

		            TextView text_inf_entrada = (TextView) view.findViewById(R.id.text_inferior); 
		            if (text_inf_entrada != null)
		            	text_inf_entrada.setText(((Element) entrada).getTextInferior()); 

		            ImageView imatge_entrada = (ImageView) view.findViewById(R.id.imatge); 
		            if (imatge_entrada != null)
		            	imatge_entrada.setImageResource(((Element) entrada).getIdImatge());
		        }
			}
		});
		
		 // Li afegim un lisener per a quan seleccionem algun element de la llista.
		 laLlista.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) {
				 
				TextView ts = (TextView) arg1.findViewById(R.id.text_superior);
				 TextView ti = (TextView) arg1.findViewById(R.id.text_inferior);
				 ImageView iv = (ImageView) arg1.findViewById(R.id.imatge);
				 
				Toast.makeText(arg1.getContext(), "Has seleccionat "+ts.getText()+"\n"+ti.getText(), Toast.LENGTH_SHORT).show();				

				/*
				//Unflem el layout que utilitzar� el Toast
				 LayoutInflater vi = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE); 
				 View toastView = vi.inflate(R.layout.element, null); //toastView �s el Layout d'un element, per� sense les dades

				 toastView.setBackgroundColor(Color.BLUE);
				 //Necessitem fer-ho d'aquesta Manera, ja que un View (arg1) nom�s pot dindre un pare, i en este cas �s l'adaptador 
				 
				 
				 
				 TextView tos = (TextView) toastView.findViewById(R.id.text_superior);
				 TextView toi = (TextView) toastView.findViewById(R.id.text_inferior);
				 ImageView tiv = (ImageView) toastView.findViewById(R.id.imatge);
				 				 
				 tos.setText(ts.getText().toString());
				 toi.setText(ti.getText().toString());
				 tiv.setImageResource(iv.getId());
				 
				 // Creem el Toast
				 Toast t = new Toast(Inici.this);
				 				 
				 t.setDuration(Toast.LENGTH_SHORT);
				 t.setGravity(Gravity.BOTTOM, 0, 0);
				
				 t.setView(toastView);
				 t.show();
				 */
			}	 
		 });
		 
		 
		
	}
		

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_inici, menu);
		return true;
	}

}
