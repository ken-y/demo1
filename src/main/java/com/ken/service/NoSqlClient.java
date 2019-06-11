package com.ken.service;

public interface NoSqlClient<T> {
    void set(final String key, final T value);

    void set(String key, T value, Long expiry);

    <T> boolean exist(Class<T> clazz, String key);

    T get(final String key, Class<T> clazz);

    <T> void delete(String key);

    <T> void hashSet(String key, String hashKey, T hashValue);

    Object hashGet(String key, String hashKey, Class<?> hashValueClazz);
}
