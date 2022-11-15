package ru.brasenia.wishlist.service;

import java.util.List;

import ru.brasenia.wishlist.service.wish.WishData;

public interface WishService {

    List<WishData> getAllWishes();

    WishData saveWith(WishData wishData);
}
