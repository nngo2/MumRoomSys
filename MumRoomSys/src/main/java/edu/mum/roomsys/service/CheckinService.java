package edu.mum.roomsys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import edu.mum.roomsys.dao.CheckinDao;
import edu.mum.roomsys.domain.Booking;

@Service
public class CheckinService {

	@Autowired
	private CheckinDao checkinDao;

	public Booking findByStatusNewLike(int studentId) {
		PageRequest pr = new PageRequest(0, 1, new Sort(Direction.DESC, "moveInDate"));
		Page<Booking> pageBooking = checkinDao.findByStatusNewLike(studentId, pr);
		if(pageBooking.hasContent()) {
			return pageBooking.getContent().get(0);  
		}
		return null;
	}

}