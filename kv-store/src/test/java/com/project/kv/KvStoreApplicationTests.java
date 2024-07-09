package com.project.kv;

import com.project.kv.storage.InMemoryKeyValueStore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class KvStoreApplicationTests {

	private InMemoryKeyValueStore keyValueStore;

	@BeforeEach
	void setUp() {
		keyValueStore = new InMemoryKeyValueStore();
	}

	@Test
	void testPutAndGet() {
		Key key = new Key("testKey");
		Value value = new Value("testValue");

		keyValueStore.put(key, value);
		Value retrievedValue = keyValueStore.get(key);

		assertEquals(value.value(), retrievedValue.value());
	}

	@Test
	void testDelete() {
		Key key = new Key("testKey");
		Value value = new Value("testValue");

		keyValueStore.put(key, value);
		keyValueStore.delete(key);

		assertNull(keyValueStore.get(key));
	}

	@Test
	void testGetNonExistentKey() {
		Key key = new Key("nonExistentKey");

		assertNull(keyValueStore.get(key));
	}

}
