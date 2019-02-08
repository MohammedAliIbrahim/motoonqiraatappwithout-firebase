package com.qr.mibrahim.motonqiraatashr;

/**
 * Created by m.ibrahim on 23/01/19.
 */

public  class textproceesung {



    public static String fsNoTshkel(String s)
    {
        try
        {
            s = s.replace("ْ", ""); //   ْ
            s = s.replace("َ", ""); //   َ
            s = s.replace("ِ", ""); //   ِ
            s = s.replace("ّ", ""); //   ّ
            s = s.replace("ُ", ""); //   ُ
            s = s.replace("ً", ""); //   ً
            s = s.replace("ٍ", ""); //  ٍ
            s = s.replace("ّ", ""); // ~
            s = s.replace("ٌ", ""); //  ٌ

            return s;
        }
        catch (Exception e)
        {

            s = " ";
            return s;
        }
    }







}
