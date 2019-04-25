package com.okz.cip.cache;

import lombok.extern.slf4j.Slf4j;
import org.crazycake.shiro.IRedisManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.lang.Nullable;

import java.util.Set;

/**
 * @author huangyang
 * @Description: redis 操作类 ，同时实现IRedisManager接口 ，供shiro使用
 * @date 2019/04/24 下午8:16
 */

@Slf4j
public class RedisCache implements IRedisManager, Cache {

    @Autowired
    private StringRedisTemplate template;


    @FunctionalInterface
    private interface RedisCommand<T> {
        T exec(RedisConnection connection);
    }

    private <T> T doRedisCommand(RedisCommand<T> command) {
        return template.execute(new RedisCallback<T>() {
            @Nullable
            @Override
            public T doInRedis(RedisConnection redisConnection) throws DataAccessException {
                return command.exec(redisConnection);
            }
        });
    }


    @Override
    public byte[] get(byte[] key) {
        if (key == null) {
            return null;
        }
        return doRedisCommand(conn -> conn.get(key));
    }

    @Override
    public byte[] set(byte[] key, byte[] value, int expiredSeconds) {
        if (key == null || value == null) {
            return null;
        }

        if (expiredSeconds > 0) {
            doRedisCommand(conn -> conn.setEx(key, expiredSeconds, value));
        } else {
            doRedisCommand(conn -> conn.set(key, value));
        }
        return value;
    }

    @Override
    public void del(byte[] bytes) {
        doRedisCommand(conn -> conn.del(bytes));
    }

    @Override
    public Long dbSize(byte[] bytes) {
        return doRedisCommand(conn -> conn.dbSize());
    }

    @Override
    public Set<byte[]> keys(byte[] bytes) {
        return doRedisCommand(conn -> conn.keys(bytes));
    }
}
