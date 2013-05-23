package es.upsam.supermercado.subastas;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import es.upsam.supermercado.subastas.adapters.SubastaAdapter;
import es.upsam.supermercado.subastas.modelos.Producto;
import es.upsam.supermercado.subastas.modelos.Subasta;

public class MainActivity extends FragmentActivity {

	SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


		// Create the adapter that will return a fragment for each of the three
		// primary sections of the app.
		mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);

	}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		/**
		 * Instancia el fragment correspondiente a la pagina indicada en el argumento del metodo.
		 * 
		 * @param position. Indica la pagina seleccionada.
		 * @return Fragment. Devuelve el fragment correspondiente.
		 */
		@Override
		public Fragment getItem(int position) {
			Fragment fragment;
			switch (position) {
			case 1:
				fragment = new ProductosSubastaListFragement();
				break;
			default:
				fragment = new DummySectionFragment();
				Bundle args = new Bundle();
				args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, position + 1);
				fragment.setArguments(args);
				break;
			}
			return fragment;
		}

		@Override
		public int getCount() {
			// En total existen 3 paginas en la aplicacion (Productos en subastas, Subastas activas y mis pujas).
			return 3;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			Locale l = Locale.getDefault();
			switch (position) {
			case 0:
				return getString(R.string.titulo_seccion_subastas).toUpperCase(l);
			case 1:
				return getString(R.string.titulo_seccion_pujas_activas).toUpperCase(l);
			case 2:
				return getString(R.string.titulo_seccion_mis_pujas).toUpperCase(l);
			}
			return null;
		}
	}

	/**
	 * A dummy fragment representing a section of the app, but that simply
	 * displays dummy text.
	 */
	public static class DummySectionFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		public static final String ARG_SECTION_NUMBER = "section_number";

		public DummySectionFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main_dummy, container, false);
			TextView dummyTextView = (TextView) rootView.findViewById(R.id.section_label);
			dummyTextView.setText(Integer.toString(getArguments().getInt(ARG_SECTION_NUMBER)));
			return rootView;
		}
	}


	public static class ProductosSubastaListFragement extends ListFragment{

		private List<Subasta> subastas;
		
		@Override
		public void onActivityCreated(Bundle savedInstanceState) {		
			super.onActivityCreated(savedInstanceState);
			
			//TODO: Recuperar las subastas desde el servidor (AsynTask)
			subastas = new ArrayList<Subasta>();
			Producto producto = new Producto();
			producto.setNombreProducto("Jamón Serrano");
			producto.setIdProducto(1);
			Subasta subasta = new Subasta();
			subasta.setProducto(producto);
			subasta.setUnidades(100);
			subasta.setNumeroPujas(5);
			Calendar finSubasta = new GregorianCalendar();
			finSubasta.set(2013, 06, 06);
			subasta.setFechaFin(finSubasta.getTime());
			subastas.add(subasta);
			SubastaAdapter subastaAdapter = new SubastaAdapter(getActivity(), subastas);
			setListAdapter(subastaAdapter);
		}
		
		@Override
		public void onListItemClick(ListView l, View v, int position, long id) {
			super.onListItemClick(l, v, position, id);
			Intent intent = new Intent(getActivity(),DetallesSubastaActivity.class);
			Bundle bundle = new Bundle();
			bundle.putSerializable(Constantes.ELEMENTO_EN_SUBASTA, subastas.get(position));
			intent.putExtras(bundle);
			getActivity().startActivity(intent);
		}

	}

}
