package com.wd.dao;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wd.bean.Clothes;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext_mapper.xml")
public class ClothesMapperTest {
	@Autowired
	private ClothesMapper clothesMapper;
	@Test
	public void test() {
		
		List<Clothes> allList=clothesMapper.getAlllist();
		for (Clothes clothes : allList) {
			System.out.println(clothes);
		}
		
	}
	@Test
	public void test1() {
		Clothes c=new Clothes();
		c.setId("15");
		c.setParam_name("衣服");
		c.setParam_value("100");
		c.setRemark("余量充足");
		clothesMapper.add(c);
		}
	@Test
	public void test2(){
		String id="15";
		clothesMapper.delete(id);
	}
	@Test
	public void test3(){
		String id="12";
		Clothes c=clothesMapper.selectById(id);
		System.out.println(c);
	}		
	@Test
	public void test4() {
		Clothes c=new Clothes();
		c.setId("13");
		c.setParam_name("衣服");
		c.setParam_value("100");
		c.setRemark("余量充足");
		clothesMapper.update(c);
		}
}
