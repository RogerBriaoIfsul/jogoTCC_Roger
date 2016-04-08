package aulas.ddmi.jogotcc_roger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Aluno on 03/03/2016.
 */
public class Historia extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historia);
    }

    public void batalha(View view){
        Intent it = new Intent(Historia.this, Deck.class);
        startActivity(it);
    }
}
