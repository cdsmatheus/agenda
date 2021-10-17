package com.cdsmatheus.agenda;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.cdsmatheus.agenda.R;
import com.cdsmatheus.agenda.control.database;
import com.cdsmatheus.agenda.model.contato;
public class MainActivity extends Activity {

	//Instancia os objetos como classes
	public Button btnCadastrar;
	public EditText txtNome;
	public EditText txtTelefone;
	public EditText txtCelular;
	public EditText txtEndereco;
	public database db;
	
	@Override
	//Evento de criação dos Itens
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Associa as classes com os itens da interface
		btnCadastrar = (Button)findViewById(R.id.btnCadastrar);
		txtNome = (EditText)findViewById(R.id.txtNome);
		txtTelefone = (EditText)findViewById(R.id.txtTelefone);
		txtCelular=(EditText)findViewById(R.id.txtCelular);
		txtEndereco=(EditText)findViewById(R.id.txtEndereco);
		db = new database(this);
		AddData();
		
		//Evento de clique do Botão
		
			
	}
	public void AddData() {
		btnCadastrar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//Instância a classe de Modelo
				contato model = new contato();
				//Define os valores do modelo de contato
				model.setCelular(txtCelular.getText().toString());
				model.setEndereco(txtEndereco.getText().toString());
				model.setNome(txtNome.getText().toString());
				model.setTelefone(txtTelefone.getText().toString());
				
				if (db.cadastraContato(model)==true) {
					Toast.makeText(MainActivity.this,"Contato Cadastrado",Toast.LENGTH_LONG).show();
				}
				else
				{
					Toast.makeText(MainActivity.this,"Não foi possível fazer o cadastro",Toast.LENGTH_LONG).show();
				}	
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}	
}
