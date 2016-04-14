package com.example.testapp;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class AccountActivity extends Activity {

	private TextView txtBienvenue, txtMontant;
	private ListView listViewDestinataires;
	private List<String> listDestinataires = new ArrayList<String>();
	private Button btnValider;
	private SeekBar seekbarMontant;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_account);
		
		//On initialise les composants
		this.txtBienvenue = (TextView) this.findViewById(R.id.txtBienvenue);
		this.btnValider = (Button) this.findViewById(R.id.btnConnexion);
		this.seekbarMontant = (SeekBar) this.findViewById(R.id.seekBarChoixMontant);
		this.txtMontant = (TextView) this.findViewById(R.id.montantChoisi);
		
		this.seekbarMontant.setMax(99);
		this.seekbarMontant.setProgress(50);
		
		//On récupère le login mis dans l'extra de l'intent
		String loginUser = getIntent().getExtras().get("login").toString();
		
		//ON cache la barre d'action
		this.getActionBar().hide();
		
		//On affiche un message personnalisé avec le prénom de bienvenue
		this.txtBienvenue.setText("Bienvenue, "+loginUser+" sur votre compte !");
		
		
		//On ajoute des destinataire à l'arraylist
		this.listDestinataires.add("Clément");
		this.listDestinataires.add("Stéphane");
		this.listDestinataires.add("Ludovic");
		this.listDestinataires.add("Albert");
		
		//On défini et remplis la listView
		this.listViewDestinataires = (ListView) this.findViewById(R.id.listDestinataire);
		
		//On ajoute la liste des destinataires à la listview
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(AccountActivity.this, android.R.layout.simple_list_item_1, this.listDestinataires);
		this.listViewDestinataires.setAdapter(arrayAdapter);
		
		//On ititialise les listener
		this.initListener();
		
		
		//Affiche un toast en bas de la page
		//Toast.makeText(getApplicationContext(), "SALUT", Toast.LENGTH_LONG).show();	
	}
	
	
	
	//Méthode qui initialise les listener sur les composants de la page
	private void initListener(){
		
		this.seekbarMontant.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				AccountActivity.this.txtMontant.setText(1+progress+"€");
				
			}
		});
	}
}
