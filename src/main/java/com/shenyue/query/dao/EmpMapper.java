package com.shenyue.query.dao;

import com.shenyue.query.entity.EDInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EmpMapper {
    List<EDInfo> selectAll();

}
