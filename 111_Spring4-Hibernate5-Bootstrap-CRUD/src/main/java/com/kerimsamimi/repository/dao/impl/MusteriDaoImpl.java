package com.kerimsamimi.repository.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kerimsamimi.model.Musteri;
import com.kerimsamimi.repository.dao.MusteriDao;

@Repository
public class MusteriDaoImpl implements MusteriDao {
	
	@Inject //@Autowired
	private SessionFactory sessionFactory;
	
	public MusteriDaoImpl() {
		System.out.println("MusteriDaoImpl");
	}

	@Override
	public List<Musteri> findAllMusteri() {
		return sessionFactory.getCurrentSession().createQuery("FROM "+Musteri.class.getName()).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Musteri> findMusteriler(String arananMusteriAdi) {
		String sqlSorgu="SELECT m.* FROM Musteri m WHERE m.musteriAdi LIKE'"+arananMusteriAdi +"%'";
		
		List <Object[]> musteriObjects= sessionFactory.getCurrentSession().createSQLQuery(sqlSorgu).list();
		
		List<Musteri> musteriler=new ArrayList<Musteri>();
		
		for(Object[] musteriObject : musteriObjects) {
			
			Musteri musteri=new Musteri();
			
			long musteriId=((BigInteger) musteriObject[0]).longValue();
			String musteriAdi=(String) musteriObject[1];
			String musteriSoyadi=(String) musteriObject[3];
			int musteriNo= (Integer) musteriObject[2];
			
			
			musteri.setMusteriId(musteriId);
			musteri.setMusteriAdi(musteriAdi);
			musteri.setMusteriSoyadi(musteriSoyadi);
			musteri.setMusteriNo(musteriNo);
			
			musteriler.add(musteri);
			
		}
		return musteriler;
	}

	@Override
	public Musteri findMusteri(long musteriId) {
		
		return sessionFactory.getCurrentSession().get(Musteri.class, musteriId);
	}

	@Override
	public long createMusteri(Musteri musteri) {
		
		return (Long) sessionFactory.getCurrentSession().save(musteri);
	}

	@Override
	public Musteri updateMusteri(Musteri musteri) {
		sessionFactory.getCurrentSession().update(musteri);
		return musteri;
	}

	@Override
	public void deleteMusteri(long musteriId) {
		Musteri musteri = new Musteri();
		musteri.setMusteriId(musteriId);
		sessionFactory.getCurrentSession().delete(musteri);

	}

}
