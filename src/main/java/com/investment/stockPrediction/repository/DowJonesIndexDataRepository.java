package com.investment.stockPrediction.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.investment.stockPrediction.model.DowJonesIndexCK;
import com.investment.stockPrediction.model.DowJonesIndexData;

@Repository
public interface DowJonesIndexDataRepository extends JpaRepository<DowJonesIndexData, DowJonesIndexCK> {
	
	List<DowJonesIndexData> findByStock(String stock);

}
