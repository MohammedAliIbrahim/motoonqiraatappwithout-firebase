package com.qr.mibrahim.motonqiraatashr;

public class DictObjectModel {


    private int Id ;
    private String surahname ;
    private int idhidden ;
   // String word, meaning;

public DictObjectModel(int Id, String surahname, int idhidden){

    this.setId(Id);
    this.setSurahname(surahname);
this.setIdhidden(idhidden);

    }


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getSurahname() {
        return surahname;
    }

    public void setSurahname(String surahname) {
        this.surahname = surahname;
    }

    public int getIdhidden() {
        return idhidden;
    }

    public void setIdhidden(int idhidden) {
        this.idhidden = idhidden;
    }
}
