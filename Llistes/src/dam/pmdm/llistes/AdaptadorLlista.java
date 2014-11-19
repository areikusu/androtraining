package dam.pmdm.llistes;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class AdaptadorLlista extends BaseAdapter {
	private Context context;
	private int idLayout;
	private ArrayList <?> entrades;
	
	public AdaptadorLlista (Context context, int idLayout, ArrayList<?> entrades) { 
		super();  
		this.context = context; 
		this.entrades = entrades; 
		this.idLayout = idLayout; 
	 }

	@Override
	//ens indica el numero d'entrades que hi ha en l'arrayList
	public int getCount() {
		// TODO Auto-generated method stub
		return entrades.size();
	}

	@Override
	//torna l'Element position de l'arrayList
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return entrades.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		 return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// Mètode que em torna un Objecte View amb la imatge i els textos necessaris
		if (convertView == null) { //convertView és un objecte Layout que inicialment esta a null
			// Necessitem un Layout que dins continga un horitzontalLayout, amb un ImageView, un verticalLayout, i dos TextView
		    LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE); 
		    convertView = vi.inflate(idLayout, null); //ConvertView és eixe Layout però sense les dades
	    }
		//El mètode onEntrada ens ompli les dades del layout amb un element estret de l'ArrayList que conté les dades
		 onEntrada (entrades.get(position), convertView);
		 // Tornem eixe View amb les dades plenes.
		return convertView;
	}
	
	 // Mètode abstracte que ens omplirà les dades del View amb les dades del ArrayList
	 public abstract void onEntrada (Object entrada, View view);
	 
}
