package com.project.kv;

import java.util.Objects;

public record Key(String key) {

    public Key {
        if (key == null || key.isEmpty()) {
            throw new IllegalArgumentException("Key cannot be null or empty");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Key key1 = (Key) obj;
        return Objects.equals(key, key1.key);
    }

}
