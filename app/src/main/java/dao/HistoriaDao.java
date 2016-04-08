package dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import modelo.Historia;

/**
 * Created by Aluno on 01/04/2016.
 */
public class HistoriaDao {
    private static HistoriaDao hDAO; // objeto da pr�pria classe
    private final Context context; // o contexto da aplica��o
    private DBHelper myHelper; // objeto que auxilia na cria��o e/ou upgrade do
    // banco de dados
    private SQLiteDatabase database; // objeto de conex�o com o banco de dados

    private HistoriaDao(Context context) {
        this.context = context; // recebe o contexto da Activity que o chamou
    }

    public static HistoriaDao getInstance(Context context) {
        if (hDAO == null) {
            hDAO = new HistoriaDao(context);
            return hDAO;
        }
        return hDAO;
    }

    public HistoriaDao open() {
        myHelper = DBHelper.getInstance(context); // inst�ncia um objeto que
        // auxilia na cria��o e/ou
        // atualiza��o
        database = myHelper.getWritableDatabase(); // devolve uma conex�o para o
        // banco de dados
        return this; // retorna a conex�o para o banco de dados
    }

    public void close() {
        database.close(); // libera o recurso
    }

    boolean inserir(Historia h) {
        ContentValues hvalores = new ContentValues(); // objeto tupla (label
        // da coluna, valor)
        hvalores.put(Contract.Historia.COLUNA_NOME, h.getNome());
        hvalores.put(Contract.Historia.COLUNA_DATA, h.getData());
        hvalores.put(Contract.Historia.COLUNA_DESC, h.getDesc());
        hvalores.put(Contract.Historia.COLUNA_IMAGEM, h.getImagem());
        database.insertOrThrow(Contract.Cartas.TABELA_NOME, null, hvalores);
        Log.i("tcc", "Executou o script de criar/inserir na tabela "
                + Contract.Cartas.TABELA_NOME);

        return true; // se inseriu
    }

    public Cursor getHistoria() {
        // retorna o Cursor para os registros contidos no banco de dados
        return database.rawQuery("SELECT  * FROM " + Contract.Historia.TABELA_NOME, null);
    }

    /*public ArrayList<Carta> getListaImagensImperiais() {
        // retorna o Cursor para os registros contidos no banco de dados
        Cursor cursor;
        cursor = database.rawQuery(SQL_SELECT_TIPO_IMPERIAL, null);

        ArrayList<Carta> cartas = new ArrayList<Carta>();
        while (cursor.moveToNext()) {
            Carta carta = new Carta();
            carta.setImagem_carta(cursor.getInt(cursor.getColumnIndexOrThrow("id_imagem")));
            carta.setPila(cursor.getInt(cursor.getColumnIndexOrThrow(Contract.Cartas.COLUNA_PILA)));
            carta.setAtaque(cursor.getInt(cursor.getColumnIndexOrThrow(Contract.Cartas.COLUNA_ATAQUE)));
            carta.setDefesa(cursor.getInt(cursor.getColumnIndexOrThrow(Contract.Cartas.COLUNA_DEFESA)));
            cartas.add(carta);

        }
        return cartas;
    }*/
}
