package com.qr.mibrahim.motonqiraatashr;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class farshtyybah extends AppCompatActivity {

    DatabaseHelper db ;
    Cursor c;
public static String vim;
RelativeLayout bayts;
    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView2;
    TableRow sperateline;
    public static ArrayList<farshtayybahModel> farshtyybahlist;
    public static ArrayList<farshtayybahModel> alter = new ArrayList<farshtayybahModel>();
  //  public  ArrayList<farshtayybahModel> alterall = new ArrayList<farshtayybahModel>();
 //   public static      ArrayList<farshtayybahModel> filteredList = new ArrayList<farshtayybahModel>();
    private TextView emptyView;
    private TextView Surahname;
    private TextView searchnote;
    SearchView searchView;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farshtyybah);

        Intent intent = getIntent();
        String tablename;// default value of tyybah
        //surahid
        String chapterid;
        String matnno = intent.getStringExtra("matnno");
        String matn = intent.getStringExtra("matn");
        chapterid=intent.getStringExtra("key");
        bayts = (RelativeLayout)findViewById(R.id.bayts) ;
        //if it's a string you stored.
        String chaptername = intent.getStringExtra("key2");


       // try1 = (TextView) findViewById(R.id.try1);
      //  if(matnno=="2")   دى مش هتنفع عشان دى جافا استعمل
        // equal استعمل
// handle null co
        tablename="mtantyybah";
        if (matnno==null){matnno="1";}

        if (chapterid!=null && matnno.equals("1")){matn=Constants.Tybahtitle+"\n"+chaptername;}

        if(matnno.equals("2")) {

            tablename = "mstnshatibya";
            if (matn==null){   matn=Constants.shatitle2.trim()+"\n"+chaptername;}  //if (matn==null) عشان لما يكون مختار المتن كامل مش الفهرش محيطش الشابتر ب نل
        }
         else if (matnno.equals("3")){


tablename="addorah";
            if (matn==null)      {  matn=Constants.dorrahtitle2+"\n"+chaptername;}
        }
else {

             tablename="mtantyybah";

        }


       // ------------------------------------------------
        sperateline=(TableRow) findViewById(R.id.separateline);
        searchView = (SearchView) findViewById(R.id.searchView);
        searchView.setQueryHint("ابحث داخل الأبيات ");
        emptyView = (TextView) findViewById(R.id.empty_view);
        searchnote = (TextView) findViewById(R.id.seachnote);

     //   *********************************
        Surahname = (TextView) findViewById(R.id.surahname);


      Surahname.setText(matn);
        recyclerView2 = (RecyclerView) findViewById(R.id.my_recycler_view2);
        recyclerView2.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView2.setLayoutManager(layoutManager);
        recyclerView2.setItemAnimator(new DefaultItemAnimator());

        farshtyybahlist= new ArrayList<>();
        //--------------------------------------------------------
       // TextView textView = new TextView(getApplicationContext());




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

       // String[] args={value};

        // namelist=new LinkedHashMap<>();
        //  int ii;
        SQLiteDatabase sd = db.getReadableDatabase();

     //   Cursor c =  sd.rawQuery("SELECT * FROM surahs WHERE Id = " + value, null);
        //-----------------------------------------------------------------------------------------
if (chapterid!=null){ // check if chpterid has a value

     c =  sd.rawQuery("SELECT * FROM " + tablename+ " WHERE chapter = " +chapterid , null);
//bayts.setBackgroundColor(Color.parseColor("white"));

//recyclerView2.setBackgroundColor(Color.parseColor("white"));
}
        else {

    c =  sd.rawQuery("SELECT * FROM " + tablename , null);

}

//WHERE ayah is not null and  surahno = " + value
//---------------------------------------------------------------------------------------------------
            //    sd.query("surahs",columns,Constants.ROW_ID,args,null,null,null);
//sd.rawQuery("SELECT * FROM surahs WHERE ID = " + value, null);
      //  Cursor cursorc = db.rawQuery("SELECT * FROM LIST WHERE " + ID + " = " + id, null);
        //  ii=cursor.getColumnIndex("word");
        //  wordcombimelist=new ArrayList<String>();
        //    meancombimelist= new ArrayList<String>();

        while (c.moveToNext())
        {

             int Id   =    c.getInt(0);          ;
             String bayt  =    c.getString(1).trim();       ;
             String noshbayt  =   c.getString(2).trim();      ;

            farshtayybahModel f =new farshtayybahModel( Id, bayt, noshbayt);

            farshtyybahlist.add(f);

            // int Id=c.getInt(0);
         ///////////////////////////////////////////  surahname=   "سورة "  +c.getString(1);
           // int idhidden=c.getInt(0);
            // String pos=c.getString(2);

           // DictObjectModel s=new DictObjectModel(Id,surahname,idhidden);

            //ADD TO ARRAYLIS
          //  surahs.add(s);
        }




       /* for (farshtayybahModel item : farshtyybahlist) {

            if(item!=null){
                alter.add(item);}
        }*/
//alter=farshtyybahlist;


        adapter = new farshtyybahAdapter(farshtyybahlist);
        recyclerView2.setAdapter(adapter);

        //----------------------------------------------------


        if (farshtyybahlist.isEmpty()) {
            recyclerView2.setVisibility(View.GONE);
            emptyView.setVisibility(View.VISIBLE);
           searchView.setVisibility(View.GONE);
            sperateline.setVisibility(View.GONE);
           searchnote.setVisibility(View.GONE);

        }
        else {
            recyclerView2.setVisibility(View.VISIBLE);
            emptyView.setVisibility(View.GONE);
        }




/*
String s= surahname;


        try1.setText(surahname);*/
//*--------------------------------------------------------------------------------------------------
      //searchView.setFocusable(true);



searchView.setOnCloseListener(new SearchView.OnCloseListener() {
                                  @Override
                                  public boolean onClose() {
                                      sperateline.setVisibility(View.VISIBLE);
                                      searchView.setBackgroundColor(Color.GRAY);
                                      searchView.clearFocus();

                                      return  true;
                                  }
                              });
        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchView.setFocusable(true);
                searchView.setIconified(false);
                searchView.requestFocusFromTouch();
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {


            @Override
            public boolean onQueryTextSubmit(String query) {
             //   searchView.setBackgroundColor(Color.WHITE);


                return  false; }

            @Override
            public boolean onQueryTextChange(String NameSearch) {
vim=NameSearch;
                sperateline.setVisibility(View.GONE);
searchView.setBackgroundColor(Color.WHITE);
              //  newText = newText.toLowerCase();
                NameSearch = NameSearch.trim();
                final ArrayList<farshtayybahModel> filteredList = new ArrayList<farshtayybahModel>();
               /* String[] parts = NameSearch.split(" ");
                String part1 = NameSearch;//4
                String part2 = NameSearch;if (parts.length>=2){  part1=parts[0]; part2=parts[1];}
*/for (farshtayybahModel item : farshtyybahlist) {

/*if(item!=null){
    alterall.add(item);}
                }*/



/*
                for (farshtayybahModel item : alterall) {*/


                    //final String text = wordcombimelist.get(i).toLowerCase();
                    if (item.getNoshbayt().contains(NameSearch  )

                            || item.getBayt().contains(NameSearch )
                           )
{
    /*StringBuilder mss = new StringBuilder(item.getNoshbayt());
    String[] spilittedb = item.getBayt().split(" ");
    String[] spilittednot = item.getNoshbayt().split(" ");
    String[] spilittedsearch = NameSearch.split(" ");*/
   // for (String b : spilittednot)


  // filteredList.add(item);
   alter=filteredList;
    if (!NameSearch.isEmpty()) {
     //   String newbayt = item.getBayt().replace(NameSearch, "<mark>" + NameSearch + "</mark>");

      /*  String newbayt = item.getBayt().replace(NameSearch," <font color=\"#4CAF50\">"+ NameSearch + "</font>");
      //  filteredList.clear();

        item.setBayt(newbayt);*/
        filteredList.add(item);

    }/*else    if (NameSearch.isEmpty()){filteredList.clear();
*/
/*filteredList=alter;*/
/*for(farshtayybahModel b: alter){

    filteredList.add(b);*/
}}
    //}



                  //  }



                //*******************



            /*    String s = NameSearch;
                // string str = "123456";
                // int num = str.IntegerExtension();
                //Console.WriteLine("The output using extension method: {0}", num);
                StringBuilder mss = new StringBuilder(s);
                var spilitted = s.Split(' ');
                var search = "خلف";
                search = search.Trim();
                var splittedkeywork = search.Split(' ');
                foreach (string f in splittedkeywork ){


                    foreach (var sf in spilitted){

                        if (sf.fsNoTshkel()==f ||sf.fsNoTshkel().Contains(f) || sf==f || sf.Contains(f) ){
                            mss.Replace(sf, "<mark>" + sf + "</mark>");
                        }
                    }
                }
                Console.WriteLine("{0}", mss);
                Console.WriteLine("Hello World");*/

   //  if (NameSearch.isEmpty()) {
       //  adapter = new farshtyybahAdapter(farshtyybahlist);
//adapter.notifyDataSetChanged();
               /* }
                else {
*/

         adapter = new farshtyybahAdapter(filteredList);
         adapter.notifyDataSetChanged();

                recyclerView2.setAdapter(adapter);


                return true;
            }
        });




            }
}
