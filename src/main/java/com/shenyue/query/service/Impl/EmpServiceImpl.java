package com.shenyue.query.service.Impl;

import com.shenyue.query.dao.EmpMapper;
import com.shenyue.query.entity.EDInfo;
import com.shenyue.query.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements IEmpService {
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;
    //Redis的序列化器
    RedisSerializer redisSerializer = new StringRedisSerializer();

    @Override
    public List<EDInfo> selectAll() {
        redisTemplate.setKeySerializer(redisSerializer);
        List<EDInfo> list = (List<EDInfo>)redisTemplate.opsForValue().get("EDInfo");
        if(list==null){
           synchronized (this){
               list = (List<EDInfo>)redisTemplate.opsForValue().get("EDInfo");
               if (list==null){
                   list = empMapper.selectAll();
                   redisTemplate.opsForValue().set("EDInfo",list);
               }
           }
        }
        return list;
    }
}
