package dao;

import android.provider.BaseColumns;

/**
 * Created by roger_000 on 28/02/2016.
 */
public class Contract {

    public static final String BD_NOME = "gauchyoh.db"; //nome do banco de dados
    public static final int BD_VERSAO = 1; //vers�o do banco (�til para altera��es no banco de dados)

    public Contract() {
    }

    public static abstract class Jogador implements BaseColumns {

        public static final String TABELA_NOME = "jogador";
        public static final String COLUNA_IDJOG = "_id";
        public static final String COLUNA_NOME = "nome";
        public static final String COLUNA_EMAIL = "email";
        public static final String COLUNA_IDADE = "idade";
        public static final String COLUNA_SENHA = "senha";
        public static final String COLUNA_IMAGEM = "imagem";
        public static final String COLUNA_VITORIA = "vitoria";
        public static final String COLUNA_DERROTA = "derrota";
        public static final String COLUNA_PARTIDAS = "partidas";
        public static final String COLUNA_DINHEIRO = "dinheiro";
        public static final String COLUNA_FASE = "fase";
        public static final String COLUNA_XP = "xp";
    }

    public static abstract class Cartas implements BaseColumns {

        public static final String TABELA_NOME = "cartas";
        public static final String COLUNA_IDCARTA = "_id";
        public static final String COLUNA_NOME = "nome";
        public static final String COLUNA_TIPO = "tipo";
        public static final String COLUNA_PILA = "pila";
        public static final String COLUNA_IMAGEM = "id_imagem";
        public static final String COLUNA_ATAQUE = "ataque";
        public static final String COLUNA_DEFESA = "defesa";
    }
    public static abstract class Historia implements BaseColumns {

        public static final String TABELA_NOME = "historia";
        public static final String COLUNA_IDH = "_id";
        public static final String COLUNA_DATA = "data";
        public static final String COLUNA_NOME = "nome";
        public static final String COLUNA_DESC = "descricao";
        public static final String COLUNA_IMAGEM = "id_imagem";
        public static final String COLUNA_IMAGEM1 = "id_imagem1";
    }
}


