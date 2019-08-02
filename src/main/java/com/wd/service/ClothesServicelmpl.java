package com.wd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wd.bean.Clothes;
import com.wd.dao.ClothesMapper;
@Service
public class ClothesServicelmpl implements ClothesService{
	@Autowired
	private ClothesMapper clothesMaper;

	@Override
	public List<Clothes> getAlllist() {
		
		return clothesMaper.getAlllist();
	}
	@Override
	public  Integer add(Clothes c){
		return clothesMaper.add(c);
	}
	
	public void delete(String id){
		 clothesMaper.delete(id);
	}
	
	public Clothes selectById(String id){
		return clothesMaper.selectById(id);
	}
	public void update(Clothes c){
		clothesMaper.update(c);
	}
}
