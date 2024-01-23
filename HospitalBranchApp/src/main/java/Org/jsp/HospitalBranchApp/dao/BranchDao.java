package Org.jsp.HospitalBranchApp.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Org.jsp.HospitalBranchApp.dto.Branch;
import Org.jsp.HospitalBranchApp.repository.BranchRepository;

@Repository
public class BranchDao {
	@Autowired
	private BranchRepository repository;
	
	public Branch saveBranch(Branch branch) {
		return repository.save(branch);
	}
	public Branch updateBranch(Branch branch) {
		return repository.save(branch);
	}
	public List<Branch> findBranchByHospitalId(int hospital_id) {
		return  repository.findBranchByHospitalId(hospital_id);
	}
	public List<Branch> findBranchByHospitalName(String hospital_name) {
		return  repository.findBranchByHospitalName(hospital_name);
	}
	public List<Branch> findBranchByHospitalGst(String hospital_gst) {
		return  repository.findBranchByHospitalName(hospital_gst);
	}
	

}
