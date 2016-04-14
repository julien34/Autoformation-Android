package com.example.testapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

	//On déclare les composants de la vue
	private Button btnConnexion;
	private EditText txtLogin, txtPassword;
	
	
	/**
	 * Méthode qui se lance au démarrage de l'activité
	 * */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//On attribut les composants xml à des objets java
		this.btnConnexion = (Button) findViewById(R.id.btnConnexion);
		this.txtLogin = (EditText) findViewById(R.id.txtLogin);
		this.txtPassword = (EditText) findViewById(R.id.txtPassword);
		
		//On ajoute un listener sur le bouton de connexion
		this.btnConnexion.setOnClickListener(this);
		
		//Masque la barre du haut
		getActionBar().hide();
	}
	
	
	//Méthode qui check si la combinaison login / pass est correcte.
	private void checkLogin(String login, String password){
		
		if (login.equals("julien") && password.equals("test")){
			
			//On lance une autre activité avec un intent
			Intent monCompte = new Intent(MainActivity.this, AccountActivity.class);
			
			//On ajout des extras à l'activité (login et mdp)
			monCompte.putExtra("login", login);
			monCompte.putExtra("password", password);
			
			startActivity(monCompte);
		}
		else {
			this.afficherMsgErreur("Ces login / mot de passe ne sont pas corrects.");
		}
	}
	
	
	//Méthode qui affiche un message d'erreur
	private void afficherMsgErreur(String msg){
		
		//On récupère le textView du message d'erreur qui est vide et on lui change la valeur
		TextView msgErreur = (TextView) findViewById(R.id.txtMsgErreur);
		msgErreur.setText("Login ou mot de passe incorrect");
	}
	
	
	/**
	 * Méthode qui écoute les différents composants.
	 * */
	@Override
	public void onClick(View v) {
		
		//Selon l'id du bouton cliqué :
		switch(v.getId()){
		
		//Bouton de connexion
		case R.id.btnConnexion :
			
			//On récupère les login et mot de passe
			String login = this.txtLogin.getText().toString();
			String password = this.txtPassword.getText().toString();
			
			//On les teste
			this.checkLogin(login, password);
			break;
		}
		
	}
}
