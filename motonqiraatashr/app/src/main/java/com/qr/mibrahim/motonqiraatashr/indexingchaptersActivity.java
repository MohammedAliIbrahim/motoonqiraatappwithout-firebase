package com.qr.mibrahim.motonqiraatashr;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class indexingchaptersActivity extends AppCompatActivity {



    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerViewchapters;
    // private static CardView card;
    public static ArrayList<chaptersmodel> chapters;
    public static String globalmatno;
    DatabaseHelper db ;
    Cursor c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indexingchapters);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();

        String matnno = intent.getStringExtra("matnno");
        String matn = intent.getStringExtra("matn");
     //   setTitle(Html.fromHtml("<p<font color=\"#2e3436\">الفهرس</font></p>" ));
        String index= "الفهرس ";

        String mtnname = Constants.Tybahtitle;
        if (matnno==null){matnno="1";}

        if(matnno.equals("2")) {

            mtnname = Constants.shatitle;

        }
        else if (matnno.equals("3")){


            mtnname=Constants.dorrahtitle;
        }
        else {

            mtnname=Constants.ttitle;
        }
// to carry the value to chapter adapter
globalmatno=matnno;

        String pagetitle=index+":"+mtnname;

        setTitle(pagetitle);
      //  toolbarsetTitleTextColor(Color.parseColor("#2e3436"));
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();


            }
        });



      //  Intent intent = getIntent();
        String tablename;// default value of tyybah
        //surahid
        String chapterid;
     //   String matnno = intent.getStringExtra("matnno");
     //   String matn = intent.getStringExtra("matn");
      //  chapterid=intent.getStringExtra("key");
     //   bayts = (RelativeLayout)findViewById(R.id.bayts) ;
        //if it's a string you stored.
        String chaptername = intent.getStringExtra("key2");

        tablename="tchapters";
        if (matnno==null){matnno="1";}

        if(matnno.equals("2")) {

            tablename = "shchapters";

        }
        else if (matnno.equals("3")){


            tablename="dchapters";
        }
        else {

            tablename="tchapters";
        }






   /* ArrayList<Integer> wordcombimelist;

    ArrayList<String> meancombimelist;*/
        //  LinkedHashMap<String,String> namelist;
        // ArrayList<DictObjectModel> surahs;
        SearchView searchView;



            recyclerViewchapters = (RecyclerView) findViewById(R.id.my_recycler_viewchaptes);
            recyclerViewchapters.setHasFixedSize(true);

            layoutManager = new LinearLayoutManager(this);
            recyclerViewchapters.setLayoutManager(layoutManager);
            recyclerViewchapters.setItemAnimator(new DefaultItemAnimator());
            //  recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
            // recyclerView.setHasFixedSize(true);
     /*   card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(MainActivity.this, farshtyybah.class);
                myIntent.putExtra("key", ""); //Optional parameters
                MainActivity.this.startActivity(myIntent);


            }
        });
        db= new DatabaseHelper(this);
      //  searchView = (SearchView) findViewById(R.id.searchView);
     //   searchView.setQueryHint("Search Here");
       /* searchView.setQueryRefinementEnabled(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);*/
            //  recyclerView.setItemAnimator(new DefaultItemAnimator());
            chapters= new ArrayList<>();
/*
        for(int i = 0 ; i<7 ; i++){
            surahs.add(new DictObjectModel(i,"الفاتحة"));
        }
*/





            db =new DatabaseHelper(this);
            try {

                db.createDataBase();
                db.openDataBase();

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            String[] columns={Constants.ROW_ID,Constants.Tiltle};



            // namelist=new LinkedHashMap<>();
            //  int ii;
            SQLiteDatabase sd = db.getReadableDatabase();
            c =  sd.query(tablename,columns,null,null,null,null,null);
            //  ii=cursor.getColumnIndex("word");
            //  wordcombimelist=new ArrayList<String>();
            //    meancombimelist= new ArrayList<String>();
            while (c.moveToNext())
            {
                int Id=c.getInt(0);
                String title=    c.getString(1);
              //  int idhidden=c.getInt(0);
                // String pos=c.getString(2);

                chaptersmodel s=new chaptersmodel(Id,title);

                //ADD TO ARRAYLIS
                chapters.add(s);
            }

            adapter = new chaptersAdapter(chapters);
            recyclerViewchapters.setAdapter(adapter);

        }



    }

