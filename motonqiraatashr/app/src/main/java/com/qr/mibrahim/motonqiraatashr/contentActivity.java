package com.qr.mibrahim.motonqiraatashr;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.SearchView;
import android.text.Html;
import android.view.View;
import android.widget.TableRow;
import android.widget.TextView;


public class contentActivity extends AppCompatActivity {


    private CardView tybbah;
    private CardView shatbyah;
    private CardView dorrah;
    private TextView fullt;
    private TextView title1;
    private TextView bychaptert;
    private TextView fullsh;
    private TextView titlesh;
    private TextView bychaptersh;
    private TextView fulld;
    private TextView titled;
    private TextView bychapterd;

 //   private final int SPLASH_DISPLAY_LENGTH = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);


        tybbah=(CardView) findViewById(R.id.card_viewtyybah);
        shatbyah=(CardView) findViewById(R.id.card_viewshatibya);
        dorrah=(CardView) findViewById(R.id.card_addorah);
        //************************
fullt = (TextView) findViewById(R.id.full) ;
        bychaptert = (TextView) findViewById(R.id.bychapter) ;
        title1 = (TextView) findViewById(R.id.title1) ;

        //***********
        fullsh = (TextView) findViewById(R.id.fullsh) ;
        bychaptersh = (TextView) findViewById(R.id.bychaptersh) ;
        titlesh = (TextView) findViewById(R.id.title2) ;
        //*********************
        fulld = (TextView) findViewById(R.id.fulld) ;
        bychapterd = (TextView) findViewById(R.id.bychapterd) ;
        titled = (TextView) findViewById(R.id.title3) ;
        //************

        fullt.setText(Html.fromHtml("<u>  المتن كاملا  </u> -->"));
        bychaptert.setText(Html.fromHtml("<u>  المتن مقسما حسب الباب  </u> --> " ));
        fullt.setVisibility(View.GONE);
        bychaptert.setVisibility(View.GONE);
        //***********************

        fullsh.setText(Html.fromHtml("<u>  المتن كاملا   </u>  -->"));
        bychaptersh.setText(Html.fromHtml("<u>  المتن مقسما حسب الباب </u> -->"));
        fullsh.setVisibility(View.GONE);
        bychaptersh.setVisibility(View.GONE);
        //*****************
        fulld.setText(Html.fromHtml("<u>  المتن كاملا  </u> -->"));
        bychapterd.setText(Html.fromHtml("<u> المتن مقسما حسب الباب  </u> -->"));
        fulld.setVisibility(View.GONE);
        bychapterd.setVisibility(View.GONE);


      //  tybbah.setOnClickListener      الضغط عبلى الكارد فيو
       title1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (fullt.getVisibility()==View.GONE){
fullt.setVisibility(View.VISIBLE);
               bychaptert.setVisibility(View.VISIBLE);}
               else {fullt.setVisibility(View.GONE);
                    bychaptert.setVisibility(View.GONE);
                }
             /*   Intent myIntent = new Intent(view.getContext(), farshtyybah.class);

                myIntent.putExtra("matnno", "1");
                myIntent.putExtra("matn", "متن طيبة النشر ");
                //   myIntent.putExtra("key2", surahname);
                view.getContext().startActivity(myIntent);*/

            }
        });

fullt.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent myIntent = new Intent(view.getContext(), farshtyybah.class);

        myIntent.putExtra("matnno", "1");
        myIntent.putExtra("matn", "متن طيبة النشر ");
        //   myIntent.putExtra("key2", surahname);
        view.getContext().startActivity(myIntent);
    }
});


       bychaptert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), indexingchaptersActivity.class);

                myIntent.putExtra("matnno", "1");
                myIntent.putExtra("matn", "متن طيبة النشر ");
                //   myIntent.putExtra("key2", surahname);
                view.getContext().startActivity(myIntent);
            }
        });


        titlesh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (fullsh.getVisibility()==View.GONE){
                    fullsh.setVisibility(View.VISIBLE);
                    bychaptersh.setVisibility(View.VISIBLE);}
                else {fullsh.setVisibility(View.GONE);
                    bychaptersh.setVisibility(View.GONE);
                }        }
        });
        bychaptersh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), indexingchaptersActivity.class);

                myIntent.putExtra("matnno", "2");
                myIntent.putExtra("matn", "متن الشاطبية ");
                //   myIntent.putExtra("key2", surahname);
                view.getContext().startActivity(myIntent);
            }
        });
      //  shatbyah.setOnClickListener
       fullsh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(view.getContext(), farshtyybah.class);

                myIntent.putExtra("matnno", "2");
                myIntent.putExtra("matn", "متن الشاطبية ");
                //   myIntent.putExtra("key2", surahname);
                view.getContext().startActivity(myIntent);

            }
        });




        titled.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (fulld.getVisibility()==View.GONE){
                    fulld.setVisibility(View.VISIBLE);
                    bychapterd.setVisibility(View.VISIBLE);}
                else {fulld.setVisibility(View.GONE);
                    bychapterd.setVisibility(View.GONE);
                }        }
        });

       // dorrah.setOnClickListener
        fulld.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(view.getContext(), farshtyybah.class);

                myIntent.putExtra("matnno", "3");
                myIntent.putExtra("matn", "متن الدرة المضيئة ");
                //   myIntent.putExtra("key2", surahname);
                view.getContext().startActivity(myIntent);

            }
        });


        bychapterd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), indexingchaptersActivity.class);

                myIntent.putExtra("matnno", "3");
                myIntent.putExtra("matn", "متن الدرة المضيئة ");
                //   myIntent.putExtra("key2", surahname);
                view.getContext().startActivity(myIntent);
            }
        });

       /* new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                *//* Create an Intent that will start the Menu-Activity. *//*
                Intent mainIntent = new Intent(contentActivity.this,splash.class);
                contentActivity.this.startActivity(mainIntent);
                contentActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);*/
    }
}
