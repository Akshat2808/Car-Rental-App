package com.example.carrentals;

public class ViewItemModel {
    private int imageView;
    private int divider2;
    private int divider3;
    private String heading;
    private String details;
    private String rating_km_driven;
    private String price;

    public ViewItemModel(int imageView, int divider2, int divider3, String heading, String details,
                         String rating_km_driven, String price) {
        this.imageView = imageView;
        this.divider2 = divider2;
        this.divider3 = divider3;
        this.heading = heading;
        this.details = details;
        this.rating_km_driven = rating_km_driven;
        this.price = price;
    }

    public int getImageView() {
        return imageView;
    }

    public void setImageView(int imageView) {
        this.imageView = imageView;
    }

    public int getDivider2() {
        return divider2;
    }

    public void setDivider2(int divider2) {
        this.divider2 = divider2;
    }

    public int getDivider3() {
        return divider3;
    }

    public void setDivider3(int divider3) {
        this.divider3 = divider3;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getRating_km_driven() {
        return rating_km_driven;
    }

    public void setRating_km_driven(String rating_km_driven) {
        this.rating_km_driven = rating_km_driven;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
