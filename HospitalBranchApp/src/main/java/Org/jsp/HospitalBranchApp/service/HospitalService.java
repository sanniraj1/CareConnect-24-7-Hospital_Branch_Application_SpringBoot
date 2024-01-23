package Org.jsp.HospitalBranchApp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import Org.jsp.HospitalBranchApp.dao.HospitalDao;
import Org.jsp.HospitalBranchApp.dto.Hospital;
import Org.jsp.HospitalBranchApp.dto.ResponseStructure;
import Org.jsp.HospitalBranchApp.exception.IdNotFoundException;

@Service
public class HospitalService {
	@Autowired
	private HospitalDao hdao;
	
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(Hospital hospital){
		ResponseStructure<Hospital> structure=new ResponseStructure<>();
		hospital=hdao.saveHospital(hospital);
		structure.setData(hospital);
		structure.setMessage("hospital register successfully");
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Hospital>>(structure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(Hospital hospital){
		ResponseStructure<Hospital> structure=new ResponseStructure<>();
		hospital=hdao.updateHospital(hospital);
		structure.setData(hospital);
		structure.setMessage("hospital update successfully");
		structure.setStatusCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Hospital>>(structure,HttpStatus.ACCEPTED);
	}
	
	public ResponseEntity<ResponseStructure<Hospital>> findHospitalById(int id){
		ResponseStructure<Hospital> structure=new ResponseStructure<>();
		Optional<Hospital> rm=hdao.findById(id);
		if(rm.isPresent())
		{
			structure.setData(rm.get());
			structure.setMessage("hospital found successfully");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Hospital>>(structure,HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}
	public ResponseEntity<ResponseStructure<String>> deleteHospitalById(int id){
		ResponseStructure<String> structure=new ResponseStructure<>();
		boolean deleted=hdao.deleteById(id);
		if(deleted)
		{
			structure.setData("hospital deleted");
			structure.setMessage("hospital found ");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.OK);	
		}
		structure.setData("hospital not  deleted");
		structure.setMessage("hospital  not found ");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}

}
