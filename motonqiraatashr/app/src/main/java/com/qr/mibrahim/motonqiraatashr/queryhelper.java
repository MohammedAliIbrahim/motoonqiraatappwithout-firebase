package com.qr.mibrahim.motonqiraatashr;

/**
 * Created by m.ibrahim on 13/01/19.
 */

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class queryhelper {

    DatabaseHelper db ;

    Context c;
    SQLiteDatabase sd = db.getReadableDatabase();
   // SQLiteDatabase db;
    queryhelper helper;

    public queryhelper(Context c) {
        this.c = c;
        helper=new queryhelper(c);
    }
    public Cursor getAllsurahs()
    {
        String[] columns={Constants.ROW_ID,Constants.NAME};

        return sd.query("surahs",columns,null,null,null,null,null);

    }



}
