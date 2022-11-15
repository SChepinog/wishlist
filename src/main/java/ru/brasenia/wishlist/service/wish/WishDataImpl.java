package ru.brasenia.wishlist.service.wish;

public class WishDataImpl implements WishData {

    private final String name;

    public WishDataImpl(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
