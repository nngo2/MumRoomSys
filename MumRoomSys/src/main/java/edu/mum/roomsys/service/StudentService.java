package edu.mum.roomsys.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import edu.mum.roomsys.dao.AccountDao;
import edu.mum.roomsys.dao.StudentDao;
import edu.mum.roomsys.domain.Student;
import edu.mum.roomsys.dto.PageDto;
import edu.mum.roomsys.dto.SearchCriteria;
import edu.mum.roomsys.util.PagingHelper;

@Service
public class StudentService {

	@Autowired
	private StudentDao studentDao;
	
	@Autowired
	private AccountDao accountDao;
	
	public Page<Student> findAll(int page, int size) {
		PageRequest pReqest = new PageRequest(page, size, new Sort(Direction.ASC, "name"));
		return studentDao.findAll(pReqest);
	}
	
	public PageDto getPage(Page<Student> page, int current) {
		PagingHelper<Student> paging = new PagingHelper<>(page, current);
		return new PageDto(paging.getCurrentPage(), paging.getNextPage(), paging.getPreviousPage(), paging.getTotalPage());
	}

	public Page<Student> search(SearchCriteria searchCriteria, int pageNo, int pageSize) {
		if (searchCriteria.getCriteria() == null) {
			searchCriteria.setCriteria("");
			searchCriteria.setSearchBy("name");
		}				
		PageRequest pReqest = new PageRequest(pageNo, pageSize, new Sort(Direction.ASC, "name"));
		switch (searchCriteria.getSearchBy()) {
			case "name":
				return studentDao.findByNameLike(searchCriteria.getCriteria(), pReqest);
			case "email":
				return studentDao.findByEmailLike(searchCriteria.getCriteria(), pReqest);
		}
		return null;
	}
}
