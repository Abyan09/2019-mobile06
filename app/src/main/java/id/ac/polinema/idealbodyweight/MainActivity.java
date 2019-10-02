package id.ac.polinema.idealbodyweight;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import id.ac.polinema.fragments.AboutFragment;
import id.ac.polinema.fragments.BrocaIndexFragment;
import id.ac.polinema.fragments.MenuFragment;

public class MainActivity extends AppCompatActivity implements MenuFragment.OnFragmentInteractionListener,
        BrocaIndexFragment.OnFragmentInteractionListener{

	private MenuFragment menuFragment;
	private AboutFragment aboutFragment;
    private BrocaIndexFragment brocaIndexFragment;
	// Deklarasikan atribut Fragment di sini

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		menuFragment = new MenuFragment();
		aboutFragment = AboutFragment.newInstance("Moch. Abyan An-nabhany");
        brocaIndexFragment = new BrocaIndexFragment();
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_container, menuFragment)
				.commit();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu, menu);
		return  true;
	}

	@Override
	public boolean onOptionsItemSelected(@NonNull MenuItem item) {
		// TODO: Tambahkan penanganan menu di sini
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_container, aboutFragment)
				.addToBackStack(null)
				.commit();
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onBrocaIndexButtonClicked() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, brocaIndexFragment)
                .commit();
	}

	@Override
	public void onBodyMassIndexButtonClicked() {

	}

    @Override
    public void onCalculateBrocaIndexClicked(float index) {

    }
}
