package es.upsam.supermercado.subastas.adapters;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import es.upsam.supermercado.subastas.R;
import es.upsam.supermercado.subastas.modelos.Subasta;

public class SubastaAdapter extends ArrayAdapter<Subasta>{

	private List<Subasta> subastas;
	
	public SubastaAdapter(Context context, List<Subasta> objects) {
		super(context, R.layout.subasta_item_row, objects);
		this.subastas = objects;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		View view = convertView;
		
		if(view == null){
			LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = inflater.inflate(R.layout.subasta_item_row, null);
		}
		
		Subasta subasta = subastas.get(position);
	
		if(subasta != null){
			
			TextView nombreProducto = (TextView) view.findViewById(R.id.nombreProducto);
			ImageView imagenProducto = (ImageView) view.findViewById(R.id.imagenProducto);
			TextView unidadesProducto = (TextView) view.findViewById(R.id.unidadesProducto);
			TextView numeroPujas = (TextView) view.findViewById(R.id.numeroPujas);
			TextView finPuja = (TextView) view.findViewById(R.id.finPuja);
			
			if(nombreProducto != null){
				nombreProducto.setText(subasta.getProducto().getNombreProducto());
			}
			
			if(imagenProducto != null){
				imagenProducto.setImageResource(R.drawable.food);
			}
			
			if(unidadesProducto != null){
				unidadesProducto.setText(String.valueOf(subasta.getUnidades())+" Unids");
			}
			
			if(numeroPujas != null){
				numeroPujas.setText(String.valueOf(subasta.getNumeroPujas()) +" Pujas");
			}
			
			if(finPuja != null){
				//Obtenemos el tiempo que falta para que la subasta acabe
				DateTime ahora = DateTime.now();
				DateTime finSubasta = new DateTime(subasta.getFechaFin());
				Period periodo = new Period(ahora,finSubasta, PeriodType.dayTime());
				PeriodFormatter formatter = new PeriodFormatterBuilder()
				        .appendDays().appendSuffix(" day ", "d ")
				        .appendHours().appendSuffix(" hour ", "h ")
				        .toFormatter();				
				finPuja.setText(formatter.print(periodo));
			}
			
		}
	
		return view;
		
	}
	
}
