package aulas.ddmi.jogotcc_roger;



import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import dao.CartaDao;

public class InicialActivity extends Activity {

    MediaPlayer mp = new MediaPlayer();
    @Override
    protected void onCreate(Bundle safedInstanceState) {
        super.onCreate(safedInstanceState);
        setContentView(R.layout.activity_incial);
        CartaDao.getInstance(this).open();

        mp.stop();
        mp = MediaPlayer.create(this, R.raw.riogrande);
        mp.start();
        mp.setLooping(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_incial, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void campanha(View view){
        Intent it = new Intent(InicialActivity.this, Campanha.class);
        startActivity(it);
    }
}
