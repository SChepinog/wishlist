package ru.brasenia.wishlist.service;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import ru.brasenia.wishlist.repo.WishEntity;
import ru.brasenia.wishlist.repo.WishRepo;
import ru.brasenia.wishlist.service.wish.WishData;
import ru.brasenia.wishlist.service.wish.WishDataImpl;

@Service
public class WishServiceImpl implements WishService {

    private final WishRepo wishRepo;

    public WishServiceImpl(WishRepo wishRepo) {
        this.wishRepo = wishRepo;
    }

    @Override
    public List<WishData> getAllWishes() {
        Iterator<WishEntity> all = wishRepo.findAll().iterator();
        List<WishData> result = new LinkedList<>();
        while (all.hasNext()) {
            result.add(new WishDataImpl(all.next().getName()));
        }
        return result;
    }

    @Override
    public WishData saveWith(WishData wishData) {
        WishEntity saved = wishRepo.save(new WishEntity().setName(wishData.getName()));
        return new WishDataImpl(saved.getName());
    }
}
