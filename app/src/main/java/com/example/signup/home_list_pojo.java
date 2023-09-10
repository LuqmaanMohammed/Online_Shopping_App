package com.example.signup;

public class home_list_pojo {
        int item;
        int cart;
    boolean isAddedToCart;

    boolean isClicked; // New field to track if the item is clicked
    public home_list_pojo(int item) {
        this.item = item;
        this.cart = R.drawable.ic_cart_default;
        this.isAddedToCart = false;
        this.isClicked = false; // Default value is false (not clicked)
    }
    public boolean isAddedToCart() {
        return isAddedToCart;
    }

    public void setAddedToCart(boolean addedToCart) {
        isAddedToCart = addedToCart;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getCart() {
        return cart;
    }

    public void setCart(int cart) {
        this.cart = cart;
    }

    public boolean isClicked() {
        return isClicked;
    }

    public void setClicked(boolean clicked) {
        isClicked = clicked;
    }
}
