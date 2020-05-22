package com.example.caca_a_frase;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Menu extends Activity {

private static Button jogar;
private static Button jogar2;
MediaPlayer player;
public static boolean shouldPlay = false;


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_menu);

    //Isto faz a música tocar quando carrega a atividade!
    player = MediaPlayer.create(this, R.raw.background_music);
    player.setLooping(true);
    player.setVolume(10f,10f);
    player.start();
    //Até aqui!

    onClickButtonListener();
    onClickButtonListener2();

    findViewById(R.id.fullscreen_content_controls);
    findViewById(R.id.fullscreen_content);
    }

//Botão para jogar!

public void onClickButtonListener() {
jogar = (Button) findViewById(R.id.botaoJogar);
final MediaPlayer mp2 = MediaPlayer.create(this, R.raw.click);
jogar.setOnClickListener(
        new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mp2.start();
                Intent intent = new Intent("com.example.caca_a_frase.Jogo");
                shouldPlay = true;
                startActivity(intent);
            }
        }
        );

//Acaba aqui!
//Botão para saír!
Button sair = (Button) findViewById(R.id.botaoSair);
final MediaPlayer mp = MediaPlayer.create(this, R.raw.click);
sair.setOnClickListener(new OnClickListener() {

    @Override
    public void onClick(View v) {

        mp.start();
        createDialog();
    }
        private void createDialog() {
            AlertDialog.Builder alertDlg = new AlertDialog.Builder(Menu.this);
            alertDlg.setMessage("Tens a certeza que queres saír?");
            alertDlg.setCancelable(false);

            alertDlg.setPositiveButton("Sim", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                    System.exit(0);

                }
            });

            alertDlg.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {


                }
            });

                alertDlg.create().show();

                }
            });

}
//Acaba aqui!
//Botão para Opções!

public void onClickButtonListener2() {
    jogar2 = (Button) findViewById(R.id.botaoOpcoes);
    final MediaPlayer mp3 = MediaPlayer.create(this, R.raw.click);
    jogar2.setOnClickListener(
        new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mp3.start();
                Intent intent = new Intent("com.example.caca_a_frase.Opcoes");
                shouldPlay = true;
                startActivity(intent);
            }
        }
        );
}

//Acaba aqui!
//Quando carrega voltar.

@Override
public void onBackPressed() {
createDialog();
}
private void createDialog() {
    AlertDialog.Builder alertDlg = new AlertDialog.Builder(Menu.this);
    alertDlg.setMessage("Tens a certeza que queres saír?");
    alertDlg.setCancelable(false);

    alertDlg.setPositiveButton("Sim", new DialogInterface.OnClickListener() {

        @Override
        public void onClick(DialogInterface dialog, int which) {
            finish();
            System.exit(0);

        }
    });

    alertDlg.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {

        @Override
        public void onClick(DialogInterface dialog, int which) {


        }
    });

        alertDlg.create().show();

}
//Acaba aqui!
//Quando aplicação é fechada!
@Override
protected void onPause() {
        super.onPause();
        if (shouldPlay == false){
            player.pause();
        }
    }
@Override
protected void onResume() {
        super.onResume();
        if (shouldPlay == false){
            player.start();
        }
        else {
            shouldPlay = false;
        }
    }
//Acaba aqui!
}