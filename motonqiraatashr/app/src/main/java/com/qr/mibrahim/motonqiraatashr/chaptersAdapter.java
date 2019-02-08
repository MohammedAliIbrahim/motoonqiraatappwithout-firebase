package com.qr.mibrahim.motonqiraatashr;

/**
 * Created by m.ibrahim on 29/01/19.
 */

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.qr.mibrahim.motonqiraatashr.indexingchaptersActivity.globalmatno;


public class chaptersAdapter extends RecyclerView.Adapter<chaptersAdapter.MyViewHolder> {


    //  public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private ArrayList<chaptersmodel> dataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
    /*    TextView textViewVersion;
*/
    TextView rlid;
        // ImageView imageViewIcon;

        public MyViewHolder(final View itemView) {
            super(itemView);
            this.textViewName = (TextView) itemView.findViewById(R.id.textViewName);
           /* this.textViewVersion = (TextView) itemView.findViewById(R.id.textViewVersion);*/
          this. rlid = (TextView) itemView.findViewById(R.id.rmmm);
            rlid.setVisibility(View.GONE);
            //    itemView.getContext().startActivity(new Intent(itemView.getContext(), farshtyybah.class));



            //    this.imageViewIcon = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }

    public chaptersAdapter(ArrayList<chaptersmodel> data) {
        this.dataSet = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType ) {
        final View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_row, parent, false);

        //    view.setOnClickListener(MainActivity.myOnClickListener);
        // view.setOnClickListener(mOnClickListener);
        //  MyViewHolder myViewHolder = new MyViewHolder(view);
        final MyViewHolder myViewHolder = new MyViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//*****************************************
                String localmatnno= globalmatno;   // get the value of matnno from indexingactivity
                //************************************
             //   int itemPosition = myViewHolder.getLayoutPosition();
                String chapterid = myViewHolder.rlid.getText().toString();
                String chaptertitle = myViewHolder.textViewName.getText().toString();
                Toast.makeText(view.getContext(), chapterid, Toast.LENGTH_LONG).show();
                Intent myIntent = new Intent(v.getContext(), farshtyybah.class);
                myIntent.putExtra("key", chapterid);
                myIntent.putExtra("key2", chaptertitle);

                myIntent.putExtra("matnno", localmatnno);
              //  myIntent.putExtra("matn", "متن الشاطبية ");
                v.getContext().startActivity(myIntent);
            }
        });

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {



        TextView textViewName = holder.textViewName;
       // TextView textViewVersion = holder.textViewVersion;
        TextView rlid = holder.rlid;
        // ImageView imageView = holder.imageViewIcon;

        textViewName.setText(dataSet.get(listPosition).getTitle());
       /* textViewVersion.setText(   "ترتيب السورة : " +dataSet.get(listPosition).getId());
*/
        rlid.setText(  String.valueOf(dataSet.get(listPosition).getId()) );
        // imageView.setImageResource(dataSet.get(listPosition).getImage());
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