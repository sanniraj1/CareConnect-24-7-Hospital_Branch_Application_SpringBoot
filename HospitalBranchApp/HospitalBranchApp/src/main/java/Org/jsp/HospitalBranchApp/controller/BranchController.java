package Org.jsp.HospitalBranchApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Org.jsp.HospitalBranchApp.dto.Branch;
import Org.jsp.HospitalBranchApp.dto.ResponseStructure;
import Org.jsp.HospitalBranchApp.service.BranchService;

@RestController
public class BranchController {
	@Autowired
	private BranchService service;
	
	@PostMapping("/branchs/{hospital_id}")
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@RequestBody Branch branch,@PathVariable int hospital_id)
	{
		return service.saveBranch(branch, hospital_id);
	}
	@PutMapping("/branchs/{hospital_id}")
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(@RequestBody Branch branch,@PathVariable int hospital_id)
	{
		return service.updateBranch(branch, hospital_id);
	}
	@GetMapping("/branchs/{hospital_id}")
	public ResponseEntity<ResponseStructure<List<Branch>>> findBranchByHospitalId(@PathVariable int hospital_id)
	{
		return service.findBranchByHospitalId(hospital_id);
	}

}
