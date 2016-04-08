package dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import aulas.ddmi.jogotcc_roger.R;

/**
 * Created by roger_000 on 28/02/2016.
 */
public class DBHelper extends SQLiteOpenHelper{

    private static DBHelper dbHelper;
    private Context context;

    private DBHelper(Context context){
        super(context, Contract.BD_NOME, null, Contract.BD_VERSAO);
        this.context = context;
    }

    public static DBHelper getInstance(Context context) {
        if (dbHelper == null) {
            dbHelper = new DBHelper(context);
            return dbHelper;
        } else {
            return dbHelper;
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        String jogsqlcreate = "create table " + Contract.Jogador.TABELA_NOME
                + " (" + Contract.Jogador.COLUNA_IDJOG
                + " integer primary key autoincrement,"
                + Contract.Jogador.COLUNA_NOME + " text,"
                + Contract.Jogador.COLUNA_EMAIL + " text,"
                + Contract.Jogador.COLUNA_IMAGEM + " blob,"
                + Contract.Jogador.COLUNA_IDADE + " integer,"
                + Contract.Jogador.COLUNA_SENHA + " text,"
                + Contract.Jogador.COLUNA_VITORIA + " integer,"
                + Contract.Jogador.COLUNA_DERROTA + " integer,"
                + Contract.Jogador.COLUNA_PARTIDAS + " integer,"
                + Contract.Jogador.COLUNA_DINHEIRO + " decimal,"
                + Contract.Jogador.COLUNA_FASE + " integer,"
                + Contract.Jogador.COLUNA_XP + " decimal);";

        db.execSQL(jogsqlcreate);
        Log.d("DBHelper", "Criou a tabela " + Contract.Jogador.TABELA_NOME);


        String cartassqlcreate = "create table " + Contract.Cartas.TABELA_NOME
                + " (" + Contract.Cartas.COLUNA_IDCARTA
                + " integer primary key autoincrement,"
                + Contract.Cartas.COLUNA_NOME + " text,"
                + Contract.Cartas.COLUNA_TIPO + " text,"
                + Contract.Cartas.COLUNA_PILA + " integer,"
                + Contract.Cartas.COLUNA_ATAQUE + " integer,"
                + Contract.Cartas.COLUNA_DEFESA + " integer,"
                + Contract.Cartas.COLUNA_IMAGEM + " integer);";

        db.execSQL(cartassqlcreate);
        Log.d("DBHelper", "Criou a tabela " + Contract.Cartas.TABELA_NOME);

        ContentValues cartavalores = new ContentValues(); // objeto tupla (label
        // da coluna, valor)
        cartavalores.put(Contract.Cartas.COLUNA_NOME, "Soldado");
        cartavalores.put(Contract.Cartas.COLUNA_NOME, "Soldado");
        cartavalores.put(Contract.Cartas.COLUNA_TIPO, "Imperial");
        cartavalores.put(Contract.Cartas.COLUNA_PILA, 1);
        cartavalores.put(Contract.Cartas.COLUNA_ATAQUE, 1);
        cartavalores.put(Contract.Cartas.COLUNA_DEFESA, 2);
        cartavalores.put(Contract.Cartas.COLUNA_IMAGEM, R.drawable.carta1);
        db.insertOrThrow(Contract.Cartas.TABELA_NOME, null, cartavalores);
        Log.i("tcc", "Executou o script de criação/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);

        cartavalores.put(Contract.Cartas.COLUNA_TIPO, "Imperial");
        cartavalores.put(Contract.Cartas.COLUNA_PILA, 1);
        cartavalores.put(Contract.Cartas.COLUNA_ATAQUE, 1);
        cartavalores.put(Contract.Cartas.COLUNA_DEFESA, 2);
        cartavalores.put(Contract.Cartas.COLUNA_IMAGEM, R.drawable.carta1);
        db.insertOrThrow(Contract.Cartas.TABELA_NOME, null, cartavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);

        cartavalores.put(Contract.Cartas.COLUNA_NOME, "Soldado");
        cartavalores.put(Contract.Cartas.COLUNA_NOME, "Gauchao");
        cartavalores.put(Contract.Cartas.COLUNA_TIPO, "farroupilha");
        cartavalores.put(Contract.Cartas.COLUNA_PILA, 1);
        cartavalores.put(Contract.Cartas.COLUNA_ATAQUE, 1);
        cartavalores.put(Contract.Cartas.COLUNA_DEFESA, 2);
        cartavalores.put(Contract.Cartas.COLUNA_IMAGEM, R.drawable.carta2);
        db.insertOrThrow(Contract.Cartas.TABELA_NOME, null, cartavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);

        cartavalores.put(Contract.Cartas.COLUNA_NOME, "Gauchao");
        cartavalores.put(Contract.Cartas.COLUNA_TIPO, "farroupilha");
        cartavalores.put(Contract.Cartas.COLUNA_PILA, 1);
        cartavalores.put(Contract.Cartas.COLUNA_ATAQUE, 1);
        cartavalores.put(Contract.Cartas.COLUNA_DEFESA, 2);
        cartavalores.put(Contract.Cartas.COLUNA_IMAGEM, R.drawable.carta2);
        db.insertOrThrow(Contract.Cartas.TABELA_NOME, null, cartavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);

        cartavalores.put(Contract.Cartas.COLUNA_NOME, "Spadachin");
        cartavalores.put(Contract.Cartas.COLUNA_TIPO, "farroupilha");
        cartavalores.put(Contract.Cartas.COLUNA_PILA, 2);
        cartavalores.put(Contract.Cartas.COLUNA_ATAQUE, 2);
        cartavalores.put(Contract.Cartas.COLUNA_DEFESA, 2);
        cartavalores.put(Contract.Cartas.COLUNA_IMAGEM, R.drawable.carta3);
        db.insertOrThrow(Contract.Cartas.TABELA_NOME, null, cartavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);

        cartavalores.put(Contract.Cartas.COLUNA_NOME, "Spadachin");
        cartavalores.put(Contract.Cartas.COLUNA_TIPO, "farroupilha");
        cartavalores.put(Contract.Cartas.COLUNA_PILA, 2);
        cartavalores.put(Contract.Cartas.COLUNA_ATAQUE, 2);
        cartavalores.put(Contract.Cartas.COLUNA_DEFESA, 2);
        cartavalores.put(Contract.Cartas.COLUNA_IMAGEM, R.drawable.carta3);
        db.insertOrThrow(Contract.Cartas.TABELA_NOME, null, cartavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);


        cartavalores.put(Contract.Cartas.COLUNA_NOME, "Aleleke");
        cartavalores.put(Contract.Cartas.COLUNA_TIPO, "farroupilha");
        cartavalores.put(Contract.Cartas.COLUNA_PILA, 3);
        cartavalores.put(Contract.Cartas.COLUNA_ATAQUE, 2);
        cartavalores.put(Contract.Cartas.COLUNA_DEFESA, 4);
        cartavalores.put(Contract.Cartas.COLUNA_IMAGEM, R.drawable.carta4);
        db.insertOrThrow(Contract.Cartas.TABELA_NOME, null, cartavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);

        cartavalores.put(Contract.Cartas.COLUNA_NOME, "Aleleke");
        cartavalores.put(Contract.Cartas.COLUNA_TIPO, "farroupilha");
        cartavalores.put(Contract.Cartas.COLUNA_PILA, 3);
        cartavalores.put(Contract.Cartas.COLUNA_ATAQUE, 2);
        cartavalores.put(Contract.Cartas.COLUNA_DEFESA, 4);
        cartavalores.put(Contract.Cartas.COLUNA_IMAGEM, R.drawable.carta4);
        db.insertOrThrow(Contract.Cartas.TABELA_NOME, null, cartavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);


        cartavalores.put(Contract.Cartas.COLUNA_NOME, "Centauro");
        cartavalores.put(Contract.Cartas.COLUNA_TIPO, "farroupilha");
        cartavalores.put(Contract.Cartas.COLUNA_PILA, 3);
        cartavalores.put(Contract.Cartas.COLUNA_ATAQUE, 3);
        cartavalores.put(Contract.Cartas.COLUNA_DEFESA, 4);
        cartavalores.put(Contract.Cartas.COLUNA_IMAGEM, R.drawable.carta5);
        db.insertOrThrow(Contract.Cartas.TABELA_NOME, null, cartavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);

        cartavalores.put(Contract.Cartas.COLUNA_NOME, "Centauro");
        cartavalores.put(Contract.Cartas.COLUNA_TIPO, "farroupilha");
        cartavalores.put(Contract.Cartas.COLUNA_PILA, 3);
        cartavalores.put(Contract.Cartas.COLUNA_ATAQUE, 3);
        cartavalores.put(Contract.Cartas.COLUNA_DEFESA, 4);
        cartavalores.put(Contract.Cartas.COLUNA_IMAGEM, R.drawable.carta5);
        db.insertOrThrow(Contract.Cartas.TABELA_NOME, null, cartavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);

        cartavalores.put(Contract.Cartas.COLUNA_NOME, "Velho");
        cartavalores.put(Contract.Cartas.COLUNA_TIPO, "imperial");
        cartavalores.put(Contract.Cartas.COLUNA_PILA, 2);
        cartavalores.put(Contract.Cartas.COLUNA_ATAQUE, 2);
        cartavalores.put(Contract.Cartas.COLUNA_DEFESA, 2);
        cartavalores.put(Contract.Cartas.COLUNA_IMAGEM, R.drawable.carta6);
        db.insertOrThrow(Contract.Cartas.TABELA_NOME, null, cartavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);

        cartavalores.put(Contract.Cartas.COLUNA_NOME, "Velho");
        cartavalores.put(Contract.Cartas.COLUNA_TIPO, "imperial");
        cartavalores.put(Contract.Cartas.COLUNA_PILA, 2);
        cartavalores.put(Contract.Cartas.COLUNA_ATAQUE, 2);
        cartavalores.put(Contract.Cartas.COLUNA_DEFESA, 2);
        cartavalores.put(Contract.Cartas.COLUNA_IMAGEM, R.drawable.carta6);
        db.insertOrThrow(Contract.Cartas.TABELA_NOME, null, cartavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);

        cartavalores.put(Contract.Cartas.COLUNA_NOME, "Imperial");
        cartavalores.put(Contract.Cartas.COLUNA_TIPO, "Imperial");
        cartavalores.put(Contract.Cartas.COLUNA_PILA, 2);
        cartavalores.put(Contract.Cartas.COLUNA_ATAQUE, 2);
        cartavalores.put(Contract.Cartas.COLUNA_DEFESA, 2);
        cartavalores.put(Contract.Cartas.COLUNA_IMAGEM, R.drawable.carta7);
        db.insertOrThrow(Contract.Cartas.TABELA_NOME, null, cartavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);

        cartavalores.put(Contract.Cartas.COLUNA_NOME, "Imperial");
        cartavalores.put(Contract.Cartas.COLUNA_TIPO, "Imperial");
        cartavalores.put(Contract.Cartas.COLUNA_PILA, 2);
        cartavalores.put(Contract.Cartas.COLUNA_ATAQUE, 2);
        cartavalores.put(Contract.Cartas.COLUNA_DEFESA, 2);
        cartavalores.put(Contract.Cartas.COLUNA_IMAGEM, R.drawable.carta7);
        db.insertOrThrow(Contract.Cartas.TABELA_NOME, null, cartavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);

        cartavalores.put(Contract.Cartas.COLUNA_NOME, "Cavalaria");
        cartavalores.put(Contract.Cartas.COLUNA_TIPO, "imperial");
        cartavalores.put(Contract.Cartas.COLUNA_PILA, 4);
        cartavalores.put(Contract.Cartas.COLUNA_ATAQUE, 4);
        cartavalores.put(Contract.Cartas.COLUNA_DEFESA, 4);
        cartavalores.put(Contract.Cartas.COLUNA_IMAGEM, R.drawable.carta8);
        db.insertOrThrow(Contract.Cartas.TABELA_NOME, null, cartavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);

        cartavalores.put(Contract.Cartas.COLUNA_NOME, "Cavalaria");
        cartavalores.put(Contract.Cartas.COLUNA_TIPO, "imperial");
        cartavalores.put(Contract.Cartas.COLUNA_PILA, 4);
        cartavalores.put(Contract.Cartas.COLUNA_ATAQUE, 4);
        cartavalores.put(Contract.Cartas.COLUNA_DEFESA, 4);
        cartavalores.put(Contract.Cartas.COLUNA_IMAGEM, R.drawable.carta8);
        db.insertOrThrow(Contract.Cartas.TABELA_NOME, null, cartavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);


        cartavalores.put(Contract.Cartas.COLUNA_NOME, "Lancelot");
        cartavalores.put(Contract.Cartas.COLUNA_TIPO, "farroupilha");
        cartavalores.put(Contract.Cartas.COLUNA_PILA, 4);
        cartavalores.put(Contract.Cartas.COLUNA_ATAQUE, 5);
        cartavalores.put(Contract.Cartas.COLUNA_DEFESA, 4);
        cartavalores.put(Contract.Cartas.COLUNA_IMAGEM, R.drawable.carta11);
        db.insertOrThrow(Contract.Cartas.TABELA_NOME, null, cartavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);

        cartavalores.put(Contract.Cartas.COLUNA_NOME, "Lancelot");
        cartavalores.put(Contract.Cartas.COLUNA_TIPO, "farroupilha");
        cartavalores.put(Contract.Cartas.COLUNA_PILA, 5);
        cartavalores.put(Contract.Cartas.COLUNA_ATAQUE, 5);
        cartavalores.put(Contract.Cartas.COLUNA_DEFESA, 4);
        cartavalores.put(Contract.Cartas.COLUNA_IMAGEM, R.drawable.carta11);
        db.insertOrThrow(Contract.Cartas.TABELA_NOME, null, cartavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);

        cartavalores.put(Contract.Cartas.COLUNA_NOME, "Milico");
        cartavalores.put(Contract.Cartas.COLUNA_TIPO, "imperial");
        cartavalores.put(Contract.Cartas.COLUNA_PILA, 1);
        cartavalores.put(Contract.Cartas.COLUNA_ATAQUE, 1);
        cartavalores.put(Contract.Cartas.COLUNA_DEFESA, 1);
        cartavalores.put(Contract.Cartas.COLUNA_IMAGEM, R.drawable.carta12);
        db.insertOrThrow(Contract.Cartas.TABELA_NOME, null, cartavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);

        cartavalores.put(Contract.Cartas.COLUNA_NOME, "Milico");
        cartavalores.put(Contract.Cartas.COLUNA_TIPO, "imperial");
        cartavalores.put(Contract.Cartas.COLUNA_PILA, 1);
        cartavalores.put(Contract.Cartas.COLUNA_ATAQUE, 1);
        cartavalores.put(Contract.Cartas.COLUNA_DEFESA, 1);
        cartavalores.put(Contract.Cartas.COLUNA_IMAGEM, R.drawable.carta12);
        db.insertOrThrow(Contract.Cartas.TABELA_NOME, null, cartavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);

        cartavalores.put(Contract.Cartas.COLUNA_NOME, "Assassin's");
        cartavalores.put(Contract.Cartas.COLUNA_TIPO, "farroupilha");
        cartavalores.put(Contract.Cartas.COLUNA_PILA, 6);
        cartavalores.put(Contract.Cartas.COLUNA_ATAQUE, 5);
        cartavalores.put(Contract.Cartas.COLUNA_DEFESA, 6);
        cartavalores.put(Contract.Cartas.COLUNA_IMAGEM, R.drawable.carta16);
        db.insertOrThrow(Contract.Cartas.TABELA_NOME, null, cartavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);

        cartavalores.put(Contract.Cartas.COLUNA_NOME, "Assassin's");
        cartavalores.put(Contract.Cartas.COLUNA_TIPO, "farroupilha");
        cartavalores.put(Contract.Cartas.COLUNA_PILA, 6);
        cartavalores.put(Contract.Cartas.COLUNA_ATAQUE, 5);
        cartavalores.put(Contract.Cartas.COLUNA_DEFESA, 6);
        cartavalores.put(Contract.Cartas.COLUNA_IMAGEM, R.drawable.carta16);
        db.insertOrThrow(Contract.Cartas.TABELA_NOME, null, cartavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);

        cartavalores.put(Contract.Cartas.COLUNA_NOME, "Seival");
        cartavalores.put(Contract.Cartas.COLUNA_TIPO, "farroupilha");
        cartavalores.put(Contract.Cartas.COLUNA_PILA, 6);
        cartavalores.put(Contract.Cartas.COLUNA_ATAQUE, 4);
        cartavalores.put(Contract.Cartas.COLUNA_DEFESA, 8);
        cartavalores.put(Contract.Cartas.COLUNA_IMAGEM, R.drawable.carta17);
        db.insertOrThrow(Contract.Cartas.TABELA_NOME, null, cartavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);

        cartavalores.put(Contract.Cartas.COLUNA_NOME, "Seival");
        cartavalores.put(Contract.Cartas.COLUNA_TIPO, "farroupilha");
        cartavalores.put(Contract.Cartas.COLUNA_PILA, 6);
        cartavalores.put(Contract.Cartas.COLUNA_ATAQUE, 4);
        cartavalores.put(Contract.Cartas.COLUNA_DEFESA, 8);
        cartavalores.put(Contract.Cartas.COLUNA_IMAGEM, R.drawable.carta17);
        db.insertOrThrow(Contract.Cartas.TABELA_NOME, null, cartavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);

        cartavalores.put(Contract.Cartas.COLUNA_NOME, "Fuzileiro");
        cartavalores.put(Contract.Cartas.COLUNA_TIPO, "imperial");
        cartavalores.put(Contract.Cartas.COLUNA_PILA, 4);
        cartavalores.put(Contract.Cartas.COLUNA_ATAQUE, 5);
        cartavalores.put(Contract.Cartas.COLUNA_DEFESA, 4);
        cartavalores.put(Contract.Cartas.COLUNA_IMAGEM, R.drawable.carta18);
        db.insertOrThrow(Contract.Cartas.TABELA_NOME, null, cartavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);

        cartavalores.put(Contract.Cartas.COLUNA_NOME, "Fuzileiro");
        cartavalores.put(Contract.Cartas.COLUNA_TIPO, "imperial");
        cartavalores.put(Contract.Cartas.COLUNA_PILA, 4);
        cartavalores.put(Contract.Cartas.COLUNA_ATAQUE, 5);
        cartavalores.put(Contract.Cartas.COLUNA_DEFESA, 4);
        cartavalores.put(Contract.Cartas.COLUNA_IMAGEM, R.drawable.carta18);
        db.insertOrThrow(Contract.Cartas.TABELA_NOME, null, cartavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);

        cartavalores.put(Contract.Cartas.COLUNA_NOME, "Sentinela");
        cartavalores.put(Contract.Cartas.COLUNA_TIPO, "imperial");
        cartavalores.put(Contract.Cartas.COLUNA_PILA, 4);
        cartavalores.put(Contract.Cartas.COLUNA_ATAQUE, 4);
        cartavalores.put(Contract.Cartas.COLUNA_DEFESA, 4);
        cartavalores.put(Contract.Cartas.COLUNA_IMAGEM, R.drawable.carta19);
        db.insertOrThrow(Contract.Cartas.TABELA_NOME, null, cartavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);

        cartavalores.put(Contract.Cartas.COLUNA_NOME, "Sentinela");
        cartavalores.put(Contract.Cartas.COLUNA_TIPO, "imperial");
        cartavalores.put(Contract.Cartas.COLUNA_PILA, 4);
        cartavalores.put(Contract.Cartas.COLUNA_ATAQUE, 4);
        cartavalores.put(Contract.Cartas.COLUNA_DEFESA, 4);
        cartavalores.put(Contract.Cartas.COLUNA_IMAGEM, R.drawable.carta19);
        db.insertOrThrow(Contract.Cartas.TABELA_NOME, null, cartavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);

        cartavalores.put(Contract.Cartas.COLUNA_NOME, "Porta Bandeira");
        cartavalores.put(Contract.Cartas.COLUNA_TIPO, "farroupilha");
        cartavalores.put(Contract.Cartas.COLUNA_PILA, 5);
        cartavalores.put(Contract.Cartas.COLUNA_ATAQUE, 5);
        cartavalores.put(Contract.Cartas.COLUNA_DEFESA, 5);
        cartavalores.put(Contract.Cartas.COLUNA_IMAGEM, R.drawable.carta20);
        db.insertOrThrow(Contract.Cartas.TABELA_NOME, null, cartavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);

        cartavalores.put(Contract.Cartas.COLUNA_NOME, "Porta Bandeira");
        cartavalores.put(Contract.Cartas.COLUNA_TIPO, "farroupilha");
        cartavalores.put(Contract.Cartas.COLUNA_PILA, 5);
        cartavalores.put(Contract.Cartas.COLUNA_ATAQUE, 5);
        cartavalores.put(Contract.Cartas.COLUNA_DEFESA, 5);
        cartavalores.put(Contract.Cartas.COLUNA_IMAGEM, R.drawable.carta20);
        db.insertOrThrow(Contract.Cartas.TABELA_NOME, null, cartavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);

        cartavalores.put(Contract.Cartas.COLUNA_NOME, "Infantaria");
        cartavalores.put(Contract.Cartas.COLUNA_TIPO, "imperial");
        cartavalores.put(Contract.Cartas.COLUNA_PILA, 5);
        cartavalores.put(Contract.Cartas.COLUNA_ATAQUE, 5);
        cartavalores.put(Contract.Cartas.COLUNA_DEFESA, 6);
        cartavalores.put(Contract.Cartas.COLUNA_IMAGEM, R.drawable.carta21);
        db.insertOrThrow(Contract.Cartas.TABELA_NOME, null, cartavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);

        cartavalores.put(Contract.Cartas.COLUNA_NOME, "Infantaria");
        cartavalores.put(Contract.Cartas.COLUNA_TIPO, "imperial");
        cartavalores.put(Contract.Cartas.COLUNA_PILA, 5);
        cartavalores.put(Contract.Cartas.COLUNA_ATAQUE, 5);
        cartavalores.put(Contract.Cartas.COLUNA_DEFESA, 6);
        cartavalores.put(Contract.Cartas.COLUNA_IMAGEM, R.drawable.carta21);
        db.insertOrThrow(Contract.Cartas.TABELA_NOME, null, cartavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);

        cartavalores.put(Contract.Cartas.COLUNA_NOME, "Itaparica");
        cartavalores.put(Contract.Cartas.COLUNA_TIPO, "imperial");
        cartavalores.put(Contract.Cartas.COLUNA_PILA, 7);
        cartavalores.put(Contract.Cartas.COLUNA_ATAQUE, 5);
        cartavalores.put(Contract.Cartas.COLUNA_DEFESA, 8);
        cartavalores.put(Contract.Cartas.COLUNA_IMAGEM, R.drawable.carta22);
        db.insertOrThrow(Contract.Cartas.TABELA_NOME, null, cartavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);

        cartavalores.put(Contract.Cartas.COLUNA_NOME, "Itaparica");
        cartavalores.put(Contract.Cartas.COLUNA_TIPO, "imperial");
        cartavalores.put(Contract.Cartas.COLUNA_PILA, 7);
        cartavalores.put(Contract.Cartas.COLUNA_ATAQUE, 5);
        cartavalores.put(Contract.Cartas.COLUNA_DEFESA, 8);
        cartavalores.put(Contract.Cartas.COLUNA_IMAGEM, R.drawable.carta22);
        db.insertOrThrow(Contract.Cartas.TABELA_NOME, null, cartavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);

        cartavalores.put(Contract.Cartas.COLUNA_NOME, "Avante");
        cartavalores.put(Contract.Cartas.COLUNA_TIPO, "imperial");
        cartavalores.put(Contract.Cartas.COLUNA_PILA, 6);
        cartavalores.put(Contract.Cartas.COLUNA_ATAQUE, 6);
        cartavalores.put(Contract.Cartas.COLUNA_DEFESA, 6);
        cartavalores.put(Contract.Cartas.COLUNA_IMAGEM, R.drawable.carta23);
        db.insertOrThrow(Contract.Cartas.TABELA_NOME, null, cartavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);

        cartavalores.put(Contract.Cartas.COLUNA_NOME, "Avante");
        cartavalores.put(Contract.Cartas.COLUNA_TIPO, "imperial");
        cartavalores.put(Contract.Cartas.COLUNA_PILA, 6);
        cartavalores.put(Contract.Cartas.COLUNA_ATAQUE, 6);
        cartavalores.put(Contract.Cartas.COLUNA_DEFESA, 6);
        cartavalores.put(Contract.Cartas.COLUNA_IMAGEM, R.drawable.carta23);
        db.insertOrThrow(Contract.Cartas.TABELA_NOME, null, cartavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);

        cartavalores.put(Contract.Cartas.COLUNA_NOME, "Brimquedo");
        cartavalores.put(Contract.Cartas.COLUNA_TIPO, "imperial");
        cartavalores.put(Contract.Cartas.COLUNA_PILA, 3);
        cartavalores.put(Contract.Cartas.COLUNA_ATAQUE, 3);
        cartavalores.put(Contract.Cartas.COLUNA_DEFESA, 3);
        cartavalores.put(Contract.Cartas.COLUNA_IMAGEM, R.drawable.carta24);
        db.insertOrThrow(Contract.Cartas.TABELA_NOME, null, cartavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);

        cartavalores.put(Contract.Cartas.COLUNA_NOME, "Brimquedo");
        cartavalores.put(Contract.Cartas.COLUNA_TIPO, "imperial");
        cartavalores.put(Contract.Cartas.COLUNA_PILA, 3);
        cartavalores.put(Contract.Cartas.COLUNA_ATAQUE, 3);
        cartavalores.put(Contract.Cartas.COLUNA_DEFESA, 3);
        cartavalores.put(Contract.Cartas.COLUNA_IMAGEM, R.drawable.carta24);
        db.insertOrThrow(Contract.Cartas.TABELA_NOME, null, cartavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);

        cartavalores.put(Contract.Cartas.COLUNA_NOME, "Encostado");
        cartavalores.put(Contract.Cartas.COLUNA_TIPO, "imperial");
        cartavalores.put(Contract.Cartas.COLUNA_PILA, 3);
        cartavalores.put(Contract.Cartas.COLUNA_ATAQUE, 2);
        cartavalores.put(Contract.Cartas.COLUNA_DEFESA, 4);
        cartavalores.put(Contract.Cartas.COLUNA_IMAGEM, R.drawable.carta25);;
        db.insertOrThrow(Contract.Cartas.TABELA_NOME, null, cartavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);

        cartavalores.put(Contract.Cartas.COLUNA_NOME, "Encostado");
        cartavalores.put(Contract.Cartas.COLUNA_TIPO, "imperial");
        cartavalores.put(Contract.Cartas.COLUNA_PILA, 3);
        cartavalores.put(Contract.Cartas.COLUNA_ATAQUE, 2);
        cartavalores.put(Contract.Cartas.COLUNA_DEFESA, 4);
        cartavalores.put(Contract.Cartas.COLUNA_IMAGEM, R.drawable.carta25);
        db.insertOrThrow(Contract.Cartas.TABELA_NOME, null, cartavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);

        cartavalores.put(Contract.Cartas.COLUNA_NOME, "Soldado de Chumbo");
        cartavalores.put(Contract.Cartas.COLUNA_TIPO, "imperial");
        cartavalores.put(Contract.Cartas.COLUNA_PILA, 1);
        cartavalores.put(Contract.Cartas.COLUNA_ATAQUE, 1);
        cartavalores.put(Contract.Cartas.COLUNA_DEFESA, 1);
        cartavalores.put(Contract.Cartas.COLUNA_IMAGEM, R.drawable.carta26);
        db.insertOrThrow(Contract.Cartas.TABELA_NOME, null, cartavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);

        cartavalores.put(Contract.Cartas.COLUNA_NOME, "Soldado de Chumbo");
        cartavalores.put(Contract.Cartas.COLUNA_TIPO, "imperial");
        cartavalores.put(Contract.Cartas.COLUNA_PILA, 1);
        cartavalores.put(Contract.Cartas.COLUNA_ATAQUE, 1);
        cartavalores.put(Contract.Cartas.COLUNA_DEFESA, 1);
        cartavalores.put(Contract.Cartas.COLUNA_IMAGEM, R.drawable.carta26);
        db.insertOrThrow(Contract.Cartas.TABELA_NOME, null, cartavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);


        cartavalores.put(Contract.Cartas.COLUNA_NOME, "Lanceiro");
        cartavalores.put(Contract.Cartas.COLUNA_TIPO, "farroupilha");
        cartavalores.put(Contract.Cartas.COLUNA_PILA, 5);
        cartavalores.put(Contract.Cartas.COLUNA_ATAQUE, 6);
        cartavalores.put(Contract.Cartas.COLUNA_DEFESA, 4);
        cartavalores.put(Contract.Cartas.COLUNA_IMAGEM, R.drawable.carta28);
        db.insertOrThrow(Contract.Cartas.TABELA_NOME, null, cartavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);

        cartavalores.put(Contract.Cartas.COLUNA_NOME, "Lanceiro");
        cartavalores.put(Contract.Cartas.COLUNA_TIPO, "farroupilha");
        cartavalores.put(Contract.Cartas.COLUNA_PILA, 5);
        cartavalores.put(Contract.Cartas.COLUNA_ATAQUE, 6);
        cartavalores.put(Contract.Cartas.COLUNA_DEFESA, 4);
        cartavalores.put(Contract.Cartas.COLUNA_IMAGEM, R.drawable.carta28);
        db.insertOrThrow(Contract.Cartas.TABELA_NOME, null, cartavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);

        cartavalores.put(Contract.Cartas.COLUNA_NOME, "Oficial");
        cartavalores.put(Contract.Cartas.COLUNA_TIPO, "farroupilha");
        cartavalores.put(Contract.Cartas.COLUNA_PILA, 4);
        cartavalores.put(Contract.Cartas.COLUNA_ATAQUE, 4);
        cartavalores.put(Contract.Cartas.COLUNA_DEFESA, 5);
        cartavalores.put(Contract.Cartas.COLUNA_IMAGEM, R.drawable.carta30);
        db.insertOrThrow(Contract.Cartas.TABELA_NOME, null, cartavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);

        cartavalores.put(Contract.Cartas.COLUNA_NOME, "Oficial");
        cartavalores.put(Contract.Cartas.COLUNA_TIPO, "farroupilha");
        cartavalores.put(Contract.Cartas.COLUNA_PILA, 4);
        cartavalores.put(Contract.Cartas.COLUNA_ATAQUE, 4);
        cartavalores.put(Contract.Cartas.COLUNA_DEFESA, 5);
        cartavalores.put(Contract.Cartas.COLUNA_IMAGEM, R.drawable.carta30);
        db.insertOrThrow(Contract.Cartas.TABELA_NOME, null, cartavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);

        cartavalores.put(Contract.Cartas.COLUNA_NOME, "Soldado");
        cartavalores.put(Contract.Cartas.COLUNA_TIPO, "farroupilha");
        cartavalores.put(Contract.Cartas.COLUNA_PILA, 1);
        cartavalores.put(Contract.Cartas.COLUNA_ATAQUE, 1);
        cartavalores.put(Contract.Cartas.COLUNA_DEFESA, 1);
        cartavalores.put(Contract.Cartas.COLUNA_IMAGEM, R.drawable.carta31);
        db.insertOrThrow(Contract.Cartas.TABELA_NOME, null, cartavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);

        cartavalores.put(Contract.Cartas.COLUNA_NOME, "Soldado");
        cartavalores.put(Contract.Cartas.COLUNA_TIPO, "farroupilha");
        cartavalores.put(Contract.Cartas.COLUNA_PILA, 1);
        cartavalores.put(Contract.Cartas.COLUNA_ATAQUE, 1);
        cartavalores.put(Contract.Cartas.COLUNA_DEFESA, 1);
        cartavalores.put(Contract.Cartas.COLUNA_IMAGEM, R.drawable.carta31);
        db.insertOrThrow(Contract.Cartas.TABELA_NOME, null, cartavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);

        cartavalores.put(Contract.Cartas.COLUNA_NOME, "Anita");
        cartavalores.put(Contract.Cartas.COLUNA_TIPO, "farroupilha");
        cartavalores.put(Contract.Cartas.COLUNA_PILA, 4);
        cartavalores.put(Contract.Cartas.COLUNA_ATAQUE, 5);
        cartavalores.put(Contract.Cartas.COLUNA_DEFESA, 4);
        cartavalores.put(Contract.Cartas.COLUNA_IMAGEM, R.drawable.carta_anita);
        db.insertOrThrow(Contract.Cartas.TABELA_NOME, null, cartavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);

        cartavalores.put(Contract.Cartas.COLUNA_NOME, "David Canabarro");
        cartavalores.put(Contract.Cartas.COLUNA_TIPO, "farroupilha");
        cartavalores.put(Contract.Cartas.COLUNA_PILA, 6);
        cartavalores.put(Contract.Cartas.COLUNA_ATAQUE, 6);
        cartavalores.put(Contract.Cartas.COLUNA_DEFESA, 8);
        cartavalores.put(Contract.Cartas.COLUNA_IMAGEM, R.drawable.carta_david);
        db.insertOrThrow(Contract.Cartas.TABELA_NOME, null, cartavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);

        cartavalores.put(Contract.Cartas.COLUNA_NOME, "Duque de Caxias");
        cartavalores.put(Contract.Cartas.COLUNA_TIPO, "imperial");
        cartavalores.put(Contract.Cartas.COLUNA_PILA, 8);
        cartavalores.put(Contract.Cartas.COLUNA_ATAQUE, 8);
        cartavalores.put(Contract.Cartas.COLUNA_DEFESA, 8);
        cartavalores.put(Contract.Cartas.COLUNA_IMAGEM, R.drawable.carta_duque);
        db.insertOrThrow(Contract.Cartas.TABELA_NOME, null, cartavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);

        cartavalores.put(Contract.Cartas.COLUNA_NOME, "Capitão Garibaldi");
        cartavalores.put(Contract.Cartas.COLUNA_TIPO, "farroupilha");
        cartavalores.put(Contract.Cartas.COLUNA_PILA, 6);
        cartavalores.put(Contract.Cartas.COLUNA_ATAQUE, 6);
        cartavalores.put(Contract.Cartas.COLUNA_DEFESA, 6);
        cartavalores.put(Contract.Cartas.COLUNA_IMAGEM, R.drawable.carta_garibaldi);
        db.insertOrThrow(Contract.Cartas.TABELA_NOME, null, cartavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);

        cartavalores.put(Contract.Cartas.COLUNA_NOME, "Bento Manuel");
        cartavalores.put(Contract.Cartas.COLUNA_TIPO, "imperial");
        cartavalores.put(Contract.Cartas.COLUNA_PILA, 6);
        cartavalores.put(Contract.Cartas.COLUNA_ATAQUE, 6);
        cartavalores.put(Contract.Cartas.COLUNA_DEFESA, 7);
        cartavalores.put(Contract.Cartas.COLUNA_IMAGEM, R.drawable.carta_manuel);
        db.insertOrThrow(Contract.Cartas.TABELA_NOME, null, cartavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);

        cartavalores.put(Contract.Cartas.COLUNA_NOME, "Marques de Souza");
        cartavalores.put(Contract.Cartas.COLUNA_TIPO, "imperial");
        cartavalores.put(Contract.Cartas.COLUNA_PILA, 6);
        cartavalores.put(Contract.Cartas.COLUNA_ATAQUE, 6);
        cartavalores.put(Contract.Cartas.COLUNA_DEFESA, 8);
        cartavalores.put(Contract.Cartas.COLUNA_IMAGEM, R.drawable.carta_marques);
        db.insertOrThrow(Contract.Cartas.TABELA_NOME, null, cartavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);

        cartavalores.put(Contract.Cartas.COLUNA_NOME, "General Neto");
        cartavalores.put(Contract.Cartas.COLUNA_TIPO, "farroupilha");
        cartavalores.put(Contract.Cartas.COLUNA_PILA, 7);
        cartavalores.put(Contract.Cartas.COLUNA_ATAQUE, 7);
        cartavalores.put(Contract.Cartas.COLUNA_DEFESA, 7);
        cartavalores.put(Contract.Cartas.COLUNA_IMAGEM, R.drawable.carta_neto);
        db.insertOrThrow(Contract.Cartas.TABELA_NOME, null, cartavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);

        cartavalores.put(Contract.Cartas.COLUNA_NOME, "Onofre Pires");
        cartavalores.put(Contract.Cartas.COLUNA_TIPO, "farroupilha");
        cartavalores.put(Contract.Cartas.COLUNA_PILA, 5);
        cartavalores.put(Contract.Cartas.COLUNA_ATAQUE, 5);
        cartavalores.put(Contract.Cartas.COLUNA_DEFESA, 6);
        cartavalores.put(Contract.Cartas.COLUNA_IMAGEM, R.drawable.carta_onofre);
        db.insertOrThrow(Contract.Cartas.TABELA_NOME, null, cartavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);

        cartavalores.put(Contract.Cartas.COLUNA_NOME, "Silva tavares");
        cartavalores.put(Contract.Cartas.COLUNA_TIPO, "imperial");
        cartavalores.put(Contract.Cartas.COLUNA_PILA, 5);
        cartavalores.put(Contract.Cartas.COLUNA_ATAQUE, 5);
        cartavalores.put(Contract.Cartas.COLUNA_DEFESA, 5);
        cartavalores.put(Contract.Cartas.COLUNA_IMAGEM, R.drawable.carta_silva);
        db.insertOrThrow(Contract.Cartas.TABELA_NOME, null, cartavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);


        cartavalores.put(Contract.Cartas.COLUNA_NOME, "General Bento Gonçalvez");
        cartavalores.put(Contract.Cartas.COLUNA_TIPO, "farroupilha");
        cartavalores.put(Contract.Cartas.COLUNA_PILA, 8);
        cartavalores.put(Contract.Cartas.COLUNA_ATAQUE, 9);
        cartavalores.put(Contract.Cartas.COLUNA_DEFESA, 8);
        cartavalores.put(Contract.Cartas.COLUNA_IMAGEM, R.drawable.carta_bento);
        db.insertOrThrow(Contract.Cartas.TABELA_NOME, null, cartavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);

        cartavalores.put(Contract.Cartas.COLUNA_NOME, "Lanceiro Negro");
        cartavalores.put(Contract.Cartas.COLUNA_TIPO, "farroupilha");
        cartavalores.put(Contract.Cartas.COLUNA_PILA, 2);
        cartavalores.put(Contract.Cartas.COLUNA_ATAQUE, 2);
        cartavalores.put(Contract.Cartas.COLUNA_DEFESA, 2);
        cartavalores.put(Contract.Cartas.COLUNA_IMAGEM, R.drawable.carta_negro);
        db.insertOrThrow(Contract.Cartas.TABELA_NOME, null, cartavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);

        cartavalores.put(Contract.Cartas.COLUNA_NOME, "Lanceiro Negro");
        cartavalores.put(Contract.Cartas.COLUNA_TIPO, "farroupilha");
        cartavalores.put(Contract.Cartas.COLUNA_PILA, 2);
        cartavalores.put(Contract.Cartas.COLUNA_ATAQUE, 2);
        cartavalores.put(Contract.Cartas.COLUNA_DEFESA, 2);
        cartavalores.put(Contract.Cartas.COLUNA_IMAGEM, R.drawable.carta_negro);
        db.insertOrThrow(Contract.Cartas.TABELA_NOME, null, cartavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);

        String historiasqlcreate = "create table " + Contract.Historia.TABELA_NOME
                + " (" + Contract.Historia.COLUNA_IDH
                + " integer primary key autoincrement,"
                + Contract.Historia.COLUNA_DATA + " text,"
                + Contract.Historia.COLUNA_NOME + " text,"
                + Contract.Historia.COLUNA_DESC + " text,"
                + Contract.Historia.COLUNA_IMAGEM + " integer,"
                + Contract.Historia.COLUNA_IMAGEM1 + " integer);";

        db.execSQL(historiasqlcreate);

        ContentValues historiavalores = new ContentValues();
        historiavalores.put(Contract.Historia.COLUNA_DATA, "20/09/1835");
        historiavalores.put(Contract.Historia.COLUNA_NOME, "Batalha da Ponte da Azenha");
        historiavalores.put(Contract.Historia.COLUNA_DESC, "Em várias cidades do interior as milícias foram alertadas para deflagrarem a revolta.\n" +
                "Bento comandava uma tropa reunida em Pedras Brancas,\n" +
                "hoje cidade de Guaíba. Gomes Jardim e Onofre Pires comandavam os farroupilhas \n" +
                "aquartelados, com cerca de 200 homens, no morro da Azenha , o atual cemitério \n" +
                "São Miguel e Almas. Também mantinham, no dia 19 de setembro de 1835, um piquete com \n" +
                "trinta homens nas imediações da ponte da Azenha sobre o arroio Dilúvio, comandado \n" +
                "por Manuel Vieira da Rocha, o cabo Rocha, que aguardava o amanhecer do dia 20 para \n" +
                "investir, junto com o restante da tropa, contra os muros da vila. Porém Fernandes \n" +
                "Braga ouvira alguns boatos e, desconfiado, mandou uma partida de 9 homens sob o \n" +
                "comando de José Gordilho de Barbuda Filho, o 2° visconde de Camamu, fazer um \n" +
                "reconhecimento durante à noite. Descuidados e inexperientes, os guardas imperiais se \n" +
                "deixaram notar e foram atacados pelo piquete republicano e fugiram, resultando 2 \n" +
                "mortos e cinco feridos. Um dos feridos, o próprio visconde, sujo e ensanguentado \n" +
                "alertou Fernandes Braga da revolta. Eram 11 horas da noite de 19 de setembro de 1835.\n");
        historiavalores.put(Contract.Historia.COLUNA_IMAGEM, R.drawable.historia11);
        historiavalores.put(Contract.Historia.COLUNA_IMAGEM1, R.drawable.historia1);
        db.insertOrThrow(Contract.Historia.TABELA_NOME, null, historiavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);

        historiavalores.put(Contract.Historia.COLUNA_DATA, "10/09/1836");
        historiavalores.put(Contract.Historia.COLUNA_NOME, "Batalha do Seival");
        historiavalores.put(Contract.Historia.COLUNA_DESC, "Com o objetivo original de derrubar o presidente da província, apenas, os revoltosos gaúchos \n" +
                "enfrentaram as tropas imperiais. Destacado por Bento Gonçalves, o coronel Neto deslocou-se, \n" +
                "no início de setembro de 1836, à região de Bagé, onde encontrava-se o comandante imperial \n" +
                "João da Silva Tavares, vindo do Uruguai. A primeira brigada de Neto, com 400 homens, \n" +
                "atravessou o arroio Seival e encontrou as tropas de Silva Tavares sobre uma coxilha, com 560 \n" +
                "homens. Durante a tarde de 10 de setembro de 1836, Silva Tavares avançou sobre a coxilha, e os \n" +
                "revoltosos defenderam-se usando lanças e espadas.\n" +
                "\n" +
                "Inicialmente houve pequena vantagem das forças imperiais, mas o cavalo de Silva Tavares, \n" +
                "com o freio rebentado na peleia, disparou em velocidade, causando a impressão de fuga, mesmo\n" +
                " entre seus comandados. A confusão entre eles foi aproveitada pelos cavaleiros de Neto, que \n" +
                "atacaram com força redobrada. O resultado deste mal-entendido foi ficarem os revoltosos \n" +
                "quase intactos, enquanto houve 180 mortos, 63 feridos e 100 prisioneiros do lado dos imperiais. \n" +
                "Entre os prisioneios estava João Frederico Caldwell." +
                "11 de setembro\n" +
                "\n" +
                "O coronel farroupilha Antônio de Souza Neto proclama a República \n" +
                "Rio-Grandense.");
        historiavalores.put(Contract.Historia.COLUNA_IMAGEM, R.drawable.seival);
        historiavalores.put(Contract.Historia.COLUNA_IMAGEM1, R.drawable.seival1);
        db.insertOrThrow(Contract.Historia.TABELA_NOME, null, historiavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);

        historiavalores.put(Contract.Historia.COLUNA_DATA, "3/010/1836");
        historiavalores.put(Contract.Historia.COLUNA_NOME, "Batalha do Fanfa");
        historiavalores.put(Contract.Historia.COLUNA_DESC, "Em 3 de Outubro de 1836, as forças imperiais fecham o cerco por terra. As forças farroupilhas \n" +
                "resistem, sabedores da proximidade de tropas lideradas por Crescêncio de Carvalho. \n" +
                "Repelem os marines que desembarcam na ilha pela costa sul e as tentativas de travessia pelo \n" +
                "norte. Naquela noite, porém, negociam um acordo pelo qual os farrapos entregariam as armas, \n" +
                "capitulariam e voltariam livres para suas casas.\n" +
                "\n" +
                "Pela manhã do dia 4 de outubro era formalizada a capitulação. Muitos revoltosos jogaram suas \n" +
                "armas no rio, ao invés de entregá-las aos imperiais. No momento em que confraternizavam as \n" +
                "tropas, chega Araújo Ribeiro, em pessoa, trazido por John Grenfell. Imediatamente ordena a \n" +
                "prisão dos farrapos, desprevenidos e desarmados, não aceitando o acordo. Bento Manuel \n" +
                "colabora com a captura. Entre outros, Bento Gonçalves, Tito Lívio Zambeccari, Pedro Boticário, \n" +
                "José de Almeida Corte Real, Onofre Pires e José Calvet são presos. Por esse motivo, além de ser\n" +
                " conhecido como a derrota do Fanfa, o episódio é também chamado");
        historiavalores.put(Contract.Historia.COLUNA_IMAGEM, R.drawable.fanfa);
        historiavalores.put(Contract.Historia.COLUNA_IMAGEM1, R.drawable.fanfa1);
        db.insertOrThrow(Contract.Historia.TABELA_NOME, null, historiavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);

        historiavalores.put(Contract.Historia.COLUNA_DATA, "30/04/1838");
        historiavalores.put(Contract.Historia.COLUNA_NOME, "Batalha do Barro Vermelho");
        historiavalores.put(Contract.Historia.COLUNA_DESC, "Batalha do Barro Vermelho foi um conflito travado em Rio Pardo (Rio Grande do Sul), em 30 de abril de 1838.\n" +
                "Cerca de 5 mil homens se enfrentaram, numa das maiores vitórias dos rebeldes gaúchos em toda a campanha.\n" +
                "\n" +
                "Bento Gonçalves, Bento Manuel, Antônio de Souza Netto e Domingos Crescêncio comandaram os farrapos \n" +
                "que atacaram Rio Pardo. O marechal Sebastião Barreto e o major José Joaquim de Andrade Neves, ao perceberem\n" +
                " que não conseguiriam defender a cidade, ordenaram que os soldados resistissem, enquanto reuniam os outros \n" +
                "oficiais para fugir de barco pelo Rio Jacuí, segundo o historiador militar Lucas Alexandre Boiteux .\n" +
                "\n" +
                "Tomando a cidade, Souza Netto capturou a banda imperial e encomendou ao seu maestro, Joaquim José de \n" +
                "Mendanha, a composição de um hino para os separatistas. O músico entregou o hino em cinco dias. A letra foi \n" +
                "escrita pelo poeta Serafim de Alencastro, capitão das forças rebeldes, e a música mais tarde se tornou o hino do \n" +
                "Rio Grande do Sul .");
        historiavalores.put(Contract.Historia.COLUNA_IMAGEM, R.drawable.barro);
        historiavalores.put(Contract.Historia.COLUNA_IMAGEM1, R.drawable.barro1);
        db.insertOrThrow(Contract.Historia.TABELA_NOME, null, historiavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);

        historiavalores.put(Contract.Historia.COLUNA_DATA, "22/06/1839");
        historiavalores.put(Contract.Historia.COLUNA_NOME, "Batalha de Laguna");
        historiavalores.put(Contract.Historia.COLUNA_DESC, "Os arroupilhas organizaram uma expedição para tormar laguna. David Canabarro comandou a expedição que teve o \n" +
                "apoio de Giussepe Garibaldi, comandante da Marinha Farroupilha. Nessa ocasião Garibaldi fez transpor os lanchões\n" +
                "Seival e Farroupilha, por terra, desde o Rio Capivari até a foz do rio Tramandaí. Em 22 de julho e tomada a cidade de \n" +
                "Laguna em Santa Catarina, e no dia 29 é proclmada Republica Juliana.\n");
        historiavalores.put(Contract.Historia.COLUNA_IMAGEM, R.drawable.laguna);
        historiavalores.put(Contract.Historia.COLUNA_IMAGEM1, R.drawable.laguna1);
        db.insertOrThrow(Contract.Historia.TABELA_NOME, null, historiavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);

        historiavalores.put(Contract.Historia.COLUNA_DATA, "14/11/1844");
        historiavalores.put(Contract.Historia.COLUNA_NOME, "Batalha de Porongos");
        historiavalores.put(Contract.Historia.COLUNA_DESC, "Batalha de Porongos ou Traição dos Porongos foi o último confronto da Revolução Farroupilha. Persistem suspeitas \n" +
                "que teria sido uma batalha combinada entre o general farroupilha David Canabarro e o exército imperial. Resultou \n" +
                "no massacre do Corpo de Lanceiros Negros de Teixeira Nunes, que estavam acampados na curva do arroio Porongos, \n" +
                "no atual município de Pinheiro Machado quando foram atacados pelos imperiais.\n" +
                "\n" +
                "Em novembro de 1844, a revolução encontrava-se em pleno armistício, e seu fim já começava a ser negociado entre os \n" +
                "líderes de ambos os lados. Os lanceiros negros estavam acampados no cerro de Porongos sob comando do general \n" +
                "David Canabarro, quando foram atacados de surpresa por forças sob o comando de Francisco Pedro de Abreu, o \n" +
                "Moringue. O Corpo de Lanceiros Negros, cerca de 100 homens de mãos livres, tentou resistir ao ataque, mas foram \n" +
                "quase todos mortos. Também foram presos mais de 300 republicanos, entre brancos e negros, e 35 oficiais farroupilhas.");
        historiavalores.put(Contract.Historia.COLUNA_IMAGEM, R.drawable.porongos);
        historiavalores.put(Contract.Historia.COLUNA_IMAGEM1, R.drawable.porongos1);
        db.insertOrThrow(Contract.Historia.TABELA_NOME, null, historiavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);

        historiavalores.put(Contract.Historia.COLUNA_DATA, "01/03/1845");
        historiavalores.put(Contract.Historia.COLUNA_NOME, "Paz de Poncho Verde");
        historiavalores.put(Contract.Historia.COLUNA_DESC, "O Tratado de Poncho Verde, Convenção de Poncho Verde ou Paz de Poncho Verde é o nome dado a um acordo que \n" +
                "pôs fim à Revolução Farroupilha, voltando o território litigante a fazer parte do Império do Brasil, de D. Pedro II. É \n" +
                "aceita como data de sua assinatura o 1º de março de 1845, quando foi anunciada a paz. Ponche Verde ou Poncho Verde é\n" +
                " uma região assim denominada pelas suas verdes campinas, ótimas para o pastoreio de gado; hoje o lugar tem como sede \n" +
                "o município de Dom Pedrito, no estado do Rio Grande do Sul.");
        historiavalores.put(Contract.Historia.COLUNA_IMAGEM, R.drawable.paz);
        historiavalores.put(Contract.Historia.COLUNA_IMAGEM1, R.drawable.paz1);
        db.insertOrThrow(Contract.Historia.TABELA_NOME, null, historiavalores);
        Log.i("tcc", "Executou o script de cria��o/inser��o da tabela "
                + Contract.Cartas.TABELA_NOME);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Log.d("tcc", "Upgrade da versão " + oldVersion + " para " + newVersion
                + ", destruindo tudo.");
        db.execSQL("drop table if exists " + Contract.Jogador.TABELA_NOME);
        onCreate(db); // chama onCreate e recria o banco de dados
        Log.i("tcc", "Executou o script de upgrade da tabela"
                + Contract.Cartas.TABELA_NOME);

    }

}
