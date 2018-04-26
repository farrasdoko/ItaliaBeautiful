package com.gmail.farasabiyyu12.italiabeautiful.Recyclerview;

/**
 *
 * Created by farasabiyyuhandoko on 24/04/18.
 *
 */

public class ItemObject {
    private String name;
    private int photo;

    public ItemObject(String name, int photo) {
        this.name = name;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
