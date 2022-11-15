package ru.brasenia.wishlist.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ru.brasenia.wishlist.service.wish.WishData;
import ru.brasenia.wishlist.service.wish.WishDataImpl;
import ru.brasenia.wishlist.service.WishService;

@RestController
@RequestMapping("/wish")
public class WishController {

    private final WishService wishService;

    public WishController(WishService wishService) {
        this.wishService = wishService;
    }

    @GetMapping
    public List<String> getAllWishes() {
        return wishService.getAllWishes().stream().map(WishData::getName).collect(Collectors.toList());
    }

    @PostMapping
    public String createWish(
        @RequestParam String name
    ) {
        WishData wishData = wishService.saveWith(new WishDataImpl(name));//TODO to factory
        return wishData.getName();
    }
}
