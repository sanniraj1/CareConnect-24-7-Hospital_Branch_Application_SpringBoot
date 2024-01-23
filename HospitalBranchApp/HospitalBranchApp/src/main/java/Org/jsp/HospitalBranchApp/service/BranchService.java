package Org.jsp.HospitalBranchApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import Org.jsp.HospitalBranchApp.dao.BranchDao;
import Org.jsp.HospitalBranchApp.dao.HospitalDao;
import Org.jsp.HospitalBranchApp.dto.Branch;
import Org.jsp.HospitalBranchApp.dto.Hospital;
import Org.jsp.HospitalBranchApp.dto.ResponseStructure;
import Org.jsp.HospitalBranchApp.exception.IdNotFoundException;

@Service
public class BranchService {
	@Autowired
	private BranchDao bdao;
	@Autowired
	private HospitalDao hdao;

	public ResponseEntity<ResponseStructure<Branch>> saveBranch(Branch branch,int hospital_id){
		ResponseStructure<Branch> structure=new ResponseStructure<>();
		Optional<Hospital> rm=hdao.findById(hospital_id);
		if(rm.isPresent())
		{
			Hospital h =rm.get();
			h.getBranchs().add(branch);
			branch.setHospital(h);
			hdao.updateHospital(h);
			bdao.saveBranch(branch);
			structure.setData(branch);
			structure.setMessage("Branch Added successfully");
			structure.setStatusCode(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Branch>>(structure,HttpStatus.CREATED);
		}
		throw new IdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(Branch branch,int hospital_id){
		ResponseStructure<Branch> structure=new ResponseStructure<>();
		Optional<Hospital> rm=hdao.findById(hospital_id);
		if(rm.isPresent())
		{
			Hospital h =rm.get();
			branch.setHospital(h);
			bdao.saveBranch(branch);
			structure.setData(branch);
			structure.setMessage("Branch update successfully");
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Branch>>(structure,HttpStatus.ACCEPTED);
		}
		throw new IdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<List<Branch>>> findBranchByHospitalId(int hospital_id){

		ResponseStructure<List<Branch>> structure=new ResponseStructure<>();
		Optional<Hospital> rm=hdao.findById(hospital_id);
		if(rm.isPresent()) {
			structure.setData(bdao.findBranchByHospitalId(hospital_id));
			structure.setMessage("branch found successfully");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Branch>>>(structure,HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}

//	public ResponseEntity<ResponseStructure<List<Branch>>> findBranchByHospitalName(int hospital_name){
//
//		ResponseStructure<List<Branch>> structure=new ResponseStructure<>();
//		Optional<Branch> rm=bdao.findBranchByHospitalName(hospital_name);
//		if(rm.isPresent()) {
//			structure.setData(Branch);
//			structure.setMessage("branch found successfully");
//			structure.setStatusCode(HttpStatus.OK.value());
//			return new ResponseEntity<ResponseStructure<List<Branch>>>(structure,HttpStatus.OK);
//		}
//		throw new IdNotFoundException();
//	}
//
//	public ResponseEntity<ResponseStructure<List<Branch>>> findBranchByHospitalId(int hospital_id){
//
//		ResponseStructure<List<Branch>> structure=new ResponseStructure<>();
//		Optional<Hospital> rm=hdao.findById(hospital_id);
//		if(rm.isPresent()) {
//			structure.setData(bdao.findBranchByHospitalId(hospital_id));
//			structure.setMessage("brancg found successfully");
//			structure.setStatusCode(HttpStatus.OK.value());
//			return new ResponseEntity<ResponseStructure<List<Branch>>>(structure,HttpStatus.OK);
//		}
//		throw new IdNotFoundException();
//	}
	

}
