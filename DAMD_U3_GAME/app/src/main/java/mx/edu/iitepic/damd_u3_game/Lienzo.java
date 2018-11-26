package mx.edu.iitepic.damd_u3_game;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo extends View {

    Imagen fondo, nave, gameover, intentar, puntero, misil01, punteroMisil, alien1, alien2, alien3, puntero1, puntero2, fuego1, fuego2, fuego3, gana;
    Roca roca1, roca2, roca3, roca4,roca5,roca6, roca7,roca8,roca9;
    String puntuacion;
    int puntaje = 0;

    MediaPlayer player;

    MainActivity inicio;

    public Lienzo(Context context) {
        super(context);

        puntuacion = "Puntaje: 0";

        fondo = new Imagen(R.drawable.cielok, 0, 0, this, fondo);

        nave = new Imagen(R.drawable.nav2, 750, 1800,this, nave);

        gameover = new Imagen(R.drawable.gameover, 450,450,this, gameover);
        gameover.hacerVisible(false);

        intentar = new Imagen(R.drawable.kia, 480, 1350,this, intentar);
        intentar.hacerVisible(false);

        gana= new Imagen(R.drawable.winner,450,450,this,gana);
        gana.hacerVisible(false);


        roca1 = new Roca(R.drawable.meteorito3,0,0,this);
        roca1.moverRoca(20);
        roca2 = new Roca(R.drawable.meteorito3,200,-100,this);
        roca2.moverRoca(5);
        roca3 = new Roca(R.drawable.meteorito3,410,-200,this);
        roca3.moverRoca(15);
        roca4 = new Roca(R.drawable.meteorito3,600,-150,this);
        roca4.moverRoca(22);
        roca5 = new Roca(R.drawable.meteorito3,800,-300,this);
        roca5.moverRoca(10);
        roca6 = new Roca(R.drawable.meteorito3,1000,-100,this);
        roca6.moverRoca(2);
        roca7 = new Roca(R.drawable.meteorito3,1200,0,this);
        roca7.moverRoca(17);
        roca8 = new Roca(R.drawable.meteorito3,1400,-300,this);
        roca8.moverRoca(10);
        roca9 = new Roca(R.drawable.meteorito3,1600,-100,this);
        roca9.moverRoca(5);


        alien1 = new Imagen(R.drawable.naveimg, 720,150,this, alien1);
        alien1.moverAlien(20);
        puntero1 = alien1;
        fuego1 = new Imagen(R.drawable.balaimg,855,150, this, alien1);
        fuego1.moverFuego(40);



        alien2 = new Imagen(R.drawable.naveimg, 100,-250,this, alien2);
        alien2.moverAlien(30);
        puntero2 = alien2;
        fuego2 = new Imagen(R.drawable.balaimg,250,-250,this, alien2);
        fuego2.moverFuego(40);


        alien3 = new Imagen(R.drawable.naveimg, 1400,-250,this, alien3);
        alien3.moverAlien(30);
        puntero2 = alien3;
        fuego3 = new Imagen(R.drawable.balaimg,1525,-255,this, alien3);
        fuego3.moverFuego(40);



        misil01 = new Imagen(R.drawable.misi2,850,2300,this, misil01);

        puntero = null; //
        punteroMisil = null;



        inicio = (MainActivity) context;


    }

    @Override
    protected void onDraw(Canvas c){
        super.onDraw(c);
        Paint p = new Paint();

        fondo.pintar(c, p);

        roca1.pintarRoca(c,p);
        roca2.pintarRoca(c,p);
        roca3.pintarRoca(c,p);
        roca4.pintarRoca(c,p);
        roca5.pintarRoca(c,p);
        roca6.pintarRoca(c,p);
        roca7.pintarRoca(c,p);
        roca8.pintarRoca(c,p);
        roca9.pintarRoca(c,p);

        misil01.pintar(c,p);


        fuego1.pintar(c,p);
        fuego2.pintar(c,p);
        fuego3.pintar(c,p);

        alien1.pintar(c,p);
        alien2.pintar(c,p);
        alien3.pintar(c,p);



        nave.pintar(c,p);


        p.setTextSize(100);
        p.setColor(Color.WHITE);
        c.drawText(puntuacion,50,100,p);



        gameover.pintar(c,p);
        intentar.pintar(c,p);

        gana.pintar(c,p);


        if(nave.colision(alien1)==true || nave.colision(alien2)==true || nave.colision(alien3)==true){
            nave.hacerVisible(false);
            alien1.hacerVisible(false);
            alien2.hacerVisible(false);
            alien3.hacerVisible(false);
            fuego1.hacerVisible(false);
            fuego2.hacerVisible(false);
            fuego3.hacerVisible(false);
            gameover.hacerVisible(true);
            intentar.hacerVisible(true);
        }


        if(fuego1.colision(nave)==true || fuego2.colision(nave)==true || fuego3.colision(nave)==true){

            nave.hacerVisible(false);
            alien1.hacerVisible(false);
            alien2.hacerVisible(false);
            alien3.hacerVisible(false);
            fuego1.hacerVisible(false);
            fuego2.hacerVisible(false);
            fuego3.hacerVisible(false);
            gameover.hacerVisible(true);
            intentar.hacerVisible(true);
        }


        if(misil01.colision(alien1)==true){
            alien1.hacerVisible(false);
            alien1 = new Imagen(R.drawable.alienimg, 720,-250,this, alien1);
            alien1.moverAlien(20);

            misil01 = new Imagen(R.drawable.misi2,-50,2600,this, misil01);

            fuego1 = new Imagen(R.drawable.balaimg,855,-255, this, alien1);
            fuego1.moverFuego(60);

            puntaje = puntaje +100;
            puntuacion = "Puntaje: " + puntaje;
        }

        if(misil01.colision(alien2)==true){
            alien2.hacerVisible(false);
            alien2 = new Imagen(R.drawable.alienimg, 100,-250,this, alien2);
            alien2.moverAlien(20);

            misil01 = new Imagen(R.drawable.misi2,-50,2600,this, misil01);

            fuego2 = new Imagen(R.drawable.balaimg,250,-250,this, alien2);
            fuego2.moverFuego(60);

            puntaje = puntaje +100;
            puntuacion = "Puntaje: " + puntaje;

        }

        if(misil01.colision(alien3)==true){
            alien3.hacerVisible(false);

            alien3 = new Imagen(R.drawable.alienimg, 1400,-250,this, alien3);
            alien3.moverAlien(20);
            misil01 = new Imagen(R.drawable.misi2,-50,2600,this, misil01);

            fuego3 = new Imagen(R.drawable.balaimg,1525,-255,this, alien3);
            fuego3.moverFuego(60);

            puntaje = puntaje +100;
            puntuacion = "Puntaje: " + puntaje;
        }

        if (puntaje == 400){

            nave.hacerVisible(false);
            alien1.hacerVisible(false);
            alien2.hacerVisible(false);
            alien3.hacerVisible(false);
            fuego1.hacerVisible(false);
            fuego2.hacerVisible(false);
            fuego3.hacerVisible(false);
            gana.hacerVisible(true);
            intentar.hacerVisible(true);

        }

    }


    public boolean onTouchEvent(MotionEvent e){

        float xp = e.getX();
        float yp = e.getY();

        switch (e.getAction()){
            case MotionEvent.ACTION_DOWN:
                if (nave.estaEnArea(xp,yp)){
                    puntero = nave;
                }
                if (intentar.estaEnArea(xp,yp)){
                    cargarPantalla();
                }

                break;

            case MotionEvent.ACTION_MOVE:
                if (puntero!=null){
                    if(nave.estaEnArea(xp,yp)){
                        nave.mover(xp);
                    }
                }

                break;

            case MotionEvent.ACTION_UP:

                if (puntero!=null){
                    if(nave.estaEnArea(xp,yp)){
                        misil01 = new Imagen(R.drawable.misi2,xp,2050,this, misil01);
                        misil01.moverMisil(25);
                        punteroMisil = misil01;
                    }
                }
                break;
        }
        invalidate();
        return true;
    }

    private void cargarPantalla() {

        Intent pantalla = new Intent(inicio,Main2Activity.class);
        inicio.startActivity(pantalla);

    }


}
