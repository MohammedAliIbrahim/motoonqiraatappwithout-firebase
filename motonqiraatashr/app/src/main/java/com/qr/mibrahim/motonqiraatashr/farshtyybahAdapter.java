package com.qr.mibrahim.motonqiraatashr;

import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.qr.mibrahim.motonqiraatashr.farshtyybah.vim;
import static com.qr.mibrahim.motonqiraatashr.textproceesung.fsNoTshkel;

/**
 * Created by m.ibrahim on 16/01/19.
 */

public class farshtyybahAdapter extends RecyclerView.Adapter<farshtyybahAdapter.MyViewHolder> {


    //  public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private ArrayList<farshtayybahModel> dataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        SearchView searchView;
        TextView textView1;
        private CardView c2;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        LinearLayout cardfashlin;
       // TextView textViewVersion;
       // TextView rlid;
        // ImageView imageViewIcon;

        public MyViewHolder(final View itemView) {
            super(itemView);
            this.textView1 = (TextView) itemView.findViewById(R.id.textViewt1);
            c2=(CardView) itemView.findViewById(R.id.card_view2);
            this.cardfashlin = (LinearLayout) itemView.findViewById(R.id.lincardfarsh);
         this.searchView = (SearchView) itemView.findViewById(R.id.searchView);
          /*  this.textView2 = (TextView) itemView.findViewById(R.id.textViewt2);
            this.textView3 = (TextView) itemView.findViewById(R.id.textViewt3);
            this.textView4 = (TextView) itemView.findViewById(R.id.textViewt4);
            this.textView5 = (TextView) itemView.findViewById(R.id.textViewt5);
            this.textView6 = (TextView) itemView.findViewById(R.id.textViewt6);*/
          /*  this. rlid = (TextView) itemView.findViewById(R.id.rmmm);
            rlid.setVisibility(View.GONE);*/
            //    itemView.getContext().startActivity(new Intent(itemView.getContext(), farshtyybah.class));

            //    this.imageViewIcon = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }

    public farshtyybahAdapter(ArrayList<farshtayybahModel> data) {
        this.dataSet = data;
    }

    @Override
    public farshtyybahAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType ) {
        final View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.farshtyybah_card_view_row, parent, false);

        //    view.setOnClickListener(MainActivity.myOnClickListener);
        // view.setOnClickListener(mOnClickListener);
        //  MyViewHolder myViewHolder = new MyViewHolder(view);
        final farshtyybahAdapter.MyViewHolder myViewHolder = new farshtyybahAdapter.MyViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int itemPosition = myViewHolder.getLayoutPosition();
              //  String surahid = myViewHolder.rlid.getText().toString();
                Toast.makeText(view.getContext(), "بسم الله الرحمن الرحيم", Toast.LENGTH_LONG).show();
              /*  Intent myIntent = new Intent(v.getContext(), farshtyybah.class);
                myIntent.putExtra("key", surahid);
                v.getContext().startActivity(myIntent);*/
            }
        });

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final farshtyybahAdapter.MyViewHolder holder, final int listPosition) {

        TextView textView1 = holder.textView1;
        CardView c2 = holder.c2;
        LinearLayout cardfashlin = holder.cardfashlin;
        SearchView searchView = holder.searchView;
       /* TextView textView2 = holder.textView2;
        TextView textView3 = holder.textView3;
        TextView textView4 = holder.textView4;
        TextView textView5 = holder.textView5;
        TextView textView6 = holder.textView6;*/

        /*TextView textViewVersion = holder.textViewVersion;
        TextView rlid = holder.rlid;*/
        // ImageView imageView = holder.imageViewIcon;
      /*  if ( vim!=null){
            if (vim.length()>1){*/
      /*  String[] spilittedb = dataSet.get(listPosition).getBayt().split(" ");
        String[] spilittednot = dataSet.get(listPosition).getNoshbayt().replace(vim," <font color=\"#4CAF50\">"+ vim+ "</font>").split(" ");
*/


/*
        if (textproceesung.fsNoTshkel(dataSet.get(listPosition).getBayt()).contains(vim))
                {
                    dataSet.get(listPosition).getBayt().replace(vim);
                     String newbayt = dataSet.get(listPosition).getNoshbayt().replace(vim," <font color=\"#4CAF50\">"+ vim+ "</font>")


                }*/

      /*  for (int i=0;i<= spilittedb.length; i++ ){

            if (spilittednot[i].contains("<")){

               spilittedb[i] =" <font color=\"#4CAF50\">"+ spilittedb[i]+ "</font>";}

        }*/

/*
S/*tring intialbayt = dataSet.get(listPosition).getBayt();
String[] intialbaytarray = intialbayt.split(" ");
               // StringBuilder finalbayt = new StringBuilder(intialbayt);
                StringBuffer finalbayt = new StringBuffer(intialbayt);
               String[] splittedkeywork = vim.split(" ");

                for (String f : splittedkeywork ){
                    for (String word : intialbaytarray ){


                        if (fsNoTshkel(word).equals(f) ||fsNoTshkel(word).contains(f))
                        {
                           finalbayt.toString().replace(f," <font color=\"#4CAF50\">"+ f+ "</font>");
                      //      finalbayt.replace(f.i," <font color=\"#4CAF50\">"+ f+ "</font>");

                        }
*/



//




/*
            String newnotshbayt;
     //  newnotshbayt = dataSet.get(listPosition).getNoshbayt().replace(vim," <font color=\"#4CAF50\">"+ vim+ "</font>");

                for (int i=1;i< spilittednot.length; i++ ){

                    if (spilittednot[i].contains("<")){
String fff = fsNoTshkel(spilittedb[i]);
                fff        ="<font color=\"#4CAF50\">"+ fff+ "</font>";}
                       *//* spilittedb[i] =spilittedb[i].replace(spilittedb[i]," <font color=\"#4CAF50\">"+ spilittedb[i]+ "</font>");}
*//*
                }
//textView1.setText(newbayt);
                String s = "";
StringBuilder finalbayt = new StringBuilder();


                for (String m :spilittedb ) {
                    finalbayt.append(m+" ");
                }*/

     /*   textView1.setText(  Html.fromHtml( ));} else {

                textView1.setText(  dataSet.get(listPosition).getBayt());

            }

        }
        else {
*/
            textView1.setText(  dataSet.get(listPosition).getBayt());


/*if(






        /*textView2.setText(   Html.fromHtml("<dl> <dt><font color=\"#4CAF50\">الكلمة</font>  : </dt> </br> <dd>" +  dataSet.get(listPosition).getWord()+"</dd></dl>"));
        textView3.setText(    Html.fromHtml("<dl> <dt><font color=\"#4CAF50\">مذاهب القراء </font>  : </dt> </br> <dd>" +  dataSet.get(listPosition).getMzaheb()+"</dd></dl>"));
        //<font color="#4CAF50">الفرش والقراءات</font>
        textView4.setText(Html.fromHtml("<dl> <dt><font color=\"#4CAF50\">الفرش والقراءات</font>  : </dt> </br> <dd>" +  dataSet.get(listPosition).getFarsh()+"</dd></dl>"));
       //Html.fromHtml("<dl> <dt><font color=\"#4CAF50\">الشاهد من الطيبة</font>  : </dt> </br> <dd>" +  dataSet.get(listPosition).getFarsh()+"</dd></dl>"
        //"الشاهد من الطيبة  : " +  dataSet.get(listPosition).getShahed()
        textView5.setText(   Html.fromHtml("<dl> <dt><font color=\"#4CAF50\">الشاهد من الطيبة</font>  : </dt> </br> <dd>" +  dataSet.get(listPosition).getShahed()+"</dd></dl>"));
     //   textView6.setText(dataSet.get(listPosition).getSurahno());
        textView6.setText(   Html.fromHtml("<dl> <dt>ترتيب السورة  : </dt> </br> <dd>" +  dataSet.get(listPosition).getSurahno()+"</dd></dl>"));
*/
       // rlid.setText(  String.valueOf(dataSet.get(listPosition).getIdhidden()) );



        // imageView.setImageResource(dataSet.get(listPosition).getImage());




        if(dataSet.get(listPosition).getNoshbayt().toString().contains("(") && dataSet.get(listPosition).getNoshbayt().toString().contains(")") ){


           // textView1.setBackgroundColor(Color.parseColor("#FF424242"));
          //  textView1.setBackgroundColor(Color.parseColor("#4CAF50"));
            textView1.setTextColor(Color.parseColor("#4CAF50"));
            cardfashlin.setBackgroundColor(Color.parseColor("#4CAF50"));
           /* c2.setBackgroundColor(Color.parseColor("#4CAF50"));
            c2.setRadius(10);*/
        }
        if(!dataSet.get(listPosition).getBayt().toString().contains("(")){

//#2e3436
            //cardfashlin.setBackgroundColor(Color.parseColor("#FF424242"));
            cardfashlin.setBackgroundColor(Color.parseColor("#2e3436"));
           // c2.setRadius(10);
            textView1.setBackgroundColor(Color.WHITE);
            textView1.setTextColor(Color.BLACK);
            //   cardfashlin.setBackgroundColor(Color.MAGENTA);
         //   c2.setBackgroundColor(Color.WHITE);
        }


    }
/*
    public void message (final MyViewHolder holder, final int listPosition) {

        int itemPosition = myViewHolder.getLayoutPosition();
        String item = "itemPosition)) )";
        Toast.makeText(view.getContext(), item, Toast.LENGTH_LONG).show();


    }*/





    @Override
    public int getItemCount() {
        return dataSet.size();
    }

}
