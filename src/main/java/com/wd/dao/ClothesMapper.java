package com.wd.dao;

import java.util.List;

import com.wd.bean.Clothes;

public interface ClothesMapper {

	List<Clothes> getAlllist();
	Integer add(Clothes c);
	void delete(String id);
	Clothes selectById(String id);
	void update(Clothes c);
	}
		

