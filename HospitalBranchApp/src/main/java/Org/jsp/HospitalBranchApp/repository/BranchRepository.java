package Org.jsp.HospitalBranchApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import Org.jsp.HospitalBranchApp.dto.Branch;

public interface BranchRepository  extends JpaRepository<Branch, Integer>{
	

	@Query("select b from Branch b where b.hospital.id=?1")
	public List<Branch> findBranchByHospitalId(int hospital_id);
	
	@Query("select b from Branch b where b.hospital.name=?1")
	public List<Branch> findBranchByHospitalName(String hospital_name);
	
	@Query("select b from Branch b where b.hospital.gst=?1")
	public List<Branch> findBranchByHospitalGst(String hospital_gst);
}
