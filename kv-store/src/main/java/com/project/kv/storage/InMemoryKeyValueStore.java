package com.project.kv.storage;

import com.project.kv.Key;
import com.project.kv.Value;

import java.util.concurrent.ConcurrentHashMap;

public class InMemoryKeyValueStore {

    private final ConcurrentHashMap<Key, Value> store = new ConcurrentHashMap<>();

    public void put(Key key, Value value) {
        store.put(key, value);
    }

    public Value get(Key key) {
        return store.get(key);
    }

    public void delete(Key key) {
        store.remove(key);
    }

}
