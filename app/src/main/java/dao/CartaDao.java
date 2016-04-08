package dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.util.ArrayList;

import aulas.ddmi.jogotcc_roger.R;
import modelo.Carta;


/**
 * Created by Aluno on 10/03/2016.
 */
public class CartaDao {
    // atributos e/ou constantes da classe
    private static CartaDao cartaDAO; // objeto da pr�pria classe
    private final Context context; // o contexto da aplica��o
    private DBHelper myHelper; // objeto que auxilia na cria��o e/ou upgrade do
    // banco de dados
    private static final String SQL_SELECT_TIPO = "SELECT * FROM cartas WHERE tipo = 'farroupilha'";
    private static final String SQL_SELECT_TIPO_IMPERIAL = "SELECT * FROM cartas WHERE tipo = 'imperial'";
    private SQLiteDatabase database; // objeto de conex�o com o banco de dados

    private CartaDao(Context context) {
        this.context = context; // recebe o contexto da Activity que o chamou
    }

    public static CartaDao getInstance(Context context) {
        if (cartaDAO == null) {
            cartaDAO = new CartaDao(context);
            return cartaDAO;
        }
        return cartaDAO;
    }

    public CartaDao open() {
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

    boolean inserir(Carta carta) {
        ContentValues cartavalores = new ContentValues(); // objeto tupla (label
        // da coluna, valor)
        cartavalores.put(Contract.Cartas.COLUNA_NOME, carta.getNome());
        cartavalores.put(Contract.Cartas.COLUNA_TIPO, carta.getTipo());
        cartavalores.put(Contract.Cartas.COLUNA_PILA, carta.getPila());
        cartavalores.put(Contract.Cartas.COLUNA_ATAQUE, carta.getAtaque());
        cartavalores.put(Contract.Cartas.COLUNA_DEFESA, carta.getDefesa());
        cartavalores.put(Contract.Cartas.COLUNA_IMAGEM, carta.getImagem_carta());
        database.insertOrThrow(Contract.Cartas.TABELA_NOME, null, cartavalores);
        Log.i("tcc", "Executou o script de criar/inserir na tabela "
                + Contract.Cartas.TABELA_NOME);

        return true; // se inseriu
    }

    public ArrayList<Carta> getListaImagens() {
        // retorna o Cursor para os registros contidos no banco de dados
        Cursor cursor;
        cursor = database.rawQuery(SQL_SELECT_TIPO, null);

        ArrayList<Carta> cartas = new ArrayList<Carta>();
        while (cursor.moveToNext()) {
            Carta carta = new Carta();
            carta.setImagem_carta(cursor.getInt(cursor.getColumnIndexOrThrow(Contract.Cartas.COLUNA_IMAGEM)));
            carta.setPila(cursor.getInt(cursor.getColumnIndexOrThrow(Contract.Cartas.COLUNA_PILA)));
            carta.setAtaque(cursor.getInt(cursor.getColumnIndexOrThrow(Contract.Cartas.COLUNA_ATAQUE)));
            carta.setDefesa(cursor.getInt(cursor.getColumnIndexOrThrow(Contract.Cartas.COLUNA_DEFESA)));

            cartas.add(carta);

        }
        return cartas;
    }

    public ArrayList<Carta> getListaImagensImperiais() {
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
    }
}
