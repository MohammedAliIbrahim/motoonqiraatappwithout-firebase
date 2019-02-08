package com.qr.mibrahim.motonqiraatashr;

/**
 * Created by m.ibrahim on 29/01/19.
 */

public class chaptersmodel {
    private int Id ;

    public chaptersmodel(int id, String title) {
        Id = id;
        this.title = title;
    }

    private String title ;


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
