package Org.jsp.HospitalBranchApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Org.jsp.HospitalBranchApp.dto.Hospital;

public interface HospoitalRepository extends JpaRepository<Hospital, Integer> {

}
