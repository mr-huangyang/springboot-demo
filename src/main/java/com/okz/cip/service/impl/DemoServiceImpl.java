package com.okz.cip.service.impl;

import com.okz.cip.cache.RedisCache;
import com.okz.cip.dao.DemoDao;
import com.okz.cip.entity.Demo;
import com.okz.cip.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huangyang
 * @Description: ${todo}(这里用一句话描述这个类的作用)
 * @date 2019/04/24 下午4:54
 */

@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private DemoDao demoDao;

    @Autowired
    private RedisCache redisCache;

    @Override
    public Integer findOne() {
        redisCache.set("fuck".getBytes(), "fuck".getBytes(), 10000);
        byte[] data = redisCache.get("fuck".getBytes());
        System.out.println(new String(data));
        return demoDao.selectOne(new Demo(56)).getId();
    }

}
