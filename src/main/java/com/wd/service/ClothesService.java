package com.wd.service;

import java.util.List;

import com.wd.bean.Clothes;

public interface ClothesService{
	
	List<Clothes> getAlllist();
	Integer add(Clothes c);
	void delete (String id);
	Clothes selectById(String id);
	void update(Clothes c);
}