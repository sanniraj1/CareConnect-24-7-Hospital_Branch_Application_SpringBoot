package Org.jsp.HospitalBranchApp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Org.jsp.HospitalBranchApp.dto.Hospital;
import Org.jsp.HospitalBranchApp.repository.HospoitalRepository;

@Repository
public class HospitalDao {
	@Autowired
	private HospoitalRepository repository;
	
	public Hospital saveHospital(Hospital hospital) {
		return repository.save(hospital);
	}
	public Hospital updateHospital(Hospital hospital) {
		return repository.save(hospital);
	}
	public Optional<Hospital> findById(int  id) {
		return repository.findById(id);
	}
	
	public boolean deleteById(int id) {
		Optional<Hospital> rm=findById(id);
		if(rm.isPresent()) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}
	
	

}
