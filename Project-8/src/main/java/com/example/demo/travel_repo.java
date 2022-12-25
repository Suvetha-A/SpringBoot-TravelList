package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;

public interface travel_repo extends JpaRepository<Travel,Integer>{
	
	 @Query(value = "SELECT * FROM travel t where t.travelid = ?1", nativeQuery = true)
	 List<Travel> findById(int id);
	 
	 @Modifying
	 @Transactional 
	 @Query(value = "DELETE FROM travel WHERE travelid = ?1 ", nativeQuery = true)
	 void deleteAllByIdInBatch(int id);
	 
	 @Transactional
	 @Modifying
	 @Query(value = "Update travel t set t.travelid = ?1 ,t.name=?2, t.description =?3  where t.travelid= ?4 ", nativeQuery = true)
	 void update(int id1, String name,String description,int id);



}
