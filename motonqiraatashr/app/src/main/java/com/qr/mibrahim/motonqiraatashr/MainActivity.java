package com.qr.mibrahim.motonqiraatashr;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    //***********************************************



    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
   // private static CardView card;
    public static ArrayList<DictObjectModel> surahs;
    DatabaseHelper db ;
   /* ArrayList<Integer> wordcombimelist;

    ArrayList<String> meancombimelist;*/
  //  LinkedHashMap<String,String> namelist;
  // ArrayList<DictObjectModel> surahs;
    SearchView searchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    //    card= (CardView) findViewById(R.id.card_view);
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
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
        surahs= new ArrayList<>();
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

        String[] columns={Constants.ROW_ID,Constants.NAME};



        // namelist=new LinkedHashMap<>();
        //  int ii;
        SQLiteDatabase sd = db.getReadableDatabase();
        Cursor c =  sd.query("mstnshatibya",columns,null,null,null,null,null);
        //  ii=cursor.getColumnIndex("word");
        //  wordcombimelist=new ArrayList<String>();
        //    meancombimelist= new ArrayList<String>();
        while (c.moveToNext())
        {
            int Id=c.getInt(0);
            String surahname=    c.getString(1);
            int idhidden=c.getInt(0);
            // String pos=c.getString(2);

            DictObjectModel s=new DictObjectModel(Id,surahname,idhidden);

            //ADD TO ARRAYLIS
            surahs.add(s);
        }

        //CHECK IF ARRAYLIST ISNT EMPTY
        //  if(!(surahs.size()<1))
        //   {


        //  }



        adapter = new CustomAdapter(surahs);
        recyclerView.setAdapter(adapter);

      //  data = new ArrayList<DictObjectModel>();
       // fetchData();
/*

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {return  false; }

            @Override
            public boolean onQueryTextChange(String newText) {


                newText = newText.toLowerCase();

                final ArrayList<DictObjectModel> filteredList = new ArrayList<DictObjectModel>();

                for (int i = 0; i < wordcombimelist.size(); i++) {

                    final String text = wordcombimelist.get(i).toLowerCase();
                    if (text.contains(newText)) {

                        filteredList.add(new DictObjectModel(wordcombimelist.get(i),meancombimelist.get(i)));
                    }
                }
                adapter = new CustomAdapter(filteredList);
                recyclerView.setAdapter(adapter);


                return true;
            }
        });

*/
    }


    public void fetchData(){

/*
        db =new DatabaseHelper(this);
        try {

            db.createDataBase();
            db.openDataBase();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        String[] columns={Constants.ROW_ID,Constants.NAME};



       // namelist=new LinkedHashMap<>();
      //  int ii;
        SQLiteDatabase sd = db.getReadableDatabase();
        Cursor c =  sd.query("surahs",columns,null,null,null,null,null);
      //  ii=cursor.getColumnIndex("word");
      //  wordcombimelist=new ArrayList<String>();
    //    meancombimelist= new ArrayList<String>();
      /*  while (c.moveToNext())
        {
            int Id=c.getInt(0);
            String surahname=c.getString(1);
            // String pos=c.getString(2);

            DictObjectModel s=new DictObjectModel(Id,surahname);

            //ADD TO ARRAYLIS
            surahs.add(s);
        }*/

        //CHECK IF ARRAYLIST ISNT EMPTY
      //  if(!(surahs.size()<1))
     //   {


      //  }

    //    adapter = new CustomAdapter(surahs);
       // recyclerView.setAdapter(adapter);
    }

/*
        //    surahs.clear();

            queryhelper qh=new queryhelper(this);
        //    db.openDB();

            //RETRIEVE
            Cursor c=qh.getAllsurahs();

            //LOOP AND ADD TO ARRAYLIST
            while (c.moveToNext())
            {
                int Id=c.getInt(0);
                String surahname=c.getString(1);
               // String pos=c.getString(2);

                DictObjectModel s=new DictObjectModel(Id,surahname);

                //ADD TO ARRAYLIS
                surahs.add(s);
            }

            //CHECK IF ARRAYLIST ISNT EMPTY
            if(!(surahs.size()<1))
            {


                adapter = new CustomAdapter(surahs);
                recyclerView.setAdapter(adapter);

            }

        //    db.closeDB();;


*/


       // final ArrayList<DictObjectModel> filteredList = new ArrayList<DictObjectModel>();


/*
        int ii;
        SQLiteDatabase sd = db.getReadableDatabase();
        Cursor cursor = sd.query("surahs" ,null, null, null, null, null, null);
        ii=cursor.getColumnIndex("Id");
        wordcombimelist=new ArrayList<Integer>();
        meancombimelist= new ArrayList<String>();
        while (cursor.moveToNext()){
            namelist.put(cursor.getString(ii), cursor.getString(cursor.getColumnIndex("surahname")));
        }
        Iterator entries = namelist.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry thisEntry = (Map.Entry) entries.next();
            wordcombimelist.add(String.valueOf(thisEntry.getKey()));
            meancombimelist.add("- "+String.valueOf(thisEntry.getValue()));
        }

               // filteredList.add(new DictObjectModel(wordcombimelist.get(i),meancombimelist.get(i)));


        adapter = new CustomAdapter(filteredList);
        recyclerView.setAdapter(adapter);

*/

    }
    /*

     /*
    public void fetchData()
    {
        db =new DatabaseHelper(this);
        try {

            db.createDataBase();
            db.openDataBase();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


        namelist=new LinkedHashMap<>();
        int ii;
        SQLiteDatabase sd = db.getReadableDatabase();
        Cursor cursor = sd.query("surahs" ,null, null, null, null, null, null);
        ii=cursor.getColumnIndex("Id");
        wordcombimelist=new ArrayList<Integer>();
        meancombimelist= new ArrayList<String>();
        while (cursor.moveToNext()){
            namelist.put(cursor.getString(ii), cursor.getString(cursor.getColumnIndex("surahname")));
        }
        Iterator entries = namelist.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry thisEntry = (Map.Entry) entries.next();
            wordcombimelist.add(String.valueOf(thisEntry.getKey()));
            meancombimelist.add("- "+String.valueOf(thisEntry.getValue()));
        }

        for (int i = 0; i < wordcombimelist.size(); i++) {
            data.add(new DictObjectModel(wordcombimelist.get(i), meancombimelist.get(i)));
        }
        adapter = new CustomAdapter(data);
        recyclerView.setAdapter(adapter);
    }*/


