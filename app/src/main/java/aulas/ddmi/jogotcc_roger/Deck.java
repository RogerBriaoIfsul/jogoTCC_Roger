package aulas.ddmi.jogotcc_roger;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.View.OnDragListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;


import dao.CartaDao;
import dao.Contract;
import modelo.Carta;

/**
 * Created by Aluno on 04/03/2016.
 */
public class Deck extends Activity implements OnTouchListener, OnDragListener{


    private ArrayList<Carta> cartas;
    private ArrayList<Carta> cartas_mao;
    private ArrayList<Carta> cartas_ai;
    private CartaDao cartaDAO;
    private ImageView imv0, imv1, imv2, imv3, imv4;
    private ImageView imv0_ai, imv1_ai, imv2_ai, imv3_ai, imv4_ai;
    private ImageView campo1, campo2, campo3, campo4;
    private ImageView campo1_ai, campo2_ai, campo3_ai, campo4_ai;

    private EditText vidaAi;
    private EditText vida;
    private EditText pila;
    private EditText pilaAi;

    int v = 30;
    int p = 0;
    int pila_atual = p + 1 ;

//odsfmeoipszldkffdjdiejfiosadoejrasdfoemfodesa]dsofjeomceoem
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Deck", "Antes de associar o layout.");
        setContentView(R.layout.activity_batalha);
        Log.d("Deck", "Antes de criar a instância de cartaDAO");
        cartaDAO = CartaDao.getInstance(this).open();
        Log.d("Deck", "Criou a instância de cartaDAO");
        //mapeia o editor de texto pila
        vidaAi = (EditText) findViewById(R.id.edtxtVidaAi);
        vida = (EditText) findViewById(R.id.edtxtVida);
        pila = (EditText) findViewById(R.id.edtxtPila);
        pilaAi = (EditText) findViewById(R.id.edtxtPilaAi);

        pilaAi.setText(String.valueOf(pila_atual));
        pila.setText(String.valueOf(pila_atual));
        vida.setText(String.valueOf(v));
        vidaAi.setText(String.valueOf(v)) ;

        cartas = cartaDAO.getListaImagens();
        //realizar um if para embaralhar as cartas como tipo farroupilha
        Collections.shuffle(cartas, new java.util.Random(new java.util.Date().getTime())); // faz um shuffle nas imagens

        // mapeia os containers, cria o handler para o Touch, e coloca a imagem
        // no container
        Log.d("Deck", "tamanho cartas: " + cartas.size());
        imv0 = (ImageView) findViewById(R.id.imageView2);
        Log.d("Deck", "id_imagem arraylist: " + cartas.get(0).getImagem_carta());
        imv0.setTag(cartas.get(0).getImagem_carta());
        imv0.setImageResource(cartas.get(0).getImagem_carta());
        imv0.setOnTouchListener(Deck.this);

        imv1 = (ImageView) findViewById(R.id.imageView3);
        imv1.setTag(cartas.get(1).getImagem_carta());
        imv1.setImageResource(cartas.get(1).getImagem_carta());
        imv1.setOnTouchListener(Deck.this);

        imv2 = (ImageView) findViewById(R.id.imageView4);
        imv2.setTag(cartas.get(2).getImagem_carta());
        imv2.setImageResource(cartas.get(2).getImagem_carta());
        imv2.setOnTouchListener(Deck.this);

        imv3 = (ImageView) findViewById(R.id.imageView5);
        imv3.setTag(cartas.get(3).getImagem_carta());
        imv3.setImageResource(cartas.get(3).getImagem_carta());
        imv3.setOnTouchListener(Deck.this);

        imv4 = (ImageView) findViewById(R.id.imageView6);
        imv4.setTag(cartas.get(4).getImagem_carta());
        imv4.setImageResource(cartas.get(4).getImagem_carta());
        imv4.setOnTouchListener(Deck.this);


        //embaralha as cartas do oponente
        cartas_ai = cartaDAO.getListaImagensImperiais();
        //realizar um if para embaralhar as cartas como tipo imperial
        Collections.shuffle(cartas_ai, new java.util.Random(new java.util.Date().getTime()));

        cartas_mao = new ArrayList<Carta>(5);
        //mapeia as cartas do oponente
        imv0_ai = (ImageView) findViewById(R.id.verso1);
        imv0_ai.setTag(cartas_ai.get(0).getImagem_carta());
        imv0_ai.setImageResource(R.drawable.metadeverso);

        imv1_ai = (ImageView) findViewById(R.id.verso2);
        imv1_ai.setTag(cartas_ai.get(1).getImagem_carta());
        imv1_ai.setImageResource(R.drawable.metadeverso);

        imv2_ai = (ImageView) findViewById(R.id.verso3);
        imv2_ai.setTag(cartas_ai.get(2).getImagem_carta());
        imv2_ai.setImageResource(R.drawable.metadeverso);

        imv3_ai = (ImageView) findViewById(R.id.verso4);
        imv3_ai.setTag(cartas_ai.get(3).getImagem_carta());
        imv3_ai.setImageResource(R.drawable.metadeverso);

        imv4_ai = (ImageView) findViewById(R.id.verso5);
        imv4_ai.setTag(cartas_ai.get(4).getImagem_carta());
        imv4_ai.setImageResource(R.drawable.metadeverso);

        //mapeia o container de cartas do usuario
        campo1 = (ImageView) findViewById(R.id.campo01);
        campo2 = (ImageView) findViewById(R.id.campo02);
        campo3 = (ImageView) findViewById(R.id.campo03);
        campo4 = (ImageView) findViewById(R.id.campo04);

        //mapeia o container de cartas da ai
        campo1_ai = (ImageView) findViewById(R.id.campo01);
        campo2_ai = (ImageView) findViewById(R.id.campo02);
        campo3_ai = (ImageView) findViewById(R.id.campo03);
        campo4_ai = (ImageView) findViewById(R.id.campo04);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Queres trocar as cartas da mão?");
        builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Deck.Embaralhar();
                cartas = cartaDAO.getListaImagens();
                Log.d("Deck", "pegou as cartas no banco ");
                Collections.shuffle(cartas, new java.util.Random(
                        new java.util.Date().getTime())); // faz um shuffle nas imagens
                Log.d("Deck", "Embaralhou as cartas ");

                // mapeia os containers, cria o handler para o Touch, e coloca a imagem
                // no container
                imv0 = (ImageView) findViewById(R.id.imageView2);
                imv0.setTag(cartas.get(0).getImagem_carta());
                imv0.setImageResource(cartas.get(0).getImagem_carta());
                imv0.setOnTouchListener(Deck.this);

                imv1 = (ImageView) findViewById(R.id.imageView3);
                imv1.setTag(cartas.get(1).getImagem_carta());
                imv1.setImageResource(cartas.get(1).getImagem_carta());
                imv1.setOnTouchListener(Deck.this);

                imv2 = (ImageView) findViewById(R.id.imageView4);
                imv2.setTag(cartas.get(2).getImagem_carta());
                imv2.setImageResource(cartas.get(2).getImagem_carta());
                imv2.setOnTouchListener(Deck.this);

                imv3 = (ImageView) findViewById(R.id.imageView5);
                imv3.setTag(cartas.get(3).getImagem_carta());
                imv3.setImageResource(cartas.get(3).getImagem_carta());
                imv3.setOnTouchListener(Deck.this);

                imv4 = (ImageView) findViewById(R.id.imageView6);
                imv4.setTag(cartas.get(4).getImagem_carta());
                imv4.setImageResource(cartas.get(4).getImagem_carta());
                imv4.setOnTouchListener(Deck.this);

                Toast.makeText(getBaseContext(), "Troucou a mão", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int Não) {
                Toast.makeText(getBaseContext(), "Permanece com a mão", Toast.LENGTH_SHORT).show();
                return;
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();

        campo1 = (ImageView) findViewById(R.id.campo1);
        campo1.setOnDragListener(Deck.this);
        campo2 = (ImageView) findViewById(R.id.campo2);
        campo2.setOnDragListener(Deck.this);
        campo3 = (ImageView) findViewById(R.id.campo3);
        campo3.setOnDragListener(Deck.this);
        campo4 = (ImageView) findViewById(R.id.campo4);
        campo4.setOnDragListener(Deck.this); // estabelece que o ViewGroup dos campos
        // serão o Listener (ouvinte)
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Log.d("Main", "Entrou no touch. Tag da View = " + v.getTag().toString());
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            ClipData clipdata= ClipData.newPlainText("my", v.getTag().toString()); //vincula dados ao View (objeto) que est� sendo arrastado
            View.DragShadowBuilder dsb = new View.DragShadowBuilder(v); //faz a imagem do objeto aparecer durante o arraste
            v.startDrag(clipdata, dsb, v, 0);
            return true;
        }
        return false;
    }


    @Override
    public boolean onDrag(View v, DragEvent event) {
        switch(event.getAction()){
            case DragEvent.ACTION_DRAG_STARTED:{ //ao inicializar, clipData
                return true;
            }
            case DragEvent.ACTION_DRAG_EXITED:{ //ao sair da �rea de drop
                Log.d("Deck", "saiu da AREA DE DROP");

                break;
            }
            case DragEvent.ACTION_DRAG_ENTERED:{ //ao entrar na �rea de drop
                Log.d("Deck", "Entrou na AREA DE DROP");
                break;
            }
            case DragEvent.ACTION_DRAG_ENDED:{ //ao encerrar a opera��o de arraste (ao soltar)
                Log.d("Deck", "encerra o drag and drop.");
                break;
            }
            case DragEvent.ACTION_DROP:{ //ao realizar o Drop (soltar)
                Log.d("Deck", "Objeto arrastado.");
                //identifica a tag "my" e l� o valor anexado no ClipData
                event.getResult();
                if (event.getClipDescription().getLabel().equals("my"))
                    Log.d("Deck","Dados obtidos do ClipData. Tag = "+event.getClipData().getItemAt(event.getClipData().getItemCount()-1).getText().toString());

                if(cartas.get(0).getPila() <= pila_atual ){
                    v.setTag(Integer.parseInt(event.getClipData().getItemAt(event.getClipData().getItemCount() - 1).getText().toString()));
                    ImageView imv = (ImageView) v;
                    imv.setImageResource(Integer.parseInt(event.getClipData().getItemAt(event.getClipData().getItemCount() - 1).getText().toString()));
                    v.setVisibility(View.VISIBLE);

                    pila_atual = pila_atual - cartas.get(0).getPila() ;
                    pila.setText(String.valueOf(pila_atual));

                    break;
                }else {
                    if (cartas.get(1).getPila() <= pila_atual) {
                        v.setTag(Integer.parseInt(event.getClipData().getItemAt(event.getClipData().getItemCount() - 1).getText().toString()));
                        ImageView imv = (ImageView) v;
                        imv.setImageResource(Integer.parseInt(event.getClipData().getItemAt(event.getClipData().getItemCount() - 1).getText().toString()));
                        v.setVisibility(View.VISIBLE);

                        pila_atual = pila_atual - cartas.get(1).getPila() ;
                        pila.setText(String.valueOf(pila_atual));

                        break;
                    } else {
                        if (cartas.get(2).getPila() <= pila_atual) {
                            v.setTag(Integer.parseInt(event.getClipData().getItemAt(event.getClipData().getItemCount() - 1).getText().toString()));
                            ImageView imv = (ImageView) v;
                            imv.setImageResource(Integer.parseInt(event.getClipData().getItemAt(event.getClipData().getItemCount() - 1).getText().toString()));
                            v.setVisibility(View.VISIBLE);

                            pila_atual = pila_atual - cartas.get(2).getPila() ;
                            pila.setText(String.valueOf(pila_atual));

                            break;
                        } else {
                            if (cartas.get(3).getPila() <= pila_atual) {
                                v.setTag(Integer.parseInt(event.getClipData().getItemAt(event.getClipData().getItemCount() - 1).getText().toString()));
                                ImageView imv = (ImageView) v;
                                imv.setImageResource(Integer.parseInt(event.getClipData().getItemAt(event.getClipData().getItemCount() - 1).getText().toString()));
                                v.setVisibility(View.VISIBLE);

                                pila_atual = pila_atual - cartas.get(3).getPila() ;
                                pila.setText(String.valueOf(pila_atual));

                                break;
                            } else {
                                if (cartas.get(4).getPila() <= pila_atual) {
                                    v.setTag(Integer.parseInt(event.getClipData().getItemAt(event.getClipData().getItemCount() - 1).getText().toString()));
                                    ImageView imv = (ImageView) v;
                                    imv.setImageResource(Integer.parseInt(event.getClipData().getItemAt(event.getClipData().getItemCount() - 1).getText().toString()));
                                    v.setVisibility(View.VISIBLE);

                                    pila_atual = pila_atual - cartas.get(4).getPila() ;
                                    pila.setText(String.valueOf(pila_atual));

                                    break;
                                } else {
                                    return false;
                                }
                            }
                        }
                    }
                }

            }
            default:{ //por padr�o, fa�a nada.
                break;
            }
        }
        return true;
    }

    public void Passar(View view){
        Log.d("Deck","Antes de acionar o onClick");
        Button btnPassar = (Button) findViewById(R.id.btnPassar);
        btnPassar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //Faz o "Ataque"
                Log.d("Deck","Entrou no onClick");
                //Chama o "oponente"
                if(pila_atual == 10){
                    pila_atual = 10;
                }
                Log.d("Deck", "Antes de Verificar cartas da mao " +cartas_ai.get(0).getPila());
                if(cartas_ai.get(0).getPila() <= pila_atual){
                    //adiciona a carta no campo 1
                    campo1_ai.setImageResource(cartas_ai.get(0).getImagem_carta());
                    //desconta o pila da carta com o pila da visao
                    pila_atual = pila_atual - cartas.get(0).getPila() ;
                    pilaAi.setText(String.valueOf(pila_atual));

                    Log.d("Deck", "Verificou cartas da mao");

                    Toast.makeText(Deck.this, "Oponente passou a Vez", Toast.LENGTH_SHORT).show();

                }else {
                    Log.d("Deck", "Antes de Verificar cartas da mao" +cartas_ai.get(1).getPila());
                    if (cartas_ai.get(1).getPila() <= pila_atual) {

                        campo1_ai.setImageResource(cartas_ai.get(1).getImagem_carta());
                        pila_atual = pila_atual - cartas.get(1).getPila() ;
                        pilaAi.setText(String.valueOf(pila_atual));
                        Log.d("Deck", "Verificou cartas da mao");

                        Toast.makeText(Deck.this, "Oponente passou a Vez", Toast.LENGTH_SHORT).show();

                    } else {
                        Log.d("Deck", "Antes de Verificar cartas da mao" +cartas_ai.get(2).getPila());
                        if (cartas_ai.get(2).getPila() <= pila_atual) {
                            campo1_ai.setImageResource(cartas_ai.get(2).getImagem_carta());
                            pila_atual = pila_atual - cartas.get(2).getPila() ;
                            pilaAi.setText(String.valueOf(pila_atual));
                            Log.d("Deck", "Verificou cartas da mao");
                            Toast.makeText(Deck.this, "Oponente passou a Vez", Toast.LENGTH_SHORT).show();

                        } else {
                            Log.d("Deck", "Antes de Verificar cartas da mao" +cartas_ai.get(3).getPila());
                            if (cartas_ai.get(3).getPila() <= pila_atual) {
                                campo1_ai.setImageResource(cartas_ai.get(3).getImagem_carta());
                                pila_atual = pila_atual - cartas.get(3).getPila() ;
                                pilaAi.setText(String.valueOf(pila_atual));
                                Log.d("Deck", "Verificou cartas da mao");
                                Toast.makeText(Deck.this, "Oponente passou a Vez", Toast.LENGTH_SHORT).show();

                            } else {
                                Log.d("Deck", "Antes de Verificar cartas da mao" +cartas_ai.get(4).getPila());
                                if (cartas_ai.get(4).getPila() <= pila_atual) {
                                    campo1_ai.setImageResource(cartas_ai.get(4).getImagem_carta());
                                    pila_atual = pila_atual - cartas.get(4).getPila() ;
                                    pilaAi.setText(String.valueOf(pila_atual));
                                    Log.d("Deck", "Verificou cartas da mao");
                                    Toast.makeText(Deck.this, "Oponente passou a Vez", Toast.LENGTH_SHORT).show();

                                } else {Log.d("Deck", "Não entrou em nenhuma das condições");
                                    //desbolqueia o drag and drop do usuario
                                    Toast.makeText(Deck.this, "Oponente passou a Vez", Toast.LENGTH_SHORT).show();

                                }
                            }
                        }
                    }
                }
            }
        });
    }

}
