package aulas.ddmi.jogotcc_roger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import adapter.CampanhaAdapter;
import dao.Contract;
import dao.HistoriaDao;

/**
 * Created by roger_000 on 02/03/2016.
 */
public class Campanha extends Activity {

    private HistoriaDao hDAO;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campanha);
        Log.d("Campanha", "Executou onCreate() na classe Campanha");

        hDAO = HistoriaDao.getInstance(this);
        hDAO.open();

        ListView listView = (ListView) findViewById(R.id.lvdatas);
        final String[] DE = {Contract.Historia.COLUNA_DATA, Contract.Historia.COLUNA_NOME}; //DE (colunas presentes no Cursor)
        final int[] PARA = {R.id.txtdata, R.id.txtnome} ;


        CampanhaAdapter dadosAdapter = new adapter.CampanhaAdapter(
                Campanha.this, //contexto da aplicação
                R.layout.campanha_adapter, //layout de cada item do GridView
                hDAO.getHistoria(), //cursor (resultante de uma consulta no banco de dados)
                DE,
                PARA,
                0);

        //associa o adaptador a GridView
        listView.setAdapter(dadosAdapter);
    }

    @Override
    public void onBackPressed() {
        Intent it = new Intent(Campanha.this, InicialActivity.class);
        startActivity(it);
    }

    public void verHistoria(View view){
        Intent it = new Intent(Campanha.this, Historia.class);
        startActivity(it);
    }
}
