package com.qr.mibrahim.motonqiraatashr;

/**
 * Created by m.ibrahim on 16/01/19.
 */

public class farshtayybahModel {


    private int Id ;
    private String bayt ;
    private String noshbayt ;


    public farshtayybahModel(int id, String bayt, String noshbayt) {
        Id = id;
        this.noshbayt = noshbayt;
        this.bayt = bayt;

    }


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getBayt() {
        return bayt;
    }

    public void setBayt(String bayt) {
        this.bayt = bayt;
    }


    public String getNoshbayt() {
        return noshbayt;
    }

    public void setNoshbayt(String bayt) {
        this.noshbayt =noshbayt;
    }
}