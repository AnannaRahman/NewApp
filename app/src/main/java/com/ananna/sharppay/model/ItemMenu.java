package com.ananna.sharppay.model;

public class ItemMenu {
    int image;
    String title;
    String titleSummery;
    String description;
    String endTitle;

    String itemRating;


    public ItemMenu(int image, String title, String titleSummery, String description, String endTitle,String itemRating ) {
        this.image=image;
        this.title=title;
        this.titleSummery=titleSummery;
        this.description=description;
        this.endTitle=endTitle;
        this.itemRating=itemRating;

    }


    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleSummery() {
        return titleSummery;
    }

    public void setTitleSummery(String titleSummery) {
        this.titleSummery = titleSummery;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEndTitle() {
        return endTitle;
    }

    public void setEndTitle(String endTitle) {
        this.endTitle = endTitle;
    }

    public String getItemRating() {
        return itemRating;
    }

    public void setItemRating(String itemRating) {
        this.itemRating = itemRating;
    }


}
