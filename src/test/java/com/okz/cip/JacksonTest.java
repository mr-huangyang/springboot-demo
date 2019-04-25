package com.okz.cip;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author huangyang
 * @Description: ${todo}(这里用一句话描述这个类的作用)
 * @date 2019/04/25 下午4:21
 */
public class JacksonTest {

    @Test
    public void test() throws JsonProcessingException {
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);

        Map<String,Object> map = new LinkedHashMap<>();
        map.put("k1",1);
        map.put("k1","xx");

        System.out.println(om.writeValueAsString(map));
        System.out.println(jackson2JsonRedisSerializer.serialize(map));

    }


}
