package com.okz.cip.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author huangyang
 * @Description: ${todo}(这里用一句话描述这个类的作用)
 * @date 2019/04/24 下午4:30
 */

@Table(name = "okz_c_user")
@Getter
@Setter
public class Demo {

    public Demo(){}
    public Demo(Integer id){
        this.id = id;
    }

    @Id
    private Integer id;

}
