package adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.View;

import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import aulas.ddmi.jogotcc_roger.R;
import dao.Contract;
import dao.HistoriaDao;

/**
 * Created by Aluno on 01/04/2016.
 */
public class CampanhaAdapter extends SimpleCursorAdapter {
    public CampanhaAdapter(Context context, int layout, Cursor c, String[] from, int[] to, int flags) {
        super(context, layout, c, from, to, flags);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        super.bindView(view, context, cursor);
        /*//mapeia a ImageView do layout da View interna da GridView
        TextView txtdata = (TextView) view.findViewById(R.id.txtdata);
        TextView txtnome = (TextView) view.findViewById(R.id.txtnome);
        //insere a imange no componente a partir do seu id na classe R
        txtdata.setText(cursor.getInt(cursor.getColumnIndex(Contract.Historia.COLUNA_DATA)));
        txtnome.setText(cursor.getInt(cursor.getColumnIndex(Contract.Historia.COLUNA_NOME)));*/
    }
}
