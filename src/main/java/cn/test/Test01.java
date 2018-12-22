package cn.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.entity.Music;
import cn.service.dao.impl.MusicServiceDaoImpl;

public class Test01 {
	public static void main(String[] args) {
		ApplicationContext con = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		MusicServiceDaoImpl service = 
				con.getBean("musicServiceDaoImpl", MusicServiceDaoImpl.class);
		
		List<Music> list = service.findByNameMusic("你");
		System.out.println(list);
	}
}
