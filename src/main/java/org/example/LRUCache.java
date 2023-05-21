package org.example;

import java.util.*;

public class LRUCache {
    private LinkedHashMap<Integer, Integer> cache;
    private int cacheSize;

    public LRUCache(int cacheSize) {
        this.cacheSize = cacheSize;
        cache = new LinkedHashMap<Integer, Integer>(cacheSize, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > LRUCache.this.cacheSize;
            }
        };
    }

    public Integer get(int key) {
        return cache.getOrDefault(key, null);
    }

    public void set(int key, int value) {
        cache.put(key, value);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.set(1, 1);
        cache.set(2, 2);
        System.out.println(cache.get(1));  // returns 1
        cache.set(3, 3);  // evicts key 2
        System.out.println(cache.get(2));  // returns null (not found)
        cache.set(4, 4);  // evicts key 1
        System.out.println(cache.get(1));  // returns null (not found)
        System.out.println(cache.get(3));  // returns 3
        System.out.println(cache.get(4));  // returns 4
    }
}

//    Implement an LRU (Least Recently Used) cache. It should be able to be initialized with a cache size n, and contain the following methods:
//
//        set(key, value): sets key to value. If there are already n items in the cache and we are adding a new item, then it should also remove the least recently used item.
//        get(key): gets the value at key. If no such key exists, return null.
//        Each operation should run in O(1) time.