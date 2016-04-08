package aulas.ddmi.jogotcc_roger;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;

import dao.CartaDao;
import dao.Contract;
import modelo.Carta;

/**
 * Created by Aluno on 28/03/2016.
 */
public class AI extends Activity{
    private CartaDao cartaDAO;
    private static AI ai;
    private final Context context;

    private ImageView campo1_ai, campo2_ai, campo3_ai, campo4_ai;
    private EditText pilaAi;

    int p = 0;
    int pila_atual = p + 1 ;

    public AI(Context context) {
        this.context = context;
    }


    public void Jogada(ArrayList<Carta> cartas_ai) {

        if(pila_atual == 10){
            pila_atual = 10;
        }
        campo1_ai = (ImageView) findViewById(R.id.campo01);
        campo2_ai = (ImageView) findViewById(R.id.campo02);
        campo3_ai = (ImageView) findViewById(R.id.campo03);
        campo4_ai = (ImageView) findViewById(R.id.campo04);

        if(cartas_ai.get(0).getPila() <= pila_atual ){
            campo1_ai.setImageResource(cartas_ai.get(0).getImagem_carta());
            //pila_atual = pila_atual - cartas.get(0).getPila() ;
            //pilaAi.setText(String.valueOf(pila_atual));
        }else {
            if (cartas_ai.get(1).getPila() <= pila_atual) {
                campo1_ai.setImageResource(cartas_ai.get(1).getImagem_carta());

                //pila_atual = pila_atual - cartas.get(0).getPila() ;
                //pilaAi.setText(String.valueOf(pila_atual));
            } else {
                if (cartas_ai.get(2).getPila() <= pila_atual) {
                    campo1_ai.setImageResource(cartas_ai.get(2).getImagem_carta());
                    //pila_atual = pila_atual - cartas.get(0).getPila() ;
                    //pilaAi.setText(String.valueOf(pila_atual));
                } else {
                    if (cartas_ai.get(3).getPila() <= pila_atual) {
                        campo1_ai.setImageResource(cartas_ai.get(3).getImagem_carta());
                        //pila_atual = pila_atual - cartas.get(0).getPila() ;
                        //pilaAi.setText(String.valueOf(pila_atual));
                    } else {
                        if (cartas_ai.get(4).getPila() <= pila_atual) {
                            campo1_ai.setImageResource(cartas_ai.get(4).getImagem_carta());
                            //pila_atual = pila_atual - cartas.get(0).getPila() ;
                            //pilaAi.setText(String.valueOf(pila_atual));
                        } else {
                            //desbolqueia o drag and drop do usuario

                        }

                        }
                    }
                }
            }
    }

}