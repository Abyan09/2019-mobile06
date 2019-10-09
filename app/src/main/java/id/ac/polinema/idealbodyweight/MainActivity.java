package id.ac.polinema.idealbodyweight;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import id.ac.polinema.fragments.AboutFragment;
import id.ac.polinema.fragments.BMIFragment;
import id.ac.polinema.fragments.BrocaIndexFragment;
import id.ac.polinema.fragments.MenuFragment;
import id.ac.polinema.fragments.ResultFragment;

public class MainActivity extends AppCompatActivity implements MenuFragment.OnFragmentInteractionListener,
        BrocaIndexFragment.OnFragmentInteractionListener,
		ResultFragment.OnFragmentInteractionListener,
		BMIFragment.OnFragmentInteractionListener{

	private MenuFragment menuFragment;
	private AboutFragment aboutFragment;
    private BrocaIndexFragment brocaIndexFragment;
	private ResultFragment resultFragment;
	private BMIFragment bmiFragment;
	// Deklarasikan atribut Fragment di sini

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		menuFragment = new MenuFragment();
		aboutFragment = AboutFragment.newInstance("Moch. Abyan An-nabhany");
        brocaIndexFragment = new BrocaIndexFragment();
		resultFragment = new ResultFragment();
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_container, menuFragment)
				.commit();
		bmiFragment = new BMIFragment();
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
				.addToBackStack(null)
				.commit();
	}

	@Override
	public void onBodyMassIndexButtonClicked() {
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_container, bmiFragment)
				.addToBackStack(null)
				.commit();
	}

    @Override
    public void onCalculateBrocaIndexClicked(float index) {
		resultFragment.setInformation(String.format("Your ideal weight is %.2f kg", index));
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_container, resultFragment)
				.replace(R.id.fragment_container, resultFragment, "BROCA")
				.commit();
    }

	@Override
	public void onTryAgainButtonClicked(String tag) {
		if (tag.equals("BROCA")) {
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.fragment_container, brocaIndexFragment)
					.commit();
		}else if(tag.equals("BMI")){
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.fragment_container, bmiFragment)
					.commit();
		}
	}

	@Override
	public void onCalculateBMIClicked(String result) {
		resultFragment.setInformation(String.format("Your healthy BMI range is "+result));
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_container, brocaIndexFragment)
				.replace(R.id.fragment_container, resultFragment, "BMI")
				.commit();
	}
}
