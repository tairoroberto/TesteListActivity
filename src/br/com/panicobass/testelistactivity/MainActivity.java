package br.com.panicobass.testelistactivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

//Classe extend ListActivity
public class MainActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// ListActivity já implementa uma view
		// Então não é necessario chamar o methodo setContentVeiw();
		// setContentView(R.layout.activity_main);

		// Temos que implementar um array de Strings para passar os nomes que
		// estrão na lista
		String[] ativities = new String[] { "Activity 1", "Activity 2", "Sair" };

		// Declaramos um adapter para preencher nossa lista
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, ativities);

		// Passamos nosso adapter para ser mostrado na tela
		setListAdapter(adapter);
	}

	// Método para pegar o evento de clique da lista
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		Toast.makeText(this,
				this.getListAdapter().getItem(position).toString(),
				Toast.LENGTH_SHORT).show();

		switch (position) {
		//caso poisição == 0 chama a activity 1
		case 0:
			acessarActivity1(v);
			break;
		//caso poisição == 1 chama a activity 1
		case 1:
			acessarActivity2(v);
			break;
			//caso poisição == 2 sai da aplicação
		case 2:
			sair(v);
			break;
		default:
			break;
		}
	}

	// Método para acessar a activity 1
	public void acessarActivity1(View view) {
		Intent intent = new Intent(MainActivity.this, Activity1.class);
		startActivity(intent);
	}

	// Método para acessar a activity 2
	public void acessarActivity2(View view) {
		Intent intent = new Intent(MainActivity.this, Activity2.class);
		startActivity(intent);
	}

	// Método para sair da app
	public void sair(View view) {
		finish();
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
