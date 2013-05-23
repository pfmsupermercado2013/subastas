package es.upsam.supermercado.subastas.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import es.upsam.supermercado.subastas.DetallesSubastaActivity;
import es.upsam.supermercado.subastas.R;
import es.upsam.supermercado.subastas.modelos.Subasta;

public class DetallesSubastaFragment extends Fragment{
	
	Subasta subasta;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.subasta_detalles_fragment, container, false);
		return view;
	}
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.subasta = ((DetallesSubastaActivity)getActivity()).getSubasta();
		System.out.println(subasta.getProducto().getNombreProducto());
	}
	
}
