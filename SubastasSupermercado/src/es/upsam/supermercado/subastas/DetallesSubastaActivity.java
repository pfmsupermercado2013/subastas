package es.upsam.supermercado.subastas;

import es.upsam.supermercado.subastas.modelos.Subasta;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class DetallesSubastaActivity extends FragmentActivity{

	private Subasta subasta;
	
	public Subasta getSubasta() {
		return subasta;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle b = this.getIntent().getExtras();
		if(b!=null){
			subasta = (Subasta) b.getSerializable(Constantes.ELEMENTO_EN_SUBASTA);
		}
		setContentView(R.layout.activity_detalles_subasta);
	}
	
}