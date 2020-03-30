package com.example.data_base;

public class Pub {
    private String name; // название
    private String description;
    private int PhotoResource;

    public Pub(String name, String description, int photo_id){

        this.name=name;
        this.description=description;
        this.PhotoResource=photo_id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPhotoResource() {
        return this.PhotoResource;
    }

    public void setPhotoResource(int flagResource) {
        this.PhotoResource = flagResource;
    }
}
